package at.ac.tgm.msyllaba;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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
                this.pic = new URI(picUrl).toURL();
            }catch (MalformedURLException | URISyntaxException exc){
                throw new IllegalArgumentException("Error while setting picture: invalid url");
            }
        } else {
            throw new IllegalArgumentException("Error while setting picture: url string parameter is empty or null");
        }
    }

    public URL getPic() {
        return this.pic;
    }

    public void setWord(String word) {
        if(word != null && !word.isEmpty()) {
            this.word = word;
        } else {
            throw new IllegalArgumentException("Error while setting word: word parameter is empty or null");
        }
    }

    public String getWord() {
        return this.word;
    }

}
