package com.lyp.dao.impl;

import com.lyp.dao.ItemsDao;
import com.lyp.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-08-11-12:26
 */
public class ItemsDaoImpl implements ItemsDao {
    @Override
    public List<User> findAll() throws Exception{
        //把数据库结果集转成java的List集合
        List<User> list = new ArrayList<User>();
        //先获取contection对象
        Connection connection = null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //先获取contection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy", "root", "qwe123");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select  * from user");
            //执行数据库查询操作
            rs = pst.executeQuery();

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rs.close();
            pst.close();
            connection.close();
        }
    return list;
    }
}
