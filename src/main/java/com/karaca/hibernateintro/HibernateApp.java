/*
 * MIT License
 * 
 * Copyright (c) 2016 kemalsamikaraca
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.karaca.hibernateintro;

import com.karaca.hibernateintro.common.User;
import com.karaca.hibernateintro.persistence.HibernateUtil;
import org.hibernate.Session;

public class HibernateApp {
    
    public static void main(String[] args){
        // -1- Add User to Table
        registerNewUser("kemalsamikaraca" , "java-developer" , "kskaraca@gmail.com");
            
        // -2- Close Connection
        HibernateUtil.shutdown();    
    }
    
    /**
     * 
     * @param username
     * @param password
     * @param mail 
     */
    public static void registerNewUser(String username, String password, String mail){
        // -- 1 -- Transaction begin
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        // -- 2 -- Set user values
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(mail);
        
        // -- 3 -- Transaction commit 
        session.save(user);
        session.getTransaction().commit(); 
    }
    
}

