package at.ac.tgm.msyllaba;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Wordtrainer {

    private List<TrainingPair> trainingPairs;
    private TrainingPair currentPair;
    private int total, incorrect;
    private SaveLoad saveload = new SaveLoadJSON(this);

    public Wordtrainer() {
        if(JOptionPane.showConfirmDialog(null, "Spielstand laden?", "laden", JOptionPane.YES_NO_OPTION) == 0) {
            try {
                saveload.load("trainer.json");
            } catch (RuntimeException exc) {
                System.out.println("Error while loading: loading default training pairs");
                this.setDefaultTrainingPairs();
            }
        } else{
            this.setDefaultTrainingPairs();
        }

        while (true) {
            this.getRandomPair();
            Image image = new ImageIcon(this.currentPair.getPic(), "picture").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
            ImageIcon imageIcon =  new ImageIcon(image);
            String word;
            try{
                word = JOptionPane.showInputDialog(null, this.getStats() + "\nWas ist auf dem Bild zu sehen?", "Worttrainer", JOptionPane.QUESTION_MESSAGE, imageIcon, null, "").toString();
            }catch (NullPointerException exc){
                    break;
            }
            if (this.checkIgnoreCase(word)) {
                JOptionPane.showMessageDialog(null, "Richtig!", "Worttrainer", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Falsch! Das gesuchte Wort war: " + this.getCurrentPair().getWord(), "Worttrainer", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(JOptionPane.showConfirmDialog(null, "Spielstand speichern?", "laden", JOptionPane.YES_NO_OPTION) == 0) {
            saveload.save("trainer.json");
        }
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
        throw new NullPointerException("Error while getting current pair: current pair is null");
    }

    public List<TrainingPair> getTrainingPairs(){
        return this.trainingPairs;
    }

    public void setTrainingPairs(List<TrainingPair> trainingPairs){
        this.trainingPairs = trainingPairs;
    }

    public void getRandomPair(){
        this.currentPair = this.trainingPairs.get((int) (Math.random() * this.trainingPairs.size()));
    }

    public int getTotal(){
        return this.total;
    }

    public int getIncorrect(){
        return this.incorrect;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public String getStats(){
        return "Total: " + this.total + " Correct: " + (this.total - this.incorrect) + " Incorrect: " + this.incorrect;
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
