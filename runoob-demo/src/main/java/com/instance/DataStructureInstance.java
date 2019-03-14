package com.instance;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 10:17
 */
public class DataStructureInstance {
    public static void main(String[] args) {
        System.out.println("Java数据结构实例！");
    }
}


/**
 * 数字求和运算：
 * 使用do...while结构求0~100的整数数字之和.
 */
class NumberSummation {
    public static void main(String[] args) {
        int limit = 100;
        long sum = 0;
        int cnt = 1;
        do {
            sum += cnt;
            cnt++;
        } while (cnt <= limit);
        System.out.printf("1+...+%d=%d\n", limit, sum);
    }
}


/**
 * 利用堆栈将中缀表达式转换成后缀表达式：
 * 例如：124*5/+7-36/+
 * Postfix is 124*5/+7-36/+
 */
class InfixConvertPostfix {
    private Stack stack;
    private String input;
    private String output = "";

    public InfixConvertPostfix(String in) {
        input = in;
        int stackSize = input.length();
        stack = new Stack(stackSize);
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOperation(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperation(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    getParent();
                    break;
                    default:
                        output += ch;
                        break;
            }
        }
        while (!stack.isEmpty()) {
            output += stack.pop();
        }
        System.out.println(output);
        return output;
    }

    public void gotOperation(char opt, int prec) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int pr;
                if (opTop == '+' || opTop == '-') {
                    pr = 1;
                } else {
                    pr = 2;
                }
                if (pr < prec) {
                    stack.push(opTop);
                    break;
                } else {
                    output += opTop;
                }
            }
        }
        stack.push(opt);
    }

    public void getParent() {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }

    public static void main(String[] args) throws IOException  {
        String input = "1+2*4/5-7+3/6";
        String output;
        InfixConvertPostfix inToPost = new InfixConvertPostfix(input);
        output = inToPost.doTrans();
        System.out.println("Postfix is " + output);
    }
}


/**
 * 栈结构：基本操作
 */
class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char ch) {
        stackArray[++top] = ch;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}


/**
 * 在链表（LinkedList）的开头和结尾添加元素
 */
class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        System.out.println("原始链表：" + linkedList);
        linkedList.addFirst("0");
        System.out.println("头插入元素0的链表：" + linkedList);
        linkedList.addLast("6");
        System.out.println("尾插入元素6的链表：" + linkedList);
    }
}


/**
 * 获取链表（LinkedList）的第一个和最后一个元素：
 * 使用LinkedList类的linkedlistname.getFirst()和linkedlistname.getLast()来获取链表的第一个和最后一个元素.
 */
class LinkedListGetItem {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("100");
        linkedList.add("200");
        linkedList.add("300");
        linkedList.add("400");
        linkedList.add("500");
        System.out.println("链表的第一个元素是：" + linkedList.getFirst());
        System.out.println("链表的最后一个元素是：" + linkedList.getLast());
    }
}


/**
 * 删除链表中的元素：
 * 使用clear()方法删除链表中的元素
 */
class LinkedListDeleteItem {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("8");
        linkedList.add("6");
        linkedList.add("4");
        linkedList.add("5");
        System.out.println("链表删除前：" + linkedList);
        linkedList.subList(2, 4).clear();
        System.out.println("链表删除后：" + linkedList);
    }
}


/**
 * 获取链表的元素：
 * 使用top()和pop()方法来获取链表的元素.
 */
class LinkListItems {
    private LinkedList list = new LinkedList();

    public void push(Object obj) {
        list.addFirst(obj);
    }

    public Object top() {
        return list.getFirst();
    }

    public Object pop() {
        return list.removeFirst();
    }

