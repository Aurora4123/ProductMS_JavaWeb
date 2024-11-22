package com.inspur.service.impl;

import com.inspur.bean.Product;
import com.inspur.dao.impl.ProductDAOImpl;
import com.inspur.service.ProductService;
import com.inspur.util.PageUtil;

import java.util.List;

/**
 * @Author：齐文勇
 * @Package：com.inspur.service.impl
 * @Project：ProductMS
 * @name：ProductServiceImpl
 * @Date：2024/10/23 9:34
 * @Filename：ProductServiceImpl
 * 商品业务实现类
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public boolean save(Product product) {
        int save = new ProductDAOImpl().save(product);
        return save > 0 ? true : false;
    }

    @Override
    public List<Product> findAll() {
        return new ProductDAOImpl().findAll();
    }

    @Override
    public Product findById(String id) {
        return new ProductDAOImpl().findById(id);
    }

    @Override
    public boolean updateById(Product product, String id) {
        int i = new ProductDAOImpl().updateById(product, id);
        return i != 0 ? true : false;
    }

    @Override
    public boolean deleteById(String id) {
        int i = new ProductDAOImpl().deleteById(id);
        return i != 0 ? true : false;
    }

    @Override
    public PageUtil<Product> findByPage(Product product, int pageSize, int pageNum) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        //获取总条数
        int count = productDAO.findCount(product);
        //当前页数据
        List<Product> productList = productDAO.findByCondition(product, pageSize, pageNum);
        //将分页信息封装
        PageUtil<Product> pageUtil = new PageUtil<>();
        pageUtil.setT(product);
        pageUtil.setData(productList);
        pageUtil.setTotalCount(count);
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNum(pageNum);

        return pageUtil;
    }
}
