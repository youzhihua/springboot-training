package training.springboot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.springboot.jpa.dao.UserDao;
import training.springboot.jpa.pojo.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //插入一个USER
    public void addUser(User user){
        userDao.save(user);
    }

    //查询所有USER
    public List<User> queryAllUsers(){
        return userDao.findAll();
    }
}
