/**
 * A class that does the spell checking.
 * @author Mathushan Mathiyalagan
 * @version 2021-01-29
 */
public class SpellingChecker {
    private StringArray dictionary, missingWords, currentWords;

    public SpellingChecker(final String fileName, final String inputStream){
        this.dictionary = new StringArray(new FileHandling().readFromFile(fileName));
        this.missingWords = new StringArray();
        this.currentWords = new StringArray(new FileHandling().readFromStream(inputStream));
    }

    public StringArray getDictionary(){
        return this.dictionary;
    }

    public StringArray getMissingWords(){
        return this.missingWords;
    }

    public StringArray getCurrentWords(){
        return this.currentWords;
    }

    public StringArray checkSpelling(){
        for (int i = 0; i < currentWords.getAccSizeStringArray(); i++) {
            if (!binarySearch(this.dictionary.getStringArray(), this.currentWords.get(i), 0, this.dictionary.getAccSizeStringArray() - 1)){
                this.missingWords.add(this.currentWords.get(i));
            }
        }

        return this.missingWords;
    }

    public boolean binarySearch(final String[] sortedArray, final String key, final int low, final int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return false;
        }

        else if (key.compareToIgnoreCase(sortedArray[middle]) < 0) {
            return binarySearch(sortedArray, key, low, middle - 1);
        }
        else if (key.compareToIgnoreCase(sortedArray[middle]) == 0) {
            return true;
        }

        return binarySearch(sortedArray, key, middle + 1, high);
    }
}