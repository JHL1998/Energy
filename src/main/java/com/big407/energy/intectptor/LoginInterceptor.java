package com.big407.energy.intectptor;

import com.big407.energy.model.User;
import com.big407.energy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        Cookie[]cookies=request.getCookies();
        if (cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                //拿到token
                if(cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    User user=userService.findByToken(token);
                    if(user!=null){
                        //存到session里面
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }


        }
        //做拦截的目的，是存session
        return true;


    }
}
