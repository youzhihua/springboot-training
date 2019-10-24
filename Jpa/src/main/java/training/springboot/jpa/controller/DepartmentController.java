package training.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.jpa.pojo.Department;
import training.springboot.jpa.service.DepartService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartService departService;

    //增加部门
    @RequestMapping("/insertDepartment")
    public void insertDepartment(Department department){
        departService.insertDepartment(department);
    }

    //根据Id删除部门
    @RequestMapping("/deleteDepartment")
    public void deleteDepartment(Long id){
        departService.deleteDepartment(id);
    }

    //查询所有部门
    @RequestMapping("/queryAlldepartments")
    public List<Department> queryAlldepartments(){
        return departService.queryAlldepartments();
    }
}
