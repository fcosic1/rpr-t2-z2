package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna;
    private double krajnja;
    private boolean prvaPripadna;
    private boolean drugaPripadna;

    public Interval(double pocetna, double krajnja, boolean prvaPripadna, boolean drugaPripadna){
        if(pocetna > krajnja) throw new IllegalArgumentException("Pocetna tacka veca od krajnje!");
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.prvaPripadna = prvaPripadna;
        this.drugaPripadna = drugaPripadna;
    }
    public Interval(){
        pocetna = 0;
        krajnja = 0;
        prvaPripadna = false;
        drugaPripadna = false;
    }
    public boolean isNull(){
        if(pocetna == 0 && krajnja == 0 && prvaPripadna == false && drugaPripadna == false)
            return true;
        return false;
    }
    public boolean isIn(double tacka){
        if(tacka < pocetna || tacka > krajnja) return false;
        else if(tacka == pocetna && prvaPripadna == false) return false;
        else if(tacka == krajnja && drugaPripadna == false) return false;
        return true;
    }
    public Interval intersect(Interval i){
        double vPocetna = pocetna;
        if(i.pocetna > vPocetna) vPocetna = i.pocetna;
        double mKrajnja = krajnja;
        if(i.krajnja < mKrajnja) mKrajnja = i.krajnja;
        boolean prvaPripadnaNova = false;
        if(isIn(vPocetna) && i.isIn(vPocetna)) prvaPripadnaNova = true;
        boolean drugaPripadnaNova = false;
        if(isIn(mKrajnja) && i.isIn(mKrajnja)) drugaPripadnaNova = true;
        return new Interval(vPocetna, mKrajnja, prvaPripadnaNova, drugaPripadnaNova);

    }
    public static Interval intersect(Interval i1, Interval i2){
        double vPocetna = i1.pocetna;
        if(i2.pocetna > vPocetna) vPocetna = i2.pocetna;
        double mKrajnja = i1.krajnja;
        if(i2.krajnja < mKrajnja) mKrajnja = i2.krajnja;
        boolean prvaPripadnaNova = false;
        if(i1.isIn(vPocetna) && i2.isIn(vPocetna)) prvaPripadnaNova = true;
        boolean drugaPripadnaNova = false;
        if(i1.isIn(mKrajnja) && i2.isIn(mKrajnja)) drugaPripadnaNova = true;
        return new Interval(vPocetna, mKrajnja, prvaPripadnaNova, drugaPripadnaNova);
    }

    @Override
    public boolean equals(Object obj) {
        Interval c = (Interval)obj;
        return pocetna == c.pocetna && krajnja == c.krajnja && prvaPripadna == c.prvaPripadna && drugaPripadna == c.drugaPripadna;
    }

    @Override
    public String toString() {
        if(isNull()) return "()";
        String novi = "";
        if(prvaPripadna) novi += "[";
        else novi += "(";
        novi += pocetna;
        novi += ",";
        novi+= krajnja;
        if(drugaPripadna) novi += "]";
        else novi += ")";
        return novi;
    }
}
