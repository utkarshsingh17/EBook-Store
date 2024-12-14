/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoFactory;

import com.dao.IBookDao;
import com.daoImpl.BookDaoImpl;

/**
 *
 * @author kali
 */
public class BookDaoFactory {
    private BookDaoFactory(){
        
    }
    private static IBookDao bookDao=null;
    public static IBookDao getBookDao(){
        if(bookDao==null){
            bookDao=new BookDaoImpl();
        }
        return bookDao;
    }
}
