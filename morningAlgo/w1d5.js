// class Node
class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

// class SLL - Singly Linked List
class SLL {
    constructor() {
        this.head = null;
    }

    insertAtBack(data) {
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

    //given
    printList() {
        if (!this.head) {
        console.log("Empty list");
        return;
        }
        var runner = this.head;
        while (runner) {
        console.log(runner.data);
        runner = runner.next;
        }
    }

    // retrieves the data of the second to last node in this list
    // returns the data of the second to last node or null
    secondToLast() {
        var runner = this.head; 
        // if the list is empty
        // or contains less than 2 nodes
        if(runner == null || runner.next == null) {
            return null;
        }
        // traverse the linked list
        while(runner != null){
            // check if the current node is the second to last node
            if(runner.next.next == null){
                return runner.data;
            } else {
                // if not, move to the next node
                runner = runner.next;
            }
        }
        return runner.data
    } 


    // removes the node that has the matching given val as its data
    // boolean to indicate if a node was removed 
    removeData(data) {
        //HINT: The list is constructed by connecting nodes with pointers
        // Play with the pointers so that you can remove that node from the list.
        let runner = this.head
        let pointer = runner
        while(runner) {
            if(runner.data == data) {
                pointer.next = runner.next
                return this
            } else {
                pointer = runner
                runner = runner.next
            }
        }
    }
}

var list1 = new SLL();
list1.printList();

var list2 = new SLL();
list2.insertAtBack(5);
list2.insertAtBack(6);
list2.insertAtBack(7);
list2.insertAtBack(8);

console.log("Second to last is: " + list2.secondToLast());
list2.removeData(6);
list2.printList();
