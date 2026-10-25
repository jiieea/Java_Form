/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopdemo;

/**
 *
 * @author USER
 */
public class Matkul {
    String namaMk;
    int sks;
    String kodeMk;


    public Matkul(String namaMatkul, int sks,String kodeMk) {
        this.namaMk = namaMatkul;
        this.sks = sks;
        this.kodeMk = kodeMk;
    }
    
//    getter
    public String getNamaMk() {
        return namaMk;
    }
    public int getSks() {
        return sks;
    }
    public String getKodeMk() {
        return kodeMk;
    }

     public void tampilkanInformasi() {
        System.out.println("Nama Matkul      : " + namaMk);
        System.out.println("Kode matkul     : " + kodeMk);
        System.out.println("Jumlah SKS      : " + sks);
        System.out.println("---------------------------------------------");
    }
}
