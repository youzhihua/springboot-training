package training.springboot.mybatis.dao;

import org.apache.ibatis.annotations.*;
import training.springboot.mybatis.pojo.Department;
import training.springboot.mybatis.pojo.User;

import java.util.List;

@Mapper
public interface UserDao {

    //根据department_id查询user
    @Select("Select * from user where department_id = #{departmentId}")
    List<User> queryUserByDepartmentId(@Param("departmentId")Long departmentId);

    //根据userId查询user信息
    @Select("Select * from user where id = #{userId}")
    @Results({
            @Result(column = "department_id",property = "department",javaType = Department.class,one = @One(select = "training.springboot.mybatis.dao.DepartmentDao.queryDepartmentById"))
    })
    User queryUserbyUserId(@Param("userId")Long id);
}
