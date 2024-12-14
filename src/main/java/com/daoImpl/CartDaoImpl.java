/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoImpl;

import com.dto.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dao.ICartDao;
import com.util.JdbcUtil;

/**
 *
 * @author kali
 */
public class CartDaoImpl implements ICartDao {

    Connection con=null;
     PreparedStatement ps=null;
     ResultSet rs=null;


   

    @Override
    public boolean addCart(Cart arg0) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String insert = "insert into cart(bid,uid,bookName,author,price,totalPrice) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(insert);  
            ps.setInt(1, arg0.getBid());
            ps.setInt(2, arg0.getUid());
            ps.setString(3, arg0.getBookName());
            ps.setString(4, arg0.getAuthor());
            ps.setDouble(5, arg0.getPrice());
            ps.setDouble(6, arg0.getTotalPrice());

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
    public List<Cart> getBookByUserId(Integer arg0) {
        List<Cart> list = new ArrayList<>();
        Cart c = null;
        double totalPrice=0;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from cart where uid=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, arg0);
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                c = new Cart();
                c.setAuthor(rs.getString("author"));
                c.setBid(rs.getInt("bid"));
                c.setBookName(rs.getString("bookName"));
                c.setCid(rs.getInt("cid"));
                c.setPrice(rs.getDouble("price"));
                c.setUid(rs.getInt("uid"));
                totalPrice = totalPrice+ rs.getDouble("price");
                c.setTotalPrice(totalPrice);
                list.add(c);
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
    public boolean deleteBook(Integer arg0, Integer arg1, Integer arg2) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String delete = "delete from cart where bid=? and uid=? and cid=?";
            ps = con.prepareStatement(delete);
            ps.setInt(1, arg0);
            ps.setInt(2, arg1);
            ps.setInt(3, arg2);
            Integer roll = ps.executeUpdate();
            if(roll==1)
            {
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

}
