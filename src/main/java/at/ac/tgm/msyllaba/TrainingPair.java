package at.ac.tgm.msyllaba;

import java.net.MalformedURLException;
import java.net.URL;

public class TrainingPair {

    private URL pic;
    private String word;

    public TrainingPair(String picUrl, String word) {
        this.setPic(picUrl);
        this.setWord(word);
    }

    public void setPic(String picUrl) {
        if (picUrl != null && !picUrl.isEmpty()) {
            try{
                this.pic = new URL(picUrl); //evtl. .toURL();
            }catch (MalformedURLException exc){
                System.err.println("invalid url");
            }
        } else {
            throw new IllegalArgumentException("url string is empty");
        }
    }

    public URL getPic() {
        return this.pic;
    }

    public void setWord(String word) {
        if(word != null && !word.isEmpty()) {
            this.word = word;
        } else {
            throw new IllegalArgumentException("word is empty");
        }
    }

    public String getWord() {
        return this.word;
    }

}
