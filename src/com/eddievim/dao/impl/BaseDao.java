package com.eddievim.dao.impl;

import com.eddievim.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * @param sql
     * @param args
     * @return 返回-1失败，其他表示影响的行数
     * @throws SQLException
     */
    public int update(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 查询返回一个JavaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   sql语句
     * @param args  参数
     * @param <T>   返回的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 查询返回多个JavaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   sql语句
     * @param args  参数
     * @param <T>   返回的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Object queryForSingleValue(String sql, Object... args){
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}