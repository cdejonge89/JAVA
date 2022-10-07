class BSTNode { // TreeNode , node
        constructor(data) {
        this.data = data;
        this.left = null; // a BSTNode with a smaller value
        this.right = null; 
        }
    }
    class BinarySearchTree {
        constructor() {
            this.root = null;
        }

    size(node = this.root) {
        // check is tree is empty, return 0;
        if(node == null) {
            return 0;
        } else {
            return this.size(node.left) + 1 + this.size(node.right);
        }
    }
    

    
    height(node = this.root) {
        // checking if left and right are null
        if (node.right == null && node.left == null){
            return 1;
        }
        var heightL =0;
        var heightR= 0;
        if(node.left!=null){
            heightL = this.height(node.left);
        }
        if(node.right!=null){
            heightR = this.height(node.right);
        }
        if(heightL > heightR) {
            return heightL+1;
        } else {
            return heightR+1;
        }
    }

    //OR
    height2(node = this.root) {
        if (node === null) {
            return 0;
        }
        if (this.height2(node.left) > this.height2(node.right)) {
            return (this.height2(node.left) + 1)
        }
        else {
            return (this.height2(node.right) + 1)
        }
    }
    

    isFull(node = this.root) {
        
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
        insert(newVal, curr = this.root) {
        let newNode = new BSTNode(newVal);
        if (!curr) {
            this.root = newNode;
            return "node inserted";
        }
        while (curr) {
            if (newVal < curr.data) {
            if (!curr.left) {
                curr.left = newNode
                return;
            }
            curr = curr.left;
            } else if (newVal >= curr.data) {
            if (!curr.right) {
                curr.right = newNode;
                return;
            }
            curr = curr.right
            }
        }
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
    twoLevelTree.print();

    /* threeLevelTree 
            root
            10
            /   \
        5     15
        / \    / \
    2   8  13  20
    */
    const threeLevelTree = new BinarySearchTree();
    threeLevelTree.insert(10)
    threeLevelTree.root = new BSTNode(10);
    threeLevelTree.root.left = new BSTNode(5);
    threeLevelTree.root.left.left = new BSTNode(2);
    threeLevelTree.root.left.right = new BSTNode(8);
    threeLevelTree.root.right = new BSTNode(15);
    threeLevelTree.root.right.right = new BSTNode(20);
    threeLevelTree.root.right.left = new BSTNode(13);
    threeLevelTree.print()

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
    
    
    // const fullTree = new BinarySearchTree();
    // fullTree
    //     .insert(25)
    //     .insert(15)
    //     .insert(10)
    //     .insert(22)
    //     .insert(4)
    //     .insert(12)
    //     .insert(18)
    //     .insert(24)
    //     .insert(50)
    //     .insert(35)
    //     .insert(70)
    //     .insert(31)
    //     .insert(44)
    //     .insert(66)
    //     .insert(90);

    console.log("threeLevelTree size: " + threeLevelTree.size());
    console.log("twoLevelTree size: " + twoLevelTree.size());

    console.log("threeLevelTree height:  " + threeLevelTree.height());
    console.log("twoLevelTree height:  " + twoLevelTree.height());

    console.log("2 - threeLevelTree height:  " + threeLevelTree.height2());
    console.log("2 - twoLevelTree height:  " + twoLevelTree.height2());