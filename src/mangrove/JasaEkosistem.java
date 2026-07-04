package mangrove;

/*   - getJenisJasa(bentukKegiatan) : mengembalikan Jenis Jasa
 *     berdasarkan nama bentuk kegiatan
 *   - getBentukKegiatanList()      : mengembalikan semua bentuk
 *     kegiatan yang dimiliki desa sebagai array String
 *   - getNilaiPerKegiatan(bentuk)  : mengembalikan nilai Rp
 *     per bentuk kegiatan spesifik dari Tabel 3
 */
public class JasaEkosistem extends desa {

    public JasaEkosistem() {
        // super() otomatis memanggil constructor desa()
        // sehingga semua ArrayList terinisialisasi
    }

    // ============================================================
    // TABEL 2 — PERHITUNGAN PRODUKSI TAMBAK
    // ============================================================

    /**
     * Menghitung total produksi tambak (Tabel 2).
     * Menggunakan getter yang diwarisi dari superclass desa.
     */
    public double getTotalProduksi() {
        return getTambakTradisional() + getTambakIntensif();
    }

    // ============================================================
    // TABEL 3 — NILAI TOTAL JASA EKOSISTEM PER DESA
    // ============================================================

    /*
     * Mengembalikan TOTAL nilai jasa ekosistem per desa (Tabel 3).
     * Null-check mencegah NullPointerException.
     */
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

    // ============================================================
    // TABEL 3 — JENIS JASA BERDASARKAN BENTUK KEGIATAN
    // ============================================================

    /* Mengembalikan Jenis Jasa berdasarkan nama bentuk kegiatan.
     * Digunakan saat menyimpan baris per-kegiatan ke ArrayList.
     *
     * Penyedia Pangan      → Jasa Produksi (Pasarbanggi)
     *                      → Jasa Penyedia (Tireman & Kabongan Lor)
     * Pemecah Gelombang    → Jasa Pengatur
     * Keaneragaman Hayati  → Jasa Pengatur
     * Wisata               → Jasa Budaya
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

    /* Mengembalikan daftar semua Bentuk Kegiatan yang dimiliki desa (Tabel 3).
     * Digunakan untuk mengisi ComboBox Bentuk Kegiatan di form.
     *
     * Pasarbanggi  → 4 kegiatan (termasuk Wisata)
     * Tireman      → 4 kegiatan (Wisata ada tapi nilainya 0)
     * Kabongan Lor → 3 kegiatan (tidak ada Penyedia Pangan & Wisata)
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

    /* Mengembalikan nilai Rp per bentuk kegiatan spesifik (Tabel 3).
     * Digunakan untuk mengisi field Nilai Jasa saat kegiatan dipilih.
     *
     * Pasarbanggi:
     *   Penyedia Pangan       = 215.350.000
     *   Pemecah Gelombang     = 46.609.626.790
     *   Keaneragaman Hayati   =      8.115.504,90
     *   Wisata                =    117.241.000
     *
     * Tireman:
     *   Penyedia Pangan       = 186.150.000
     *   Pemecah Gelombang     = 36.206.448.610
     *   Keaneragaman Hayati   =      4.260.245,60
     *   Wisata                =              0
     *
     * Kabongan Lor:
     *   Penyedia Pangan       =              0
     *   Pemecah Gelombang     =  1.818.472.430
     *   Keaneragaman Hayati   =        762.636,56
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
        }
        return 0;
    }

    // ============================================================
    // FORMAT RUPIAH (helper)
    // ============================================================
    public String getTotalProduksiFormatted() {
        return "Rp " + String.format(LOCALE_ID, "%,.0f", getTotalProduksi());
    }
    public String getNilaiJasaFormatted() {
        return "Rp " + String.format(LOCALE_ID, "%,.2f", getNilaiJasa());
    }
}
