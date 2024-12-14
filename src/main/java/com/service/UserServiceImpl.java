/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.IUserDao;
import com.daoFactory.UserDaoFactory;
import com.dto.User;

/**
 *
 * @author kali
 */
public class UserServiceImpl implements IUserService {
    IUserDao userDao=null;
  public boolean userRegistration(User u){
      userDao=UserDaoFactory.getUserDao();
     return  userDao.userRegistration(u);
      
  }
    
    public User loginUser(String email, String password){
         userDao=UserDaoFactory.getUserDao();
     return  userDao.loginUser(email,password);
        
    }
    
    public boolean updateProfile(User u){
         userDao=UserDaoFactory.getUserDao();
     return  userDao.updateProfile(u);
    }
    
    public User getUserByUserId(Integer id){
         userDao=UserDaoFactory.getUserDao();
     return  userDao.getUserByUserId(id);
    }
    
    public boolean updateUserOtherDetail(User u){
         userDao=UserDaoFactory.getUserDao();
     return  userDao.updateUserOtherDetail(u);
    }
    
    public boolean checkEmail(String email){
         userDao=UserDaoFactory.getUserDao();
     return  userDao.checkEmail(email);
    }
    
}
