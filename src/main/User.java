/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author yo
 */
public class User {
    public int id;
    public String name;
    public String email;
    public String password;
    public boolean isAdmin;

    @Override
    public String toString() {
        return "User" +
                "id=" + id +
                ", name'" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    } 
}
