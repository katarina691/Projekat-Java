package autobuskastanica;

public class Karta {
    
    private String polaziste;
    private String odrediste;
    private static int IDKarte = 1;
    private int cena;
    private String tip; //povratna ili nije povratna karta

    public Karta() {
    }

    public Karta(String polaziste, String odrediste, int cena, String tip) {
        this.polaziste = polaziste;
        this.odrediste = odrediste;
        this.cena = cena;
        this.tip = tip;
    }

    public static int getIDKarte() {
        return IDKarte;
    }

    public static void setIDKarte() {
        Karta.IDKarte = ++IDKarte;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

   

    public String getPolaziste() {
        return polaziste;
    }

    public void setPolaziste(String polaziste) {
        this.polaziste = polaziste;
    }

    public String getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(String odrediste) {
        this.odrediste = odrediste;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
    @Override
    public String toString() {
        
        if(tip.equals("povratna")){
            return  "\n Rezervacija: " + polaziste + " " + odrediste + " " + cena + " POVRATNA \n";
        }
        else {
            return  "\n Rezervacija: " + polaziste + " " + odrediste + " " + cena + "\n " ;
    }
    
    }
}
