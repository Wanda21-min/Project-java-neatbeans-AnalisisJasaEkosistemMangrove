package frame;

import mangrove.JasaEkosistem;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class FrameMangrove extends javax.swing.JFrame {

    private JasaEkosistem obj;

    public FrameMangrove() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Form Analisis Jasa Ekosistem Mangrove");
        obj = new JasaEkosistem();
        // Isi ComboBox Bentuk Kegiatan untuk desa awal (Pasarbanggi)
        updateCmbBentukKegiatan();
        // Muat data awal dari Tabel 2 & Tabel 3 jurnal
        muatDataAwal();
        // Tampilkan ke Table
        loadData();
    }

    // Memuat data awal dari Tabel 2 & Tabel 3 jurnal.
    public void muatDataAwal() {
        simpanDataDesa("Pasarbanggi",  2316600000.0, 3430000000.0, "Penyedia Pangan");
        simpanDataDesa("Tireman",       445500000.0, 6059666340.0, "Penyedia Pangan");
        simpanDataDesa("Kabongan Lor",  222750000.0,          0.0, "Pemecah Gelombang");
    }

    // set data ke obj, hitung total & nilai, simpan ke semua ArrayList.
    private void simpanDataDesa(String nama, double tradisional,
                                 double intensif, String bentukKegiatan) {
        obj.setNamaDesa(nama);
        obj.setTambakTradisional(tradisional);
        obj.setTambakIntensif(intensif);

        String jenisJasa = obj.getJenisJasa(bentukKegiatan);

        obj.inputDesa(nama);
        obj.inputJenisJasa(jenisJasa);
        obj.inputBentukKegiatan(bentukKegiatan);
        obj.inputTradisional(tradisional);
        obj.inputIntensif(intensif);
        obj.inputTotalProduksi(obj.getTotalProduksi());
        obj.inputNilaiJasa(obj.getNilaiJasa());
    }

    // Merefresh Table dari ArrayList.
    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < obj.arrayDesa().size(); i++) {
            model.addRow(new Object[]{
                obj.arrayDesa().get(i),
                obj.arrayJenisJasa().get(i),
                obj.arrayBentukKegiatan().get(i),
                "Rp " + String.format("%,.0f", obj.arrayTradisional().get(i)),
                "Rp " + String.format("%,.0f", obj.arrayIntensif().get(i)),
                "Rp " + String.format("%,.0f", obj.arrayTotalProduksi().get(i)),
                "Rp " + String.format("%,.2f", obj.arrayNilaiJasa().get(i))
            });
        }
    }

    /*
     Memperbarui isi ComboBox Bentuk Kegiatan
     sesuai desa yang sedang dipilih di ComboBox.
     */
    private void updateCmbBentukKegiatan() {
        String desaDipilih = jComboBox1.getSelectedItem().toString();
        obj.setNamaDesa(desaDipilih);
        String[] daftarKegiatan = obj.getBentukKegiatanList();
        cmbBentukKegiatan.setModel(
            new javax.swing.DefaultComboBoxModel<>(daftarKegiatan));
        // Trigger update Jenis Jasa & Nilai Jasa otomatis
        updateJenisJasaDanNilai();
    }

    /*
    Mengisi lblJenisJasaValue secara otomatis
    berdasarkan desa + bentuk kegiatan yang dipilih.
    */
    private void updateJenisJasaDanNilai() {
        String desa    = jComboBox1.getSelectedItem().toString();
        String kegiatan = cmbBentukKegiatan.getSelectedItem() != null
                         ? cmbBentukKegiatan.getSelectedItem().toString() : "";
        obj.setNamaDesa(desa);
        // Isi Jenis Jasa otomatis
        String jenis = obj.getJenisJasa(kegiatan);
        lblJenisJasaValue.setText(jenis);
        // Isi Nilai Jasa Kegiatan otomatis (read-only)
        double nilaiKegiatan = obj.getNilaiPerKegiatan(kegiatan);
        jTextField5.setText(String.format("%,.2f", nilaiKegiatan));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDesa = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblBentukKegiatan = new javax.swing.JLabel();
        cmbBentukKegiatan = new javax.swing.JComboBox<>();
        lblJenisJasa = new javax.swing.JLabel();
        lblJenisJasaValue = new javax.swing.JLabel();
        lblTradisional = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        lblIntensif = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        lblTotalProduksi = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        lblNilaiJasaKegiatan = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnProses = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Analisis Jasa Ekosistem Mangrove");

        lblDesa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDesa.setText("Desa");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pasarbanggi", "Tireman", "Kabongan Lor" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        lblBentukKegiatan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblBentukKegiatan.setText("Bentuk Kegiatan");

        cmbBentukKegiatan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbBentukKegiatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Penyedia Pangan", "Pemecah Gelombang", "Keaneragaman Hayati", "Wisata" }));
        cmbBentukKegiatan.addActionListener(this::cmbBentukKegiatanActionPerformed);

        lblJenisJasa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblJenisJasa.setText("Jenis Jasa");

        lblJenisJasaValue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblJenisJasaValue.setText("-");

        lblTradisional.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTradisional.setText("Tambak Tradisional (Rp)");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblIntensif.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblIntensif.setText("Tambak Intensif (Rp)");

        jTextField3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblTotalProduksi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTotalProduksi.setText("Total Produksi (Rp)");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblNilaiJasaKegiatan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNilaiJasaKegiatan.setText("Nilai Jasa Ekosistem (Rp)");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnTambah.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(this::btnTambahActionPerformed);

        btnProses.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnProses.setText("Proses");
        btnProses.addActionListener(this::btnProsesActionPerformed);

        btnHapus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnKeluar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(this::btnKeluarActionPerformed);

        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Desa", "Jenis Jasa", "Bentuk Kegiatan", "Tambak Tradisional", "Tambak Intensif", "Total Produksi", "Nilai Jasa Ekosistem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(22);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(160);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnKeluar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDesa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblBentukKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(cmbBentukKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblJenisJasa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lblJenisJasaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTradisional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblIntensif, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTotalProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNilaiJasaKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHapus))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTambah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnProses))
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesa)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBentukKegiatan)
                    .addComponent(cmbBentukKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJenisJasa)
                    .addComponent(lblJenisJasaValue))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTradisional)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntensif)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalProduksi)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNilaiJasaKegiatan)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnProses)
                    .addComponent(btnHapus))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKeluar)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Saat desa di-ComboBox diganti:
    1. Update isi ComboBox Bentuk Kegiatan sesuai desa
    2. Isi otomatis Tambak Tradisional & Intensif (Tabel 2)
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Update ComboBox Bentuk Kegiatan
        updateCmbBentukKegiatan();
        // Auto-isi Tradisional & Intensif dari Tabel 2
        String dipilih = jComboBox1.getSelectedItem().toString();
        switch (dipilih) {
            case "Pasarbanggi":
                jTextField2.setText("2316600000");
                jTextField3.setText("3430000000");
                break;
            case "Tireman":
                jTextField2.setText("445500000");
                jTextField3.setText("6059666340");
                break;
            case "Kabongan Lor":
                jTextField2.setText("222750000");
                jTextField3.setText("0");
                break;
        }
        // Bersihkan field Total Produksi saat ganti desa
        jTextField4.setText("");
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /*
     * Saat Bentuk Kegiatan diganti:
     * Update Jenis Jasa dan Nilai Jasa Ekosistem secara otomatis.
     */
    private void cmbBentukKegiatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBentukKegiatanActionPerformed
        updateJenisJasaDanNilai();
    }//GEN-LAST:event_cmbBentukKegiatanActionPerformed

    /*
     * Tombol Proses:
     * Menghitung Total Produksi dan menampilkan rincian
     * lengkap Tabel 3 di JOptionPane.
     */
    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        try {
            if (jTextField2.getText().trim().isEmpty()
                    || jTextField3.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Field Tambak Tradisional dan Intensif harus diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String desa     = jComboBox1.getSelectedItem().toString();
            String kegiatan = cmbBentukKegiatan.getSelectedItem().toString();
            double tradisional = Double.parseDouble(jTextField2.getText().trim());
            double intensif    = Double.parseDouble(jTextField3.getText().trim());

            obj.setNamaDesa(desa);
            obj.setTambakTradisional(tradisional);
            obj.setTambakIntensif(intensif);

            double totalProduksi  = obj.getTotalProduksi();
            double nilaiJasaTotal = obj.getNilaiJasa();
            double nilaiKegiatan  = obj.getNilaiPerKegiatan(kegiatan);
            String jenisJasa      = obj.getJenisJasa(kegiatan);

            // Tampilkan Total Produksi di field
            jTextField4.setText(String.format("%,.0f", totalProduksi));

            // hasil rincian lengkap
            JOptionPane.showMessageDialog(this,
                "Desa             : " + desa + "\n" +
                "Jenis Jasa       : " + jenisJasa + "\n" +
                "Bentuk Kegiatan  : " + kegiatan + "\n" +
                "──────────────────────────────────────\n" +
                "Tambak Tradisional : Rp " +
                    String.format("%,.0f", tradisional) + "\n" +
                "Tambak Intensif    : Rp " +
                    String.format("%,.0f", intensif) + "\n" +
                "Total Produksi     : Rp " +
                    String.format("%,.0f", totalProduksi) + "\n" +
                "──────────────────────────────────────\n"+
                "Nilai Jasa (" + kegiatan + "):\n"+
                "  Rp " + String.format("%,.2f", nilaiKegiatan)+ "\n\n" +
                "TOTAL Nilai Jasa Ekosistem:\n"+
                "  Rp " + String.format("%,.2f", nilaiJasaTotal),
                "Hasil Proses — " + desa,
                JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Input Tradisional/Intensif harus berupa angka!\nContoh: 2316600000",
                "Error Input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    /*
     * Menyimpan data dari form ke ArrayList dan merefresh tabel.
     */
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            if (jTextField2.getText().trim().isEmpty()
                    || jTextField3.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Field Tambak Tradisional dan Intensif harus diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String nama        = jComboBox1.getSelectedItem().toString();
            String kegiatan    = cmbBentukKegiatan.getSelectedItem().toString();
            double tradisional = Double.parseDouble(jTextField2.getText().trim());
            double intensif    = Double.parseDouble(jTextField3.getText().trim());

            simpanDataDesa(nama, tradisional, intensif, kegiatan);
            loadData();

            jTextField4.setText("");
            JOptionPane.showMessageDialog(this,
                "Data berhasil ditambahkan!\n" +
                "Desa: " + nama + " | " + kegiatan,
                "Sukses", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Input harus berupa angka!\nContoh: 2316600000",
                "Error Input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    // menghapus baris yang dipilih di tabel
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int barisPilih = jTable1.getSelectedRow();
        if (barisPilih < 0) {
            JOptionPane.showMessageDialog(this,
                "Pilih baris yang ingin dihapus terlebih dahulu!",
                "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String namaDipilih = obj.arrayDesa().get(barisPilih);
        int ok = JOptionPane.showConfirmDialog(this,
            "Hapus data \"" + namaDipilih + "\"?",
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            obj.hapusData(barisPilih);
            loadData();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    // tutup form ini saja
    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrameMangrove().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbBentukKegiatan;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblBentukKegiatan;
    private javax.swing.JLabel lblDesa;
    private javax.swing.JLabel lblIntensif;
    private javax.swing.JLabel lblJenisJasa;
    private javax.swing.JLabel lblJenisJasaValue;
    private javax.swing.JLabel lblNilaiJasaKegiatan;
    private javax.swing.JLabel lblTotalProduksi;
    private javax.swing.JLabel lblTradisional;
    // End of variables declaration//GEN-END:variables
}
