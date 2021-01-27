package Converter;

import java.util.ArrayList;

public class MaxLenWords {
    private int lenghtWord;
    private ArrayList<String> words;

    public MaxLenWords(int lenghtWord, ArrayList<String> words) {
        this.lenghtWord = lenghtWord;
        this.words = words;
    }

    public int getLenghtWord() {
        return lenghtWord;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    @Override
    public String toString() {
        return "В тексте самые длинные слова встречаются: " + lenghtWord + " раз " +
                ", эти слова: " + words;
    }
}
