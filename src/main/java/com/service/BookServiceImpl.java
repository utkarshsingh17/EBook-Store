/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.IBookDao;
import com.daoFactory.BookDaoFactory;
import com.dto.Books;
import java.util.List;

/**
 *
 * @author kali
 */
public class BookServiceImpl implements IBookService {
    IBookDao bookDao=null;
    public boolean insertBook(Books book){
         bookDao=BookDaoFactory.getBookDao();
        return bookDao.insertBook(book);
        
    }

    public List<Books> getAllBooks(){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getAllBooks();
    }

    public Books getBookById(Integer id){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getBookById(id);
    }

    public boolean updateBook(Books books){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.updateBook(books);
    }

    public boolean deleteBook(Integer id){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.deleteBook(id);
    }

    public List<Books> getNewBooks(){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getNewBooks();
    }

    public List<Books> getRecentBooks(){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getRecentBooks();
    }

    public List<Books> getOldBooks(){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getOldBooks();
    }

    public List<Books> getAllRecentBook(){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getAllRecentBook();
    }

    public List<Books> getAllNewBook(){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getAllNewBook();
    }

    public List<Books> getAllOldBook(){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getAllOldBook();
    }

    public List<Books> getUserAllOldBooks(String email, String category){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getUserAllOldBooks(email,category);
    }
    
    public boolean deleteUserOldBook(String email,String category, Integer bookId){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.deleteUserOldBook(email,category,bookId);
    }
    
    public List<Books> getBookBySearch(String ch){
        bookDao=BookDaoFactory.getBookDao();
        return bookDao.getBookBySearch(ch);
    }
    
}
