package com.patterns;

/**
 * 适配器模式-接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 12:17
 */
public interface MediaPlayer {
    /**
     * 媒体播放
     * @param audioType 媒体类型
     * @param fileName 文件名称
     */
    void play(String audioType, String fileName);
}
