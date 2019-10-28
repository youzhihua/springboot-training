package training.springboot.mybatis.dao;

import org.apache.ibatis.annotations.*;
import training.springboot.mybatis.pojo.Department;

import java.util.List;

@Mapper
public interface DepartmentDao {

    //查询所有部门信息
    @Select("Select * from department")
    @Results({
            @Result(column = "id",property = "users",javaType = List.class,many = @Many(select = "training.springboot.mybatis.dao.UserDao.queryUserByDepartmentId"))
    })
    List<Department> queryAllDepartment();

    //根据部门ID查询部门信息
    @Select("Select * from department where id = #{id}")
    Department queryDepartmentById(@Param("id")Long id);

    //插入一条部门记录
    @Insert("Insert into department(name) values(#{name})")
    Integer addDepartment(Department department);

    //删除一条部门记录
    @Delete("delete from department where id = #{id}")
    Integer deleteDepartmentById(@Param("id")Long id);

}
