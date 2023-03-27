package ispis;

import java.io.PrintWriter;

public interface Ispisivanje {
    
    public PrintWriter kreirajFajl(String imeFajla);
    void upisUFajl(PrintWriter writer, String podaciZaUpis);
    
}
