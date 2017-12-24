package org.glamey.springboottrain.algorithm;

import java.util.LinkedList;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.21.08.
 */
public class LoopTreeNode {

  public static void main(String[] args) {

    TreeNode<Integer> root = generate();
    System.out.println("--广度遍历--");
    loopTreeByWidth(root);

    System.out.println("--先续遍历--");
    loopByPreOrder(root);

    System.out.println("--中续遍历--");
    loopByInOrder(root);

    System.out.println("--后续遍历--");
    loopByPostOrder(root);
  }

  /**
   * 广度遍历二叉树
   *
   * @param root
   */
  private static void loopTreeByWidth(TreeNode<Integer> root) {
    if(root == null) {
      return;
    }

    LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
    stack.offer(root);

    while (!stack.isEmpty()) {
      int size = stack.size();
      for (int i = 0; i < size; i++) {
        TreeNode<Integer> node = stack.poll();
        System.out.print(node.t + " ");

        if(node.left != null) {
          stack.offer(node.left);
        }

        if(node.right != null) {
          stack.offer(node.right);
        }
      }
      System.out.println();
    }
  }

  public static void loopByPreOrder(TreeNode<Integer> node) {
    if(node == null) {
      return;
    }
    System.out.println(node.t);
    loopByPreOrder(node.left);
    loopByPreOrder(node.right);
  }

  public static void loopByInOrder(TreeNode<Integer> node) {
    if(node == null) {
      return;
    }

    loopByInOrder(node.left);
    System.out.println(node.t);
    loopByInOrder(node.right);
  }

  public static void loopByPostOrder(TreeNode<Integer> node) {
    if(node == null) {
      return;
    }

    loopByInOrder(node.left);
    loopByInOrder(node.right);
    System.out.println(node.t);
  }

  private static TreeNode<Integer> generate() {
    /**
     *      4
     *    3   8
     *  2  5 6    7
     * 1
     */

    TreeNode<Integer> root = new TreeNode<>(4);
    TreeNode<Integer> node1 = new TreeNode<>(1);
    TreeNode<Integer> node2 = new TreeNode<>(2);
    TreeNode<Integer> node5 = new TreeNode<>(5);
    TreeNode<Integer> node6 = new TreeNode<>(6);
    TreeNode<Integer> node7 = new TreeNode<>(7);
    TreeNode<Integer> node3 = new TreeNode<>(3);
    TreeNode<Integer> node8 = new TreeNode<>(8);

    node2.left = node1;
    node3.left = node2;
    node3.right = node5;
    node8.left = node6;
    node8.right = node7;
    root.left = node3;
    root.right = node8;

    return root;
  }
}
