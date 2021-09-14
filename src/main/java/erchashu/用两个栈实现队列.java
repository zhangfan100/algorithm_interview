package erchashu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 用两个栈实现队列 {

    /**
     * 描述
     * 用两个栈来实现一个队列，分别完成在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
     *
     * 示例:
     * 输入:
     * ["PSH1","PSH2","POP","POP"]
     * 返回:
     * 1,2
     * 解析:
     * "PSH1":代表将1插入队列尾部
     * "PSH2":代表将2插入队列尾部
     * "POP“:代表删除一个元素，先进先出=>返回1
     * "POP“:代表删除一个元素，先进先出=>返回2
     * 示例1
     * 输入：
     * ["PSH1","PSH2","POP","POP"]
     * 复制
     * 返回值：
     * 1,2
     */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // stack1 专门用来push
    public void push(int node) {
        stack1.push(node);
    }

    // 2专门用来读
    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int data = stack2.pop();
        // 还原现场  2的数据导入到1中
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return data;
    }

    public static void main(String[] args) {
        用两个栈实现队列 ss = new 用两个栈实现队列();
        List<String> rs = new ArrayList<String>(){{
            add("PSH1");
            add("PSH2");
            add("POP");
            add("PSH3");
            add("PSH4");
            add("POP");
            add("PSH5");
            add("POP");
            add("POP");
            add("POP");
        }};
        for (int i = 0; i < rs.size(); i++) {
            String s = rs.get(i);
            if (s.startsWith("PSH")){
                ss.push(Integer.valueOf(s.replace("PSH","")));
            }else{
                System.out.println(ss.pop());
            }
        }
    }

}
