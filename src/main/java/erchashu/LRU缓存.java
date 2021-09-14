package erchashu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRU缓存 {

    /**
     * 提示:
     * 1.某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的，然后都会刷新缓存。
     * 2.当缓存的大小超过K时，移除最不经常使用的记录。
     * 3.输入一个二维数组与K，二维数组每一维有2个或者3个数字，第1个数字为opt，第2，3个数字为key，value
     *    若opt=1，接下来两个整数key, value，表示set(key, value)
     *    若opt=2，接下来一个整数key，表示get(key)，若key未出现过或已被移除，则返回-1
     *    对于每个opt=2，输出一个答案
     * 4.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
     *
     * 进阶:你是否可以在O(1)的时间复杂度完成set和get操作
     */

    public static void main(String[] args) {
        int[][] ops = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,3,4},{1,4,4},{2,2}};
        new LRU缓存().LRU(ops,3);
    }

    LinkedHashMap<Integer,Integer> dataMap = new LinkedHashMap<Integer,Integer>();
    int capacity = 0;

    public int[] LRU (int[][] operators, int k) {
        capacity = k;
        List<Integer> result = new ArrayList<Integer>();
        for (int[] temp : operators){
            if (temp[0] == 1){
                // set
                put(temp[1],temp[2]);
            }else{
                // get
                result.add(get(temp[1]));
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
            System.out.println(ints[i]);
        }
        return ints;
    }

    public void put(Integer key, Integer value) {
        if (dataMap.containsKey(key)) {
            // 清楚  重新放入到后面
            dataMap.remove(key);
            dataMap.put(key, value);
        } else {
            dataMap.put(key, value);
            if (dataMap.size() > capacity) {
                // 清理第一个 就是最近没用的
                Integer firstKey = dataMap.entrySet().iterator().next().getKey();
                dataMap.remove(firstKey);
            }
        }
    }

    public Integer get(Integer key){
        if (dataMap.containsKey(key)){
            Integer remove = dataMap.remove(key);
            dataMap.put(key,remove);
            return remove;
        }
        return -1;

    }
}
