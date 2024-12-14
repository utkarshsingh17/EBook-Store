/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dto.Books;
import java.util.List;

/**
 *
 * @author kali
 */
public interface IBookService {
    
    public boolean insertBook(Books book);

    public List<Books> getAllBooks();

    public Books getBookById(Integer id);

    public boolean updateBook(Books books);

    public boolean deleteBook(Integer id);

    public List<Books> getNewBooks();

    public List<Books> getRecentBooks();

    public List<Books> getOldBooks();

    public List<Books> getAllRecentBook();

    public List<Books> getAllNewBook();

    public List<Books> getAllOldBook();

    public List<Books> getUserAllOldBooks(String email, String category);
    
    public boolean deleteUserOldBook(String email,String category, Integer bookId);
    
    public List<Books> getBookBySearch(String ch);
}
