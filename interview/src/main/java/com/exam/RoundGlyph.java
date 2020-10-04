package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 00:06
 */
public class RoundGlyph extends Glyph {

    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }

    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}


class Glyph {

    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}