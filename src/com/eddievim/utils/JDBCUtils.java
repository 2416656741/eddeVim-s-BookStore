package com.eddievim.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static{
        //初始化dataSourse
        try {
            Properties properties = new Properties();

            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            //创建 数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return ： null失败，有值成功
     */
    public static Connection getConnection(){
        Connection conn = conns.get();

        if(conn == null) {
            try {
                conn = dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

//    public static void close(Connection conn){
//        if(conn != null) {
//            try {
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    /**
     * 提交事务并关闭释放连接
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        if(connection != null) {//如果不等于null 则
            try {
                connection.commit();//提交事务
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        //一定要执行remove操作
        conns.remove();
    }

    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if(connection != null) {//如果不等于null 则
            try {
                connection.rollback();//提交事务
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        //一定要执行remove操作
        conns.remove();
    }
}
