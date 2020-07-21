package com.patterns;

/**
 * 前端控制器模式--使用FrontController来演示前端控制器模式(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 08:56
 */
public class PatternDemoFrontController {
    public static void main(String[] args) {
        FrontController controller = new FrontController();
        controller.dispatchRequest("HOME");
        controller.dispatchRequest("PERSON");
    }
}
