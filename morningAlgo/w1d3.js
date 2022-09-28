
class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

// SLL(Singly Linked List)
// keeps track of the start (head) of the list and to store all the
// functionality (methods) that each list should have.
class SLL {
    constructor() {
        this.head = null;
    }
    // checks if list is empty
    isEmpty() {
        if (this.head === null) {
            return true
        } else {
            return false
        }
    }

    // inserts at the back
    insertAtBack(data) {
        // create a new node with the given balue
        var newNode = new ListNode(data);
        if (this.head) {
        var runner = this.head;
        while (runner.next) {
            runner = runner.next;
        }
        runner.next = newNode;
        } else {
        this.head = newNode;
        }
    }

    // insert at front
    // create a new node with the given data and insers that node to the front
    insertAtFront(data) {
        // instantiate the ListNode with data
        var node = new ListNode(data);
        // // pointer of the newNode to the original head
        node.next = this.head
        // // reassign the head
        this.head = node
        // edge case: how do we handle an empty list

        // this method does the same thing
        // checks to see if head is empty
        // var node = new ListNode(data)
        // if(this.head) {
        //     node.next = this.head;
        // }
        //     this.head = node;
        //     return this.head;
    }

    // removed the first node of the list
    removeHead() {
        // reassign the head
        this.head = this.head.next;
    }

    // the method used to print (console.log)
    printList() {
        if (!this.head) {
        console.log("Empty list");
        return;
        }
        var runner = this.head;
        while (runner) {
        // while(runner != null)
        console.log(runner.data);
        runner = runner.next;
        }
    }
}

var emptyList = new SLL(); // EMPTY LIST
emptyList.printList();

var list1 = new SLL();
list1.insertAtBack(5);
list1.insertAtBack(6);
list1.insertAtBack(7);
list1.insertAtFront(10);
list1.insertAtFront(9);
list1.removeHead();


list1.printList();
