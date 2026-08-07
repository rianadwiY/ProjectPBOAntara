/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import database.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TransaksiController {
    public int simpanTransaksi(int idKasir, double total, double bayar, double kembalian) {

    int idTransaksi = 0;

    try {

        String sql = "INSERT INTO transaksi(id_kasir,total,bayar,kembalian) VALUES(?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setInt(1, idKasir);
        ps.setDouble(2, total);
        ps.setDouble(3, bayar);
        ps.setDouble(4, kembalian);

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            idTransaksi = rs.getInt(1);
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

    return idTransaksi;
}
    public void simpanDetail(int idTransaksi, int idBarang, int qty, double harga, double subtotal) {

    try {

        String sql = "INSERT INTO detail_transaksi(id_transaksi,id_barang,jumlah,harga,subtotal) VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, idTransaksi);
        ps.setInt(2, idBarang);
        ps.setInt(3, qty);
        ps.setDouble(4, harga);
        ps.setDouble(5, subtotal);

        ps.executeUpdate();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

}
    public void updateStok(int idBarang, int qty) {

    try {

        String sql = "UPDATE barang SET stok = stok - ? WHERE id_barang=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, qty);
        ps.setInt(2, idBarang);

        ps.executeUpdate();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

}
    public ResultSet tampilRiwayat() {

    try {

        String sql =
        "SELECT transaksi.id_transaksi, " +
        "transaksi.tanggal, " +
        "kasir.nama, " +
        "transaksi.total, " +
        "transaksi.bayar, " +
        "transaksi.kembalian " +
        "FROM transaksi " +
        "JOIN kasir ON transaksi.id_kasir = kasir.id_kasir " +
        "ORDER BY transaksi.id_transaksi DESC";

        PreparedStatement ps = conn.prepareStatement(sql);

        return ps.executeQuery();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

    return null;

}

    Connection conn = Koneksi.getKoneksi();

}
