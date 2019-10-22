package traning.springboot.jdbctemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traning.springboot.jdbctemplate.pojo.Book;
import traning.springboot.jdbctemplate.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/queryAllBooks")
    public List<Book> queryAllBooks() {
        return bookService.queryAllBooks();
    }

    @RequestMapping("/queryBookByBookId")
    public Book queryBookByBookId(Integer id) {
        return bookService.queryBookByBookId(id);
    }

    @RequestMapping("/updateBookInfoByBookId")
    public boolean updateBookInfoByBookId(Book book, Integer id) {
        return bookService.updateBookInfoByBookId(book,id);
    }

    @RequestMapping("/deleteBookByBookId")
    public boolean deleteBookByBookId(Integer id) {
        return bookService.deleteBookByBookId(id);
    }

    @RequestMapping("/insertBook")
    public boolean insertBook(Book book) {
        return bookService.insertBook(book);
    }

}
