package com.runoob;

import java.sql.*;

/**
 * 连接数据库实例
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/28 22:14
 */
public class MysqlDemo {

    /**
     * JDBC驱动名及其数据库URL
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/pyspider_db";

    /**
     * 数据库的用户与密码
     */
    static final String USER = "root";
    static final String PASSWORD = "zbc12300";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "select id, name, url from websites;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                System.out.printf("ID: %d\t站点名称：%s\t站点URL：%s\n", id, name, url);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
