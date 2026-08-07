/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getKoneksi() {

        if (koneksi == null) {

            try {

                String url = "jdbc:mysql://localhost:3306/db_minimarket";
                String user = "root";
                String password = "";

                koneksi = DriverManager.getConnection(url, user, password);

                System.out.println("Database berhasil terkoneksi.");

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null,
                        "Koneksi gagal : " + e.getMessage());

            }

        }

        return koneksi;

    }

}
