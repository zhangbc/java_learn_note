package com.leetcode.algorithm;

/**
 * 1095. 山脉数组中查找目标值
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/3 11:04
 */
public class Solution1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        if (length < 3) {
            return -1;
        }

        // 找峰值
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // 升序查找
        int index = binarySearch(mountainArr, target, 0, low, true);
        if (index != -1) {
            return index;
        }

        return binarySearch(mountainArr, target, low + 1, length - 1, false);
    }

    private int binarySearch(MountainArray mountainArr, int target, int low, int high, boolean flag) {
        if (!flag) {
            target *= -1;
        }

        while (low <= high) {
            int mid = (low + high) >> 1;
            int cur = mountainArr.get(mid) * (flag ? 1 : -1);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}


interface MountainArray {
    default int get(int index) {
        return 0;
    }

    default int length() {
        return 0;
    }
}
