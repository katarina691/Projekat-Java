package korisnici;

import autobuskastanica.Gradovi;


public class Putnik extends Korisnik {
    
    String prezime;
    Gradovi odrediste; 

    //prazan konstruktor
    public Putnik() {
    }

    //konstruktor po poljima
    public Putnik(String prezime, Gradovi odrediste, String ime, Gradovi polaziste) {
        super(ime, polaziste);
        this.prezime = prezime;
        this.odrediste = odrediste;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Gradovi getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(Gradovi odrediste) {
        this.odrediste = odrediste;
    }

    @Override
    public String toString() {
        
        return "Putnik " + "Ime i prezime: " + super.ime + " " + prezime + 
                "\n Polaziste: " + super.polaziste + " \n Odrediste=" + odrediste + '\n';
    }
    
    
}
