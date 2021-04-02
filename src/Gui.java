import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
    private JTextArea textArea;
    private JTextField stringField;
    private JScrollPane scrollPane;

    SpellingChecker spellingChecker;
    SpellingSuggester spellingSuggester;
    SpellingCorrector spellingCorrector;

    public Gui() {
        displayConfigurations();
        setMainContainer();
        this.setVisible (true);
    }

    private void displayConfigurations(){
        this.setSize (700, 600);
        this.setTitle ("Spell Checker");
        this.setResizable (false);
    }

    private void setMainContainer(){
        Container main = this.getContentPane();
        textArea = new JTextArea ("Enter text to spell check.\n\nNote the text and dictionary file name have to be specified before" +
                " you can click Spell Check.\n\nIf you would like to use the default dictionary then leave the dictionary file name as it is.");
        scrollPane = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        main.add (scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel ();
        JLabel label = new JLabel ("Enter dictionary file name: ");
        panel.add (label);
        stringField = new JTextField ("src/words.txt",30);
        panel.add (stringField);

        JButton check = new JButton ("Spell Check");
        check.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                handleCheckClick();
            }
        });

        panel.add(check);
        main.add (panel, BorderLayout.SOUTH);
    }

    public void handleCheckClick () {
        spellingChecker = new SpellingChecker(stringField.getText().strip(), textArea.getText());
        StringArray missingWords = spellingChecker.checkSpelling();

        spellingSuggester = new SpellingSuggester(spellingChecker);
        SpellingCorrector spellingCorrector = new SpellingCorrector(spellingChecker, spellingSuggester, "CorrectedOutput.txt");
        for (int i = 0; i < missingWords.getAccSizeStringArray(); i++){
            textArea.setText(spellingSuggester.makeSuggestions(missingWords.get(i)));
            spellingCorrector.changeToOption(missingWords.get(i));
        }

        spellingCorrector.writeToFile(spellingChecker.getCurrentWords());
        textArea.setText("Enter text to spell check.");
        stringField.setText("src/words.txt");
    }
}