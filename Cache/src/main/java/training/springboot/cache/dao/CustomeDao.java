package training.springboot.cache.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自定义的mapper模板
 * @param <T>
 */
public interface CustomeDao<T> extends MySqlMapper<T>, Mapper<T> {
}
