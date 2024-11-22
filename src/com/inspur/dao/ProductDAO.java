package com.inspur.dao;

import com.inspur.bean.Product;

import java.util.List;

/**
 * @Author：齐文勇
 * @Package：com.inspur.dao
 * @Project：ProductMS
 * @name：ProductDAO
 * @Date：2024/10/23 9:15
 * @Filename：ProductDAO
 * 商品持久层接口
 * 做CURD操作
 */
public interface ProductDAO {
    /**
     *
     * @param product 页面传值
     * @return
     */
    public int save(Product product);

    /**
     * 获取全列表
     * @return
     */
    public List<Product> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Product  findById(String id);

    /**
     * 根据id修改
     * @param product 页面修改后的数据
     * @param id
     * @return
     */
    public int updateById(Product product,String id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int deleteById(String id);

    /**
     * 根据条件查询总条数
     * @param product
     * @return
     */
    public int  findCount(Product product);

    /**
     *
     * @param product  条件
     * @param pageSize 每页显示条数
     * @param pageNum  当前页数
     * @return
     */
    public List<Product> findByCondition(Product product,int pageSize,int pageNum);

}
