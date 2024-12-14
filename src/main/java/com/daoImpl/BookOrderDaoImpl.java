/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoImpl;

import com.dto.BookOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dao.IBookOrderDao;

import com.util.JdbcUtil;

/**
 *
 * @author kali
 */
public class BookOrderDaoImpl implements IBookOrderDao {

     Connection con=null;
     PreparedStatement ps=null;
     ResultSet rs=null;

   

    @Override
    public boolean saveOrder(List<BookOrder> bList) {
        boolean f = false;
        try {
             con=JdbcUtil.getJdbcConnection();
            String insertOrder = "insert into book_order(order_id,user_name,email,address,book_name,author,price,payment,number) values(?,?,?,?,?,?,?,?,?)";
            con.setAutoCommit(false);
            ps = con.prepareStatement(insertOrder);
            for (BookOrder b : bList) {
                ps.setString(1, b.getOrderId());
                ps.setString(2, b.getUserName());
                ps.setString(3, b.getEmail());
                ps.setString(4, b.getFullAddress());
                ps.setString(5, b.getBookName());
                ps.setString(6, b.getAuthorName());
                ps.setString(7, b.getPrice());
                ps.setString(8, b.getPaymentType());
                ps.setString(9, b.getPhoneNumber());
                ps.addBatch();
            }
            int[] count = ps.executeBatch();
            con.commit();
            con.setAutoCommit(true);
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
    public List<BookOrder> getAllBookByUser(String email) {
        List<BookOrder> list = new ArrayList<>();
        BookOrder b = null;
        try {
             con=JdbcUtil.getJdbcConnection();
            String query = "select * from book_order where email=? ORDER by order_id DESC";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                b = new BookOrder();
                b.setId(rs.getInt("id"));
                b.setOrderId(rs.getString("order_id"));
                b.setUserName(rs.getString("user_name"));
                b.setEmail(rs.getString("email"));
                b.setFullAddress(rs.getString("address"));
                b.setBookName(rs.getString("book_name"));
                b.setAuthorName(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                b.setPaymentType(rs.getString("payment"));
                b.setPhoneNumber(rs.getString("number"));
                b.setOrderTime(rs.getString("order_time" + ""));
                list.add(b);
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
        return list;
    }

    @Override
    public List<BookOrder> getAllBookByAdmin() {
        List<BookOrder> list = new ArrayList<>();
        BookOrder b = null;
        try {
             con=JdbcUtil.getJdbcConnection();
            String query = "select * from book_order ORDER by order_id DESC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = new BookOrder();
                b.setId(rs.getInt("id"));
                b.setOrderId(rs.getString("order_id"));
                b.setUserName(rs.getString("user_name"));
                b.setEmail(rs.getString("email"));
                b.setFullAddress(rs.getString("address"));
                b.setBookName(rs.getString("book_name"));
                b.setAuthorName(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                b.setPaymentType(rs.getString("payment"));
                b.setPhoneNumber(rs.getString("number"));
                b.setOrderTime(rs.getString("order_time" + ""));
                list.add(b);
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
        return list;
    }

    @Override
    public BookOrder getBookByOrderId(String arg0) {
        BookOrder b = new BookOrder();
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from book_order where order_id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, arg0);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = new BookOrder();
                b.setId(rs.getInt("id"));
                b.setOrderId(rs.getString("order_id"));
                b.setUserName(rs.getString("user_name"));
                b.setEmail(rs.getString("email"));
                b.setFullAddress(rs.getString("address"));
                b.setBookName(rs.getString("book_name"));
                b.setAuthorName(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                b.setPaymentType(rs.getString("payment"));
                b.setPhoneNumber(rs.getString("number"));
                b.setOrderTime(rs.getString("order_time" + ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return b;
    }

}
