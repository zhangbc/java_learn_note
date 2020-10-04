package com.exam;

/**
 * LambdaExpressions
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 09:12
 */
public class LambdaExpressions {

    static Body body1 = head -> head + " No parents!";
    static Body body2 = (head) -> head + " More details.";
    static Description desc = () -> "Short info.";
    static Multi multi = (head, d) -> head + d;
    static Description moreLine = () -> {
        System.out.println("moreLine()");
        return "from moreLine()";
    };

    public static void main(String[] args) {
        System.out.println(body1.detailed("Oh!"));
        System.out.println(body2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(multi.towArgs("Pi!", Math.PI));
        System.out.println(moreLine.brief());
    }
}


interface Description {
    String brief();
}


interface Body {
    String detailed(String head);
}


interface Multi {
    String towArgs(String head, Double d);
}