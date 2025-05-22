package DLL09;

import java.lang.classfile.components.ClassPrinter.Node;
import java.util.Scanner;

public class DoubleLinkedList09 {
    Node09 head;
    Node09 tail;

    public DoubleLinkedList09() {
        head = null;
        tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addFirst(Mahasiswa09 data) {
        Node09 newNode = new Node09(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addLast(Mahasiswa09 data) {
        Node09 newNode = new Node09(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }
        Node09 temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; 
        }
        System.out.println("Data yang dihapus: " + temp.data.nim);
    }    
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }
        Node09 temp = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; 
        }
        System.out.println("Data yang dihapus: " + temp.data.nim);
    }
    public void insertAfter(String keyNim, Mahasiswa09 data) {
        Node09 current = head;

        // Cari node dengan nim = keyNim
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan."); 
            return;
        } 

        Node09 newNode = new Node09(data);
        
        //Jika current adalah tail, cukup tambahkan di akhir
        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            // Sisipkan di tengah
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }
    public void print() {
        Node09 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }
     public static Mahasiswa09 inputMahasiswa(Scanner sc) {
    System.out.print("Masukkan NIM: ");
    String nim = sc.nextLine();
    System.out.print("Masukkan Nama: ");
    String nama = sc.nextLine();
    System.out.print("Masukkan Kelas: ");
    String kelas = sc.nextLine();
    System.out.print("Masukkan IPK: ");
    double ipk = sc.nextDouble();
    sc.nextLine(); 

    return new Mahasiswa09(nim, nama, kelas, ipk);
}
     public Node09 search(String nim) {
        Node09 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
     }

}
