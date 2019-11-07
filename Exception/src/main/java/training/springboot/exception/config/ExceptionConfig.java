package training.springboot.exception.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.RuntimeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常配置类
 */
@RestControllerAdvice
public class ExceptionConfig{


    /**
     * 自定义的异常处理器,捕获数组越界异常
     */
   @ExceptionHandler(value = CustomerException.class)
   public String customGlobalException(CustomerException e){
        return e.toString();
   }

    /**
     * 捕获运行时异常，并跳转到自定义的Error界面
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView defaultException(HttpServletRequest request,RuntimeException e,HttpServletResponse response){
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("errMsg",e.getMessage());
        returnMap.put("timestamp",System.currentTimeMillis());
        returnMap.put("status",response.getStatus());
        returnMap.put("url",request.getRequestURL());

        ModelAndView modelAndView = new ModelAndView("Error",returnMap);
        return modelAndView;
    }

}
