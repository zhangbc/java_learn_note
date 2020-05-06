package com.patterns;

/**
 * 适配器模式-实现AdvancedMediaPlayer接口的Mp4Player实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 12:24
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
