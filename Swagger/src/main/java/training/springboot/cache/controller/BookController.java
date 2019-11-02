package training.springboot.cache.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.cache.pojo.Book;
import training.springboot.cache.service.BookService;

import java.util.List;

@RestController
@Api(tags = "1.0.0", value = "书籍控制器")
public class BookController {

    @Autowired
    private BookService bookService;

    //获取所有书的信息
    @RequestMapping(value = "/queryAllBookInfo",method = RequestMethod.GET)
    @ApiResponse(message = "查询所有书籍信息",code = 200)
    public List<Book> queryAllBookInfo(){
        return bookService.queryAllBookInfo();
    }

    //根据主键获取书的信息
    @RequestMapping(value = "/queryBookById",method = RequestMethod.GET)
    @ApiImplicitParam(value = "书籍Id")
    @ApiResponse(message = "根据书籍Id查询书籍信息",code = 200)
    public Book queryBookById(Integer id){
        return bookService.queryBookById(id);
    }

    //更新书的信息
    @RequestMapping(value = "/updateBookInfo",method = RequestMethod.POST)
    @ApiImplicitParam(value = "书籍对象实体")
    public Book updateBookInfo(Book book){
        return bookService.updateBookInfo(book);
    }

    //删除书的信息
    @RequestMapping(value = "/deleteBookInfo",method = RequestMethod.DELETE)
    @ApiImplicitParam(value = "书籍Id")
    @ApiResponse(message = "删除书籍的个数",code = 200)
    public Integer deleteBookInfo(Integer id){
        return bookService.deleteBookInfo(id);
    }

    //增加一本书的信息
    @RequestMapping(value = "/insertBook",method = RequestMethod.POST)
    @ApiImplicitParam(value = "书籍对象实体")
    public Book insertBook(Book book){
        return bookService.insertBook(book);
    }

}
