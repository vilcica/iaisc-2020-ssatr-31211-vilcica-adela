package mas.ssatr.vilcica.adela;

import java.util.List;

public class Place {
   String nume;
   int nrjet;
    List<String> in;
    List<String> out;

    public Place(){

    }
    public Place(String nume, int nrjet, List<String> in, List<String> out) {
        this.nume = nume;
        this.nrjet = nrjet;
        this.in = in;
        this.out = out;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrjet() {
        return nrjet;
    }

    public void setNrjet(int nrjet) {
        this.nrjet = nrjet;
    }

    public List<String> getIn() {
        return in;
    }

    public void setIn(List<String> in) {
        this.in = in;
    }

    public List<String> getOut() {
        return out;
    }

    public void setOut(List<String> out) {
        this.out = out;
    }

}