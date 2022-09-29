
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

        var node = new ListNode(data);
        node.next = this.head
        this.head = node


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


// determines whether or not the given search value exists in this list
// return boolean
    contains(data){
        var current = this.head;
        while (current != null) {
            if (current.data == data) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }


// removes the last node of this list
// returns the data from the node that was removed
    removeBack(data) {
        if (this.head == null) {
            return null;
        }
        if (this.head.next == null ) {
            return null;
        }
        // find the second last node
        let secondLast = this.head;
        if(secondLast != null) {
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }
            //change next of second last
            secondLast.next = null;
        }
        return this;
    }
}

var emptyList = new SLL(); // EMPTY LIST

var list2 = new SLL();
list2.insertAtBack(1);
list2.insertAtBack(2);
list2.insertAtBack(3);
list2.insertAtBack(9);

list2.removeBack();
list2.printList();

emptyList.printList();
list2.printList();

console.log(list2.contains(3));
// expected result: true
console.log(list2.contains(1000));
// expected result: false

