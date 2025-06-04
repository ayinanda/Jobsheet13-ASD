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
            System.out.println("\n====== MENU DOUBLE LINKED LIST ======");
            System.out.println("1. Tambah data di awal");
            System.out.println("2. Tambah data di akhir");
            System.out.println("3. Tambah data di indeks tertentu");
            System.out.println("4. Hapus data pertama");
            System.out.println("5. Hapus data terakhir");
            System.out.println("6. Hapus data setelah NIM tertentu");
            System.out.println("7. Hapus data di indeks tertentu");
            System.out.println("8. Tampilkan semua data");
            System.out.println("9. Tampilkan data pertama");
            System.out.println("10.Tampilkan data terakhir");
            System.out.println("11.Tampilkan data di indeks tertentu");
            System.out.println("12.Tampilkan jumlah data (size)");
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
                System.out.print("Masukkan indeks: ");
                int index = scan09.nextInt();
                scan09.nextLine();
                Mahasiswa09 mhs = inputMahasiswa(scan09);
                list.add(index, mhs);
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
                System.out.print("Masukkan NIM yang ingin dihapus: ");
                String keyNim = scan09.nextLine();
                list.removeAfter(keyNim);
                break;
            }
            case 7: {
                System.out.print("Masukkan indeks yang ingin dihapus: ");
                int index = scan09.nextInt();
                scan09.nextLine();
                list.remove(index);
                break;
            }
            case 8: {
                list.print();
                break;
            }
            case 9: {
                list.getFirst();
                break;
            }
            case 10: {
                list.getLast();
                break;
            }
            case 11: {
                System.out.print("Masukkan indeks yang ingin ditampilkan: ");
                int index = scan09.nextInt();
                scan09.nextLine();
                list.getIndex(index);
                break;
            }
            case 12: {
                System.out.println("Jumlah data (size): " + list.size());
                break;
            }
            case 0: {
                System.out.println("Keluar dari program.");
                break;
            }
            default: {
                System.out.println("Pilihan tidak valid.");
                break;
            }
        }
        } while (pilihan != 0);
        scan09.close();
    }

}
