package com.sort;

import java.util.Arrays;

/**
 * @author simple
 * <p>
 * 堆排序的前提是 这个堆是完全二叉树
 * 完全二叉树概念 :
 * 若设二叉树的深度为k，除第 k 层外，其它各层 (1～k-1) 的结点数都达到最大个数，第k 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * <p>
 * 如果i=1, 则结点i是二叉树的根, 无双亲;如果i>1, 则其双亲parent (i) 是结点[i/2].
 * 如果2i>n, 则结点i无左孩子, 否则其左孩子lchild (i) 是结点2i;
 * 如果2i+1>n, 则结点i无右孩子, 否则其右孩子rchild (i) 是结点2i+1.
 */
public class Heap {
    // 将三个元素组成的堆进行大根堆排序
    private void heapify(int[] tree, int len, int i) {
        if (i >= len) return;
        // 数组下标从零开始，所以要多加一
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 < len && tree[c1] > tree[max]) max = c1;
        if (c2 < len && tree[c2] > tree[max]) max = c2;
        if (max != i) {
            swap(tree, i, max);
            heapify(tree, len, max); //  递归 -> 对当前最大值的子节点再做堆化 (对子节点进行大根堆排序)
        }
    }

    // 从最后一个非叶子节点开始，从后往前依次做堆化即可实现大根堆
    public void buildBigRootHeap(int[] tree, int len) {
        int lastNode = len - 1;
        int lastParent = (lastNode - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapify(tree, len, i);
        }
        System.out.println("big root tree(heap) : " + Arrays.toString(tree));
    }

    // 小根堆
    public void heapSort(int[] tree, int len) {
        // 构建大根堆
        buildBigRootHeap(tree, len);
        for (int i = len - 1; i >= 0; i--) {
            // 将最小的元素和最大的元素互换位置
            swap(tree, 0, i);
            // 重新堆化 -> 将最大的元素放在堆顶点
            heapify(tree, i, 0);
        }
    }

    private void swap(int[] tree, int c1, int i) {
        int temp = tree[c1];
        tree[c1] = tree[i];
        tree[i] = temp;
    }

    public static void main(String[] args) {
        //        4
        //     /    \
        //    10     3
        //   /  \   /
        //  5   12 2
        int[] tree = {4, 10, 3, 5, 12, 2};
        new Heap().heapSort(tree, 6);

        System.out.println("small root tree(heap) : " + Arrays.toString(tree));
    }
}
