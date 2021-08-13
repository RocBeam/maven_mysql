package com.lyp.test;

import com.lyp.dao.ItemsDao;
import com.lyp.dao.impl.ItemsDaoImpl;
import com.lyp.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @create 2021-08-11-12:44
 */
public class ItemsTest{
    @Test
    public void findAl() throws Exception{
        ItemsDao itemsDao = new ItemsDaoImpl();
        List<User> list =  itemsDao.findAll();
        for(User user : list){
            System.out.println(user.getUsername());
            System.out.println("hello");
        }
    }
}
