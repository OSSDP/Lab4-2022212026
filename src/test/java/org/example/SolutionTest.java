package org.example;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testFindRepeatedDnaSequences_WithRepetitions() {
        // 测试目的：验证当输入字符串中有重复的长度为10的DNA序列时，是否能正确找出所有重复的序列。
        
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.findRepeatedDnaSequences(s)));
    }

    @Test
    void testFindRepeatedDnaSequences_SingleLongRepetition() {
        // 测试目的：验证当输入字符串中有一个非常长的重复序列时，是否能正确找出该序列。
        // 使用的测试用例：一个长度超过10且有重复部分的DNA序列
        String s = "AAAAAAAAAAAAA";
        List<String> expected = Arrays.asList("AAAAAAAAAA");
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.findRepeatedDnaSequences(s)));
    }

    @Test
    void testFindRepeatedDnaSequences_NoRepetitions() {
        // 测试目的：验证当输入字符串中没有重复的长度为10的DNA序列时，返回的结果应该为空。
        // 使用的测试用例：一个没有任何重复子串的DNA序列
        String s = "ACGTACGTACGT";
        List<String> expected = Arrays.asList();
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.findRepeatedDnaSequences(s)));
    }

    @Test
    void testFindRepeatedDnaSequences_BorderCase() {
        // 测试目的：验证当输入字符串刚好是长度为10的重复序列时，返回的结果也应该为空（因为需要至少出现两次）。
        // 使用的测试用例：一个长度恰好为10的DNA序列
        String s = "TTTTTTTTTT";
        List<String> expected = Arrays.asList();
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.findRepeatedDnaSequences(s)));
    }

    @Test
    void testFindRepeatedDnaSequences_ShortSequence() {
        // 测试目的：验证当输入字符串长度小于10时，返回的结果应该为空。
        // 使用的测试用例：一个长度小于10的DNA序列
        String s = "ACGT";
        List<String> expected = Arrays.asList();
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.findRepeatedDnaSequences(s)));
    }

    @Test
    void testFindRepeatedDnaSequences_EmptyString() {
        // 测试目的：验证当输入是一个空字符串时，返回的结果应该为空。
        // 使用的测试用例：空字符串
        String s = "";
        List<String> expected = Arrays.asList();
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.findRepeatedDnaSequences(s)));
    }
}
