package training.springboot.mapper.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自定义的基础mapper
 * @param <T>
 */
public interface CustomMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
