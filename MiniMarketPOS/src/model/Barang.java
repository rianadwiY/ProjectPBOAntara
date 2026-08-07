/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;
public class Barang {
    private int idBarang;
    private String kodeBarang;
    private String namaBarang;
    private double harga;
    private int stok;
    private String kategori;
    
    //constraktor
    public Barang() {
    }
    public Barang(int idBarang, String kodeBarang, String namaBarang, String kategori,
        double harga, int stok) {
    this.idBarang = idBarang;
    this.kodeBarang = kodeBarang;
    this.namaBarang = namaBarang;
    this.kategori = kategori;
    this.harga = harga;
    this.stok = stok;
}
    //penerapan setter getter
    public int getIdBarang() {
        return idBarang;
    }
    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }
    public String getKodeBarang() {
        return kodeBarang;
    }
    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }
    //enkapsulasi
    public String getNamaBarang() {
        return namaBarang;
    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public String getKategori() {
    return kategori;
}
public void setKategori(String kategori) {
    this.kategori = kategori;
}
}