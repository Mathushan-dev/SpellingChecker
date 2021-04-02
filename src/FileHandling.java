import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * A class that does the file handling.
 * @author Mathushan Mathiyalagan
 * @version 2021-01-29
 */
public class FileHandling {
    public StringArray readFromFile(final String fileName) {
        StringArray text = new StringArray();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();

            while(line != null){
                text.add(line.strip());
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new JFrame(),"File " + fileName + " could not be found.\nClick OK to terminate.", "FileNotFound", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),"File " + fileName + " could not be read.\nClick OK to terminate.", "FileNotReadable", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        return text;
    }

    public StringArray readFromStream(String inputStream) {
        StringArray text = new StringArray();

        // Regex to limit spaces between words to 1
        inputStream = inputStream.replaceAll("\\s+", " ");

        String characterStream = "";
        try{
            InputStream targetStream = new ByteArrayInputStream(inputStream.getBytes());
            int ch = targetStream.read();
            while(ch != -1) {
                if (Character.isLetter(ch) || Character.isSpaceChar(ch)) {
                    characterStream += (char) ch;
                }
                ch = targetStream.read();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),"Stream could not be read.\nClick OK to terminate.", "StreamNotReadable", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        String[] words = characterStream.split(" ");
        for (String word : words){
            if (word != ""){
                text.add(word);
            }
        }

        return text;
    }

    public void writeToFile(String output, String fileName){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            if (output == ""){
                JOptionPane.showMessageDialog(new JFrame(),"There are no contents to write to the file.\nClick OK to terminate.", "NullWriter", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            bufferedWriter.write(output);
            bufferedWriter.close();
            JOptionPane.showMessageDialog(new JFrame(),"File written successfully with spelling errors corrected.\nClick OK to terminate.", "FileWritten", JOptionPane.INFORMATION_MESSAGE);
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),"File " + fileName + " could not be written to.\nClick OK to terminate.", "FilePermissionError", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        return;
    }
}