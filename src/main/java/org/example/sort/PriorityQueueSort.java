package org.example.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先级队列排序
 *
 * @author lichuan
 */
public class PriorityQueueSort {

    public int[] priorityQueueSort(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);

        for (int i : arr) {
            priorityQueue.add(i);
        }

        int index = 0;
        while (!priorityQueue.isEmpty()) {
            arr[index++] = priorityQueue.poll();
        }

        return arr;
    }
}
