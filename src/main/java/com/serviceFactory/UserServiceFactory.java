/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.IUserService;
import com.service.UserServiceImpl;

/**
 *
 * @author kali
 */
public class UserServiceFactory {
    private UserServiceFactory(){

    }
    private static IUserService userService=null;
    public static IUserService getUserService(){
        if(userService==null) {
            userService = new UserServiceImpl();
        }
        return userService;

    }
}
