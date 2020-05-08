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
public class DataArray {
    public Penilaian[] tmb;
    private int nElemen;
    
    public DataArray(int max) {
        tmb = new Penilaian[max];
        nElemen = 0;
    }
    
    public void insert(int id, String nama,String nim,String kelas, String istima, String kalam, String kitabah, String qiroah) {
        tmb[nElemen] = new Penilaian(id, 0, nama, nim, kelas,istima,kalam,kitabah,qiroah);
        nElemen++;
    }
    
    public void edit(int id, String nama, String nim,String kelas, String istima, String kalam, String kitabah, String qiroah) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (tmb[i].getId() == id) {
                break;
            }
        }
        if (i != nElemen) {
            tmb[i].setNama(nama);
            tmb[i].setNim(nim);
            tmb[i].setKelas(kelas);
            tmb[i].setIstima(istima);
            tmb[i].setKalam(kalam);
            tmb[i].setKitabah(kitabah);
            tmb[i].setQiroah(qiroah);
        }
    }
    
    public void delete(int id){
        int i;
        for (i = 0; i < nElemen; i++) {
            if (tmb[i].getId() == id) {
                break;
            }
        }
        if (i != nElemen) {
            for (int j = i; j < nElemen; j++) {
                tmb[j] = tmb[j + 1];
            }
            nElemen--;
        }
        
        tmb[id] = null;
    }
    
    public String[][] Array() {
        String result[][] = new String[nElemen][6];
        for (int i = 0; i < nElemen; i++) {
            String[] data = {tmb[i].getNama(), tmb[i].getNim(),tmb[i].getKelas(), tmb[i].getIstima(), tmb[i].getKalam(), tmb[i].getKitabah(), tmb[i].getQiroah()};
            result[i] = data;
        }
        return result;
    }
    
    public void SelectionSort() {
        int start, i, min;
        
        for (start = 0; start < nElemen-1; start++) {
            min = start;
            for (i = start + 1; i < nElemen; i++) {
                if (tmb[i].getNim().compareTo(tmb[min].getNim())< 0) {
                    min = i;
                }
            }
            swap(start, min);
        }
    }
    
    public void swap(int key1, int key2) {
        Penilaian temp = tmb[key1];
        tmb[key1] = tmb[key2];
        tmb[key2] = temp;
    }
}
