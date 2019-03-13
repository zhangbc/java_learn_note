package com.runoob;

import java.applet.Applet;
import java.awt.*;

/**
 * @author 张伯成
 * @date 2019/3/11 13:20
 */
public class HelloWorldApplet extends Applet {
    @Override
    public void paint(Graphics graphics) {
        graphics.drawString("Hello World", 25, 50);
    }
}
