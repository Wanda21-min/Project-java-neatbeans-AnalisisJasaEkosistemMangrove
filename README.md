<img width="928" height="303" alt="Screenshot 2026-10-04 215850" src="https://github.com/user-attachments/assets/de37b81c-ca15-4039-a479-e0322233dcfe" />

Jawaban dari eksperimen praktikum 6
1. Muncul pesan error: Koleksi is abstract; cannot be instantiated, karena koleksi dideklarasikan abstract, dan class abstract tidak boleh dibuat objeknya langsung dengan new. Class abstract hanya berfungsi sebagai kerangka untuk diturunkan. Itu masuk akal karena tidak ada koleksi yang "hanya koleksi". Pasti berupa Buku, Majalah, atau Skripsi.
2. Dengan @Override, ada 2 error:
- Buku is not abstract and does not override abstract method hitungDenda(int) in BisaDipinjam 
- method does not override or implement a method from a supertype
Tanpa @Override hanya  1 error:
- Buku is not abstract and does not override abstract method hitungDenda(int) in BisaDipinjam
3. Program berhenti saat dijalankan (kompilasi berhasil)
4. Aturan yang dilanggar adalah encapsulation (enkapsulasi)
