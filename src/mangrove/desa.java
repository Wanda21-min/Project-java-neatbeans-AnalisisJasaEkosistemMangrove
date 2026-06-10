package mangrove;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class desa {
    private String namaDesa;
    private double tambakTradisional;
    private double tambakIntensif;
    private ArrayList<String> dataDesa;
    private ArrayList<Double> dataTradisional;
    private ArrayList<Double> dataIntensif;
    private ArrayList<Double> dataTotalProduksi;
    private ArrayList<Double> dataNilaiJasa;
    private ArrayList<String> dataJenisJasa;
    private ArrayList<String> dataBentukKegiatan;

    //CONSTRUCTOR 1 tanpa parameter
    public desa() {
        dataDesa           = new ArrayList<>();
        dataTradisional    = new ArrayList<>();
        dataIntensif       = new ArrayList<>();
        dataTotalProduksi  = new ArrayList<>();
        dataNilaiJasa      = new ArrayList<>();
        // [BARU] Inisialisasi ArrayList Jenis Jasa & Bentuk Kegiatan
        dataJenisJasa      = new ArrayList<>();
        dataBentukKegiatan = new ArrayList<>();
    }

    //CONSTRUCTOR 2 dengan parameter
    public desa(String namaDesa, double tambakTradisional, double tambakIntensif) {
        this.namaDesa          = namaDesa;
        this.tambakTradisional = tambakTradisional;
        this.tambakIntensif    = tambakIntensif;
    }

    //PENCARIAN INDEX
    public int getIndexData(String desa) {
        return dataDesa.indexOf(desa);
    }

    //TAMPILKAN DETAIL DATA DESA
    public void cariDataDesa(String desa) {
        int i = getIndexData(desa);
        if (i >= 0) {
            String info =
                "Desa              : " + dataDesa.get(i)                                      + "\n" +
                "Jenis Jasa        : " + dataJenisJasa.get(i)                                 + "\n" +
                "Bentuk Kegiatan   : " + dataBentukKegiatan.get(i)                            + "\n" +
                "Tambak Tradisional: Rp " + String.format("%,.0f", dataTradisional.get(i))    + "\n" +
                "Tambak Intensif   : Rp " + String.format("%,.0f", dataIntensif.get(i))       + "\n" +
                "Total Produksi    : Rp " + String.format("%,.0f", dataTotalProduksi.get(i))  + "\n" +
                "Nilai Jasa        : Rp " + String.format("%,.2f", dataNilaiJasa.get(i));
            JOptionPane.showMessageDialog(null, info, "Detail Data Desa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Desa \"" + desa + "\" tidak ditemukan!");
        }
    }

    //INPUT KE ARRAYLIST
    public void inputDesa(String desa)               { dataDesa.add(desa); }
    public void inputTradisional(double nilai)       { dataTradisional.add(nilai); }
    public void inputIntensif(double nilai)          { dataIntensif.add(nilai); }
    public void inputTotalProduksi(double nilai)     { dataTotalProduksi.add(nilai); }
    public void inputNilaiJasa(double nilai)         { dataNilaiJasa.add(nilai); }
    public void inputJenisJasa(String jenisJasa)         { dataJenisJasa.add(jenisJasa); }
    public void inputBentukKegiatan(String bentukKegiatan) { dataBentukKegiatan.add(bentukKegiatan); }

    //HAPUS DATA BERDASARKAN INDEX
    public void hapusData(int index) {
        if (index >= 0 && index < dataDesa.size()) {
            dataDesa.remove(index);
            dataTradisional.remove(index);
            dataIntensif.remove(index);
            dataTotalProduksi.remove(index);
            dataNilaiJasa.remove(index);
            // [BARU] Hapus juga Jenis Jasa & Bentuk Kegiatan
            dataJenisJasa.remove(index);
            dataBentukKegiatan.remove(index);
        }
    }

    //GETTER ARRAYLIST
    public ArrayList<String> arrayDesa()             { return dataDesa; }
    public ArrayList<Double> arrayTradisional()      { return dataTradisional; }
    public ArrayList<Double> arrayIntensif()         { return dataIntensif; }
    public ArrayList<Double> arrayTotalProduksi()    { return dataTotalProduksi; }
    public ArrayList<Double> arrayNilaiJasa()        { return dataNilaiJasa; }
    public ArrayList<String> arrayJenisJasa()        { return dataJenisJasa; }
    public ArrayList<String> arrayBentukKegiatan()   { return dataBentukKegiatan; }

    //SETTER & GETTER atribut tunggal
    public void setNamaDesa(String namaDesa) {
        if (namaDesa != null && !namaDesa.isEmpty()) this.namaDesa = namaDesa;
    }
    public String getNamaDesa()                      { return namaDesa; }

    public void setTambakTradisional(double nilai)   { this.tambakTradisional = nilai; }
    public double getTambakTradisional()             { return tambakTradisional; }

    public void setTambakIntensif(double nilai)      { this.tambakIntensif = nilai; }
    public double getTambakIntensif()                { return tambakIntensif; }
}
