package org.nocoder.leetcode.solution;

/**
 * 28. Implement strStr()
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string?
 * This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 *
 * @author yangjinlong
 * @date 2018-12-17
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        if (needleArr.length == 0) {
            return 0;
        }

        for (int i = 0; i < haystackArr.length - needleArr.length + 1; i++) {
            if (checkMatchingAtIndex(haystackArr, needleArr, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean checkMatchingAtIndex(char[] haystackArr, char[] needleArr, int idx) {

        for (int i = 0; i < needleArr.length; i++) {
            if (haystackArr[i + idx] != needleArr[i]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("hello", "llo"));
        System.out.println(implementStrStr.strStr("aaaaaa", "bba"));
        System.out.println(implementStrStr.strStr("bbbbbb", ""));
        System.out.println(implementStrStr.strStr("mississipp", "issip"));
    }
}
