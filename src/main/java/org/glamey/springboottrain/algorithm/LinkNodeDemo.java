package org.glamey.springboottrain.algorithm;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.19.21.
 */
public class LinkNodeDemo {

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    LinkNodeDemo demo = new LinkNodeDemo();
    Node node = demo.createNodes(new int[] {1, 2, 3, 4, 5});
    System.out.println("--------[构建单向链表]---------");
    demo.printNode(node);

    System.out.println("--------[翻转单向链表]---------");
    Node revertNode = demo.revertNode(node);
    demo.printNode(revertNode);
  }

  public Node createNodes(int[] nums) {
    int len = nums.length;
    if(len == 1) {
      return new Node(nums[0]);
    }

    Node head = new Node(nums[0]);
    Node pNode = head, tmpNode;
    for (int i = 1; i < len; i++) {
      tmpNode = new Node(nums[i]);
      pNode.next = tmpNode;
      pNode = tmpNode; //重置上一个节点为当前节点，为了下次遍历使用
    }

    return head;
  }

  public Node revertNode(Node node) {
    if(node == null) {
      return node;
    }

    Node pNode = node, curNode = node.next, tmpNode;
    while (curNode != null) {
      tmpNode = curNode.next;
      curNode.next = pNode;
      pNode = curNode;
      curNode = tmpNode;
    }
    node.next = null;
    return pNode;
  }

  public void printNode(Node node) {
    if(node == null) {
      return;
    }

    Node tmpNode = node;
    while (tmpNode != null) {
      System.out.println(tmpNode.data);
      tmpNode = tmpNode.next;
    }
  }
}


