package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/")
    public void hello(HttpServletRequest request, HttpServletResponse response){
        logger.info("进入首页拉");
        try{
            request.getRequestDispatcher("/index.html").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @RequestMapping("/t1")
    public void hello1(HttpServletRequest request, HttpServletResponse response){
        logger.info("进入t1");
        try{
            request.getRequestDispatcher("/test.html").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
