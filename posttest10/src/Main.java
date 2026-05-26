import java.util.*;

public class Main {

    public static void main(String[] args) {

        // MAP FILM
        Map<String, Film> filmMap = new HashMap<>();
        filmMap.put("F01", new Film("F01", "Avengers", 50000));
        filmMap.put("F02", new Film("F02", "Interstellar", 45000));
        filmMap.put("F03", new Film("F03", "Spiderman", 55000));

        // SET KURSI
        Set<String> kursi = new HashSet<>();

        // LIST RIWAYAT
        List<Transaksi> riwayat = new ArrayList<>();

        // SIMULASI
        pesan("Andi", "F01", "A1", filmMap, kursi, riwayat);
        pesan("Budi", "F01", "A2", filmMap, kursi, riwayat);
        pesan("Citra", "F02", "A3", filmMap, kursi, riwayat);

        // gagal (kursi sama)
        pesan("Doni", "F01", "A1", filmMap, kursi, riwayat);

        System.out.println("\n=== RIWAYAT ===");
        for (Transaksi t : riwayat) {
            System.out.println(t);
        }
    }

    public static void pesan(String nama, String kodeFilm, String kursi, Map<String, Film> filmMap, Set<String> kursiSet, List<Transaksi> riwayat) {

        Film film = filmMap.get(kodeFilm);

        if (film == null) {
            System.out.println("Film tidak ada");
            return;
        }

        if (kursiSet.contains(kursi)) {
            System.out.println("Kursi sudah dipakai: " + kursi);
            return;
        }

        kursiSet.add(kursi);
        riwayat.add(new Transaksi(nama, film.judul, kursi, film.harga));

        System.out.println(nama + " berhasil pesan " + film.judul);
    }
}