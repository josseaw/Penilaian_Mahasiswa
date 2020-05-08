/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penilaian_mahasiswa;


/**
 *
 * @author BintangDiLangit
 */
public class LinkedList {
    private Penilaian head;
    public LinkedList() {
        head = null;
    }
    
    public void insert(Penilaian newLink) {
        newLink.next = head;
        head = newLink;
    }
    
    public void edit(int id, String nama, String nim, String ComBox, String istima, String kalam, String kitabah, String qiroah) {
        Penilaian current = head;
        while(current != null) {
            if (current.getId() == id) {
                current.setNama(nama);
                current.setNim(nim);
                current.setKelas(ComBox);
                current.setIstima(istima);
                current.setKalam(kalam);
                current.setKitabah(kitabah);
                current.setQiroah(qiroah);
            }
            current = current.next;
        }
    }
    
    public void delete(int key) {
        Penilaian current = head;
        Penilaian previous = head;
        
        while(current.getId() != key) {
            if (current.next == null) {
                break;
            } else {
                previous = current;
                current = current.next;
            }
        }
    }
    
    public Penilaian find(String key) {
        Penilaian current = head;
        while(current != null) {
            if (current.getNama().equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void displayList() {
        Penilaian current = head;
        while(current != null) {
            //current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
