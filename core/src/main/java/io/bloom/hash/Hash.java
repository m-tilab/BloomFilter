package io.bloom.hash;

import java.util.*;

/**
 * simple interface of hash functions
 */
public interface Hash {
    /**
     * hashes a single word but doesn't save it!
     * @param word -> the word you want to hash
     * @return a list of integers as a characters code of the word parameter
     */
    List<Integer> hash(String word);

    /**
     * hashes list of words and saves the result
     * @param words -> list of initialize words
     */
    void save(List<String> words);

    /**
     * checks if the word is in Bitset or not
     * @param integers list of hashed word numbers
     * @return a boolean that describes if the word is present or not
     */
    boolean check(List<Integer> integers);
}
