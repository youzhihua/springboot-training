package training.springboot.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import training.springboot.cache.dao.BookDao;
import training.springboot.cache.pojo.Book;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    //获取所有书的信息
    public List<Book> queryAllBookInfo(){
        return bookDao.selectAll();
    }

    //根据主键获取书的信息
    @Cacheable(cacheNames = "book",key = "'book'+#id")
    public Book queryBookById(Integer id){
        return bookDao.selectByPrimaryKey(id);
    }

    //更新书的信息
    @CachePut(cacheNames = "book",key = "'book'+#book.id",condition = "#result != null")
    public Book updateBookInfo(Book book){
        if(bookDao.updateByPrimaryKey(book)>0){
            return book;
        }
        return null;
    }

    //删除书的信息
    @CacheEvict(cacheNames = "book",key = "'book'+#id",condition = "#result>0")
    public Integer deleteBookInfo(Integer id){
        return bookDao.deleteByPrimaryKey(id);
    }

    //增加一本书的信息
    @CachePut(cacheNames = "book",key = "'book'+#result",condition = "#result != null")
    public Book insertBook(Book book){
        bookDao.insertUseGeneratedKeys(book);
        return book;
    }
}
