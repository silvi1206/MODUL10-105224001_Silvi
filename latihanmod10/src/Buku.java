import java.util.HashMap;
import java.util.Map;

public class Buku {

    static Map<String, Buku> collection = new HashMap<>();

    public String isbn;
    public String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
        collection.put(isbn, this);
    }

    public static Buku getBukuByISBN(String isbn) {
        return collection.get(isbn);
    }

     @Override
    public String toString() {
        return isbn + " - " + judul;
    }

 
}