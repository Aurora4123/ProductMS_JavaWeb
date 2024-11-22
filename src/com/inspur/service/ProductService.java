package com.inspur.service;

import com.inspur.bean.Product;
import com.inspur.util.PageUtil;

import java.util.List;

/**
 * @Author：齐文勇
 * @Package：com.inspur.service
 * @Project：ProductMS
 * @name：ProductService
 * @Date：2024/10/23 9:32
 * @Filename：ProductService
 *
 * 商品业务接口
 */
public interface ProductService {
    /**
     * 添加
     * @param product
     * @return 添加成功返回true,否则返回false
     */
    public boolean  save(Product product);

    /**
     * 获取所有商品列表
     * @return
     */
    public List<Product>  findAll();

    /**
     * 根据id修改
     * @param id
     * @return
     */
    public Product findById(String id);

    /**
     * 修改
     * @param product
     * @param id
     * @return
     */
    public boolean updateById(Product product,String id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean deleteById(String id);

    /**
     *
     * @param product 条件
     * @param pageSize 每页显示条数
     * @param pageNum 当前第几页
     * @return 当前页所有数据（分页数据及列表数据）
     */
    public PageUtil<Product> findByPage(Product product,int pageSize,int pageNum);
}
