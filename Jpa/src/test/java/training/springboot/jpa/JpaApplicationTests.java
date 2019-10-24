package training.springboot.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import training.springboot.jpa.dao.DepartmentDao;
import training.springboot.jpa.dao.RoleDao;
import training.springboot.jpa.dao.UserDao;
import training.springboot.jpa.pojo.Department;
import training.springboot.jpa.pojo.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private DepartmentDao departmentDao;

    //添加一个USER
    @Test
    public void testAddUser(){
        User user = new User();
        user.setCreateDate(new Date());
        user.setUsername("小明");
        userDao.save(user);
    }

    //添加一个部门，级联操作
    @Test
    public void testAddDepartment(){
        Department department = new Department();
        department.setName("研发部");
        department.setId((long) 1);

        User user = new User();
        user.setId((long) 2);
        user.setUsername("小红2");
        user.setCreateDate(new Date());

        List<User> users = new ArrayList<>();
        users.add(user);
        department.setUsers(users);
        departmentDao.save(department);
    }

    //查询所有USER
    @Test
    public void testQueryAllUser(){
        System.out.println(userDao.findAll());
    }

}
