/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dao;

import com.dto.Books;
import com.dto.Cart;
import java.util.List;

/**
 *
 * @author kali
 */
public interface ICartDao {
    
    public boolean addCart(Cart cart);
    
    public List<Cart> getBookByUserId(Integer id);
    
    public boolean deleteBook(Integer bid, Integer uid, Integer cid);
    
}
