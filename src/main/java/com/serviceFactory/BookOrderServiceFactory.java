/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.BookOrderServiceImpl;
import com.service.IBookOrderService;

/**
 *
 * @author kali
 */
public class BookOrderServiceFactory {
    private BookOrderServiceFactory(){
        
    }
    private static IBookOrderService bookOrderService=null;
    public static IBookOrderService  getBookOrderService(){
        if(bookOrderService==null){
            bookOrderService=new BookOrderServiceImpl();
        }
    
    return bookOrderService;
    }
}
