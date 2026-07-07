package mangrove;

/* getBentukKegiatanList() : mengembalikan semua bentuk
 * kegiatan yang dimiliki desa sebagai array String */
public class JasaEkosistem extends desa {

    public JasaEkosistem() {
        // otomatis memanggil constructor desa()
        // sehingga semua ArrayList terinisialisasi
    }

    /* Menghitung total produksi tambak (Tabel 2).
     * Menggunakan getter yang diwarisi dari superclass desa. */
    public double getTotalProduksi() {
        return getTambakTradisional() + getTambakIntensif();
    }

    /* Digunakan untuk mengisi ComboBox Bentuk Kegiatan di form */
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

    // FORMAT RUPIAH
    public String getTotalProduksiFormatted() {
        return "Rp " + String.format(LOCALE_ID, "%,.0f", getTotalProduksi());
    }
}
