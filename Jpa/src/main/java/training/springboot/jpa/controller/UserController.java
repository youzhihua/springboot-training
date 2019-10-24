package training.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.jpa.pojo.User;
import training.springboot.jpa.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //插入一个USER
    @RequestMapping("/addUser")
    public void addUser(User user){
        userService.addUser(user);
    }

    //查询所有USER
    @RequestMapping("/queryAllUsers")
    public List<User> queryAllUsers(){
        return userService.queryAllUsers();
    }

}
