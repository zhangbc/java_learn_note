package com.patterns;

/**
 * 适配器模式-实现MediaPlayer接口的AudioPlayer实体类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 12:38
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdapter adapter;

    @Override
    public void play(String audioType, String fileName) {
        String vlc = "vlc";
        String mp4 = "mp4";
        String mp3 = "mp3";
        if (audioType.equalsIgnoreCase(mp3)) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase(mp4)
                || audioType.equalsIgnoreCase(vlc)) {
            adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not support.");
        }
    }
}
