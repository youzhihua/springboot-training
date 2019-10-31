package training.springboot.cache.dao;


import org.apache.ibatis.annotations.Mapper;
import training.springboot.cache.pojo.Book;

@Mapper
public interface BookDao extends CustomeDao<Book>{
}
