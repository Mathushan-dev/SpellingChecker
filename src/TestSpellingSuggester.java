import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;


public class TestSpellingSuggester {
    private final String FILE_NAME = "src/words.txt";

    @Test
    public void testConstructors() {
        SpellingChecker spellingChecker = new SpellingChecker(FILE_NAME, "helo");
        SpellingSuggester spellingSuggester = new SpellingSuggester(spellingChecker);
        assertNotNull(spellingSuggester);
    }

    @Test
    public void testGetters() {
        SpellingChecker spellingChecker = new SpellingChecker(FILE_NAME, "helo");
        SpellingSuggester spellingSuggester = new SpellingSuggester(spellingChecker);
        assertNull(spellingSuggester.getPossibleWords());
    }

    @Test
    public void testMakeSuggestions() {
        SpellingChecker spellingChecker = new SpellingChecker(FILE_NAME, "helo");
        SpellingSuggester spellingSuggester = new SpellingSuggester(spellingChecker);
        assertNotNull(spellingSuggester.makeSuggestions("helo"));
    }
}
