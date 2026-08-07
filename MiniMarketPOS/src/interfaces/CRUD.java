/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

public interface CRUD {

    // Method abstrak
    void tambah();

    void ubah();

    void hapus();

    void tampil();

    // Method static
    static void infoAplikasi() {
        System.out.println("=== MiniMarket POS System ===");
    }

    // Method default
    default void berhasil() {
        System.out.println("Operasi berhasil dilakukan.");
    }
}
