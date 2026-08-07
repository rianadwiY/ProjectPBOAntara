/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import database.Koneksi;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Kasir;

public class KasirController implements CRUD {

    Connection conn = Koneksi.getKoneksi();

    public boolean login(String username, String password) {

        try {

            String sql = "SELECT * FROM kasir WHERE username=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return false;
    }

    // ==== Implementasi method abstrak dari interface CRUD ====

        //KasirController meng override method dari interface CRUD
    @Override
    public void tambah() {

        try {

            String sql = "INSERT INTO kasir(nama,username,password) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "Kasir Baru");
            ps.setString(2, "kasirbaru");
            ps.setString(3, "12345");

            ps.executeUpdate();

            berhasil();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }
    
    //overloading
    public void tambah(Kasir kasir) {

        try {

            String sql = "INSERT INTO kasir(nama,username,password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kasir.getNamaKasir());
            ps.setString(2, kasir.getUsername());
            ps.setString(3, kasir.getPassword());

            ps.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    @Override
    public void ubah() {

        try {

            String sql = "UPDATE kasir SET nama=? WHERE id_kasir=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "Kasir Update");
            ps.setInt(2, 1);

            ps.executeUpdate();

            berhasil();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }
       //overloading
    public void ubah(Kasir kasir) {

        try {

            String sql = "UPDATE kasir SET nama=?, username=?, password=? WHERE id_kasir=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kasir.getNamaKasir());
            ps.setString(2, kasir.getUsername());
            ps.setString(3, kasir.getPassword());
            ps.setInt(4, kasir.getIdKasir());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil diubah");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    @Override
    public void hapus() {

        try {

            String sql = "DELETE FROM kasir WHERE id_kasir=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, 1);

            ps.executeUpdate();

            berhasil();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

        //overloading
    public void hapus(int idKasir) {

        try {

            String sql = "DELETE FROM kasir WHERE id_kasir=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idKasir);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    @Override
    public void tampil() {

        try {

            String sql = "SELECT * FROM kasir";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id_kasir") + " | " +
                        rs.getString("nama") + " | " +
                        rs.getString("username"));

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public ResultSet tampilData() {

        try {

            String sql = "SELECT * FROM kasir";

            PreparedStatement ps = conn.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;
    }

}