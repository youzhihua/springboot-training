package training.springboot.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.exception.config.CustomerException;

import java.io.File;

@RestController
public class ExceptionController{

    /**
     * 测试自定义异常方法
     * @return
     */
    @GetMapping(value = "/testCustom")
    public int testCustomException(int index){
        int[] array = new int[5];
        if(index > 5){
            throw new CustomerException(500,"不合法的数组下标");
        }
        return array[index];
    }

    /**
     * 测试运行时异常,并跳转异常页面
     */
    @GetMapping(value = "/testRuntimeException")
    public int testDefaultException(){
        String test = "x";
        return Integer.parseInt(test);
    }
}
