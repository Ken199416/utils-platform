package app.config;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        放行Vue传过来一个OPTIONS请求
//        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
////            logger.info("OPTIONS请求，放行");
//            return true;
//        }
//        String token = request.getHeader("Authorization");
////        不等于空
//        if (StringUtils.isNotBlank(token)){
//            try {
//                JWTInfo jwtInfo = JwtTokenUtils.getTokenInfo(token);
//            }catch (SignatureException e){
////                未登录
//                ResponseBean responseBean = new ResponseBean();
//                responseBean.setCode(40009);
//                responseBean.setMsg("未登录");
//                returnJson(response,JSON.toJSONString(responseBean));
//            }catch (ExpiredJwtException e){
//                ResponseBean responseBean = new ResponseBean();
//                responseBean.setCode(40009);
//                responseBean.setMsg("登录信息已过期，请重新登录！");
//                returnJson(response,JSON.toJSONString(responseBean));
//            }catch (Exception e){
//                ResponseBean responseBean = new ResponseBean();
//                responseBean.setCode(40009);
//                responseBean.setMsg("登录信息异常，请重新登录！");
//                returnJson(response,JSON.toJSONString(responseBean));
//            }
//            return true;
//        }
//        ResponseBean responseBean = new ResponseBean();
//        responseBean.setCode(40004);
//        responseBean.setMsg("未登录");
//        returnJson(response,JSON.toJSONString(responseBean));
//        return false;
//    }
//
//
//    private void returnJson(HttpServletResponse response, String json) throws Exception {
//        PrintWriter writer = null;
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=utf-8");
//
//        try {
//            writer = response.getWriter();
//            writer.print(json);
//
//        } catch (IOException e) {
//            logger.error("response error", e);
//        } finally {
//            if (writer != null)
//                writer.close();
//        }
//    }
}
