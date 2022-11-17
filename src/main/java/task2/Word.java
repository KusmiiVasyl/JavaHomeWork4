package task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Word implements Comparable<Word> {
    private String word;
    private ArrayList<String> translateWords;
    private int popularityCounter;

    public Word(String word, String translateWord) {
        this.word = word;
        translateWords = new ArrayList<>();
        setTranslateWords(translateWord);
    }

    public int getPopularityCounter() {
        return popularityCounter;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslateWords(String translateWord) {
        translateWords.add(translateWord);
    }

    public void removeTranslateWords() {
        this.translateWords.clear();
    }

    public void removeWord() {
        this.word = "";
    }

    public void changeTranslateWords(String translateWord) {
        removeTranslateWords();
        setTranslateWords(translateWord);
    }

    public void showWordAndTranslate() {
        popularityCounter++;
        System.out.print(this.word + " - ");
        for (String translateWord : translateWords) {
            System.out.print(translateWord + ", ");
        }
        System.out.print("\b\b\n");
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", translateWords=" + translateWords +
                ", popularityCounter=" + popularityCounter +
                '}' + "\n";
    }

    @Override
    public int compareTo(Word o) {
        return this.word.compareTo(o.getWord());
    }
}
