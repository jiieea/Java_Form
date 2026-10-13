/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopdemo;

/**
 *
 * @author USER
 */
public class Mahasiswa {
    private String nim;
    private String nama;
    private double ipk;
    private String angkatan;

    public Mahasiswa(String nim, String nama, double ipk, String angkatan) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.angkatan = angkatan;
    }
    // Getter dan Setter
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public double getIpk() { return ipk; }
    public String getAngkatan() { return angkatan; }

    public String getStatus() {
        return ipk >= 2.0 ? "Aktif / Memenuhi Syarat" : "Dalam Pengawasan (DO Warning)";
    }
    // Method cetak untuk console
    public void tampilkanInformasi() {
        System.out.println("NIM      : " + nim);
        System.out.println("Nama     : " + nama);
        System.out.println("IPK      : " + ipk);
        System.out.println("Angkatan : " + angkatan);
        System.out.println("Status   : " + getStatus());
        System.out.println("---------------------------------------------");
    }
}
