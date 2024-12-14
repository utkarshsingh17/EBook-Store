/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dao;

import com.dto.User;

/**
 *
 * @author kali
 */
public interface IUserDao {
    public boolean userRegistration(User u);
    
    public User loginUser(String email, String password);
    
    public boolean updateProfile(User u);
    
    public User getUserByUserId(Integer id);
    
    public boolean updateUserOtherDetail(User u);
    
    public boolean checkEmail(String email);
}
