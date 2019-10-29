package training.springboot.mapper.dao;

import org.apache.ibatis.annotations.Mapper;
import training.springboot.mapper.pojo.User;

@Mapper
public interface UserDao extends CustomMapper<User> {
}
