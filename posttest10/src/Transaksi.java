public class Transaksi {
    
    String nama;
    String judulFilm;
    String kursi;
    int harga;

    Transaksi(String nama, String judulFilm, String kursi, int harga) {
        this.nama = nama;
        this.judulFilm = judulFilm;
        this.kursi = kursi;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama + " | " + judulFilm + " | Kursi: " + kursi + " | Rp" + harga;
    }
}

