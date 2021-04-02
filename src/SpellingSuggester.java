/**
 * A class that does the spell suggesting.
 * @author Mathushan Mathiyalagan
 * @version 2021-01-04
 */
public class SpellingSuggester {
    private SpellingChecker check;
    private StringArray possibleWords;

    public SpellingSuggester(SpellingChecker check){
        this.check = check;
    }

    public StringArray getPossibleWords(){
        return this.possibleWords;
    }

    public String makeSuggestions(final String word){
        StringArray closeEdits = wordEdits(word);
        this.possibleWords = new StringArray();

        for (int j = 0; j < closeEdits.getAccSizeStringArray(); j++){
            if (check.binarySearch(check.getDictionary().getStringArray(), closeEdits.get(j), 0, check.getDictionary().getAccSizeStringArray() - 1)){
                if (!this.possibleWords.contains(closeEdits.get(j))){
                    this.possibleWords.add(closeEdits.get(j));
                }
            }
        }

        return displaySuggestions(word);
    }

    private StringArray wordEdits(final String word){
        StringArray closeWords = new StringArray();

        for (int i = 1; i < word.length(); i++) {
            for (char letter = 'a'; letter <= 'z'; letter++) {
                StringBuilder sb = new StringBuilder(word);
                sb.insert(i, letter);
                closeWords.add(sb.toString().toLowerCase());

                sb = new StringBuilder(word);
                sb.setCharAt(i, letter);
                closeWords.add(sb.toString().toLowerCase());

                sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                closeWords.add(sb.toString().toLowerCase());
            }
        }

        return closeWords;
    }

    private String displaySuggestions(final String word){
        if (this.possibleWords.isEmpty()){
            return (word + " is not a recognised word.\nThere are no suggestions for this word.");
        }

        String output = word + " is not a recognised word. Did you mean?\n";
        for (int i = 0; i < this.possibleWords.getAccSizeStringArray(); i++){
            if (i < this.possibleWords.getAccSizeStringArray() - 1){
                output += (i + 1 + ". " + this.possibleWords.get(i) + ", \n");
            }
            else{
                output += (i + 1 + ". " + this.possibleWords.get(i) + "\n\n");
            }
        }

        return output;
    }
}
