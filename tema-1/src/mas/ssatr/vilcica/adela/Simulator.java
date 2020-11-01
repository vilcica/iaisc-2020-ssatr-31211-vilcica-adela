package mas.ssatr.vilcica.adela;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private int clock = 0;
    private Place place = new Place();
    private Loder loder = new Loder();
    private PetriNet petriNet = loder.load();
    private List<String> initialMark = new ArrayList<>();
    private PrintWriter printWriter = new PrintWriter(new File("src/output.txt"));
    private int clockTick;

    public Simulator(int clockTick) throws FileNotFoundException {
        this.clockTick = clockTick;
    }

    private List<String> setInitialMark(PetriNet petriNet) {
        printWriter.write("Initial Mark: ");
        for (int i = 0; i < petriNet.getPlaces().size(); i++) {
            place = petriNet.getPlaces().get(i);
            initialMark.add(place.getNume() + ":" + place.getNrjet());
            printWriter.write(place.getNume() + ":" + place.getNrjet()+" ");
        }
        printWriter.write("\n");
        System.out.println(initialMark);
        return initialMark;

    }


    private boolean checkTransition(Tranzition tranzition) {

        if (tranzition.getIn().size() == 0) {
            return false;
        }
        for (int i = 0; i < tranzition.getIn().size(); i++) {
            if (getLocationName(tranzition.getIn().get(i)) != null) {
                place = getLocationName(tranzition.getIn().get(i));
                if (place.getNrjet() == 0) {
                    return false;
                }

            }

        }
        return true;
    }

    private Place getLocationName(String name) {
        for (int i = 0; i < petriNet.getPlaces().size(); i++) {
            place = petriNet.getPlaces().get(i);
            if (place.getNume().equals(name)) {
                return place;
            }
        }
        return null;
    }

    public void simulate(PetriNet petriNet) {
        setInitialMark(petriNet);

        while (clockTick > 0) {

            for (int i = 0; i < petriNet.getTranzitions().size(); i++) {
                Tranzition tranzition = petriNet.getTranzitions().get(i);
                if (tranzition.getDurata() > 0) {
                    tranzition.setDurata(tranzition.getDurata() - 1);
                }
                if (tranzition.getNrjet() == 0) {
                    if (checkTransition(tranzition)) {// && (getLocationName( tranzition.getOut().toString()) != null)) {
                        tackeJetonFromIn(tranzition);
                    }
                }
            }
            for (int i = 0; i < petriNet.getTranzitions().size(); i++) {
                Tranzition tranzition = petriNet.getTranzitions().get(i);
                putJetonOut(tranzition);
            }
            write();
            clockTick--;

        }
        printWriter.flush();
        printWriter.close();
    }

    private void putJetonOut(Tranzition tranzition) {
        if (tranzition.getDurata() == 0) {
            if (tranzition.getNrjet() != 0) {
                tranzition.setNrjet(tranzition.getNrjet() - 1);
                for (int i = 0; i < tranzition.getOut().size(); i++) {
                    Place place = getLocationName(tranzition.getOut().get(i));
                    place.setNrjet(place.getNrjet() + 1);
                }
            }
        }
    }

    private void tackeJetonFromIn(Tranzition tranzition) {
        for (int i = 0; i < tranzition.getIn().size(); i++) {
            Place place = getLocationName(tranzition.getIn().get(i));
            if (place.getNrjet() != 0) {
                place.setNrjet(place.getNrjet() - 1);
            }
        }
        tranzition.setNrjet(tranzition.getNrjet() + 1);
        int durata = (int) (Math.random() * (tranzition.getMaxd() - tranzition.getMind()) + tranzition.getMind());
        tranzition.setDurata(durata);
    }

    private void write() {
        printWriter.write("Clock: " + clock + " Mark: ");
        System.out.print("Clock: " + clock + " ");
        for (Place place : petriNet.getPlaces()) {
            System.out.print(place.getNume() + ":" + place.getNrjet() + " ");
            printWriter.write( place.getNrjet() + " ");
        }
        System.out.println();
        printWriter.write("\n");
        try {
            Thread.sleep(1000);
            clock = clock + 1;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public PetriNet getPetriNet() {
        return petriNet;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Simulator simulator = new Simulator(11);
        PetriNet petriNet = simulator.getPetriNet();
        simulator.simulate(petriNet);
    }
}

