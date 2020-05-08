/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penilaian_mahasiswa;

public class HashTable {

    private LinkedList[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new LinkedList();
        }
    }

    public int convKey(String nim) {
        char[] chr_arr = nim.toCharArray();
        int result = 0;
        for (int i = 0; i < chr_arr.length; i++) {
            result += (int) chr_arr[i];
        }
        return result;
    }

    public int hashFunc(int pointer) {
        return pointer % size;
    }

    public void displayTable() {
        System.out.println("Table: ");
        for(int j = 0; j < size; j++) {
            System.out.print(" " + j + ". ");
            hashArray[j].displayList();
        }
    }
    
    public void put(int id, String nama, String nim, String ComBox, String istima, String kalam, String kitabah, String qiroah) {
        int hash = hashFunc(convKey(nama));
        Penilaian theLink = new Penilaian(id, hash, nama, nim, ComBox, istima, kalam, kitabah, qiroah);
        int hashVal = hashFunc(convKey(nim));
        hashArray[hashVal].insert(theLink);
    }

    public Penilaian get(String nim) {
        int hashVal = hashFunc(convKey(nim));
        Penilaian theLink = hashArray[hashVal].find(nim);
        return theLink;
    }
    
    public void edit(int id, String nama, String nim, String ComBox, String istima, String kalam, String kitabah, String qiroah) {
        int hashVal = hashFunc(convKey(nama));
        hashArray[hashVal].edit(id, nama, nim, ComBox, istima, kalam, kitabah, qiroah);
    }
    
    public void delete(int id, String nim) {
        int hashVal = hashFunc(convKey(nim));
        hashArray[hashVal].delete(id); 
    }
}

