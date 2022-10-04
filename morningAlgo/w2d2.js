/**
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
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    constructor() {
        this.root = null;
    }

    
    //Determines if this tree contains the given searchVal.
    contains(searchVal) {
        if(this.root == null) {
            return false;
        } else {
            let current = this.root
            while(current) {
                if(searchVal == current.data) {
                    return true;
                } else if( searchVal < current.data) {
                    current = current.left;
                } else(searchVal >= current.data) 
                    current = current.right;
            }
            return false;
        }
    }

    
    // Determines if this tree contains the given searchVal.
    containsRecursive(searchVal, current = this.root) {
        if (!current){
            return false
        }
        if(searchVal == current.data){
            return true;
        }
        if(searchVal < current.data){
            return this.containsRecursive(searchVal, current.left)
        }
        if(searchVal > current.data){
            return this.containsRecursive(searchVal, current.right)
        }
    
    }

    
    //Calculates the range (max - min) from the given startNode.
    range(startNode = this.root) {}

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
threeLevelTree.root = new BSTNode(10);
threeLevelTree.root.left = new BSTNode(5);
threeLevelTree.root.left.left = new BSTNode(2);
threeLevelTree.root.left.right = new BSTNode(8);
threeLevelTree.root.right = new BSTNode(15);
threeLevelTree.root.right.right = new BSTNode(20);
threeLevelTree.root.right.left = new BSTNode(13);
threeLevelTree.print();
console.log(threeLevelTree.contains(20)) // true
console.log(threeLevelTree.contains(50)) // false
console.log(threeLevelTree.containsRecursive(50)) // false
console.log(threeLevelTree.containsRecursive(20)) // true
/* fullTree
                        root
                    <-- 25 -->
                    /            \
                15             50
                /    \         /    \
            10     22      35     70
            /   \   /  \    /  \   /  \
        4    12  18  24  31  44 66  90
  */
