package io.bloom.hash;

import java.util.ArrayList;
import java.util.List;


/**
 * simple implementation of bloom filter
 * constructor is private, and you must initialize this class with {@link Builder} class
 */
public class BloomFilter {
    /**
     * takes a list of words
     * you must pass this as a list of strings
     */
    private final List<String> words;
    /**
     * keeps every implementation of {@link Hash} class
     */
    private final List<Hash> hashClasses;

    private BloomFilter(Builder builder) {
        words = builder.names;
        hashClasses = builder.hashClasses;
        hashClasses.get(0).save(words);
        hashClasses.get(1).save(words);
    }

    public List<String> getWords() {
        return words;
    }

    public List<Hash> getHashClasses() {
        return hashClasses;
    }


    public boolean check(String keyword) {
        List<Integer> firstHashedIntegers = hashClasses.get(0).hash(keyword);
        List<Integer> secondHashedIntegers = hashClasses.get(1).hash(keyword);

        return hashClasses.get(0).check(firstHashedIntegers) && hashClasses.get(1).check(secondHashedIntegers);
    }


    @Override
    public String toString() {
        return "BloomFilter{" +
                "names=" + words +
                ", hashClasses=" + hashClasses +
                '}';
    }


    public static class Builder {
        private List<String> names;
        private List<Hash> hashClasses;

        public Builder setNames(List<String> names) {
            this.names = names;
            return this;
        }

        public Builder setHashClass(Hash hashClass) {
            if (hashClasses == null)
                hashClasses = new ArrayList<>();
            hashClasses.add(hashClass);
            return this;
        }

        public BloomFilter build() {
            return new BloomFilter(this);
        }
    }


}
