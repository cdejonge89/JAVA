/**
reference:
http://btv.melezinek.cz/binary-search-tree.html
 * Class to represent a Node in a Binary Search Tree (BST).
 * The properties in the constructor are how this node is 
 * connected to other nodes to form the tree. 
 * Similar to .next in a SinglyLinkedList except a BST node can
 * be connected to two other nodes. To start, new nodes are not
 * connected to any other nodes, these properties will be set 
 * after the new node is instantiated.
 */
class BSTNode {
  // TreeNode , node
  constructor(data) {
    this.data = data;
    this.left = null; // a BSTNode with a smaller value
    this.right = null;
  }
}

/**
 * Represents an ordered tree of nodes where
 * the data of left nodes are <= to their parent and
 * the data of right nodes are > their parent's data.
 */
class BinarySearchTree {
  constructor() {
    this.root = null;
  }

  /**
   * Inserts a new node with the given newVal in the right place to preserver
   * the order of this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {number} newVal The data to be added to a new node.
   * @returns {BinarySearchTree} This tree.
   */
    insert(newVal) {
        // check if its empty
        let current = this.root;
        var newNode = new BSTNode(newVal);
        if (!current) {
            this.root = newNode;
        }
        
        while (current) {
            if (newVal < current.data) {
                if(!current.left) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if(newVal >= current.data) {
                if(!current.right) {
                    current.right = newNode;
                    return;
                }
                current = current.right
            }
        }
        return;
    }

  /**
   * Inserts a new node with the given newVal in the right place to preserver
   * the order of this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {number} newVal The data to be added to a new node.
   * @param {Node} curr The node that is currently accessed from the tree as
   *    the tree is being traversed.
   * @returns {BinarySearchTree} This tree.
   */
  insertRecursive(newVal, curr = this.root) {
    if(!curr) {
        this.root = new BSTNode(newVal)
        return this
    }
    if(newVal < curr.data) {
        if(curr.left == null) {
            curr.left = new BSTNode(newVal)
            return this
        }
        return this.insertRecursive(newVal, curr.left)
    } else {
        if(curr.right == null) {
            curr.right = new BSTNode(newVal)
            return this
        }
        return this.insertRecursive(newVal, curr.right)
    }
  }

  // HELPER METHOD
  // Logs this tree horizontally with the root on the left.
  print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
    if (!node) {
      return;
    }

    spaceCnt += spaceIncr;
    this.print(node.right, spaceCnt);

    console.log(
      " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
        `${node.data}`
    );

    this.print(node.left, spaceCnt);
  }
}

const emptyTree = new BinarySearchTree();
const oneNodeTree = new BinarySearchTree();
oneNodeTree.root = new BSTNode(10);
// oneNodeTree.print()

/* twoLevelTree
          root
          10
        /   \
      5     15
  */
const twoLevelTree = new BinarySearchTree();
twoLevelTree.root = new BSTNode(10);
twoLevelTree.root.left = new BSTNode(5);
twoLevelTree.root.right = new BSTNode(15);
// twoLevelTree.print()

/* threeLevelTree 
          root
          10
        /   \
      5     15
    / \    / \
  2   8  13  20
  */
const threeLevelTree = new BinarySearchTree();
const threeLevelTree2 = new BinarySearchTree();

threeLevelTree.insert(10);
threeLevelTree.insert(5);
threeLevelTree.insert(2);
threeLevelTree.insert(8);
threeLevelTree.insert(15);
threeLevelTree.insert(20);
threeLevelTree.insert(13);
threeLevelTree.print();

threeLevelTree2.insertRecursive(10).insertRecursive(5).insertRecursive(15)
.insertRecursive(2).insertRecursive(8).insertRecursive(20).insertRecursive(13)
threeLevelTree2.print();
