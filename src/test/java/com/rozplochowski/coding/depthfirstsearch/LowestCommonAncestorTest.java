package com.rozplochowski.coding.depthfirstsearch;

import com.rozplochowski.coding.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldFindLowestCommonAncestor(int expected, Integer[] tree, TreeNode p, TreeNode q) {
        assertEquals(expected, LowestCommonAncestor.lowestCommonAncestor(TreeNode.of(tree), p, q).val);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(3, new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, new TreeNode(5), new TreeNode(1)),
                Arguments.of(5, new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, new TreeNode(5), new TreeNode(4)),
                Arguments.of(1, new Integer[]{1,2}, new TreeNode(1), new TreeNode(2)),
                Arguments.of(0, new Integer[]{-1,0,3,-2,4,null,null,8}, new TreeNode(8), new TreeNode(4)),
                Arguments.of(37, new Integer[]{37,-34,-48,null,-100,-101,48,null,null,null,null,-54,null,-71,-22,null,null,null,8}, new TreeNode(-34), new TreeNode(-54))
        );
    }

}