package com.big407.energy.filter;

import com.big407.energy.model.Admin;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = {"/field.html"},filterName = "adminFilter")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session=request.getSession();

        Admin admin=(Admin)session.getAttribute("admin");
        if(admin==null){
            //未登陆
            response.sendRedirect("index.html");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
