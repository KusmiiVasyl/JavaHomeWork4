package task2;

import java.util.*;

public class Main {
    public static TreeSet<Word> words = new TreeSet<>();

    public static void main(String[] args) {
        Collections.addAll(words,
                new Word("study", "вивчення"),
                new Word("member", "учасник"),
                new Word("president", "президент"),
                new Word("expect", "очікувати"),
                new Word("reach", "досягати"),
                new Word("remain", "залишатися"),
                new Word("remain", "залишатися"),
                new Word("political", "політичний"),
                new Word("social", "соціальний"),
                new Word("only", "тільки"),
                new Word("major", "важливіший"),
                new Word("religious", "релігійний"),
                new Word("community", "спільнота")
        );

        words.add(dataEntryForTheDictionary("feral", "дикий"));
        displayWordAndTranslations("only");
        addTranslationOfWord("feral", "неприручений");
        changeTranslationOfWord("only", "лише");
        removeTranslationOfWord("reach");
        changeWord("study", "learn");
        removeWord("major");
        displayTop10PopularWords();
        displayTop10UnpopularWords();
    }

    public static Word dataEntryForTheDictionary(String word, String translateWord) {
        return new Word(word, translateWord);
    }

    public static void displayWordAndTranslations(String word) {
        words.stream().filter(w -> w.getWord().equals(word))
                .forEach(Word::showWordAndTranslate);
    }

    public static void addTranslationOfWord(String word, String translateWord) {
        words.stream().filter(w -> w.getWord().equals(word))
                .forEach(w -> w.setTranslateWords(translateWord));
    }

    public static void changeTranslationOfWord(String word, String translateWord) {
        words.stream().filter(w -> w.getWord().equals(word))
                .forEach(w -> w.changeTranslateWords(translateWord));
    }

    public static void removeTranslationOfWord(String word) {
        words.stream().filter(w -> w.getWord().equals(word))
                .forEach(Word::removeTranslateWords);
    }

    public static void changeWord(String word, String newWord) {
        words.stream().filter(w -> w.getWord().equals(word))
                .forEach(w -> w.setWord(newWord));
    }

    public static void removeWord(String word) {
        words.stream().filter(w -> w.getWord().equals(word))
                .forEach(Word::removeWord);
    }

    public static void displayTop10PopularWords() {
        List<Word> wordsPopular = words.stream().sorted(new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                return Integer.compare(word2.getPopularityCounter(), word1.getPopularityCounter());
            }
        }).toList();
        showFirstTenElements(wordsPopular);
    }

    public static void displayTop10UnpopularWords() {
        List<Word> wordsPopular = words.stream().sorted(new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                return Integer.compare(word1.getPopularityCounter(), word2.getPopularityCounter());
            }
        }).toList();
        showFirstTenElements(wordsPopular);
    }

    public static void showFirstTenElements(List<Word> wordsPopular) {
        int count = 0;
        for (Word word : wordsPopular) {
            count++;
            if (count > 10) break;
            System.out.println(word.getWord());
        }
    }
}
