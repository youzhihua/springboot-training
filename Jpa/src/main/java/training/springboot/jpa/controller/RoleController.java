package training.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.jpa.pojo.Role;
import training.springboot.jpa.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //增加一个角色
    public void addRole(Role role){
        roleService.addRole(role);
    }

    //删除一个角色
    public void deleteRole(Long id){
        roleService.deleteRole(id);
    }

    //查询所有角色
    public List<Role> queryAllRole(){
        return roleService.queryAllRole();
    }

    //更新一个角色
    public void updateRole(Role role){
        roleService.updateRole(role);
    }
}
