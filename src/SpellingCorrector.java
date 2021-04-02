import javax.swing.*;

/**
 * A class that does the spell correcting.
 * @author Mathushan Mathiyalagan
 * @version 2021-01-29
 */
public class SpellingCorrector {
    private SpellingChecker spellingChecker;
    private SpellingSuggester spellingSuggester;
    private String fileName;

    public SpellingCorrector(SpellingChecker spellingChecker, SpellingSuggester spellingSuggester, final String outputFileName){
        this.spellingChecker = spellingChecker;
        this.spellingSuggester = spellingSuggester;
        this.fileName = outputFileName;
    }

    public void changeToOption(final String missingWord){
        if (spellingSuggester.getPossibleWords().getAccSizeStringArray() <= 0) {
            JOptionPane.showMessageDialog(new JFrame(),"There are no alternative suggestions for " + missingWord + ".\nThis word will be unaffected.", "No suggestions found", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int option;
        do{
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("Enter option to replace " + missingWord + " with: "));
                if (option < 1 || option > spellingSuggester.getPossibleWords().getAccSizeStringArray()){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(new JFrame(),"Invalid option selected.\nPlease try again.", "Invalid Option", JOptionPane.ERROR_MESSAGE);
                option = -1;
            } catch (java.awt.HeadlessException e) {
                JOptionPane.showMessageDialog(new JFrame(),"Invalid option selected.\nPlease try again.", "Invalid Option", JOptionPane.ERROR_MESSAGE);
                option = -1;
            }
        }while(option == -1);

        spellingChecker.getCurrentWords().set(spellingChecker.getCurrentWords().indexOf(missingWord), spellingSuggester.getPossibleWords().get(option - 1));
    }

    public void writeToFile(final StringArray finalWords){
        String text = "";
        for (int i = 0; i < finalWords.getAccSizeStringArray(); i++){
            text += finalWords.get(i) + " ";
        }
        new FileHandling().writeToFile(text, fileName);
    }
}