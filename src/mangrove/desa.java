package mangrove;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

/* CLASS DESA — Superclass (class induk) */
public class desa {

    // Locale eksplisit agar format Rupiah
    protected static final Locale LOCALE_ID = new Locale("in", "ID");

    // ===== ATRIBUT PRIVATE =====
    private String namaDesa;
    private double tambakTradisional;
    private double tambakIntensif;

    // ===== ARRAYLIST — penyimpanan data dinamis =====
    private ArrayList<String> dataDesa;
    private ArrayList<Double> dataTradisional;
    private ArrayList<Double> dataIntensif;
    private ArrayList<Double> dataTotalProduksi;
    private ArrayList<Double> dataNilaiJasa;
    private ArrayList<String> dataJenisJasa;
    private ArrayList<String> dataBentukKegiatan;

    // ===== CONSTRUCTOR tanpa parameter =====
    public desa() {
        dataDesa           = new ArrayList<>();
        dataTradisional    = new ArrayList<>();
        dataIntensif       = new ArrayList<>();
        dataTotalProduksi  = new ArrayList<>();
        dataNilaiJasa      = new ArrayList<>();
        dataJenisJasa      = new ArrayList<>();
        dataBentukKegiatan = new ArrayList<>();
    }

    // ===== PENCARIAN INDEX =====
    public int getIndexData(String desa) {
        return dataDesa.indexOf(desa);
    }

    // ===== TAMPILKAN DETAIL DATA DESA =====
    public void cariDataDesa(String desa) {
        int i = getIndexData(desa);
        if (i >= 0) {
            String info =
                "Desa              : " + dataDesa.get(i)+ "\n" +
                "Jenis Jasa        : " + dataJenisJasa.get(i)+ "\n" +
                "Bentuk Kegiatan   : " + dataBentukKegiatan.get(i)+ "\n" +
                "Tambak Tradisional: Rp " + String.format(LOCALE_ID, "%,.0f", dataTradisional.get(i))+ "\n" +
                "Tambak Intensif   : Rp " + String.format(LOCALE_ID, "%,.0f", dataIntensif.get(i))+ "\n" +
                "Total Produksi    : Rp " + String.format(LOCALE_ID, "%,.0f", dataTotalProduksi.get(i))+ "\n" +
                "Nilai Jasa        : Rp " + String.format(LOCALE_ID, "%,.2f", dataNilaiJasa.get(i));
            JOptionPane.showMessageDialog(null, info, "Detail Data Desa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Desa \"" + desa + "\" tidak ditemukan!");
        }
    }

    // ===== INPUT KE ARRAYLIST =====
    public void inputDesa(String desa)               { dataDesa.add(desa); }
    public void inputTradisional(double nilai)       { dataTradisional.add(nilai); }
    public void inputIntensif(double nilai)          { dataIntensif.add(nilai); }
    public void inputTotalProduksi(double nilai)     { dataTotalProduksi.add(nilai); }
    public void inputNilaiJasa(double nilai)         { dataNilaiJasa.add(nilai); }
    // [BARU] Input Jenis Jasa & Bentuk Kegiatan
    public void inputJenisJasa(String jenisJasa)         { dataJenisJasa.add(jenisJasa); }
    public void inputBentukKegiatan(String bentukKegiatan) { dataBentukKegiatan.add(bentukKegiatan); }

    // ===== HAPUS DATA BERDASARKAN INDEX =====
    public void hapusData(int index) {
        if (index >= 0 && index < dataDesa.size()) {
            dataDesa.remove(index);
            dataTradisional.remove(index);
            dataIntensif.remove(index);
            dataTotalProduksi.remove(index);
            dataNilaiJasa.remove(index);
            dataJenisJasa.remove(index);
            dataBentukKegiatan.remove(index);
        }
    }

    // ===== GETTER ARRAYLIST =====
    public ArrayList<String> arrayDesa()             { return dataDesa; }
    public ArrayList<Double> arrayTradisional()      { return dataTradisional; }
    public ArrayList<Double> arrayIntensif()         { return dataIntensif; }
    public ArrayList<Double> arrayTotalProduksi()    { return dataTotalProduksi; }
    public ArrayList<Double> arrayNilaiJasa()        { return dataNilaiJasa; }
    public ArrayList<String> arrayJenisJasa()        { return dataJenisJasa; }
    public ArrayList<String> arrayBentukKegiatan()   { return dataBentukKegiatan; }

    // ===== SETTER & GETTER atribut tunggal =====
    public void setNamaDesa(String namaDesa) {
        if (namaDesa != null && !namaDesa.isEmpty()) this.namaDesa = namaDesa;
    }
    public String getNamaDesa()                      { return namaDesa; }

    public void setTambakTradisional(double nilai)   { this.tambakTradisional = nilai; }
    public double getTambakTradisional()             { return tambakTradisional; }

    public void setTambakIntensif(double nilai)      { this.tambakIntensif = nilai; }
    public double getTambakIntensif()                { return tambakIntensif; }
}
