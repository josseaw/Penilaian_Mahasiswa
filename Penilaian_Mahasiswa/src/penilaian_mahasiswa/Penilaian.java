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
public class Penilaian {
    private int id;
    private int hash;
    private String nama;
    private String nim;
    private String kelas;
    private String istima;
    private String kalam;
    private String kitabah;
    private String qiroah;
    public Penilaian next;
    public Penilaian rightChild;
    public Penilaian leftChild;
    
    public Penilaian(int id, int hash, String nama, String nim, String ComBox, String istima, String kalam, String kitabah, String qiroah) {
        this.id = id;
        this.hash = hash;
        this.nama= nama;
        this.nim = nim;
        this.kelas = ComBox;
        this.istima = istima;
        this.kalam = kalam;
        this.kitabah = kitabah;
        this.qiroah = qiroah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String ComBox) {
        this.kelas = ComBox;
    }

    public String getIstima() {
        return istima;
    }

    public void setIstima(String istima) {
        this.istima = istima;
    }

    public String getKalam() {
        return kalam;
    }

    public void setKalam(String kalam) {
        this.kalam = kalam;
    }
    
    public String getKitabah() {
        return kitabah;
    }
    
    public void setKitabah(String kitabah){
        this.kitabah = kitabah;
    }
    
    public String getQiroah() {
        return qiroah;
    }
    
    public void setQiroah(String qiroah){
        this.qiroah = qiroah;
    }
    
    public int getHash() {
        return hash;
    }

    public int getId() {
        return id;
    }
    
}
