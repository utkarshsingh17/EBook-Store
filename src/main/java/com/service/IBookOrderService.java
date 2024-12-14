/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dto.BookOrder;
import java.util.List;

/**
 *
 * @author kali
 */
public interface IBookOrderService {
    public boolean saveOrder(List<BookOrder> bList);
    
    public List<BookOrder> getAllBookByUser(String email);
    
    public List<BookOrder> getAllBookByAdmin();
    
    public BookOrder getBookByOrderId(String orderId);
}
