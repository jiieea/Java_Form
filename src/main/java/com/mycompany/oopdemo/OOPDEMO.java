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
            System.out.print("Pilih mode (1/2: ");
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) { // 1 & 2 atau 3
//                String -> integer
                pilihan = Integer.parseInt(input);
                break;
            }
            System.out.println("Pilihan tidak valid!");
        }

        if (pilihan == 1) {
            System.out.println("1. Input Mahasiswa");
            System.out.println("2. Input MataKuliah");
            System.out.println("3. Input Dosen");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("1")) {
                runConsoleModeMhs(scanner);
            } else if (pilihan == 2) {
                runConsoleModeMatkul(scanner);
            } else {
                runConsoleDosen(scanner); // argument
            }
        } else {
            System.out.println("\nMembuka jendela GUI...");
            java.awt.EventQueue.invokeLater(() -> new MatkulForm().setVisible(true));
        }
    }

//    input data dosen\
    private static void runConsoleDosen(Scanner scanner) {
        ArrayList<Dosen> daftarDosen = new ArrayList<>(); // Empty array []
        boolean next = true; // indicator data adding
        int counter = 1; // calculate data

        while (next) { // false
            System.out.println("\n--- Input Data Dosen ke-" + counter + " ---");
            System.out.print("Masukkan Nama Dosen      : ");
            String namaDosen = scanner.nextLine().trim();
             System.out.print("Masukkan NID     : ");
            String nid = scanner.nextLine().trim(); //ignore whitespace 

            System.out.print("Masukan Matkul   :");
            String lecture = scanner.nextLine().trim();
            System.out.println("Masukan nomor telepon : ");
            String phone = scanner.nextLine().trim();
            
//            addd new data and insert it to ArrayList
        daftarDosen.add(new Dosen(namaDosen,nid ,lecture , phone)); 
        while (true) {
                System.out.print("\nTambah dosen lagi? (y/n): ");
                String jawab = scanner.nextLine().trim();
                if (jawab.equalsIgnoreCase("y")) { // y | Y
                    break; // stop
                } else if (jawab.equalsIgnoreCase("n")) { // n | N
                    next = false;
                    break; // stop
                }
                System.out.println("Jawab dengan 'y' atau 'n'.");
            }
        counter++;
        }
         System.out.println("\n=============================================");
        System.out.println("         DAFTAR SELURUH DOSEN            ");
        System.out.println("=============================================");

        for (Dosen d : daftarDosen) {
            d.tampilkanInformasi();
        }
        System.out.println("Total Dosen : " + daftarDosen.size()); // size : array length

    }

    private static void runConsoleModeMatkul(Scanner scanner) {
        ArrayList<Matkul> daftarMatkul = new ArrayList<>();
        boolean next = true; // boolean true : false
        int counter = 1; // banyak matkul diambil
        int counterSks = 0; // akumulasi total sks yang diambil

        while (next) {
            System.out.println("\n--- Input Data Matkul ke-" + counter + " ---");
            System.out.print("Masukkan Nama Matkul      : ");
            String namaMk = scanner.nextLine().trim();

            System.out.print("Masukkan Jumlah SKS     : ");
            int sks = scanner.nextInt();

            System.out.print("Masukan kode matkul   :");
            String kodeMk = scanner.nextLine().trim();

            daftarMatkul.add(new Matkul(namaMk, sks, kodeMk));
            while (true) {
                System.out.print("\nTambah matkul lagi? (y/n): ");
                String jawab = scanner.nextLine().trim();
                if (jawab.equalsIgnoreCase("y")) {
                    break;
                } else if (jawab.equalsIgnoreCase("n")) {
                    next = false;
                    break;
                }
                System.out.println("Jawab dengan 'y' atau 'n'.");
            }
            counterSks += sks;
            counter++;
        }
        System.out.println("\n=============================================");
        System.out.println("         DAFTAR SELURUH MAHASISWA            ");
        System.out.println("=============================================");

        for (Matkul m : daftarMatkul) {
            m.tampilkanInformasi();
        }
        System.out.println("Total Matkul Terdaftar: " + daftarMatkul.size());
        System.out.println("Totak SKS yang diambil : " + counterSks);
    }

    private static void runConsoleModeMhs(Scanner scanner) {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
//        [pijar  , 3423434 , 3 , 2024]
        boolean lanjut = true;
        int counter = 1;

        while (lanjut) {
            System.out.println("\n--- Input Data Mahasiswa ke-" + counter + " ---");
            System.out.print("Masukkan NIM      : ");
            String nim = scanner.nextLine().trim(); //343432322

            System.out.print("Masukkan Nama     : ");
            String nama = scanner.nextLine().trim(); // pijar

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

    private static int getTotalSks(int counter, int currentSks) {
        return counter += currentSks;
    }

    // Reads IPK as text so both "3.5" and "3,5" work, regardless of system locale
    private static double bacaIpk(Scanner scanner) {
        while (true) {
            System.out.print("Masukkan IPK      : ");
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
//                string - double
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
