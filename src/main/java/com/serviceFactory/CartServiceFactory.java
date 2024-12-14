/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.CartServiceImpl;
import com.service.ICartService;

/**
 *
 * @author kali
 */
public class CartServiceFactory {
    private CartServiceFactory(){

    }
    private static ICartService cartService=null;
    public static ICartService getCartService(){
        if(cartService==null) {
            cartService = new CartServiceImpl();
        }
        return cartService;

    }
}
