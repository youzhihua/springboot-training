package training.springboot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.springboot.jpa.dao.RoleDao;
import training.springboot.jpa.pojo.Role;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    //增加一个角色
    public void addRole(Role role){
        roleDao.save(role);
    }

    //删除一个角色
    public void deleteRole(Long id){
        roleDao.deleteById(id);
    }

    //查询所有角色
    public List<Role> queryAllRole(){
        return roleDao.findAll();
    }

    //更新一个角色
    public void updateRole(Role role){
        roleDao.save(role);
    }
}
