package org.example.leetcode.Tree;

import org.example.leetcode.linkedList.ListNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的 前中后遍历
 *
 * @author lichuan
 */
public class TreeThreeOrders {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        int[][] result = new int[3][];
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        preOrder(root, preList);
        inOrder(root, inList);
        postOrder(root, postList);

        result[0] = toIntArray(preList);
        result[1] = toIntArray(inList);
        result[2] = toIntArray(postList);

        return result;

    }

    //*******************递归遍历**********************************

//    public void preOrder(TreeNode root, List<Integer> list) {
//        if (null != root) {
//            list.add(root.val);
//            preOrder(root.left, list);
//            preOrder(root.right, list);
//        }
//    }
//
//    public void inOrder(TreeNode root, List<Integer> list) {
//        if (null != root) {
//            inOrder(root.left, list);
//            list.add(root.val);
//            inOrder(root.right, list);
//        }
//    }
//
//    public void postOrder(TreeNode root, List<Integer> list) {
//        if (null != root) {
//            postOrder(root.left, list);
//            postOrder(root.right, list);
//            list.add(root.val);
//
//        }
//    }
    //*******************递归遍历**********************************



    //*******************非递归遍历**********************************


    public void preOrder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || null != curr) {
            //从根遍历左子树
            if (null != curr) {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            //遍历右子树
            else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }


    public void inOrder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || null != curr) {
            //从根遍历左子树
            if (null != curr) {
                stack.push(curr);
                curr = curr.left;
            }
            //遍历右子树
            else {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
    }

    /**
     * 对应前序遍历的反操作
     * 前序遍历从尾部添加元素，后序遍历从头部添加元素
     */
    public void postOrder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || null != curr) {
            //遍历右子树
            if (null != curr) {
                list.add(0, curr.val);
                stack.push(curr);
                curr = curr.right;
            }
            //遍历左子树
            else {
                curr = stack.pop();
                curr = curr.left;
            }
        }
    }

    private static int[] toIntArray(List<Integer> arrayList){
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
