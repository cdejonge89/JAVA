/** 
 * A class to represents a single item of a SinglyLinkedList that can be
 * linked to other Node instances to form a list of linked nodes.
 https://kalkicode.com/data-structure/single-linked-list-visualization
 */
class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

    /**
     * SLL(Singly Linked List)
     * keeps track of the start (head) of the list and to store all the
     * functionality (methods) that each list should have.
     */
    class SLL {
    constructor() {
        this.head = null;
    }

    /**
     * Determines if this list is empty.
     * @returns {boolean}
     */
    isEmpty() {
        if(this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates a new node with the given data and inserts it at the back of
     * this list.
     * @param {any} data The data to be added to the new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBack(data) {
        // create a new mnode with the given value
        let nodeNew = new ListNode(data);

        if (this.isEmpty()) {
            this.head = nodeNew
            return this
        } else {
            var runner = this.head
            while(runner.next != null) {
                runner = runner.next
            }
            runner.next = nodeNew
            return this
        }
    }

    /** BONUS:
     * Calls insertAtBack on each item of the given array.
     * - Time: O(n * m) n = list length, m = arr.length.
     * - Space: O(1) constant.
     * @param {Array<any>} vals The data for each new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBackMany(vals) {

    }

    //given
    printList() {
        // if the head is empty -> the list is empty
        if (this.head === null) {
        console.log("Empty list");
        } else {
        var runner = this.head;
        while (runner !== null) {
            console.log(runner.data);
            runner = runner.next;
        }
        }
        return this;
    }
}


var emptyList = new SLL();

var list1 = new SLL();
list1.insertAtBack(3).insertAtBack(6).insertAtBack(7)

console.log(emptyList.isEmpty());
console.log(list1.isEmpty());

list1.printList();
list1.insertAtBack(10).insertAtBack(11).printList();
emptyList.insertAtBack(10).insertAtBack(11).printList();
