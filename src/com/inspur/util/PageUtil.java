package com.inspur.util;

import java.util.List;

/**
 * @Author：齐文勇
 * @Package：com.inspur.util
 * @Project：ProductMS
 * @name：PageUtil
 * @Date：2024/11/6 8:50
 * @Filename：PageUtil
 * 分页工具类
 */
public class PageUtil<T> {
    //当前第几页
    private int pageNum;
    //每页显示条数
    private int pageSize;
    //总条数（数据库查询）
    private int totalCount;
    //判断是否有下一条数据（计算）
    private boolean hasNext;
    //是否有上一页数据（计算）
    private boolean hasPre;
    // 最后一页（计算）
    private int lastPage;
    // 首页（计算）
    private int firstPage=1;
    // 用来封装查询条件
    private T  t;
    //当前页数据（数据库查询）
    private List<T> data;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    //判断是否有下一页
    public boolean isHasNext() {
        //当前页小于总页数说明有下一页
         if(getPageNum()<getLastPage()){
             return true;
         }else {
             return false;
         }

    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
    //判断是否有上一页
    public boolean isHasPre() {
        if(pageNum>1){
            return  true;
        }else {
            return  false;
        }

    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    //计算最后一页
    public int getLastPage() {
        if(getTotalCount()%getPageSize() == 0){
            return  getTotalCount()/getPageSize();
        }else{
            return  getTotalCount()/getPageSize() + 1;
        }

    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getFirstPage() {
        if(firstPage<1){
            return 1;
        }
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }
}
