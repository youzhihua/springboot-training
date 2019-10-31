package training.springboot.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.cache.pojo.Book;
import training.springboot.cache.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //获取所有书的信息
    @RequestMapping("/queryAllBookInfo")
    public List<Book> queryAllBookInfo(){
        return bookService.queryAllBookInfo();
    }

    //根据主键获取书的信息
    @RequestMapping("/queryBookById")
    public Book queryBookById(Integer id){
        return bookService.queryBookById(id);
    }

    //更新书的信息
    @RequestMapping("/updateBookInfo")
    public Book updateBookInfo(Book book){
        return bookService.updateBookInfo(book);
    }

    //删除书的信息
    @RequestMapping("/deleteBookInfo")
    public Integer deleteBookInfo(Integer id){
        return bookService.deleteBookInfo(id);
    }

    //增加一本书的信息
    @RequestMapping("/insertBook")
    public Book insertBook(Book book){
        return bookService.insertBook(book);
    }

}
