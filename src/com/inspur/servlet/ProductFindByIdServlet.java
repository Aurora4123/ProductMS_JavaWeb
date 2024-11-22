package com.inspur.servlet;

import com.inspur.bean.Product;
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
 * @Date：2024/10/30 9:14
 * @Filename：${NAME}
 * 作为商品修改的回显操作
 */
@WebServlet(urlPatterns = "/ProductFindByIdServlet")
public class ProductFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码集
        request.setCharacterEncoding("UTF-8");
        //接收要修改商品的id
        String id = request.getParameter("id");
        //调用Service获取要修改的商品
        Product product = new ProductServiceImpl().findById(id);
        //放入request范围
        request.setAttribute("product",product);
        //请求转发到页面
        request.getRequestDispatcher("pages/product/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
