package ba.unsa.etf.rpr;

import java.util.List;

public abstract class Banka {

    private long brojRacuna;
   private Osoba korisnikRacuna;
   private boolean odobrenjePrekoracenja;
   private Double stanjeRacuna;

   //List<Korisnik> korisnici;
   //List<Uposlenik>uposlenici;
    public Banka(){}
    public Banka(long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    private boolean provjeriOdobrenjePrekoracnje(Double d) {
        return false;
    }

    void odobriPrekoracenje(Double d) {

    }
    public boolean izvrsiUplatu(Double d){
        return true;
    }
    public boolean izvrsiIsplatu(Double d){
        return true;
    }
    




}