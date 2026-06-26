package com.rozplochowski.coding.binarysearchtree;

import com.rozplochowski.coding.TreeNode;

public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;

        var next = root.val > val ? root.left : root.right;

        return searchBST(next, val);
    }
}
