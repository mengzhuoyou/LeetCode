package com.company;

public class Leetcode_255_verifyPreOrderInBST {
    /*
对于一个搜索二叉树的前序序列来说, 如果某段序列为一个递减序列, 说明这是一段沿着左子树的路径.
直到碰到一个比前一个大的值, 说明此时已经来到某个结点的右子树上了, 而此时可以得出一个此后序列的下界值,
也就是此后序列的任意一个值必须要比这个结点的父结点的值大, 因为对于搜索二叉树来说根节点左边的都比根节点小,
而根节点右边的都比根节点大, 所以既然现在已经来到某个结点(设为A)的右子树上, 那么此后任何结点的值必然比A的值大.

那么当我们碰到一个比之前结点大的值如何找到他的父结点呢? 可以借助一个栈,
即如果当前结点比栈顶元素小, 就入栈, 如果当前值大于栈顶值, 则让所有比当前结点小的值都出栈,
直到栈顶元素比当前结点大, 则最后一个出栈的比当前结点小的值就是当前结点的父结点,
我们只要在栈元素出栈的时候更新最小下界再将当前元素入栈即可. 另外这样的时间和空间复杂度都是O(n),
但是对于空间复杂度来说, 很容易复用原数组模拟栈来优化.
*/
/*
method 1 :

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();

        int low = Integer.MIN_VALUE; // the current minimum threshold

        for(int p : preorder) {
            if(p < low) {
                return false;
            }
            while(!stack.isEmpty() && p > stack.peek()) {
                low = stack.pop();
            }
            stack.push(p);
        }

        return true;
    }
}
*/

    class Solution {
        public boolean verifyPreorder(int[] preorder) {
            int k = -1, low = Integer.MIN_VALUE;

            for (int p : preorder) {
                if (p < low) {
                    return false;
                }

                while (k >= 0 && p > preorder[k]) {
                    low = preorder[k];
                    k--;
                }

                k++;
                preorder[k] = p;
            }

            return true;
        }
    }
}
