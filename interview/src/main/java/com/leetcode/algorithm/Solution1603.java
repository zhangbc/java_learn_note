package com.leetcode.algorithm;

/**
 * 1603. 设计停车系统
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/14 17:57
 */
public class Solution1603 {
}


class ParkingSystem {

    int[] parking = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        this.parking[0] = big;
        this.parking[1] = medium;
        this.parking[2] = small;
    }

    public boolean addCar(int carType) {
        if (carType < 1 || carType > 3) {
            return false;
        }

        if (parking[carType - 1] > 0) {
            parking[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }
}