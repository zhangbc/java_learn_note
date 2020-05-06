package com.patterns;

/**
 * 适配器模式-实现AdvancedMediaPlayer接口的VlcPlayer实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 12:24
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
