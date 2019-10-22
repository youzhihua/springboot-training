package traning.springboot.jdbctemplate.dao;

import traning.springboot.jdbctemplate.pojo.Book;

import java.util.List;

public interface BookDao {

    //查询所有书籍
    List<Book> queryAllBooks();

    //根据ID查询书籍
    Book queryBookByBookId(Integer id);

    //根据ID更新书籍
    boolean updateBookInfoByBookId(Book book,Integer id);

    //根据ID删除书籍
    boolean deleteBookByBookId(Integer id);

    //增加一本书籍
    boolean insertBook(Book book);
}
