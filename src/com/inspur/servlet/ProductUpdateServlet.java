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
 * @Date：2024/10/30 9:36
 * @Filename：${NAME}
 */
@WebServlet(urlPatterns = "/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //编码集
        request.setCharacterEncoding("UTF-8");
        //接收页面提交的修改后的数据，包括id

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String stock = request.getParameter("stock");
        String state = request.getParameter("state");
        //封装Bean
        Product product= new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(Double.parseDouble(price));
        product.setState(Integer.parseInt(state));
        product.setStock(Integer.parseInt(stock));

        //调用Service的修改方法
        boolean b = new ProductServiceImpl().updateById(product, id);

        //修改后跳转到列表界面？能否直接跳转到页面？不能
        // 跳转到查询列表的Servlet,由列表的Servlet再跳转到页面
        response.sendRedirect("ProductListServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
