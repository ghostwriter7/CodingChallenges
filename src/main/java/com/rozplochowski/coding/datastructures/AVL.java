package com.rozplochowski.coding.datastructures;

/**
 * AVL tree recognises a balance factor of -1, 0, or 1.
 * At any given node, the balance factor is the height of the right subtree minus the height of the left subtree.
 * Anytime the balance factor is not -1, 0, or 1, the tree is unbalanced and must be rotated.
 * <p>
 * RR-Rotation - Right-leaning subtree.
 * The solution is to rotate the tree to the left (drop 42 to the left, 50 becomes the root).
 * <pre>
 *    [42]             [50]
 *      \              /  \
 *       [50]       [42]  [55]
 *         \
 *         [55]
 * </pre>
 * LL-Rotation - Left-leaning subtree.
 * The solution is to rotate the tree to the right (drop 55 to the right, 50 becomes the root).
 * <pre>
 *         [55]      [50]
 *          /         /\
 *       [50]     [42] [55]
 *        /
 *      [42]
 * </pre>
 * <p>
 * LR-Rotation - Left-leaning subtree, right-leaning subtree.
 * The solution is to perform two rotations.
 * <pre>
 *      [42]       [42]    [40]
 *       /          /       /\
 *     [39]       [40]  [39] [42]
 *       \        /
 *      [40]    [39]
 * </pre>
 * <p>
 * RL-Rotation - Right-leaning subtree, left-leaning subtree.
 * The solution is to perform two rotations.
 * <pre>
 *     [39]       [39]     [40]
 *       \          \       /\
 *      [42]       [40]  [39] [42]
 *       /           \
 *     [40]         [42]
 * </pre>
 */
public class AVL {
}
