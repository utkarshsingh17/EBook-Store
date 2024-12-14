/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoFactory;

import com.dao.IBookOrderDao;
import com.daoImpl.BookOrderDaoImpl;

/**
 *
 * @author kali
 */
public class BookOrderDaoFactory {
    private BookOrderDaoFactory(){
        
    }
    private static IBookOrderDao bookOrderDao=null;
    public static IBookOrderDao getBookOrderDao(){
        if(bookOrderDao==null){
            bookOrderDao=new BookOrderDaoImpl();
        }
        return bookOrderDao;
    }
}
