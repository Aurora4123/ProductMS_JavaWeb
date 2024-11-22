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
 * @Date：2024/10/23 9:44
 * @Filename：${NAME}
 */
@WebServlet(urlPatterns = "/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码集
        request.setCharacterEncoding("UTF-8");
        //接收页面请求的数据
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String stock = request.getParameter("stock");
        String state = request.getParameter("state");

        //将提交的数据封装到javabean中
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.setState(Integer.parseInt(state));
        product.setStock(Integer.parseInt(stock));

        //调用Service进行数据添加
        boolean save = new ProductServiceImpl().save(product);
        if (save) {//能不能直接跳转到list列表页面？不能，应该跳转到列表的Servlet
            System.out.println("添加成功");
            response.sendRedirect("ProductListServlet");
        }else{
            System.out.println("添加失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
