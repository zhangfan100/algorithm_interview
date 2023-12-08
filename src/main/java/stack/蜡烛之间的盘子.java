package stack;

import java.util.Stack;

/**
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。
 * 给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，
 * 其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti]
 * 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。
 * 对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。
 * 如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 */

public class 蜡烛之间的盘子 {

    public int[] findMax(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        Stack<Character> data = new Stack<>();
        int[] result = new int[queries.length];
        int oindex = 0;
        for (int[] each : queries) {
            data.removeAllElements();
            int start = each[0];
            int end = each[1];
            int max = 0;
            for (int index = start; index <= end; index++) {
                char c = chars[index];
                if (c == '|') {
                    // 有前蜡烛 就出栈数盘子数量,在入栈，否则就入栈
                    if (data.contains('|')) {
                        max += data.size() - 1;
                        data.removeAllElements();
                    }
                    data.push(c);
                } else { // 如果前面没有蜡烛  那就不处理这个盘子
                    if (data.contains('|')) {
                        data.push(c);
                    }
                }
            }
            System.out.print(max+",");
            result[oindex++] = max;
        }
        return result;
    }


    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(new 蜡烛之间的盘子().findMax("***|**|*****|**||**|*", queries));
        System.out.println(new 蜡烛之间的盘子().platesBetweenCandles("***|**|*****|**||**|*", queries));
    }

}
