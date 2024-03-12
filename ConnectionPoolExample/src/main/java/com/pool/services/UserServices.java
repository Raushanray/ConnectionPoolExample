package com.pool.services;

import com.pool.models.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServices {

    //Autowire the JdbcClient

    private JdbcClient jdbcClient;

    //constructor injection
    public UserServices(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    //Create user
    public Users saveUser(Users users){

//        String query = "insert into users(id, name, about) values(?, ?, ?)";
//        int update = jdbcClient.sql(query)
//                .param(1, users.getId())
//                .param(2, users.getName())
//                .param(3, users.getAbout())
//                .update();
//        System.out.println("user added: " + update);

        jdbcClient.sql("insert into users(id, name, about) values(:id, :name, :about)").param("id", users.getId()).param("name", users.getName()).param("about", users.getAbout()).update();
        return users;
    }

    //get all users
    public List<Users> getAllUsers(){
//        return jdbcClient.sql("select * from users").query(Users.class).list();

        return jdbcClient.sql("select * from users").query(new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Users(rs.getInt("id"), rs.getString("name"), rs.getString("about"));
            }
        }).list();
    }
//    get single user
    public Users getUserById(int id){
        return jdbcClient.sql("select * from users where id= :id").param("id", id).query(Users.class).single();
    }

    //update user
//    TODO://

    //delete user
    public void deleteUser(int id){
        jdbcClient.sql("delete from users where id= :id").param("id", id).update();
    }


}
