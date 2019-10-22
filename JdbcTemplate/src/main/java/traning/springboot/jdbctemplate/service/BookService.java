package traning.springboot.jdbctemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import traning.springboot.jdbctemplate.dao.BookDao;
import traning.springboot.jdbctemplate.pojo.Book;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> queryAllBooks() {
        return bookDao.queryAllBooks();
    }

    public Book queryBookByBookId(Integer id) {
        return bookDao.queryBookByBookId(id);
    }

    public boolean updateBookInfoByBookId(Book book, Integer id) {
        return bookDao.updateBookInfoByBookId(book,id);
    }

    public boolean deleteBookByBookId(Integer id) {
        return bookDao.deleteBookByBookId(id);
    }

    public boolean insertBook(Book book) {
        return bookDao.insertBook(book);
    }
}
