import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class TestSpellingChecker {
    private final int WORDS_IN_DEFAULT_DICTIONARY = 235886;
    private final String FILE_NAME = "src/words.txt";

    @Test
    public void testConstructors() {
        SpellingChecker spellingChecker = new SpellingChecker(FILE_NAME, "helo");
        assertEquals(WORDS_IN_DEFAULT_DICTIONARY, spellingChecker.getDictionary().getAccSizeStringArray());
        assertEquals(0, spellingChecker.getMissingWords().getAccSizeStringArray());
        assertEquals(1, spellingChecker.getCurrentWords().getAccSizeStringArray());
        assertNotNull(spellingChecker);

    }

    @Test
    public void testGetters() {
        SpellingChecker spellingChecker = new SpellingChecker(FILE_NAME, "hi");
        assertNotNull(spellingChecker);
        assertEquals(WORDS_IN_DEFAULT_DICTIONARY, spellingChecker.getDictionary().getAccSizeStringArray());
        assertEquals(0, spellingChecker.getMissingWords().getAccSizeStringArray());
        assertEquals(1, spellingChecker.getCurrentWords().getAccSizeStringArray());
		/*The following tests are not enough but a full test will have time complexity O(n) where
		n is the number of words in the dictionary file*/
        assertNotNull(spellingChecker.getDictionary());
        assertNotNull(spellingChecker.getMissingWords());
        assertNotNull(spellingChecker.getCurrentWords());

    }

    @Test
    public void testCheckSpelling() {
        SpellingChecker spellingChecker = new SpellingChecker(FILE_NAME, "he,lo");
        assertEquals(WORDS_IN_DEFAULT_DICTIONARY, spellingChecker.getDictionary().getAccSizeStringArray());
        assertEquals("helo", spellingChecker.checkSpelling().get(0));
        assertEquals(1, spellingChecker.getMissingWords().getAccSizeStringArray());
        assertEquals(1, spellingChecker.getCurrentWords().getAccSizeStringArray());

    }
}
