package com.runoob;

import java.applet.Applet;
import java.awt.*;

/**
 * @author 张伯成
 * @date 2019/3/13 16:57
 */
public class CheckerApplet extends Applet {
    int squareSize = 50;

    public void init() {
        String squareSizeParam = getParameter("squareSize");
        parseSquareSize(squareSizeParam);

        String colorParam = getParameter("color");
        Color fg = parseColor(colorParam);

        setBackground(Color.black);
        setForeground(fg);
    }
    private void parseSquareSize(String param) {
        if (param == null) {
            return;
        }

        try {
            squareSize = Integer.parseInt(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Color parseColor(String param) {return null;}
    public void paint(Graphics gp) {}
}
