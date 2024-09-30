package at.ac.tgm.msyllaba;

import java.util.ArrayList;
import java.util.List;

public class Wordtrainer {

    private List<TrainingPair> trainingPairs;
    private TrainingPair currentPair;
    private int total, incorrect;

    public Wordtrainer() {
        if(trainingPairs == null){                         // laden oder default laden - Abfrage mittels J Option Pane

        }
        this.trainingPairs = trainingPairs;
        this.total = trainingPairs.size(); // ---
        this.incorrect = 0;
    }

    public void setDefaultTrainingPairs(){
        List<TrainingPair> defaultTrainingPairs = new ArrayList<>();
        defaultTrainingPairs.add(new TrainingPair("https://assets.variohaus.at/landscape/400x300/Fam-Emotion_Rckseite_final_23-02-2019.jpg", "Haus"));
        defaultTrainingPairs.add(new TrainingPair("https://acroadtrip.blob.core.windows.net/catalogo-imagenes/s/RT_V_4c52bfdd6eb740f7bc3b94d3e43ac703.jpg", "Auto"));
        defaultTrainingPairs.add(new TrainingPair("https://groebner-moebel.de/wp-content/uploads/2020/09/GRO_Bauernschraenke_natur_449x449_Trauntaler_Schrank_Schnitzerei.jpg", "Kasten"));
        defaultTrainingPairs.add(new TrainingPair("https://media.istockphoto.com/id/1140109823/vector/monkey-hanging-on-liana-vector-illustration-cute-animal.jpg?s=612x612&w=0&k=20&c=LoE1cx7TCNXOpftlfEq914LZTFhNoSzx9KEXlE1JpzQ=", "Monkey"));
        defaultTrainingPairs.add(new TrainingPair("https://www.parlament.gv.at/dokument/bild/201134/20113455_384.jpg", "Herbert Kickl"));
        defaultTrainingPairs.add(new TrainingPair("https://img.freepik.com/freie-psd/weisskopfseeadler-isoliert_23-2151190923.jpg", "Adler"));
        defaultTrainingPairs.add(new TrainingPair("https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/bdb/_20/208723/10782675_800.jpg", "Xylophon"));
        this.trainingPairs = defaultTrainingPairs;
    }

    public TrainingPair getCurrentPair(){
        if(this.currentPair != null){
            return this.currentPair;
        }
        throw new NullPointerException("current pair is null");
    }

    public TrainingPair getRandomPair(){
        this.currentPair = this.trainingPairs.get((int) (Math.random() * this.trainingPairs.size()));
        return this.currentPair;
    }

    public boolean check(String word) {
        this.total++;
        if(this.currentPair.getWord().equals(word)){
            return true;
        }
        this.incorrect++;
        return false;
    }

    public boolean checkIgnoreCase(String word) {
        this.total++;
        if(this.currentPair.getWord().equalsIgnoreCase(word)){
            return true;
        }
        this.incorrect++;
        return false;
    }
}
