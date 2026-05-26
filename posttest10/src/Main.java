import java.util.*;

class Film {
    String kodeFilm;
    String judul;
    int harga;

    Film(String kodeFilm, String judul, int harga) {
        this.kodeFilm = kodeFilm;
        this.judul = judul;
        this.harga = harga;
    }
}

class Transaksi {
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

public class Main {

    public static void main(String[] args) {

      
        Map<String, Film> filmMap = new HashMap<>();

        filmMap.put("F01", new Film("F01", "Avengers Endgame", 50000));
        filmMap.put("F02", new Film("F02", "Interstellar", 45000));
        filmMap.put("F03", new Film("F03", "Spiderman No Way Home", 55000));

        System.out.println("=== DAFTAR FILM ===");
        for (String key : filmMap.keySet()) {
            Film f = filmMap.get(key);
            System.out.println(f.kodeFilm + " - " + f.judul + " - Rp" + f.harga);
        }

      
        Set<String> kursiTerpesan = new HashSet<>();

        
        List<Transaksi> riwayat = new ArrayList<>();

     
        pesanTiket("Andi", "F01", "A1", filmMap, kursiTerpesan, riwayat);
        pesanTiket("Budi", "F01", "A2", filmMap, kursiTerpesan, riwayat);
        pesanTiket("Citra", "F01", "A3", filmMap, kursiTerpesan, riwayat);

       
        pesanTiket("Doni", "F01", "A1", filmMap, kursiTerpesan, riwayat);

        System.out.println("\n=== RIWAYAT TRANSAKSI ===");
        for (Transaksi t : riwayat) {
            System.out.println(t);
        }
    }

   
    public static void pesanTiket(String nama,
                                  String kodeFilm,
                                  String kursi,
                                  Map<String, Film> filmMap,
                                  Set<String> kursiTerpesan,
                                  List<Transaksi> riwayat) {

        Film film = filmMap.get(kodeFilm);

        // validasi film
        if (film == null) {
            System.out.println("GAGAL: Kode film tidak valid -> " + kodeFilm);
            return;
        }

        // validasi kursi
        if (kursiTerpesan.contains(kursi)) {
            System.out.println("GAGAL: Kursi sudah dipesan -> " + kursi);
            return;
        }

        // sukses booking
        kursiTerpesan.add(kursi);

        Transaksi t = new Transaksi(nama, film.judul, kursi, film.harga);
        riwayat.add(t);

        System.out.println("SUKSES: " + nama + " memesan " + film.judul + " kursi " + kursi);
    }
}
