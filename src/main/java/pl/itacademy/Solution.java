package pl.itacademy;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int secondMaxNumber(Collection<Integer> numbers) {
        return numbers.stream().distinct().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1).collect(Collectors.summarizingInt(Integer::intValue)).getMax();
    }

    public List<String> findPalindromes(Collection<String> words) {
        if (words == null || words.isEmpty()) {
            return null;
        }
        return words.stream().filter(this::checkPalindromes).collect(Collectors.toList());
    }

    public boolean checkPalindromes(String text) {
        String inverse = "";
        int length = text.length();
        for (int i = length - 1; i >= 0; i--) {
            inverse = inverse + text.charAt(i);
            if (text.equals(inverse)) {
                return true;
            }
        }
        return inverse.equals(text);
    }
}