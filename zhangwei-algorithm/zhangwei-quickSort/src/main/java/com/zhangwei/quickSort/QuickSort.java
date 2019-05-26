package com.zhangwei.quickSort;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @date 2019-05-23 2:47 PM
 * @since 1.0.0
 **/
public class QuickSort {
    public static void main(String[] args) {
        int array[] = {4, 1, 7, 6, 9, 2, 8, 0, 3, 5};
    }

    //三数取中
    int GetMid(int[] array, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (array[left] <= array[right]) {
            if (array[mid] < array[left])
                return left;
            else if (array[mid] > array[right])
                return right;
            else
                return mid;
        } else {
            if (array[mid] < array[right])
                return right;
            else if (array[mid] > array[left])
                return left;
            else
                return mid;
        }

    }

    void QuickSort(int[] array, int left, int right) {
        assert (array);
        if (left >= right)
            return;

        //当序列较短时，采用直接插入
        if ((right - left) <= 5)
            InsertSort(array, right - left + 1);

        int index = PartSort3(array, left, right);
        QuickSort(array, left, index - 1);
        QuickSort(array, index + 1, right);
    }

    //递归实现
    void QuickSort(int[] array, int left, int right) {
        assert (array);
        if (left >= right)//表示已经完成一个组
        {
            return;
        }
        int index = PartSort(array, left, right);//枢轴的位置
        QuickSort(array, left, index - 1);
        QuickSort(array, index + 1, right);
    }


    //左右指针法
    int PartSort1(int[] array, int left, int right) {
        assert (array);
        int mid = GetMid(array, left, right);
        swap(array[mid], array[right]);

        int&key = array[right];
        while (left < right) {
            while (left < right && array[left] <= key)//因为有可能有相同的值，防止越界，所以加上left < right
                ++left;
            while (left < right && array[right] >= key)
                --right;

            swap(array[left], array[right]);
        }

        swap(array[left], key);
        return left;
    }


    //前后指针法
    int PartSort3(int[] array, int left, int right) {
        assert (array);
        int mid = GetMid(array, left, right);
        swap(array[mid], array[right]);
        if (left < right) {
            int key = array[right];
            int cur = left;
            int pre = left - 1;
            while (cur < right) {
                while (array[cur] < key && ++pre != cur) {
                    swap(array[cur], array[pre]);
                }
                ++cur;
            }
            swap(array[++pre], array[right]);
            return pre;
        }
        return -1;
    }

}
