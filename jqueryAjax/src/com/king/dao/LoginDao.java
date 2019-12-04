package com.king.dao;

import com.king.domain.User;
import com.king.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDao {

    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDs());

    public User query(User user){
        String sql = "select * from user where username = ? and password = ?";
        User u = null;
        try {
            u = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
            return u;
        }
        return u;
    }
}
