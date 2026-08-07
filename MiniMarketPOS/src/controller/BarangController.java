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
import model.Barang;

public class BarangController implements CRUD {
    public Barang cariBarang(int idBarang) {

    Barang barang = null;

    try {

        String sql = "SELECT * FROM barang WHERE id_barang=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, idBarang);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            barang = new Barang();

            barang.setIdBarang(rs.getInt("id_barang"));
            barang.setNamaBarang(rs.getString("nama_barang"));
            barang.setKategori(rs.getString("kategori"));
            barang.setHarga(rs.getDouble("harga"));
            barang.setStok(rs.getInt("stok"));

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

    return barang;
}

    Connection conn = Koneksi.getKoneksi();

    @Override
public void tambah() {

    try {

        String sql = "INSERT INTO barang(nama_barang,harga,stok) VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, "Indomie");
        ps.setDouble(2, 3500);
        ps.setInt(3, 100);

        ps.executeUpdate();

        berhasil();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }
}
//overloading
public void tambah(Barang barang) {

    try {

        String sql = "INSERT INTO barang(kode_barang, nama_barang, kategori, harga, stok) VALUES(?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, barang.getKodeBarang());
        ps.setString(2, barang.getNamaBarang());
        ps.setString(3, barang.getKategori());
        ps.setDouble(4, barang.getHarga());
        ps.setInt(5, barang.getStok());

        ps.executeUpdate();

        berhasil();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

}

    @Override
public void ubah() {

    try {

        String sql = "UPDATE barang SET harga=? WHERE id_barang=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDouble(1, 4000);

        ps.setInt(2, 1);

        ps.executeUpdate();

        berhasil();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

}

    @Override
public void hapus() {

    try {

        String sql = "DELETE FROM barang WHERE id_barang=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, 1);

        ps.executeUpdate();

        berhasil();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

}

    public void hapus(int idBarang) {

    try {

        // Cek apakah barang sudah digunakan dalam transaksi
        String cekSql = "SELECT COUNT(*) AS jumlah " +
                        "FROM detail_transaksi " +
                        "WHERE id_barang=?";

        PreparedStatement cekPs = conn.prepareStatement(cekSql);
        cekPs.setInt(1, idBarang);

        ResultSet rs = cekPs.executeQuery();

        if (rs.next() && rs.getInt("jumlah") > 0) {

            JOptionPane.showMessageDialog(
                null,
                "Barang tidak dapat dihapus karena sudah digunakan dalam transaksi!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Jika belum pernah digunakan dalam transaksi, lakukan hapus
        String sql = "DELETE FROM barang WHERE id_barang=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idBarang);

        int hasil = ps.executeUpdate();

        if (hasil > 0) {

            JOptionPane.showMessageDialog(
                null,
                "Data barang berhasil dihapus!"
            );

        } else {

            JOptionPane.showMessageDialog(
                null,
                "Data barang tidak ditemukan!"
            );

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            null,
            "Gagal menghapus data barang: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );

    }

}

    @Override
public void tampil() {

    try {

        String sql = "SELECT * FROM barang";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            System.out.println(
                    rs.getInt("id_barang") + " | " +
                    rs.getString("nama_barang") + " | " +
                    rs.getDouble("harga") + " | " +
                    rs.getInt("stok"));

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

}

    public void ubah(Barang barang) {

    try {

        String sql = "UPDATE barang SET kode_barang=?, nama_barang=?, kategori=?, harga=?, stok=? WHERE id_barang=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, barang.getKodeBarang());
        ps.setString(2, barang.getNamaBarang());
        ps.setString(3, barang.getKategori());
        ps.setDouble(4, barang.getHarga());
        ps.setInt(5, barang.getStok());
        ps.setInt(6, barang.getIdBarang());

        ps.executeUpdate();

        berhasil();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }

}

    public ResultSet tampilData() {

    try {

        String sql = "SELECT * FROM barang";

        PreparedStatement ps = conn.prepareStatement(sql);

        return ps.executeQuery();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

    return null;

}
    
    public int getNextId() {

        int nextId = 1;

        try {

            String sql = "SELECT MAX(id_barang) AS max_id FROM barang";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nextId = rs.getInt("max_id") + 1;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return nextId;

    }
    
    public String getNextKodeBarang(String kategori) {

    String prefix;

    // Menentukan prefix berdasarkan kategori
    if (kategori.equalsIgnoreCase("Minuman")) {

        prefix = "MNM";

    } else if (kategori.equalsIgnoreCase("Makanan")) {

        prefix = "MKN";

    } else {

        prefix = "BRG";

    }

    int nomorBerikutnya = 1;

    try {

        String sql = "SELECT kode_barang " +
                     "FROM barang " +
                     "WHERE kode_barang LIKE ? " +
                     "ORDER BY kode_barang DESC " +
                     "LIMIT 1";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, prefix + "%");

        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getString("kode_barang") != null) {

            String kodeTerakhir = rs.getString("kode_barang");

            // Ambil angka dari kode
            String angkaStr = kodeTerakhir.replaceAll("[^0-9]", "");

            if (!angkaStr.isEmpty()) {

                nomorBerikutnya =
                    Integer.parseInt(angkaStr) + 1;

            }

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            null,
            e.getMessage()
        );

    }

    return prefix +
           String.format("%03d", nomorBerikutnya);
}
    
    public Barang cariBarangByKode(String kodeBarang) {

    Barang barang = null;

    try {

        String sql = "SELECT * FROM barang WHERE kode_barang=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, kodeBarang);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            barang = new Barang();

            barang.setIdBarang(rs.getInt("id_barang"));
            barang.setKodeBarang(rs.getString("kode_barang"));
            barang.setNamaBarang(rs.getString("nama_barang"));
            barang.setKategori(rs.getString("kategori"));
            barang.setHarga(rs.getDouble("harga"));
            barang.setStok(rs.getInt("stok"));

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }

    return barang;

}

}
