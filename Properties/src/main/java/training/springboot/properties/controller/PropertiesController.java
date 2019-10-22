package training.springboot.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.properties.pojo.Student;

@RestController
public class PropertiesController {

    @Autowired
    private Student student;

    @RequestMapping("/properties")
    public Student printStudentInfo(){
        return student;
    }
}
