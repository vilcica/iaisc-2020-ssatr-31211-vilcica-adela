package mas.ssatr.vilcica.adela;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class Tranzition {
    String nume;
    int nrjet, mind, maxd, durata;
    List<String> in;
    List<String> out;

    public Tranzition(){

    }
    public Tranzition(String nume, int nrjet, int mind, int maxd, int durata, List<String> in, List<String> out) {
        this.nume = nume;
        this.nrjet = nrjet;
        this.mind = mind;
        this.maxd = maxd;
        this.durata = durata;
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

    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public int getMaxd() {
        return maxd;
    }

    public void setMaxd(int maxd) {
        this.maxd = maxd;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
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