    public static void main(String[] args) {
        LinkListItems stack = new LinkListItems();
        int start = 30, end = 40;
        for (int i = start; i < end; i++) {
            stack.push(new Integer(i));
        }

        System.out.print("获取链表的元素：");
        System.out.print(stack.top() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.println(stack.pop());
    }
}


/**
 * 获取向量元素的索引值：
 * 使用Collections类的sort()方法对向量进行排序
 * 并使用 binarySearch() 方法来获取向量元素的索引值.
 */
class VectorIndexOfItem {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("X");
        v.add("M");
        v.add("D");
        v.add("A");
        v.add("O");
        Collections.sort(v);
        System.out.println("排序后的向量元素：" + v);
        int index = Collections.binarySearch(v, "D");
        System.out.println("元素D的索引值为：" + index);
    }
}


/**
 * 栈的实现
 */
class LinkedStack {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');
        System.out.println("出栈顺序：");
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            System.out.print(ch + " ");
        }
    }
}


/**
 * 链表元素查找：
 * 使用linkedlistname.indexof(element)和linkedlistname.Lastindexof(elementname) 方法
 * 在链表中获取元素第一次和最后一次出现的位置.
 */
class LinkedListSearch {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("2");
        System.out.println("元素2在链表中第一次出现的位置：" + linkedList.indexOf("2"));
        System.out.println("元素2在链表中最后一次出现的位置：" + linkedList.lastIndexOf("2"));
    }
}


/**
 * 压栈出栈的方法实现字符串反转
 */
class StringReverseByStack {
    private String input;
    private String output;
    public StringReverseByStack(String in) {
        input = in;
    }

    public String reverser() {
        int stackSize = input.length();
        Stack stack = new Stack(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }

        output = "";
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            output += ch;
        }
        return output;
    }

    public static void main(String[] args) {
        String input = "www.w3cschool.cc";
        String output;
        StringReverseByStack reverseByStack = new StringReverseByStack(input);
        output = reverseByStack.reverser();
        System.out.println("反转前：" + input);
        System.out.println("反转后：" + output);
    }
}


/**
 *  队列（Queue）用法：
 *  队列是一种特殊的线性表，只允许在表的前端进行删除操作，而在表的后端进行插入操作。
 *  LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
 */
class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // add()和remove()方法在失败时会抛出异常（不推荐）
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for (String qe: queue) {
            System.out.print(qe + " ");
        }

        System.out.println("\n===============");
        // 返回第一个元素，并在队列中删除
        System.out.println("poll=" + queue.poll());
        for (String qe: queue) {
            System.out.print(qe);
        }

        System.out.println("\n===============");
        // 返回第一个元素
        System.out.println("element=" + queue.element());
        for (String qe: queue) {
            System.out.print(qe);
        }

        System.out.println("\n===============");
        // 返回第一个元素
        System.out.println("peek=" + queue.peek());
        for (String qe: queue) {
            System.out.print(qe);
        }
    }
}


/**
 * 获取向量的最大元素：
 * 使用Vector类的add()方法及Collection类的Collections.max()来获取向量的最大元素.
 */
class VectorMaxItem {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(new Double("3.4324"));
        vector.add(new Double("3.3532"));
        vector.add(new Double("3.432401"));
        vector.add(new Double("3.342"));
        vector.add(new Double("3.349"));
        vector.add(new Double("2.9"));
        Object obj = Collections.max(vector);
        System.out.println("最大元素是：" + obj);
    }
}


/**
 * 链表修改：
 * 使用listname.add()和listname.set()方法来修改链接中的元素.
 */
class LinkListUpdate {
    public static void main(String[] args) {
        LinkedList officers = new LinkedList();
        officers.add("B");
        officers.add("B");
        officers.add("T");
        officers.add("H");
        officers.add("P");
        System.out.println("链表修改前：" + officers);
        officers.set(2, "M");
        System.out.println("链表修改后：" + officers);
    }
}


/**
 * 旋转向量：
 * 使用swap()函数来旋转向量.
 */
class VectorRotate {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");
        vector.add("5");
        System.out.println("向量旋转前：" + vector);
        Collections.swap(vector, 0, 4);
        System.out.println("向量旋转后：" + vector);
    }
}