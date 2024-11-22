package com.inspur.dao.impl;

import com.inspur.bean.Product;
import com.inspur.dao.ProductDAO;
import com.inspur.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImpl implements ProductDAO {
    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;
    @Override
    public int save(Product product) {
        try{
            //获取数据库链接
            conn = JDBCUtil.getConnection();
            String sql = "insert into product(name,price,category,stock,state)values(?,?,?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getCategory());
            pre.setInt(4,product.getStock());
            pre.setInt(5,product.getState());
            //执行sql
            int i = pre.executeUpdate();

            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {//关闭资源
            JDBCUtil.close(conn,pre);
        }
        return 0;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();

        try{
            conn = JDBCUtil.getConnection();
            String sql = "select id,name,price,category,stock,state from product";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                int stock = rs.getInt("stock");
                int state = rs.getInt("state");

                //封装到bean
                Product product = new Product();
                product.setId(id);
                product.setCategory(category);
                product.setStock(stock);
                product.setState(state);
                product.setPrice(price);
                product.setName(name);
                //将每一条数据添加到集合
                productList.add(product);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pre,rs);
        }
        return productList;
    }

    @Override
    public Product findById(String id) {
        try{
            conn = JDBCUtil.getConnection();
            String sql ="select id,name,price,category,stock,state from product where id ="+id;
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if(rs.next()){

                int pid = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                int stock = rs.getInt("stock");
                int state = rs.getInt("state");

                //封装到bean
                Product product= new Product();
                product.setId(pid);
                product.setCategory(category);
                product.setStock(stock);
                product.setState(state);
                product.setPrice(price);
                product.setName(name);

                return  product;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pre,rs);
        }
        return null;
    }

    @Override
    public int updateById(Product product, String id) {
        try{
            conn = JDBCUtil.getConnection();
            String sql  = "update product set name=?,price=?,category=?,stock=?,state=? where id = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getCategory());
            pre.setInt(4,product.getStock());
            pre.setInt(5,product.getState());
//            pre.setInt(6,product.getId());
            pre.setString(6,id);
            int i = pre.executeUpdate();

            return  i;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pre);
        }
        return 0;
    }

    @Override
    public int deleteById(String id) {

        try{
            conn = JDBCUtil.getConnection();
            String sql = "delete from product where id = "+ id;
            pre = conn.prepareStatement(sql);
            int i = pre.executeUpdate();
            return  i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pre);
        }
        return 0;
    }

    @Override
    public int findCount(Product product) {
        try{
            conn = JDBCUtil.getConnection();
            String sql = "select count(1) from product where 1 = 1 ";

            if(product!=null){
                if(product.getName()!=null && !"".equals(product.getName())){
                    sql += " and name like '%"+product.getName()+"%'";
                }
                if (product.getCategory()!=null && !"".equals(product.getCategory())){
                    sql += " and category ='"+product.getCategory()+"'";
                }
                if(product.getState()==0 || product.getState()==1){
                    sql += " and state =" + product.getState();
                }
            }
            System.out.println("11111"+sql);
            pre =conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pre);
        }
        return 0;
    }

    @Override
    public List<Product> findByCondition(Product product, int pageSize, int pageNum) {

        List<Product> productList = new ArrayList<>();

        try{
            conn = JDBCUtil.getConnection();
            String sql = "select id,name,price,category,stock,state from product where 1 = 1 ";
            if(product!=null){
                if(product.getName()!=null && !"".equals(product.getName())){
                    sql += " and name like '%"+product.getName()+"%'";
                }
                if (product.getCategory()!=null && !"".equals(product.getCategory())){
                    sql += " and category ='"+product.getCategory()+"'";
                }
                if(product.getState()==0 || product.getState()==1){
                    sql += " and state =" + product.getState();
                }
            }

            sql += " limit " +(pageNum-1)*pageSize +","+pageSize;

            System.out.println("2222222"+sql);

            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                int stock = rs.getInt("stock");
                int state = rs.getInt("state");

                //封装到bean
                Product pd = new Product();
                pd.setId(id);
                pd.setCategory(category);
                pd.setStock(stock);
                pd.setState(state);
                pd.setPrice(price);
                pd.setName(name);
                //将每一条数据添加到集合
                productList.add(pd);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pre,rs);
        }
        return productList;
    }
}
