package org.glamey.springboottrain.algorithm;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.19.18.
 */
public class TreeNode<T> {
  T t;
  TreeNode<T> left;
  TreeNode<T> right;

  public TreeNode(T t) {
    this.t = t;
    this.left = null;
    this.right = null;
  }

  public T getT() {
    return t;
  }

  public void setT(T t) {
    this.t = t;
  }

  public TreeNode<T> getLeft() {
    return left;
  }

  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  public TreeNode<T> getRight() {
    return right;
  }

  public void setRight(TreeNode<T> right) {
    this.right = right;
  }
}
