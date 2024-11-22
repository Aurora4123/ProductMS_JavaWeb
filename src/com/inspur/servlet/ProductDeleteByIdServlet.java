package com.inspur.servlet;

import com.inspur.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：齐文勇
 * @Package：${PACKAGE_NAME}
 * @Project：ProductMS
 * @name：${NAME}
 * @Date：2024/10/30 16:08
 * @Filename：${NAME}
 */
@WebServlet(urlPatterns = "/ProductDeleteByIdServlet")
public class ProductDeleteByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码集
        request.setCharacterEncoding("UTF-8");
        //接收页面提交的id
        String id = request.getParameter("id");
        //调用Service
        boolean b = new ProductServiceImpl().deleteById(id);
        //跳转到列表的Servlet，从列表的Servlet再跳转到列表页面
        response.sendRedirect("ProductListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
