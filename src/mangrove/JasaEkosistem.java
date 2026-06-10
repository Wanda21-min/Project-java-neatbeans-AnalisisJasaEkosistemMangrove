package mangrove;

public class JasaEkosistem extends desa {

    public JasaEkosistem() {
        // otomatis memanggil constructor desa()
        // sehingga semua ArrayList terinisialisasi
    }
    
    // Menghitung total produksi tambak (Tabel 2)
    public double getTotalProduksi() {
        return getTambakTradisional() + getTambakIntensif();
    }

    // Mengembalikan TOTAL nilai jasa ekosistem per desa (Tabel 3).
    public double getNilaiJasa() {
        String nama = getNamaDesa();
        if (nama == null) return 0;
        switch (nama) {
            case "Pasarbanggi":  return 46950333295.0;
            case "Tireman":      return 36396858856.0;
            case "Kabongan Lor": return 1819235066.56;
            default:             return getTotalProduksi() * 10;
        }
    }

    /*
     * Mengembalikan Jenis Jasa berdasarkan nama bentuk kegiatan.
     * Digunakan saat menyimpan baris per-kegiatan ke ArrayList.
     */
    public String getJenisJasa(String bentukKegiatan) {
        String nama = getNamaDesa();
        if (nama == null || bentukKegiatan == null) return "-";
        switch (bentukKegiatan) {
            case "Penyedia Pangan":
                // Sesuai Tabel 3: Pasarbanggi = "Jasa Produksi", lainnya "Jasa Penyedia"
                return nama.equals("Pasarbanggi") ? "Jasa Produksi" : "Jasa Penyedia";
            case "Pemecah Gelombang":
            case "Keaneragaman Hayati":
                return "Jasa Pengatur";
            case "Wisata":
                return "Jasa Budaya";
            default:
                return "Jasa Pengatur";
        }
    }

    /*
     * Mengembalikan daftar semua Bentuk Kegiatan yang dimiliki desa (Tabel 3).
     * Digunakan untuk mengisi ComboBox Bentuk Kegiatan di form.
     */
    public String[] getBentukKegiatanList() {
        String nama = getNamaDesa();
        if (nama == null) return new String[]{"Pemecah Gelombang"};
        switch (nama) {
            case "Pasarbanggi":
            case "Tireman":
                return new String[]{
                    "Penyedia Pangan",
                    "Pemecah Gelombang",
                    "Keaneragaman Hayati",
                    "Wisata"
                };
            case "Kabongan Lor":
                return new String[]{
                    "Penyedia Pangan",
                    "Pemecah Gelombang",
                    "Keaneragaman Hayati"
                };
            default:
                return new String[]{
                    "Penyedia Pangan",
                    "Pemecah Gelombang",
                    "Keaneragaman Hayati"
                };
        }
    }

    /*
     * Digunakan untuk mengisi field Nilai Jasa saat kegiatan dipilih.
     */
    public double getNilaiPerKegiatan(String bentukKegiatan) {
        String nama = getNamaDesa();
        if (nama == null || bentukKegiatan == null) return 0;
        switch (nama) {
            case "Pasarbanggi":
                switch (bentukKegiatan) {
                    case "Penyedia Pangan":     return 215350000.0;
                    case "Pemecah Gelombang":   return 46609626790.0;
                    case "Keaneragaman Hayati": return 8115504.90;
                    case "Wisata":              return 117241000.0;
                }
            break;
            case "Tireman":
                switch (bentukKegiatan) {
                    case "Penyedia Pangan":     return 186150000.0;
                    case "Pemecah Gelombang":   return 36206448610.0;
                    case "Keaneragaman Hayati": return 4260245.60;
                    case "Wisata":              return 0.0;
                }
            break;
            case "Kabongan Lor":
                switch (bentukKegiatan) {
                    case "Penyedia Pangan":     return 0.0;
                    case "Pemecah Gelombang":   return 1818472430.0;
                    case "Keaneragaman Hayati": return 762636.56;
                }
                break;
        }   return 0;
    }

    // FORMAT RUPIAH
    public String getTotalProduksiFormatted() {
        return "Rp " + String.format("%,.0f", getTotalProduksi());
    }
    public String getNilaiJasaFormatted() {
        return "Rp " + String.format("%,.2f", getNilaiJasa());
    }
}
