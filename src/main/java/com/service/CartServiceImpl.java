/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.ICartDao;
import com.daoFactory.CartDaoFactory;
import com.dto.Cart;
import java.util.List;

/**
 *
 * @author kali
 */
public class CartServiceImpl implements ICartService{
    ICartDao cartDao=null;
      public boolean addCart(Cart cart){
          cartDao=CartDaoFactory.getCartDao();
          return cartDao.addCart(cart);
      }
    
    public List<Cart> getBookByUserId(Integer id){
        cartDao=CartDaoFactory.getCartDao();
          return cartDao.getBookByUserId(id);
    }
    
    public boolean deleteBook(Integer bid, Integer uid, Integer cid){
        cartDao=CartDaoFactory.getCartDao();
          return cartDao.deleteBook(bid,uid,cid);
    }
}
