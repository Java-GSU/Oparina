package by.gsu.pms;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    public static List<Line> getLinesFromBook(Book book) {
        List<Line> result = new LinkedList<>();
        try  (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(book.getFilePath())), book.getTextEncoding()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(new Line(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Sentence> getSentencesFromLine(String line) {
        List<Sentence> result = new LinkedList<>();
        String[] strings = line.split("[.!?,]");
        for (String string : strings) {
            result.add(new Sentence(string));
        }
        return result;
    }


    public static List<Word> getWordsFromSentence(String sentence) {
        List<Word> result = new LinkedList<>();
        String[] strings = sentence.split("[ ]");
        for (String string : strings) {
            if(string.length() < 4){
            result.add(new Word("Stim")); // замена слова определённой длины
        }
            else result.add(new Word(string));
        }
        return result;
    }

   public static List<Symbol> getSymbolsFromWord(String word) {
       List<Symbol> result = new LinkedList<>();

       result.add(new Symbol(word));

       return result;

   }
}
