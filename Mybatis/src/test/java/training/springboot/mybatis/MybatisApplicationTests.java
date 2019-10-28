package training.springboot.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import training.springboot.mybatis.dao.DepartmentDao;
import training.springboot.mybatis.dao.UserDao;
import training.springboot.mybatis.pojo.Department;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    UserDao userDao;

    @Test
    public void testQueryUser(){
        System.out.println(userDao.queryUserbyUserId((long) 1));
    }

    @Test
    public void testQueryUserByDepartmentId(){
        System.out.println(userDao.queryUserByDepartmentId((long) 1));
    }

    @Test
    public void testQueryDepartmentById(){
        System.out.println(departmentDao.queryDepartmentById((long) 1));
    }

    @Test
    public void testQueryAllDepartments(){
        System.out.println(departmentDao.queryAllDepartment());
    }

    @Test
    public void testInsertDepartment(){
        Department department = new Department();
        department.setName("市场部");
        departmentDao.addDepartment(department);
    }

    @Test
    public void testDeleteDepartment(){
        departmentDao.deleteDepartmentById((long) 2);
    }
}
