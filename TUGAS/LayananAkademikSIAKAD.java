package TUGAS;

import java.util.Scanner;

public class LayananAkademikSIAKAD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // maksimal antrian 10
        AntrianLayanan26 antrian = new AntrianLayanan26(10);

        int pilihan;

        do {
            System.out.println("\n=== MENU ANTRIAN PERSETUJUAN KRS DPA ===");
            System.out.println("1. Tambah Antrian Mahasiswa");
            System.out.println("2. Proses KRS (Panggil 2 Mahasiswa)");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Tampilkan 2 Antrian Terdepan");
            System.out.println("5. Tampilkan Antrian Paling Akhir");
            System.out.println("6. Cetak Jumlah Antrian");
            System.out.println("7. Cetak Jumlah yang Sudah Proses KRS");
            System.out.println("8. Cetak Jumlah yang Belum Proses KRS");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    if (antrian.getJumlahDiproses() >= 30) {
                        System.out.println("DPA sudah menangani 30 mahasiswa, tidak bisa menerima lagi.");
                        break;
                    }

                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();

                    Mahasiswa26 mhs = new Mahasiswa26(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;

                case 2:
                    if (antrian.getJumlahDiproses() >= 30) {
                        System.out.println("DPA sudah menangani 30 mahasiswa, proses KRS dihentikan.");
                        break;
                    }
                    antrian.prosesKRS();
                    break;

                case 3:
                    antrian.tampilkanSemua();
                    break;

                case 4:
                    antrian.tampilkan2Terdepan();
                    break;

                case 5:
                    antrian.lihatAkhir();
                    break;

                case 6:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrian.getJumlahAntrian());
                    break;

                case 7:
                    System.out.println("Jumlah mahasiswa sudah proses KRS: " + antrian.getJumlahDiproses());
                    break;

                case 8:
                    System.out.println("Jumlah mahasiswa belum proses KRS: " + antrian.getBelumDiproses());
                    break;

                case 9:
                    antrian.clear();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        sc.close();
    }
}
