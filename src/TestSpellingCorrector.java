import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class TestSpellingCorrector {
    private final String INPUT_FILE_NAME = "src/words.txt";
    private final String OUTPUT_FILE_NAME = "temp.txt";

    @Test
    public void testConstructors() {
        SpellingChecker spellingChecker = new SpellingChecker(INPUT_FILE_NAME, "helo");
        SpellingSuggester spellingSuggester = new SpellingSuggester(spellingChecker);
        SpellingCorrector spellingCorrector = new SpellingCorrector(spellingChecker, spellingSuggester, OUTPUT_FILE_NAME);
        assertNotNull(spellingCorrector);
    }

    @Test
    public void testWriteToFile() {
        SpellingChecker spellingChecker = new SpellingChecker(INPUT_FILE_NAME, "helo");
        SpellingSuggester spellingSuggester = new SpellingSuggester(spellingChecker);
        SpellingCorrector spellingCorrector = new SpellingCorrector(spellingChecker, spellingSuggester, OUTPUT_FILE_NAME);
        StringArray temp = new StringArray();
        temp.add("0");
        spellingCorrector.writeToFile(temp);
        assertEquals("0", new FileHandling().readFromFile(OUTPUT_FILE_NAME).get(0));
    }
}
