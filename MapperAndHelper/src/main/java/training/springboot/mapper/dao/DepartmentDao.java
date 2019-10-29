package training.springboot.mapper.dao;

import org.apache.ibatis.annotations.Mapper;
import training.springboot.mapper.pojo.Department;

@Mapper
public interface DepartmentDao extends CustomMapper<Department> {
}
