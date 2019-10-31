package training.springboot.cache.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CustomeDao<T> extends MySqlMapper<T>, Mapper<T> {
}
