/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoImpl;

import com.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dao.IUserDao;
import com.util.JdbcUtil;

/**
 *
 * @author kali
 */
public class UserDaoImpl implements IUserDao {

    Connection con=null;
     PreparedStatement ps=null;
     ResultSet rs=null;

   

    @Override
    public boolean userRegistration(User arg0) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String insert = "insert into users(name,email,phoneNumber,password) values(?,?,?,?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, arg0.getName());
            ps.setString(2, arg0.getEmail());
            ps.setString(3, arg0.getPhoneNumber());
            ps.setString(4, arg0.getPassword());
            Integer roll = ps.executeUpdate();
            if (roll == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }

    @Override
    public User loginUser(String arg0, String arg1) {
       User u = new User();
        try {
             con=JdbcUtil.getJdbcConnection();
            String login = "select * from users where email = ? and password = ?";
            ps = con.prepareStatement(login);
            ps.setString(1, arg0);
            ps.setString(2, arg1);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setCity(rs.getString("city"));
                u.setEmail(rs.getString("email"));
                u.setLandmark(rs.getString("landmark"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setState(rs.getString("state"));
                u.setUserId(rs.getInt("id"));
                u.setZipCode(rs.getString("zip"));
                u.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public boolean updateProfile(User arg0) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String update = "update users set name=?, email=?, phoneNumber=?, password=? where id = ?";
            ps = con.prepareStatement(update);
            ps.setString(1, arg0.getName());
            ps.setString(2, arg0.getEmail());
            ps.setString(3, arg0.getPhoneNumber());
            ps.setString(4, arg0.getPassword());
            ps.setInt(5, arg0.getUserId());

            Integer roll = ps.executeUpdate();
            if (roll == 1) {
                f = true;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }

    @Override
    public User getUserByUserId(Integer arg0) {
        User u = new User();
        try {
            con=JdbcUtil.getJdbcConnection();
            String login = "select * from users where id=?";
            ps = con.prepareStatement(login);
            ps.setInt(1, arg0);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setCity(rs.getString("city"));
                u.setEmail(rs.getString("email"));
                u.setLandmark(rs.getString("landmark"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setState(rs.getString("state"));
                u.setUserId(rs.getInt("id"));
                u.setZipCode(rs.getString("zip"));
                u.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public boolean updateUserOtherDetail(User arg0) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String update = "update users set address=?, landmark=?, city=?, state=?, zipcode=? where id = ?";
            ps = con.prepareStatement(update);
            ps.setString(1, arg0.getAddress());
            ps.setString(2, arg0.getLandmark());
            ps.setString(3, arg0.getCity());
            ps.setString(4, arg0.getState());
            ps.setString(5, arg0.getZipCode());
            ps.setInt(6, arg0.getUserId());

            Integer roll = ps.executeUpdate();
            if (roll == 1) {
                f = true;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }

    @Override
    public boolean checkEmail(String arg0) {
        boolean f = true;
        try {
            con=JdbcUtil.getJdbcConnection();
            String update = "select * from users where email=?";
            ps = con.prepareStatement(update);
            ps.setString(1, arg0);
            rs = ps.executeQuery();
            while (rs.next()) {
                f = false;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }

}
