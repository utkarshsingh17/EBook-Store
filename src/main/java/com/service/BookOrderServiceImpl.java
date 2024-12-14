/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.IBookOrderDao;
import com.daoFactory.BookOrderDaoFactory;
import com.dto.BookOrder;
import java.util.List;

/**
 *
 * @author kali
 */
public class BookOrderServiceImpl implements IBookOrderService {
    IBookOrderDao bookOrderDao=null;
    public boolean saveOrder(List<BookOrder> bList){
        bookOrderDao=BookOrderDaoFactory.getBookOrderDao();
        return bookOrderDao.saveOrder(bList);
        
    }
    
    public List<BookOrder> getAllBookByUser(String email){
             bookOrderDao=BookOrderDaoFactory.getBookOrderDao();
        return bookOrderDao.getAllBookByUser(email);
    }
    
    public List<BookOrder> getAllBookByAdmin(){
             bookOrderDao=BookOrderDaoFactory.getBookOrderDao();
        return bookOrderDao.getAllBookByAdmin();
    }
    
    public BookOrder getBookByOrderId(String orderId){
             bookOrderDao=BookOrderDaoFactory.getBookOrderDao();
        return bookOrderDao.getBookByOrderId(orderId);
    }
}
