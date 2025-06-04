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
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        if (head == tail) {
            System.out.println("Data sudah berhasil dihapus. Data yang dihapus adalah: ");
            head.data.tampil();
            head = tail = null;
        } else {
            System.out.println("Data sudah berhasil dihapus. Data yang dihapus adalah: ");
            head.data.tampil(); 
            head = head.next; 
            head.prev = null;
        }  
    }    
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        if (head == tail) {
            System.out.println("Data sudah berhasil dihapus. Data yang dihapus adalah: ");
            tail.data.tampil(); 
            head = tail = null;
        } else {
            System.out.println("Data sudah berhasil dihapus. Data yang dihapus adalah: ");
            tail.data.tampil();
            tail = tail.prev;
            tail.next = null;
        }
    }
    public void removeAfter(String keyNim) {
        Node09 current = head;

        // Cari node dengan nim = keyNim
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }
        if (current.next == null) {
            System.out.println("Tidak ada node setelah NIM " + keyNim + " yang bisa dihapus.");
            return;
        }

        Node09 nodeToRemove = current.next;
        System.out.println("Data sudah berhasil dihapus. Data yang dihapus adalah: ");
        nodeToRemove.data.tampil();

        if (nodeToRemove == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = nodeToRemove.next;
            nodeToRemove.next.prev = current;
        }
    }
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node09 current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang dihapus adalah: ");
        current.data.tampil();
        if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }
    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        System.out.println("Data pada node head:");
        head.data.tampil();
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        System.out.println("Data pada node tail:");
        tail.data.tampil(); 
    }

    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        Node09 current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        System.out.println("Data pada indeks ke-" + index + ":");
        current.data.tampil();
    }
    public int size() {
        int count = 0;
        Node09 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        Node09 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
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
    public void add(int index, Mahasiswa09 data) {
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node09 current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        if (current == tail) {
            addLast(data);
            return;
        }
        Node09 newNode = new Node09(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }

}
