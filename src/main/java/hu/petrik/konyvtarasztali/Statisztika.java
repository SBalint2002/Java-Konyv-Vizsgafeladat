package hu.petrik.konyvtarasztali;

import java.sql.SQLException;
import java.util.List;

public class Statisztika {
    static KonyvDB db;
    public static void main(String[] args) {
        try{
            db = new KonyvDB();
            KonyvDB db = new KonyvDB();
            ListBooks(db);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    private static void ListBooks(KonyvDB db) throws SQLException {
        List<Konyv> konyvek = db.getKonyvek();
        konyvek.forEach(System.out::println);
        System.out.println();
    }
}

