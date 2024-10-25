import at.ac.tgm.msyllaba.SaveLoad;
import at.ac.tgm.msyllaba.SaveLoadJSON;
import at.ac.tgm.msyllaba.TrainingPair;
import at.ac.tgm.msyllaba.Wordtrainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorttrainerTest {
    private Wordtrainer wordtrainer;

    @BeforeEach
    public void setUp() {
        wordtrainer = new Wordtrainer();
        wordtrainer.setDefaultTrainingPairs();
    }

    @Test
    public void testCheckIgnoreCase_CorrectAnswer() {
        TrainingPair pair = new TrainingPair("https://example.com/image.jpg", "Haus");
        wordtrainer.setTrainingPairs(List.of(pair));
        wordtrainer.getRandomPair();
        assertTrue(wordtrainer.checkIgnoreCase("Haus"), "The answer should be correct");
    }

    @Test
    public void testCheckIgnoreCase_IncorrectAnswer() {
        TrainingPair pair = new TrainingPair("https://example.com/image.jpg", "Haus");
        wordtrainer.setTrainingPairs(List.of(pair));
        wordtrainer.getRandomPair();
        assertFalse(wordtrainer.checkIgnoreCase("Baum"), "The answer should be incorrect");
    }

    @Test
    public void testSetPic_InvalidURL() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPair("invalid-url", "Haus");
        });
    }

    @Test
    public void testSaveAndLoad_SaveTrainingPairs() {
        String path = "test_trainer.json";
        wordtrainer.setDefaultTrainingPairs();
        wordtrainer.setTotal(10);
        wordtrainer.setIncorrect(3);

        SaveLoad saveLoad = new SaveLoadJSON(wordtrainer);
        saveLoad.save(path);

        Wordtrainer loadedWordtrainer = new Wordtrainer();
        SaveLoad loadSave = new SaveLoadJSON(loadedWordtrainer);
        loadSave.load(path);

        assertEquals(wordtrainer.getTotal(), loadedWordtrainer.getTotal(), "Total attempts should match after loading");
        assertEquals(wordtrainer.getIncorrect(), loadedWordtrainer.getIncorrect(), "Incorrect attempts should match after loading");
        assertEquals(wordtrainer.getTrainingPairs().size(), loadedWordtrainer.getTrainingPairs().size(), "Training pairs size should match after loading");
    }
}
