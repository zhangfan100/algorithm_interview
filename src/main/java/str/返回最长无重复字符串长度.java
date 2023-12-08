package str;

/**
 * 给定一个只有小写字母组成的字符串，返回其中最长无重复字符的子串长度
 */
public class 返回最长无重复字符串长度 {
    public static void main(String[] args) {
        char[] chars = "tgabcdefg".toCharArray();
        System.out.println(chars[3]-'a');
        String str = "yabcdefggoplkjdscbng";
        System.out.println(new 返回最长无重复字符串长度().getMaxSub(str));
    }

    public int getMaxSub(String str){
        if (str==null|| str.isEmpty()){
            return 0;
        }

        int max = 0;
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i=0;i<length;i++){
            boolean[] set = new boolean[26];
            for (int j=i;j<length;j++){
                if (set[chars[j]-'a']){
                    break;
                }
                set[chars[j]-'a'] = true;
                max = Math.max(max,j-i+1);
            }
        }

        return max;
    }

    /**
     * 算出以0，1，2，3。。。结尾的子串最大长度 分别为 x1，x2，x3 。。。。。 n  那么就只需要找出x1到n的最大值即可
     * @param str
     * @return
     */
    public int getMaxSub1(String str){
        if (str==null|| str.isEmpty()){
            return 0;
        }


        int[] last = new int[26]; // 表示字母出现的位置
        // last[0]  表示a出现的问题
        // last[1]  表示b出现的问题
        // last[2]  表示c出现的问题
        // ...
        // last[25]  表示z出现的问题
        for (int i=0;i<26;i++){
           last[i]=-1;
        }

        int preMax = 1;// 表示前一个位置最大子串
        int max = 1;// 最大就是为0位置结尾的子串 那就是1
        char[] chars = str.toCharArray();
        int length = chars.length;
        last[chars[0]-'a']=0;
        for(int j=1;j<length;j++){
            // 算出当前位置最大不重复子串 有2个因素
                // 1、当前字符上次出现的位置距离
                // 2、前一个最大的值
            // last[chars[j]-'a']  表示当前字符上次出现的问题
            // j-last[chars[j]-'a']  表示上次出现位置和当前位置的距离
            preMax = Math.min(preMax+1,j-last[chars[j]-'a']);
            max = Math.max(preMax,max);
            last[chars[j]-'a']=j;
        }
        return max;
    }
}
