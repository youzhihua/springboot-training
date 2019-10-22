package traning.springboot.jdbctemplate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import traning.springboot.jdbctemplate.pojo.Book;

import java.util.List;

@Repository
public class BookDaoImp1 implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> queryAllBooks() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book queryBookByBookId(Integer id) {
        String sql = "select * from book where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public boolean updateBookInfoByBookId(Book book, Integer id) {
        String sql = "update book set book_name = ? and book_author = ? where id = ?";
        return jdbcTemplate.update(sql,book.getBookName(),book.getBookAuthor())>0;
    }

    @Override
    public boolean deleteBookByBookId(Integer id) {
        String sql = "delete from book where id = ?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public boolean insertBook(Book book) {
        String sql = "insert into book(book_name,book_author) values(?,?)";
        return jdbcTemplate.update(sql,book.getBookName(),book.getBookAuthor())>0;
    }
}
