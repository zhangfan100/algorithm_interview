package str;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 */
public class 替换所有的问号 {

    List<Character> characterList = new ArrayList<>();
    {
        characterList.add('a');
        characterList.add('b');
        characterList.add('c');
        characterList.add('d');
        characterList.add('e');
        characterList.add('f');
        characterList.add('g');
        characterList.add('h');
        characterList.add('i');
        characterList.add('j');
        characterList.add('k');
        characterList.add('l');
        characterList.add('m');
        characterList.add('n');
        characterList.add('o');
        characterList.add('p');
        characterList.add('q');
        characterList.add('r');
        characterList.add('s');
        characterList.add('t');
        characterList.add('u');
        characterList.add('v');
        characterList.add('w');
        characterList.add('x');
        characterList.add('y');
        characterList.add('z');
    }
    public String modifyString(String s) {
        Character preCh = null;
        for (int i = 0, j = s.length(); i < j; i++) {
            Character ch = s.charAt(i);
            if (ch == '?') {
                // 下一个是啥
                Character nextCh = null;
                if (i != j - 1) {// 不是最后一个
                    nextCh = s.charAt(i + 1);
                }
                List<Character> temp = new ArrayList<>(characterList);
                if (nextCh != null) {
                    temp.remove(nextCh);
                }
                temp.remove(preCh);
                StringBuilder sb = new StringBuilder(s);
                s = sb.replace(i, i + 1, temp.get(0).toString()).toString();
                preCh = s.charAt(i);
            } else {
                preCh = ch;
            }
        }

        return s;
    }

    public static void main(String[] args) {

        System.out.println(new 替换所有的问号().modifyString("j?qg??b"));
    }

}
