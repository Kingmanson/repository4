package com.king.servlet;

import com.king.dao.LoginDao;
import com.king.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //生成的验证码先放进session域中
        //获取实际生成的验证码


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        //数据库查询
        LoginDao dao = new LoginDao();
        User queryUser = dao.query(user);

        //
        if(queryUser != null){
            //将user放入request域中
            request.setAttribute("user",user);
            //转到登录成功页面
            request.getRequestDispatcher("loginSuccess").forward(request,response);
        }else{
            //转到登录失败页面
            response.sendRedirect("/web24/loginFail");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
