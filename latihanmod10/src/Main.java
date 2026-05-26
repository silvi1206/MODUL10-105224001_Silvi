import java.util.*;

public class Main {

    public static void main(String[] args) {

        
        Map<String, Buku> katalog = new HashMap<>();
        katalog.put("B001", new Buku("B001", "PBO Dasar"));
        katalog.put("B002", new Buku("B002", "Struktur Data"));
        katalog.put("B003", new Buku("B003", "Basis Data"));

       
        Set<Anggota> anggotaSet = new HashSet<>();
        anggotaSet.add(new Anggota("A001", "Budi", "Mahasiswa"));
        anggotaSet.add(new Anggota("A002", "Sinta", "Dosen"));
        anggotaSet.add(new Anggota("A003", "Rina", "Mahasiswa"));
        anggotaSet.add(new Anggota("A003", "Rina", "Mahasiswa")); // duplikat

        System.out.println("=== ANGGOTA ===");
        for (Anggota a : anggotaSet) {
            System.out.println(a);
        }

       
        LinkedList<String> antrian = new LinkedList<>();

        tambahAntrian(antrian, "A002", "B001", "Dosen");
        tambahAntrian(antrian, "A001", "B002", "Mahasiswa");
        tambahAntrian(antrian, "A003", "B003", "Dosen");
        tambahAntrian(antrian, "A001", "B001", "Mahasiswa");

        System.out.println("\n=== ANTRIAN ===");
        for (String s : antrian) {
            System.out.println(s);
        }

      
        Set<String> dipinjam = new HashSet<>();

        System.out.println("\n=== PROSES PEMINJAMAN ===");

        while (!antrian.isEmpty()) {

            String data = antrian.removeFirst();
            String[] pecah = data.split("#");

            String id = pecah[0];
            String isbn = pecah[1];

            Anggota anggota = cariAnggota(anggotaSet, id);
            Buku buku = katalog.get(isbn);

            if (anggota == null) {
                System.out.println("Gagal: anggota tidak ditemukan " + id);
                continue;
            }

            if (buku == null) {
                System.out.println("Gagal: buku tidak ditemukan " + isbn);
                continue;
            }

            if (dipinjam.contains(isbn)) {
                System.out.println("Gagal: buku sudah dipinjam " + buku.judul);
                continue;
            }

            dipinjam.add(isbn);
            System.out.println("Berhasil: " + anggota.nama + " meminjam " + buku.judul);
        }

       
        System.out.println("\n=== LAPORAN BUKU DIPINJAM (A-Z) ===");

        List<Buku> laporan = new ArrayList<>();

        for (String isbn : dipinjam) {
            laporan.add(katalog.get(isbn));
        }

        laporan.sort(Comparator.comparing(b -> b.judul));

        for (Buku b : laporan) {
            System.out.println(b.judul + " (" + b.isbn + ")");
        }
    }

   
    public static void tambahAntrian(LinkedList<String> antrian,
                                      String id,
                                      String isbn,
                                      String tipe) {

        String data = id + "#" + isbn;

        if (tipe.equalsIgnoreCase("Dosen")) {
            antrian.addFirst(data);
        } else {
            antrian.addLast(data);
        }
    }

    // =====================
    // CARI ANGGOTA
    // =====================
    public static Anggota cariAnggota(Set<Anggota> set, String id) {
        for (Anggota a : set) {
            if (a.idAnggota.equals(id)) {
                return a;
            }
        }
        return null;
    }
}