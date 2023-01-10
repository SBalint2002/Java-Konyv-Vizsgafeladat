package hu.petrik.konyvtarasztali;

import javafx.application.Application;

import java.sql.SQLException;
import java.util.*;

public class Statisztika {
    static KonyvDB db;
    private static int konyvindex;

    public static void main(String[] args) {
        /*if (Arrays.asList(args).contains("--stat")){
            try{
                db = new KonyvDB();
                //ListBooks();
                feladatok();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }else{
            HelloApplication.main(args);
        }*/
        try {
            db = new KonyvDB();
            //ListBooks();
            feladatok();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //ellenőrzés
    private static void ListBooks() throws SQLException {
        List<Konyv> konyvek = db.getKonyvek();
        konyvek.forEach(System.out::println);
        System.out.println();
    }

    private static void feladatok() throws SQLException {
        List<Konyv> konyvek = db.getKonyvek();

        //500 oldalnál hosszabb könyvek
        int szamlalo = 0;
        for (Konyv konyv : konyvek) {
            if (konyv.getPage_count() > 500) {
                szamlalo++;
            }
        }
        System.out.println("500 oldalnál hosszabb könyvek száma: " + szamlalo);

        //Van -e 1950-nél régebbi könyv
        boolean vane = false;
        for (Konyv konyv : konyvek) {
            if (konyv.getPublish_year() < 1950) {
                vane = true;
                break;
            }
        }
        if (vane) {
            System.out.println("Van 1950-nél régebbi könyv");
        } else {
            System.out.println("Nincs 1950-nél régebbi könyv");
        }

        //Leghosszabb könyv adatai
        int legnagyobb = 0;
        int index = 0;
        for (int i = 0; i < konyvek.size(); i++) {
            if (konyvek.get(i).getPage_count() > legnagyobb) {
                legnagyobb = konyvek.get(i).getPage_count();
                index = i;
            }
        }
        System.out.println("A leghosszabb könyv:");
        System.out.println("\tSzerző: " + konyvek.get(index).getAuthor() + "\n\tCím: " + konyvek.get(index).getTitle() + "\n\tKiadás éve: " + konyvek.get(index).getPublish_year() + "\n\tOldalszám: " + konyvek.get(index).getPage_count());

        //Legtöbb könyvvel rendelkező szerző
        Map<String, Integer> counts = new HashMap<>();


        //Könyv szerző keresése
        System.out.print("Adjon meg egy könyvet: ");
        Scanner sc = new Scanner(System.in);
        int konyvindex = 0;
        vane = false;
        for (Konyv konyv : konyvek) {
            if (konyv.getTitle().equals(sc.nextLine())) {
                konyvindex = konyv.getId();
                vane = true;
                break;
            }
        }
        if (vane){
            System.out.println("Az megadott könyv szerzője: " + konyvek.get(konyvindex).getAuthor());
        } else{
            System.out.println("Nincs ilyen könyv");
        }
    }
}

