import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestFileHandling {
    private final int WORDS_IN_DEFAULT_DICTIONARY = 235886;
    private final String INPUT_FILE_NAME = "src/words.txt";
    private final String OUTPUT_FILE_NAME = "temp.txt";

    @Test
    public void testReadFromFile() {
        FileHandling fileHandling = new FileHandling();
        assertEquals(WORDS_IN_DEFAULT_DICTIONARY, fileHandling.readFromFile(INPUT_FILE_NAME).getAccSizeStringArray());
    }

    @Test
    public void testReadFromStream() {
        FileHandling fileHandling = new FileHandling();
        assertEquals(4, fileHandling.readFromStream("test null te-st null").getAccSizeStringArray());
    }

    @Test
    public void testWriteToFile() {
        FileHandling fileHandling = new FileHandling();
        fileHandling.writeToFile("test\nnull\nte-st\nnull", OUTPUT_FILE_NAME);
        assertEquals(4, fileHandling.readFromFile(OUTPUT_FILE_NAME).getAccSizeStringArray());
    }
}
