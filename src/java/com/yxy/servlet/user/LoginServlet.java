package com.yxy.servlet.user;

import com.yxy.pojo.User;
import com.yxy.service.user.UserService;
import com.yxy.service.user.UserServiceImpl;
import com.yxy.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doGet");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");


        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        System.out.println("----------> " + user);

        if(user!=null){
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            resp.sendRedirect("hello.html");
        } else {
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
