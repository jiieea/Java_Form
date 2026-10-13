package com.mycompany.oopdemo;

import java.util.ArrayList;
import java.util.Scanner;

public class OOPDEMO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("      PILIH MODE INPUT DATA MAHASISWA       ");
        System.out.println("=============================================");
        System.out.println("1. Input via Console (Scanner)");
        System.out.println("2. Input via Tampilan GUI (JFrame Form)");

        int pilihan;
        while (true) {
            System.out.print("Pilih mode (1/2): ");
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) {
                pilihan = Integer.parseInt(input);
                break;
            }
            System.out.println("Pilihan tidak valid! Masukkan 1 atau 2.");
        }

        if (pilihan == 1) {
            runConsoleMode(scanner);
        } else {
            System.out.println("\nMembuka jendela GUI...");
            java.awt.EventQueue.invokeLater(() -> new Form().setVisible(true));
        }
    }

    private static void runConsoleMode(Scanner scanner) {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        boolean lanjut = true;
        int counter = 1;

        while (lanjut) {
            System.out.println("\n--- Input Data Mahasiswa ke-" + counter + " ---");
            System.out.print("Masukkan NIM      : ");
            String nim = scanner.nextLine().trim();

            System.out.print("Masukkan Nama     : ");
            String nama = scanner.nextLine().trim();

            double ipk = bacaIpk(scanner);

            System.out.print("Masukkan Angkatan : ");
            String angkatan = scanner.nextLine().trim();

            daftarMahasiswa.add(new Mahasiswa(nim, nama, ipk, angkatan));

            while (true) {
                System.out.print("\nTambah mahasiswa lagi? (y/n): ");
                String jawab = scanner.nextLine().trim();
                if (jawab.equalsIgnoreCase("y")) {
                    break;
                } else if (jawab.equalsIgnoreCase("n")) {
                    lanjut = false;
                    break;
                }
                System.out.println("Jawab dengan 'y' atau 'n'.");
            }
            counter++;
        }

        System.out.println("\n=============================================");
        System.out.println("         DAFTAR SELURUH MAHASISWA            ");
        System.out.println("=============================================");

        for (Mahasiswa m : daftarMahasiswa) {
            m.tampilkanInformasi();
        }
        System.out.println("Total Mahasiswa Terdaftar: " + daftarMahasiswa.size());
    }

    // Reads IPK as text so both "3.5" and "3,5" work, regardless of system locale
    private static double bacaIpk(Scanner scanner) {
        while (true) {
            System.out.print("Masukkan IPK      : ");
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                double ipk = Double.parseDouble(input);
                if (ipk >= 0.0 && ipk <= 4.0) {
                    return ipk;
                }
                System.out.println("IPK harus antara 0.0 - 4.0!");
            } catch (NumberFormatException e) {
                System.out.println("Format IPK harus angka!");
            }
        }
    }
}