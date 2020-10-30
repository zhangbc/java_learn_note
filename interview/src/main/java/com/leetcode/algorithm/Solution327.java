package com.leetcode.algorithm;

import java.util.*;

/**
 * 327. 区间和的个数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/7 10:32
 */
public class Solution327 {

    /**
     * 方法一：暴力法
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1 || lower > upper) {
            return 0;
        }

        // 整型加法溢出
        long sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] >= lower && nums[i] <= upper) {
                count++;
            }

            if (i > 0 && sum >= lower && sum <= upper) {
                count++;
            }

            long temp = sum;
            int j = 0;
            while (j < i - 1) {
                temp -= nums[j];
                if (temp >= lower && temp <= upper) {
                    count++;
                }
                j++;
            }
        }

        return count;
    }

    /**
     * 方法二：归并排序法
     */
    public int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1 || lower > upper) {
            return 0;
        }

        long temp = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            sum[i + 1] = temp;
        }

        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    private int countRangeSumRecursive(long[] sum, int lower, int upper, int low, int high) {
        if (low == high) {
            return 0;
        }

        int mid = (low + high) >> 1;
        int n1 = countRangeSumRecursive(sum, lower, upper, low, mid);
        int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, high);
        int res = n1 + n2;

        // 统计下标的数量
        int i = low, lo = mid + 1, hi = mid + 1;
        while (i <= mid) {
            while (lo <= high && sum[lo] - sum[i] < lower) {
                lo++;
            }

            while (hi <= high && sum[hi] - sum[i] <= upper) {
                hi++;
            }

            res += hi - lo;
            i++;
        }

        // 合并数组
        int[] sorted = new int[high - low + 1];
        int p1 = low, p2 = mid + 1, p = 0;
        while (p1 <= mid || p2 <= high) {
            if (p1 > mid) {
                sorted[p++] = (int) sum[p2++];
            } else if (p2 > high) {
                sorted[p++] = (int) sum[p1++];
            } else {
                if (sum[p1] < sum[p2]) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    sorted[p++] = (int) sum[p2++];
                }
            }
        }

        for (int j = 0; j < sorted.length; j++) {
            sum[low + j] = sorted[j];
        }

        return res;
    }

    /**
     * 方法三：线段树
     */
    public int countRangeSum3(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1 || lower > upper) {
            return 0;
        }

        long temp = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            preSum[i + 1] = temp;
        }

        Set<Long> allNumbers = new TreeSet<>();
        for (long item: preSum) {
            allNumbers.add(item);
            allNumbers.add(item - lower);
            allNumbers.add(item - upper);
        }

        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<>(16);
        int idx = 0;
        for (long item: allNumbers) {
            values.put(item, idx++);
        }
        
        SegNode root = build(0, values.size() - 1);
        int res = 0;
        for (long item: preSum) {
            int left = values.get(item - upper), right = values.get(item - lower);
            res += count(root, left, right);
            insert(root, values.get(item));
        }

        return res;
    }

    private void insert(SegNode root, long value) {
        root.add++;
        if (root.left == root.right) {
            return;
        }

        long mid = (root.left + root.right) >> 1;
        if (value <= mid) {
            if (root.lChild == null) {
                root.lChild = new SegNode(root.left, mid);
            }

            insert(root.lChild, value);
        } else {
            if (root.rChild == null) {
                root.rChild = new SegNode(mid + 1, root.right);
            }

            insert(root.rChild, value);
        }
    }

    private long count(SegNode root, long left, long right) {

        if (root == null) {
            return 0;
        }

        if (left > root.right || right < root.left) {
            return 0;
        }

        if (left <= root.left && right >= root.right) {
            return root.add;
        }

        return count(root.lChild, left, right) + count(root.rChild, left, right);
    }

    private SegNode build(long left, long right) {
        SegNode node = new SegNode(left, right);
        if (left == right) {
            return node;
        }

        long mid = (left + right) >> 1;
        node.lChild = build(left, mid);
        node.rChild = build(mid + 1, right);
        return node;
    }

    static class SegNode {
        long left, right, add;
        SegNode lChild, rChild;

        public SegNode(long left, long right) {
            this.left = left;
            this.right = right;
            this.add = 0;
            this.lChild = null;
            this.rChild = null;
        }
    }

    /**
     * 方法四：动态增加节点的线段树
     */
    public int countRangeSum4(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1 || lower > upper) {
            return 0;
        }

        long temp = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            preSum[i + 1] = temp;
        }

        long rightBound = Long.MIN_VALUE, leftBound = Long.MAX_VALUE;
        for (long x: preSum) {
            leftBound = Math.min(Math.min(leftBound, x), Math.min(x - lower, x - upper));
            rightBound = Math.max(Math.max(rightBound, x), Math.max(x - lower, x - upper));
        }

        SegNode root = new SegNode(leftBound, rightBound);
        int res = 0;
        for (long x: preSum) {
            res += count(root, x - upper, x - lower);
            insert(root, x);
        }

        return res;
    }

    /**
     * 方法五：树状数组
     */
    public int countRangeSum5(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1 || lower > upper) {
            return 0;
        }

        long temp = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            preSum[i + 1] = temp;
        }

        Set<Long> allNumbers = new TreeSet<>();
        for (long item: preSum) {
            allNumbers.add(item);
            allNumbers.add(item - lower);
            allNumbers.add(item - upper);
        }

        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<>(16);
        int idx = 0;
        for (long item: allNumbers) {
            values.put(item, idx++);
        }

        BIT bit = new BIT(values.size());
        int res = 0;
        for (long l : preSum) {
            int left = values.get(l - upper), right = values.get(l - lower);
            res += bit.query(right + 1) - bit.query(left);
            bit.update(values.get(l) + 1, 1);
        }

        return res;
    }

    static class BIT {
        int[] tree;
        int number;

        public BIT(int number) {
            this.number = number;
            this.tree = new int[number + 1];
        }

        public static int lowBit(int value) {
            return value & (-value);
        }

        public void update(int x, int d) {
            while (x <= number) {
                tree[x] += d;
                x += lowBit(x);
            }
        }

        public int query(int x) {
            int res = 0;
            while (x != 0) {
                res += tree[x];
                x -= lowBit(x);
            }

            return res;
        }
    }

    /**
     * 方法六：平衡二叉搜索树
     */
    public int countRangeSum6(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1 || lower > upper) {
            return 0;
        }

        long temp = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            preSum[i + 1] = temp;
        }

        BalancedTree root = new BalancedTree();
        int res = 0;
        for (long x: preSum) {
            long numLeft = root.lowerBound(x - upper);
            int rankLeft = (numLeft == Long.MAX_VALUE ? (int) (root.getSize() + 1) : root.rank(numLeft)[0]);
            long numRight = root.upperBound(x - lower);
            int rankRight = (numRight == Long.MAX_VALUE ? (int) (root.getSize()) : root.rank(numRight)[0] - 1);
            res += rankRight - rankLeft + 1;
            root.insert(x);
        }

        return res;
    }

    static class BalancedTree {

        private static class BalancedNode {
            long val;
            long seed;
            int count;
            int size;
            BalancedNode left;
            BalancedNode right;

            BalancedNode(long val, long seed) {
                this.val = val;
                this.seed = seed;
                this.count = 1;
                this.size = 1;
                this.left = null;
                this.right = null;
            }

            BalancedNode leftRotate() {
                int prevSize = size;
                int currSize = (left != null ? left.size : 0) + (right.left != null ? right.left.size : 0) + count;
                BalancedNode root = right;
                right = root.left;
                root.left = this;
                root.size = prevSize;
                size = currSize;
                return root;
            }

            BalancedNode rightRotate() {
                int prevSize = size;
                int currSize = (right != null ? right.size : 0) + (left.right != null ? left.right.size : 0) + count;
                BalancedNode root = left;
                left = root.right;
                root.right = this;
                root.size = prevSize;
                size = currSize;
                return root;
            }
        }

        private BalancedNode root;
        private int size;
        private final Random rand;

        public BalancedTree() {
            this.root = null;
            this.size = 0;
            this.rand = new Random();
        }

        public long getSize() {
            return size;
        }

        public void insert(long x) {
            size++;
            root = insert(root, x);
        }

        public long lowerBound(long x) {
            BalancedNode node = root;
            long ans = Long.MAX_VALUE;
            while (node != null) {
                if (x == node.val) {
                    return x;
                }

                if (x < node.val) {
                    ans = node.val;
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            return ans;
        }

        public long upperBound(long x) {
            BalancedNode node = root;
            long ans = Long.MAX_VALUE;
            while (node != null) {
                if (x < node.val) {
                    ans = node.val;
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            return ans;
        }

        public int[] rank(long x) {
            BalancedNode node = root;
            int ans = 0;
            while (node != null) {
                if (x < node.val) {
                    node = node.left;
                } else {
                    ans += (node.left != null ? node.left.size : 0) + node.count;
                    if (x == node.val) {
                        return new int[]{ans - node.count + 1, ans};
                    }
                    node = node.right;
                }
            }
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }

        private BalancedNode insert(BalancedNode node, long x) {
            if (node == null) {
                return new BalancedNode(x, rand.nextInt());
            }

            node.size++;
            if (x < node.val) {
                node.left = insert(node.left, x);
                if (node.left.seed > node.seed) {
                    node = node.rightRotate();
                }
            } else if (x > node.val) {
                node.right = insert(node.right, x);
                if (node.right.seed > node.seed) {
                    node = node.leftRotate();
                }
            } else {
                node.count++;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2147483647, 0, -2147483647, 2147483647};
        Solution327 solution = new Solution327();
        System.out.println(solution.countRangeSum(nums, -564, 3864));
        System.out.println(solution.countRangeSum2(nums, -564, 3864));
        System.out.println(solution.countRangeSum3(nums, -564, 3864));
        System.out.println(solution.countRangeSum4(nums, -564, 3864));
        System.out.println(solution.countRangeSum5(nums, -564, 3864));
        System.out.println(solution.countRangeSum6(nums, -564, 3864));
    }
}
