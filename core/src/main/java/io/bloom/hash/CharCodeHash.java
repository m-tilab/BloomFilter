package io.bloom.hash;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * simple implementation of bloom filter using characters code!
 * uses the code of every character as indexes in bitset
 */
public class CharCodeHash implements Hash {

    BitSet bitset = new BitSet();

    @Override
    public List<Integer> hash(String word) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < word.length(); i++)
            integers.add(
                    (int) word.charAt(i)
            );
        return integers;
    }

    @Override
    public void save(List<String> words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++)
                bitset.set(
                        word.charAt(i)
                );
        }
    }

    @Override
    public boolean check(List<Integer> integers) {
        for (Integer index : integers) {
            if (!bitset.get(index))
                return false;
        }
        return true;
    }

}
