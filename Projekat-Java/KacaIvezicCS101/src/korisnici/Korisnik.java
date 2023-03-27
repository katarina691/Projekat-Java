package korisnici;

import autobuskastanica.Gradovi;

public abstract class Korisnik {
    
    String ime;
    Gradovi polaziste;

    public Korisnik(String ime, Gradovi polaziste) {
        this.ime = ime;
        this.polaziste = polaziste;
    }

    public Korisnik() {
    }
    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Gradovi getPolaziste() {
        return polaziste;
    }

    public void setPolaziste(Gradovi polaziste) {
        this.polaziste = polaziste;
    }

    @Override
    public String toString() {
        return "Korisnik" + "ime: " + ime + ", polaziste: " + polaziste + '}';
    }
    
    
}
