package io.bloom.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashTest {
    private final List<String> words = new ArrayList<>();
    private BloomFilter bloomFilter;

    @BeforeEach
    public void init() {
        try {
            String path = "src/test/resources/";

            File textFile = new File(path + "wordlist.txt");
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                words.add(word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bloomFilter = new BloomFilter.Builder().setNames(words).setHashClass(new AlphabeticalHash()).setHashClass(new CharCodeHash()).build();
    }

    @Test
    public void test() {
        assertTrue(bloomFilter.check("Mohammad"));
        assertFalse(bloomFilter.check("#Mohammad"));
    }

    @Test
    public void testTextFile() {
        assertTrue(bloomFilter.check("Agar"));
        assertFalse(bloomFilter.check(""));
    }
}
