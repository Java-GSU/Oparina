package by.gsu.pms;

import java.util.LinkedList;
import java.util.List;

/**
 * Sentence of line.
 *
 */
public class Sentence {
    private final static String SENTENCE_SEPARATOR = ".";
    private Word words;
    private List<Sentence> sentences;

    public Sentence(String sentence) {
        this.sentences = new LinkedList<>();
        this.words = new Word("Word");
        words.addWords(parseSentenceForWords(sentence));
    }

    public List<Word> parseSentenceForWords(String sentence) { return Parser.getWordsFromSentence(sentence); }

    public String getSentences() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.words.getWords()).append(SENTENCE_SEPARATOR);
        }
        return result.toString();
    }

    public void addSentences(List<Sentence> newSentences) {
        sentences.addAll(newSentences);
    }

    public String getSentencesAsString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.words.getWordsAsString()).append(SENTENCE_SEPARATOR);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return words.getWordsAsString();
    }
}
