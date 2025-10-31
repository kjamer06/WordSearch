import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class GameClient {

    String[][] gameBoard;
    TreeSet<String> lexicon;
    
    public GameClient(){

    }

    public void loadLexicon(String fileName){
        if (fileName == null){
            throw new IllegalArgumentException();
        }
        
        File wordlist = new File(fileName);
        lexicon = new TreeSet<>();

        try (Scanner reader = new Scanner(wordlist)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                lexicon.add(data.split(" ")[0].toUpperCase());
            }
        }  
        catch (FileNotFoundException e){
            throw new IllegalArgumentException();
        }
    }

    public void setBoard(String[] letterArray){
        if (letterArray == null || Math.sqrt(letterArray.length) % 1 != 0){
            throw new IllegalArgumentException();
        }

        
    }

    public boolean isValidWord(String wordToCheck) {
        if (wordToCheck == null) {
            throw new IllegalArgumentException();
        }

        return lexicon.contains(wordToCheck);
    }

    public boolean isValidPrefix(String prefixToCheck){
        if (prefixToCheck == null) {
            throw new IllegalArgumentException();
        }
        return lexicon.ceiling(prefixToCheck).startsWith(prefixToCheck);
    }
}
