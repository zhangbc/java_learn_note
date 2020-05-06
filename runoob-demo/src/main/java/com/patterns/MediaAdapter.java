package com.patterns;

/**
 * 适配器模式-实现MediaPlayer接口的MediaAdapter适配器类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 12:29
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer player;
    String vlc = "vlc";
    String mp4 = "mp4";

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase(vlc)) {
            player = new VlcPlayer();
        }

        if (audioType.equalsIgnoreCase(mp4)) {
            player = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase(vlc)) {
            player.playVlc(fileName);
        }

        if (audioType.equalsIgnoreCase(mp4)) {
            player.playMp4(fileName);
        }
    }
}
