package training.springboot.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;
import training.springboot.mapper.dao.DepartmentDao;
import training.springboot.mapper.dao.UserDao;
import training.springboot.mapper.pojo.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MapperApplicationTests {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    UserDao userDao;

    /**
     * mapper相关测试
     */
    //测试批量插入数据
    @Test
    public void testBatchInsertUser(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setUsername("小明"+(i+1));
            user.setCreateDate(new Date());
            users.add(user);
        }
        userDao.insertList(users);
    }

    //根据主键查询元素
    @Test
    public void testQueryObjByKey(){
        System.out.println(userDao.selectByPrimaryKey(1328));
    }

    //根据id修改元素
    @Test
    public void testUpdateObjByKey(){
        User user = userDao.selectByPrimaryKey(1328);
        System.out.println("修改前："+ user);
        user.setUsername("小芳");
        userDao.updateByPrimaryKey(user);
        System.out.print("修改后："+userDao.selectByPrimaryKey(1328));
    }

    //根据id删除元素
    @Test
    public void testDelObjByPriKey(){
        System.out.println(userDao.deleteByPrimaryKey(1328));
    }

    //查询所有元素
    @Test
    public void testQueryAllUsers(){
        System.out.println(userDao.selectAll());
    }

    //插入一条元素，并获取刚插入的主键
    @Test
    public void testInsertUseGeneratedKeysMapper(){
        User user = new User();
        user.setUsername("小刚");
        userDao.insertUseGeneratedKeys(user);
        System.out.println(user.getId());
    }

    //使用Example对象排序
    @Test
    public void testExampleOrderBy(){
        Example example = new Example(User.class);
        example.orderBy("id").asc();
        System.out.println(userDao.selectByExample(example));
    }

    //使用Example对象的动态SQL
    @Test
    public void testExampleSql(){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username","小明5");
        System.out.println(userDao.selectByExample(example));
    }

    /**
     * pageHelper使用
     */
    @Test
    public void testPageHelper(){
        PageHelper.startPage(1,10);
        System.out.println(userDao.selectAll());
    }
}
