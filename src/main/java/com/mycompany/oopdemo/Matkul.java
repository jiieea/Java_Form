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


    public void Matkul(String namaMatkul, int sks,String kodeMk) {
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

}
