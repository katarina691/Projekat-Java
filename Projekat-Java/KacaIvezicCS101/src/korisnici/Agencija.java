package korisnici;

import autobuskastanica.Autobus;
import autobuskastanica.Gradovi;
import autobuskastanica.Karta;
import java.util.ArrayList;

public class Agencija extends Korisnik {
    
    String adresa;
    ArrayList<Gradovi> gradovi = new ArrayList<Gradovi>();
    ArrayList<Autobus> autobusi = new ArrayList<Autobus>();
    
    public Agencija() {
    }

    public Agencija(String adresa, String ime, Gradovi polaziste) {
        super(ime, polaziste);
        this.adresa = adresa;
    }

    public ArrayList<Autobus> kreirajPonudu(){
        gradovi.add(Gradovi.beograd);
        gradovi.add(Gradovi.nis);
        gradovi.add(Gradovi.subotica);
        gradovi.add(Gradovi.krusevac);
        
        autobusi.add(new Autobus(Gradovi.beograd));
        autobusi.add(new Autobus(Gradovi.nis));
        autobusi.add(new Autobus(Gradovi.subotica));
        autobusi.add(new Autobus(Gradovi.krusevac));
        
        return autobusi;
    }
    
    public boolean proveriOdrediste(Gradovi odrediste) {
        boolean validnoOdrediste = false;
        for (Gradovi grad : gradovi) {
            if (odrediste.equals(grad)) {
                validnoOdrediste = true; 
                break; //prestajem da trazim, nasla sam sta mi treba 
            }
        }
        if (!validnoOdrediste) {
            System.out.println("Odrediste nije u ponudi. Pokusajte ponovo");
        }
        return  validnoOdrediste;
    }

    public boolean proveriPolaziste(Gradovi polaziste) {
        boolean validnoPolaziste = false;
         for (Gradovi grad : gradovi) {
            if (polaziste.equals(grad)) {
                validnoPolaziste = true;
                break;
            }
        }
        if (!validnoPolaziste) {
            System.out.println("Polaziste nije u ponudi. Pokusajte ponovo");
        }
        return validnoPolaziste;
    }
    
    public void dodajRezervaciju(Gradovi grad, Karta karta){
        if(grad == Gradovi.beograd){
            autobusi.get(0).dodajRezervaciju(karta);
        }
        else if(grad == Gradovi.nis){
            autobusi.get(1).dodajRezervaciju(karta);
        }
        else if(grad == Gradovi.subotica){
            autobusi.get(2).dodajRezervaciju(karta);
        }
        else if(grad == Gradovi.krusevac){
            autobusi.get(3).dodajRezervaciju(karta);
        }
        else {
            System.out.println("Izabrani grad trenutno nije u ponudi.");
        }
    }
    
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Agencija " + super.ime + " se nalazi na adresi" + adresa + '\n';
    }
    
    
}
