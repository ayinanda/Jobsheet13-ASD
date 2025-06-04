package Pertemuan14;

import java.lang.classfile.components.ClassPrinter.Node;

public class BinaryTree09 {
    Node09 root;

    public BinaryTree09() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }
    
    public void add(Mahasiswa09 mahasiswa) {
        Node09 newNode = new Node09(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node09 current = root;
            Node09 parent = null;
            while (true) {
                parent = current; 
                if (mahasiswa.ipk < current.mahasiswa.ipk) { 
                    current = current.left; 
                    if (current == null) { 
                        parent.left = newNode;  
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    boolean find(double ipk) {
        boolean result = false;
        Node09 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }
    void traversePreOrder(Node09 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right); 
        }
    }
    void traverseInOrder(Node09 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }
    void traversePostOrder(Node09 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }
    Node09 getSuccessor(Node09 del) { 
        Node09 successor = del.right; 
        Node09 successorParent = del; 
        while (successor.left != null) { 
            successorParent = successor; 
            successor = successor.left; 
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }
    void delete (double ipk) {
        if (isEmpty()) {
            System.out.println("Binary Tree kosong.");
            return;
        }
        // cari node (current) yang akan dihapus
        Node09 parent = root;
        Node09 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break; 
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        //penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        } else {
            // jika node yang akan dihapus adalah anak (leaf), maka node dihapus
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null; 
                } else if (isLeftChild) {
                    parent.left = null; 
                } else {
                    parent.right = null; 
                }
            } 
            // jika node yang akan dihapus memiliki satu anak
            else if (current.right == null) {  // jika hanya punya anak kiri
                if (current == root) {
                    root = current.left; 
                } else if (isLeftChild) {
                    parent.left = current.left; 
                } else {
                    parent.right = current.left; 
                }
            } 
            else if (current.left == null) {  // jika hanya punya anak kanan
                if (current == root) {
                    root = current.right; 
                } else if (isLeftChild) {
                    parent.left = current.right; 
                } else {
                    parent.right = current.right; 
                }
            } 
            // jika node yang akan dihapus memiliki dua anak
            else {
                Node09 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor; 
                } else { 
                    if (isLeftChild) {
                    parent.left = successor; 
                } else {
                    parent.right = successor; 
                }
            }
            successor.left = current.left;
        }
  }
}
}