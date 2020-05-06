package com.patterns;

/**
 * 适配器模式-使用AudioPlayer来播放不同类型的音频格式(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 12:47
 */
public class PatternDemoAdapter {
    public static void main(String[] args) {

        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "beyond the horizon.mp3");
        player.play("mp4", "alone.mp4");
        player.play("vlc", "far far away.vlc");
        player.play("avi", "mind me.avi");
    }
}
