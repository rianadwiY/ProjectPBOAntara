/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Admin extends User {

    public Admin() {
    }
    //pemanggilan constructor dan method superclass menggunakan super.
    public Admin(int id, String nama, String username, String password) {
        super(id, nama, username, password);
    }

        //admin mengoverride method dari user
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role : Admin");
    }
}
