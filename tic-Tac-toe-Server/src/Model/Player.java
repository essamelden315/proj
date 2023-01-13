/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
<<<<<<< HEAD

import java.io.Serializable;
=======
>>>>>>> df36f219b6f4c368a3022fdbaa1f3e434c5899b1

/**
 *
 * @author HP
 */
public class Player implements Serializable{
    private int ID;
    private String name;
    private String email;
    private String password;
    private final static long serialVersionUID = 42L;
    
     public Player() 
    {
       
    }
    public Player(int ID, String name, String email, String password) 
    {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
    }
     public Player(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
