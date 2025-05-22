package DLL09;

import java.util.Scanner;

public class DLLMain09 {
    public static Mahasiswa09 inputMahasiswa(Scanner sc) {
    System.out.print("Masukkan NIM  : ");
    String nim = sc.nextLine();
    System.out.print("Masukkan Nama : ");
    String nama = sc.nextLine();
    System.out.print("Masukkan Kelas: ");
    String kelas = sc.nextLine();
    System.out.print("Masukkan IPK  : ");
    double ipk = sc.nextDouble();
    sc.nextLine(); 

    return new Mahasiswa09(nim, nama, kelas, ipk);
}
    public static void main(String[] args) {
        DoubleLinkedList09 list = new DoubleLinkedList09();
        Scanner scan09 = new Scanner(System.in);
        int pilihan;
        
        do {
            System.out.println();
            System.out.println("\n===== MENU DOUBLE LINKED LIST MAHASISWA =====");
            System.out.println("1. Tambah di Awal");
            System.out.println("2. Tambah di Akhir");
            System.out.println("3. Hapus di Awal");
            System.out.println("4. Hapus di Akhir");
            System.out.println("5. Tampilkan Data");    
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan09.nextInt();
            scan09.nextLine();

             switch (pilihan) {
            case 1: {
                Mahasiswa09 mhs = inputMahasiswa(scan09);
                list.addFirst(mhs);
                break;
            }
            case 2: {
                Mahasiswa09 mhs = inputMahasiswa(scan09);
                list.addLast(mhs);
                break;
            }
            case 3: {
                list.removeFirst();
                break;
            }
            case 4: {
                list.removeLast();
                break;
            }
            case 5: {
                list.print();
                break;
            }
            case 6: {
                System.out.print("Masukkan NIM yang dicari: ");
                String nim = scan09.nextLine();
                Node09 found = list.search(nim);
                if (found != null) {
                    System.out.println("Data ditemukan:");
                    found.data.tampil();
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
                break;
            }
            case 0: {
                System.out.println("Keluar dari program.");
                break;
            }default: {
                System.out.println("Pilihan tidak valid.");
                break;
            }
        }
        } while (pilihan != 0);
        scan09.close();
    }

}
