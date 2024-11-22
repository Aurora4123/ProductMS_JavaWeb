package com.inspur.servlet;

import com.inspur.bean.Product;
import com.inspur.service.impl.ProductServiceImpl;
import com.inspur.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author：齐文勇
 * @Package：${PACKAGE_NAME}
 * @Project：ProductMS
 * @name：${NAME}
 * @Date：2024/10/23 16:23
 * @Filename：${NAME}
 */
@WebServlet(urlPatterns = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("UTF-8");
        //        //调用service获取列表
//        List<Product> productList = new ProductServiceImpl().findAll();
//        //将列表封装到request域
//        request.setAttribute("productList",productList);
//        //请求转发到列表页面
//        request.getRequestDispatcher("pages/product/list.jsp").forward(request,response);

        //接收页面传的条件并分组
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String state = request.getParameter("state");
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setState(state!=null?Integer.parseInt(state):2);
        //调用service获取分页数据
        int pageSize= 3;
//        int pageNum = 1;
        String pn = request.getParameter("pageNum");
        int pageNum = pn!=null && !"".equals(pn) ? Integer.parseInt(pn):1;
        PageUtil<Product> pageUtil = new ProductServiceImpl().findByPage(product, pageSize, pageNum);
        request.setAttribute("pageUtil",pageUtil);
        request.getRequestDispatcher("pages/product/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
