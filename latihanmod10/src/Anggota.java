import java.util.Objects;


public class Anggota {
    public String idAnggota;
    public String nama;
    public String tipe;

    public Anggota(String id, String nama, String tipe) {
        this.idAnggota = id;
        this.nama = nama;
        this.tipe = tipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Anggota anggota = (Anggota) o;
        return Objects.equals(idAnggota, anggota.idAnggota);
    }

    @Override
    public int hashCode() {  
    return Objects.hash(idAnggota); 
    } 

    @Override
    public String toString() {
        return idAnggota + " - " + nama + " (" + tipe + ")";
    }
}


