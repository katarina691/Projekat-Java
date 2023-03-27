package autobuskastanica;

import java.util.ArrayList;

public class Autobus {
    
    Gradovi odrediste;
    ArrayList<Karta> rezKarte = new ArrayList<Karta>();
    
    public Autobus() {
    }

    public Autobus(Gradovi odrediste) {
        this.odrediste = odrediste;
    }
    
    public void dodajRezervaciju(Karta karta){
        rezKarte.add(karta);
        //karta.setIDKarte();
    }
    
    /*
    public void ukloniRezervaciju(int brojKarte){
        for(Karta karta : rezKarte){
            if(karta.getIDKarte() == brojKarte){
                rezKarte.remove(karta);
            }else{
                System.out.println("Nevazeci broj karte. Pokusajte ponovo");
            }
        }
    }
    */
    
    
    @Override
    public String toString() {
        return "Autobus ide za " + odrediste + '\n';
    }
    
    
}
