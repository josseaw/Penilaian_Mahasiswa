/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penilaian_mahasiswa;

/**
 *
 * @author ASUS
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BintangDiLangit
 */
public class CRUD {

    private PreparedStatement CRUDprestat;
    private Statement CRUDstat;
    private ResultSet CRUDdata;
    private String CRUDquery;
    private Connection CRUDcon;

    public CRUD() {
        conection conn = new conection();
        try {
            CRUDcon = conection.koneksiDB();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getAllData() {
        CRUDquery = "SELECT * FROM penilaian_mahasiswa";
        try {
            CRUDstat = CRUDcon.createStatement();
            CRUDdata = CRUDstat.executeQuery(CRUDquery);
        } catch (SQLException e) {
        }
        return CRUDdata;
    }

    public void tambahData(String nama, String nim, String kelas, String istima, String kalam, String kitabah, String qiroah) {
        CRUDquery = "INSERT INTO penilaian_mahasiswa (nama, nim, kelas,istima,kalam,kitabah,qiroah) VALUES(?,?,?,?,?,?,?)";
        try {
            CRUDprestat = CRUDcon.prepareStatement(CRUDquery);
            CRUDprestat.setString(1, nama);
            CRUDprestat.setString(2, nim);
            CRUDprestat.setString(3, kelas);
            CRUDprestat.setString(4, istima);
            CRUDprestat.setString(5, kalam);
            CRUDprestat.setString(6, kitabah);
            CRUDprestat.setString(7, qiroah);

            CRUDprestat.executeUpdate();
            CRUDprestat.close();
            System.out.println("berhasil");
        } catch (SQLException e) {
//            System.out.println("Data gagal ditambahkan");
//            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void editData(String nama, String nim, String kelas, String istima, String kalam, String kitabah, String qiroah) {
        CRUDquery = "UPDATE `penilaian_mahasiswa` SET `nama`=?,`kelas`=?,`istima`=?,`kalam`=?,`kitabah`=?,`qiroah`=? WHERE `penilaian_mahasiswa`.`nim`=?;";
        try {
            CRUDprestat = CRUDcon.prepareStatement(CRUDquery);
            CRUDprestat.setString(1, nama);
            CRUDprestat.setString(7, nim);
            CRUDprestat.setString(2, kelas);
            CRUDprestat.setString(3, istima);
            CRUDprestat.setString(4, kalam);
            CRUDprestat.setString(5, kitabah);
            CRUDprestat.setString(6, qiroah);
            CRUDprestat.executeUpdate();
            CRUDprestat.close();
            System.out.println("Edited");
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Gaiso diedit");
//            e.printStackTrace();
        }
    }

    public void hapusData(String nim) {
        CRUDquery = "DELETE FROM penilaian_mahasiswa WHERE nim=?";
        try {
            CRUDprestat = CRUDcon.prepareStatement(CRUDquery);
            CRUDprestat.setString(1, nim);
            CRUDprestat.executeUpdate();
            CRUDprestat.close();
            System.out.println("Deleted");
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Gaiso dihapus");
//            e.printStackTrace();
        }
    }

}
