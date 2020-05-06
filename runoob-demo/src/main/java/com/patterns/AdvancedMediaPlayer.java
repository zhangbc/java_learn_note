package com.patterns;

/**
 * 适配器模式-接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 12:17
 */
public interface AdvancedMediaPlayer {
    /**
     * VLC播放
     * @param fileName 文件名称
     */
    void playVlc(String fileName);

    /**
     * MP4播放
     * @param fileName 文件名称
     */
    void playMp4(String fileName);
}
