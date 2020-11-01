package mas.ssatr.vilcica.adela;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PetriNet {

    private List<Place> places;
    private List<Tranzition> tranzitions;


    public PetriNet() {
    }

    public PetriNet(List<Place> places, List<Tranzition> tranzitions) {
        this.places = places;
        this.tranzitions = tranzitions;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Tranzition> getTranzitions() {
        return tranzitions;
    }

    public void setTranzitions(List<Tranzition> tranzitions) {
        this.tranzitions = tranzitions;
    }


}
