import java.util.*;

public class SistemGudang {

    private Map<String, Barang> databaseBarang;
    private Set<String> kategoriUnik;
    private List<String> riwayat;

    public SistemGudang() {
        databaseBarang = new HashMap<>();
        kategoriUnik = new HashSet<>();
        riwayat = new ArrayList<>();
    }

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        Barang barang = new Barang(id, nama, kategori, stok);

        databaseBarang.put(id, barang);
        kategoriUnik.add(kategori);

        riwayat.add("Barang Baru: " + id + " - " + nama);
    }

    public void tambahStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);

        if (barang != null) {
            barang.stok += jumlah;
            riwayat.add("Barang Masuk: " + id + " ditambah " + jumlah + " unit");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);

        if (barang == null) {
            riwayat.add("Gagal kurangi stok: ID tidak ditemukan");
            return;
        }

        if (barang.stok >= jumlah) {
            barang.stok -= jumlah;
            riwayat.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit");
        } else {
            riwayat.add("Gagal kurangi stok: stok tidak mencukupi");
        }
    }

    public void cetakLaporan() {

        System.out.println("===== DAFTAR KATEGORI =====");
        for (String kategori : kategoriUnik) {
            System.out.println(kategori);
        }

        System.out.println("\n===== DATA BARANG =====");
        for (Barang barang : databaseBarang.values()) {
            System.out.println(barang.idBarang + " | "
                    + barang.namaBarang + " | "
                    + barang.kategori + " | Stok: "
                    + barang.stok);
        }

        System.out.println("\n===== RIWAYAT TRANSAKSI =====");
        for (String aktivitas : riwayat) {
            System.out.println(aktivitas);
        }
    }
}
