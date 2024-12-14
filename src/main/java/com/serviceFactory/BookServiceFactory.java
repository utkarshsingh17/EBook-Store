/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.BookServiceImpl;
import com.service.IBookService;

/**
 *
 * @author kali
 */
public class BookServiceFactory {
    private BookServiceFactory(){
        
    }
    private static  IBookService bookService=null;
    public static IBookService getBookService(){
        if(bookService==null){
            bookService=new BookServiceImpl();
        }
        return bookService;
    }
    
}
