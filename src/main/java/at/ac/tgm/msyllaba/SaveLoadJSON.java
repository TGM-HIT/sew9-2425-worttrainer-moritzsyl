package at.ac.tgm.msyllaba;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaveLoadJSON implements SaveLoad{
    private Wordtrainer wordtrainer;

    public SaveLoadJSON(Wordtrainer wordtrainer){
        this.wordtrainer = wordtrainer;
    }

    @Override
    public void save(String path){
        JSONArray jsonArray = new JSONArray();

        //Pairs
        for (TrainingPair pair : this.wordtrainer.getTrainingPairs()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("url", pair.getPic());
            jsonObject.put("word", pair.getWord());
            jsonArray.put(jsonObject);
        }
        //Stats
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stats_total", this.wordtrainer.getTotal());
        jsonObject.put("stats_incorrect", this.wordtrainer.getIncorrect());
        jsonArray.put(jsonObject);

        try (Writer writer = new BufferedWriter(new FileWriter("src/main/resources/"+path))) {
            writer.write(jsonArray.toString(4)); // 4 für ein schönes Format
        } catch (IOException e) {
            throw new RuntimeException("Error while saving");
        }
    }

    @Override
    public void load(String path){
        List<TrainingPair> pairs = new ArrayList<>();
        int total = -1;
        int incorrect = -1;
        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/"+path)));
            JSONArray jsonArray = new JSONArray(json);

            //Pairs
            for (int i = 0; i < jsonArray.length() - 1; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String url = jsonObject.getString("url");
                String word = jsonObject.getString("word");
                pairs.add(new TrainingPair(url, word));
            }
            //Stats
            JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
            total = jsonObject.getInt("stats_total");
            incorrect = jsonObject.getInt("stats_incorrect");

        } catch (IOException e) {
            throw new RuntimeException("Error while loading");
        }
        this.wordtrainer.setTrainingPairs(pairs);
        this.wordtrainer.setTotal(total);
        this.wordtrainer.setIncorrect(incorrect);
    }
}
