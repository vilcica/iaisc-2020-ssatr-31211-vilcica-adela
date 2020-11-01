package mas.ssatr.vilcica.adela;

import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class Loder {
    private Gson gson = new Gson();

    private Reader reader;

    public PetriNet load() {
        try {
            reader = new FileReader("src/mas/ssatr/vilcica/adela/petrinets.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return gson.fromJson(reader, PetriNet.class);

    }


}


