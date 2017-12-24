package org.glamey.springboottrain.algorithm;

/**
 * 两个递增数据合并为一个递增数组
 *
 * @author zhouyang.zhou.
 * @date 2017.12.19.14.
 */
public class ArrayMerge {
  public static void main(String[] args) {
    int[] a = new int[] {2, 5, 6, 10, 12, 16};
    int[] b = new int[] {1, 3, 5, 7, 11};

    int[] res = merge1(a, b);
    for (int re : res) {
      System.out.println(re);
    }
    System.out.println("------>");

    res = merge2(a, b);
    for (int re : res) {
      System.out.println(re);
    }
  }

  private static int[] merge1(int[] a, int[] b) {
    if(a == null) {
      return b;
    }

    if(b == null) {
      return a;
    }

    int aLen = a.length;
    int bLen = b.length;
    int rLen = aLen + bLen;
    int[] r = new int[rLen];
    System.arraycopy(a, 0, r, 0, aLen);
    System.arraycopy(b, 0, r, aLen, bLen);

    for (int i = 0; i < rLen; i++) {
      int minIndex = i;
      for (int j = i + 1; j < rLen; j++) {
        if(r[minIndex] > r[j]) {
          minIndex = j;
        }
      }
      swap(r, i, minIndex);
    }
    return r;
  }

  private static void swap(int[] r, int i, int j) {
    int tmp = r[i];
    r[i] = r[j];
    r[j] = tmp;
  }

  private static int[] merge2(int[] a, int[] b) {
    if(a == null) {
      return b;
    }

    if(b == null) {
      return a;
    }

    int aLen = a.length;
    int bLen = b.length;
    int rLen = aLen + bLen;
    int[] r = new int[rLen];
    int aIndex = 0, bIndex = 0, rIndex = 0;
    while (rIndex < rLen) {
      if(aIndex < aLen && bIndex < bLen) {
        if(a[aIndex] <= b[bIndex]) {
          r[rIndex] = a[aIndex];
          aIndex++;
        } else {
          r[rIndex] = b[bIndex];
          bIndex++;
        }
      } else if(aIndex == aLen) {
        r[rIndex] = b[bIndex];
        bIndex++;
      } else if(bIndex == bLen) {
        r[rIndex] = a[aIndex];
        aIndex++;
      } else {
        System.out.println("..");
      }
      rIndex++;
    }

    return r;
  }
}
