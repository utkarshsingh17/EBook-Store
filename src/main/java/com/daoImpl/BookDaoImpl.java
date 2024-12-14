/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoImpl;

import com.dto.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dao.IBookDao;
import com.util.JdbcUtil;

/**
 *
 * @author kali
 */
public class BookDaoImpl implements IBookDao {

     Connection con=null;
     PreparedStatement ps=null;
     ResultSet rs=null;

  
    @Override
    public boolean insertBook(Books arg0) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String insert = "insert into books(bName,author,price,bookCategory,status,photo,email) values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, arg0.getBookName());
            ps.setString(2, arg0.getAuthor());
            ps.setString(3, arg0.getPrice());
            ps.setString(4, arg0.getBookCategory());
            ps.setString(5, arg0.getStatus());
            ps.setString(6, arg0.getPhotoName());
            ps.setString(7, arg0.getEmail());
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
    public List<Books> getAllBooks() {
        List<Books> list = new ArrayList<>();
        try {
            con=JdbcUtil.getJdbcConnection();
            String booksList = "select * from books";
            ps = con.prepareStatement(booksList);
            rs = ps.executeQuery();
            while (rs.next()) {
                Books b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
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
    public Books getBookById(Integer arg0) {
        Books b = new Books();
        try {
             con=JdbcUtil.getJdbcConnection();
            String booksList = "select * from books where id = ?";
             ps = con.prepareStatement(booksList);
            ps.setInt(1, arg0);
            rs = ps.executeQuery();
            while (rs.next()) {
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
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
        return b;
    }

    @Override
    public boolean updateBook(Books arg0) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String update = "update books set bName = ?,status=?,price=?,author=? where id = ?";
            ps = con.prepareStatement(update);
            ps.setString(1, arg0.getBookName());
            ps.setString(2, arg0.getStatus());
            ps.setString(3, arg0.getPrice());
            ps.setString(4, arg0.getAuthor());
            ps.setInt(5, arg0.getBookId());
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
    public boolean deleteBook(Integer arg0) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String delete = "delete from books where id = ?";
            ps = con.prepareStatement(delete);
            ps.setInt(1, arg0);

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
    public List<Books> getNewBooks() {
        List<Books> list = new ArrayList<>();
        Books b = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books  where bookCategory = ? and status=? order by id DESC";
            ps = con.prepareStatement(query);

            ps.setString(1, "New");
            ps.setString(2, "Active");
            rs = ps.executeQuery();
            Integer i = 1;
            while (rs.next() && i <= 4) {
                b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
                list.add(b);
                i++;
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
    public List<Books> getRecentBooks() {
        List<Books> list = new ArrayList<>();
        Books b = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books  where status=? order by id DESC";
            ps = con.prepareStatement(query);
            ps.setString(1, "Active");
            rs = ps.executeQuery();
            Integer i = 1;
            while (rs.next() && i <= 4) {
                b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
                list.add(b);
                i++;
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
    public List<Books> getOldBooks() {
        List<Books> list = new ArrayList<>();
        Books b = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books  where bookCategory = ? and status=? order by id DESC";
            ps = con.prepareStatement(query);

            ps.setString(1, "Old");
            ps.setString(2, "Active");
            rs = ps.executeQuery();
            Integer i = 1;
            while (rs.next() && i <= 4) {
                b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
                list.add(b);
                i++;
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
    public List<Books> getAllRecentBook() {
        List<Books> list = new ArrayList<>();
        Books b = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books  where status=? order by id DESC";
            ps = con.prepareStatement(query);
            ps.setString(1, "Active");
            rs = ps.executeQuery();

            while (rs.next()) {
                b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
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
    public List<Books> getAllNewBook() {
        List<Books> list = new ArrayList<>();
        Books b = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books  where bookCategory = ? and status=? order by id DESC";
            ps = con.prepareStatement(query);

            ps.setString(1, "New");
            ps.setString(2, "Active");
            rs = ps.executeQuery();

            while (rs.next()) {
                b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
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
    public List<Books> getAllOldBook() {
        List<Books> list = new ArrayList<>();

        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books  where bookCategory = ? and status=? order by id DESC";
            ps = con.prepareStatement(query);

            ps.setString(1, "Old");
            ps.setString(2, "Active");
            rs = ps.executeQuery();

            while (rs.next()) {
                Books b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
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
    public List<Books> getUserAllOldBooks(String arg0, String arg1) {
        List<Books> list = new ArrayList<>();
        Books b = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books where email=? and bookCategory=?";

            ps = con.prepareStatement(query);
            ps.setString(1, arg0);
            ps.setString(2, arg1);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
                list.add(b);
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
        return list;
    }

    @Override
    public boolean deleteUserOldBook(String arg0, String arg1, Integer arg2) {
        boolean b = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String delete = "delete from books where email=? and bookCategory=? and id=?";
            ps = con.prepareStatement(delete);
            ps.setString(1, arg0);
            ps.setString(2, arg1);
            ps.setInt(3, arg2);
            Integer roll = ps.executeUpdate();
            if (roll == 1) {
                b = true;
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
        return b;
    }

    @Override
    public List<Books> getBookBySearch(String arg0) {
        List<Books> list = new ArrayList<>();
        Books b = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from books  where bName like ? or author like ? or bookCategory like ? and status=?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + arg0 + "%");
            ps.setString(2, "%" + arg0 + "%");
            ps.setString(3, "%" + arg0 + "%");
            ps.setString(4, "Active");
            rs = ps.executeQuery();

            while (rs.next()) {
                b = new Books();
                b.setBookId(rs.getInt("id"));
                b.setAuthor(rs.getString("author"));
                b.setBookCategory(rs.getString("bookCategory"));
                b.setBookName(rs.getString("bName"));
                b.setEmail(rs.getString("email"));
                b.setPhotoName(rs.getString("photo"));
                b.setPrice(rs.getString("price"));
                b.setStatus(rs.getString("status"));
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

}
