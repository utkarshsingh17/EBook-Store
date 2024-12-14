/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoFactory;

import com.dao.ICartDao;
import com.daoImpl.CartDaoImpl;

/**
 *
 * @author kali
 */
public class CartDaoFactory {
    private CartDaoFactory(){

    }
    private static ICartDao cartDao=null;
    public static ICartDao getCartDao(){
        if(cartDao==null) {
            cartDao = new CartDaoImpl();
        }
        return cartDao;

    }
}
