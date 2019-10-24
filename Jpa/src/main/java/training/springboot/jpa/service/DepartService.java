package training.springboot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.springboot.jpa.dao.DepartmentDao;
import training.springboot.jpa.pojo.Department;

import java.util.List;

@Service
public class DepartService {

    @Autowired
    private DepartmentDao departmentDao;

    //增加部门
    public void insertDepartment(Department department){
        departmentDao.save(department);
    }

    //根据Id删除部门
    public void deleteDepartment(Long id){
        departmentDao.deleteById(id);
    }

    //查询所有部门
    public List<Department> queryAlldepartments(){
        return departmentDao.findAll();
    }

}
