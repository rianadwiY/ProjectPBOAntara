/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

public class Transaksi {

    private int idTransaksi;
    private String tanggal;
    private int idKasir;
    private double total;
    private double bayar;
    private double kembalian;

    public Transaksi() {
    }

    public Transaksi(int idTransaksi, String tanggal, int idKasir,
            double total, double bayar, double kembalian) {

        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.idKasir = idKasir;
        this.total = total;
        this.bayar = bayar;
        this.kembalian = kembalian;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getIdKasir() {
        return idKasir;
    }

    public void setIdKasir(int idKasir) {
        this.idKasir = idKasir;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBayar() {
        return bayar;
    }

    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    public double getKembalian() {
        return kembalian;
    }

    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }
}
