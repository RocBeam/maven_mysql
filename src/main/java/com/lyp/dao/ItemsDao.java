package com.lyp.dao;

import com.lyp.domain.User;

import java.util.List;

/**
 * @create 2021-08-11-12:24
 */
public interface ItemsDao {
    public List<User> findAll() throws Exception;

}
