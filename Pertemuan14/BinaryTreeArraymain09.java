package Pertemuan14;

public class BinaryTreeArraymain09 {
    public static void main(String[] args) {
        BinaryTreeArray09 bta = new BinaryTreeArray09();

        Mahasiswa09 mhs1 = new Mahasiswa09("244160121", "Ali", "A", 3.57);
        Mahasiswa09 mhs2 = new Mahasiswa09("244160185", "Candra", "C", 3.41);
        Mahasiswa09 mhs3 = new Mahasiswa09("244160221", "Badar", "B", 3.75);
        Mahasiswa09 mhs4 = new Mahasiswa09("244160220", "Dewi", "B", 3.35);

        Mahasiswa09 mhs5 = new Mahasiswa09("244160131", "Devi", "A", 3.48);
        Mahasiswa09 mhs6 = new Mahasiswa09("244160205", "Ehsan", "D", 3.61);
        Mahasiswa09 mhs7 = new Mahasiswa09("244160170", "Fizi", "B", 3.86);

        Mahasiswa09[] dataMahasiswa = {mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7};
        int idxLast = 6;

        bta.populateData(dataMahasiswa, idxLast);
        System.out.println("\nInOrder Traversal Mahasiswa: ");
        bta.traverseInOrder(0);
    }
}
