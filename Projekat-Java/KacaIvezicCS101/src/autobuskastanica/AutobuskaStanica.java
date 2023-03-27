package autobuskastanica;

import ispis.Ispisivanje;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import korisnici.Agencija;
import korisnici.Putnik;

public class AutobuskaStanica implements Ispisivanje {
    
    public static boolean radiDalje = true; 
    public static int ID = 1;
    private static Scanner sc = new Scanner(System.in);

    public AutobuskaStanica() {
    }
    
    public void rezervisiPonovo() {
        System.out.println("Zelite li da rezervisete jos karata? ");
            System.out.println("1. DA");
            System.out.println("2. NE");
            String ponovo = sc.next();
            
            if(ponovo.equals("da") || ponovo.equals("DA")){
                radiDalje = true;
            }
            else {
                radiDalje = false;
                System.out.println("Hvala na poseti. Dovidjenja! :) \n\n" );
            }
    }
    
    public Gradovi validirajUnos(String grad) {
        Gradovi polaziste = null;
        try {
            polaziste = Gradovi.valueOf(grad);
             return polaziste;
        } catch (IllegalArgumentException ex) {
            System.out.println("Unos nije validan. Pokusajte ponovo. ");
            radiDalje = true;
            return null;
        }
    }
    
    public static void main(String[] args) {
       AutobuskaStanica stanica = new AutobuskaStanica();
       Agencija agencija = new Agencija();
       ArrayList<Autobus> autobusi = agencija.kreirajPonudu();
       
       System.out.println("Dobrodosli :)");
       
       while(radiDalje){
           
           System.out.println("Unesite svoje ime i prezime: ");
           String ime = sc.next();
           String prezime = sc.next();
           
           System.out.println("Iz kog grada putujete? ");
           String grad1 = sc.next();
           Gradovi polaziste = stanica.validirajUnos(grad1);
           if(polaziste == null || !agencija.proveriPolaziste(polaziste)) continue;
           //agencija.proveriPolaziste(polaziste);
           
           System.out.println("Gde zelite da odete? ");
           String grad2 = sc.next();
           Gradovi odrediste = stanica.validirajUnos(grad2);
           if(odrediste == null || !agencija.proveriOdrediste(odrediste)) continue;
           //agencija.proveriOdrediste(odrediste);
           
           Putnik putnik = new Putnik(prezime, odrediste, ime, polaziste);
           PrintWriter writer = stanica.kreirajFajl("Rezervacija"+ (ID++) +".txt") ;
           stanica.upisUFajl(writer, putnik.toString());
           
           System.out.println("Zelite li povratnu kartu? ");
           String povratna = sc.next();
           String tip = null;
           if(povratna.equals("da") || povratna.equals("DA")){
               tip = "povratna";
           }else{
               tip = "jednosmerna";
           }
           
           Karta karta = new Karta(grad1, grad2, 1000, tip);
           agencija.dodajRezervaciju(odrediste, karta);
           stanica.upisUFajl(writer, karta.toString());
           
           System.out.println("Uspesno ste rezervisali kartu \n");
           
           stanica.rezervisiPonovo();
           //zatvaramo ispis u fajl
           writer.close();
       }
    }

    @Override
    public PrintWriter kreirajFajl(String imeFajla){
        PrintWriter podaci = null;
        try {
            FileWriter fajl = new FileWriter(imeFajla);
            podaci = new PrintWriter(new BufferedWriter(fajl));
        } catch (IOException ex) {
            System.out.println("Greska u izvrsavanju: I/OException!");
            System.exit(0);
        }
       return podaci;
    }
    @Override
    public void upisUFajl(PrintWriter podaci, String podaciZaUpis) {
            podaci.println(podaciZaUpis);
           
    }
    
}
