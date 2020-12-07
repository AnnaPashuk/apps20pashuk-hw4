package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.ArrayList;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }
    public int load(String... strings) {
        int numOfWords = 0;
        String[] newWords = null;
        for (String word : strings){
            newWords = word.split("\\s+");
            for (String elem : newWords){
                if (elem.length() >= 2){
                    trie.add(new Tuple(elem, elem.length()));
                    numOfWords ++;
                }
            }
        }

        return numOfWords;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        if (pref.length() >= 2) {
            return trie.wordsWithPrefix(pref);
        }
        else{
            return null;
        }

    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        int maxLength;
        ArrayList<String> result = new ArrayList<>();
        Iterable<String> wordsResult = trie.wordsWithPrefix(pref);
        System.out.println("wordsWithPrefix" + wordsResult);
        if (pref.length() >= 2){
            if (pref.length() == 2){
                maxLength = 3;
            }
            else{
                maxLength = pref.length() + k;
            }

            for(String word: wordsResult){
                System.out.println("w " + word);

                if (word.length() <= maxLength){
                    result.add(word);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public int size() {
        return trie.size();
    }
}
