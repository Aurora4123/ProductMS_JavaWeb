package com.inspur.util;

import java.sql.*;

/**
 * @Author：齐文勇
 * @Package：com.inspur.util
 * @Project：UsersProject
 * @name：JDBCUtil
 * @Date：2024/9/18 8:52
 * @Filename：JDBCUtil
 */
public class JDBCUtil {
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String USER ="root";
    private static final String PASS ="admin";
    private static final String URL ="jdbc:mysql://localhost:3306/mydb";
    private static  Connection connection =null;

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASS);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    /*对于增删改 关闭资源*/
   public static void close(Connection connection, Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
       /* if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       close(connection,statement);

    }
    /*public static void main(String[] args) {
        System.out.println(getConnection());
    }*/
}
