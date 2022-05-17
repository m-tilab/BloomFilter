package io.bloom.hash;

import java.util.*;

/**
 * simple implementation of bloom filter using shuffled characters indexes
 * uses the index of characters as indexes in bitset
 */
public class AlphabeticalHash implements Hash {
    List<String> characters = new ArrayList<>();
    BitSet bitset = new BitSet();

    public AlphabeticalHash() {
        characters.add("a");
        characters.add("b");
        characters.add("c");
        characters.add("d");
        characters.add("e");
        characters.add("f");
        characters.add("g");
        characters.add("h");
        characters.add("i");
        characters.add("j");
        characters.add("k");
        characters.add("l");
        characters.add("m");
        characters.add("n");
        characters.add("o");
        characters.add("p");
        characters.add("q");
        characters.add("r");
        characters.add("s");
        characters.add("t");
        characters.add("u");
        characters.add("v");
        characters.add("w");
        characters.add("x");
        characters.add("y");
        characters.add("z");
        characters.add("A");
        characters.add("B");
        characters.add("C");
        characters.add("D");
        characters.add("E");
        characters.add("F");
        characters.add("G");
        characters.add("H");
        characters.add("I");
        characters.add("J");
        characters.add("K");
        characters.add("L");
        characters.add("M");
        characters.add("N");
        characters.add("O");
        characters.add("P");
        characters.add("Q");
        characters.add("R");
        characters.add("S");
        characters.add("T");
        characters.add("U");
        characters.add("V");
        characters.add("W");
        characters.add("X");
        characters.add("Y");
        characters.add("Z");
        characters.add("1");
        characters.add("2");
        characters.add("3");
        characters.add("4");
        characters.add("5");
        characters.add("6");
        characters.add("7");
        characters.add("8");
        characters.add("9");
        characters.add("!");
        characters.add("@");
        characters.add("#");
        characters.add("%");
        characters.add("^");
        characters.add("&");
        characters.add("*");
        characters.add("(");
        characters.add(")");
        characters.add("_");
        characters.add("+");
        characters.add("-");
        characters.add("?");
        characters.add(">");
        characters.add("<");
        characters.add("{");
        characters.add("}");
        characters.add("[");
        characters.add("]");
        characters.add(";");
        characters.add(":");
        characters.add("'");
        characters.add("\"");
        characters.add("/");
        characters.add("\"");
        characters.add("|");
        characters.add("�");
        Collections.shuffle(characters, new Random());
    }

    @Override
    public List<Integer> hash(String word) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < word.length(); i++)
            integers.add(
                    characters.indexOf(String.valueOf(
                                    word.charAt(i)
                            )
                    )
            );
        return integers;
    }

    @Override
    public void save(List<String> words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!characters.contains(String.valueOf(word.charAt(i))))
                    throw new RuntimeException("un handled character" + word.charAt(i));
                bitset.set(
                        characters.indexOf(String.valueOf(
                                        word.charAt(i)
                                )
                        )
                );

            }
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
