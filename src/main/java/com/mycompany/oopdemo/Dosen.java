/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopdemo;

/**
 *
 * @author USER
 */
public class Dosen {
    private final String namaDosen;
    private final String NID;
    private final String lecture;
    private final String phone;
    
    public Dosen(String nd , String nid , String matkul, String noHp) {
       namaDosen = nd;
       NID = nid;
       lecture = matkul;
       phone = noHp;
    }
    
    
//    getter : a method to get the value of an attribute;
    public String getNamaDosen() {
        return namaDosen;
    }
    public String getNid() {
        return NID;
    }
    public String lecture() {
        return lecture;
    }
    public String getPhone() {
        return phone;
    }
    
     public void tampilkanInformasi() {
        System.out.println("Nama Dosen      : " + namaDosen );
        System.out.println("Nomor induk dosen : " + NID);
        System.out.println("Matkul    : " + lecture);
        System.out.println("Nomor HP : " + phone);
        System.out.println("---------------------------------------------");
    }
}
