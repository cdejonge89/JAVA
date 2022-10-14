/* 
TODO: Create the DLLNode class and implement the DoublyLinkedList constructor
and the empty methods below the constructor.
*/

/**
 * A class to represent a doubly linked list and contain all of it's methods.
 * A doubly linked list is a singly linked list that can be traversed in both
 * directions.
 */
class DoublyLinkedList {
    /**
     * Executed when the new keyword is used to construct a new DoublyLInkedList
     * instance that inherits these methods and properties.
     */

    constructor(data) {
      // TODO: implement the constructor.
        this.data = data;
        this.previous = null;
        this.next = null
    }

    
  
    /**
     * Creates a new node and adds it at the front of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} data The data for the new node.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtFront(data) {
        // create the node and put in the data
        let newNode = new DoublyLinkedList(data)
        // make the next of the new node as node and prev as null
        newNode.next = this.head;
        newNode.prev = null;
        // change the prev to the new node
        if( this.head!=null) {
            this.head.prev = newNode;
        }
        // move the head to point to the new node
        this.head = newNode;
    }
  
    /**
     * Creates a new node and adds it at the back of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} data The data for the new node.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBack(data) {
        var newNode = new DoublyLinkedList(data)
        var last = this.head
        newNode.next = null;
        if(this.head == null) {
            newNode.prev = null;
            this.head = newNode;
            return this
        }
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }
  
    // EXTRA
    /**
     * Removes the middle node in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {any} The data of the removed node.
     */
    removeMiddleNode() {
        // when there is only 1 node, it is the middle, remove it.
        if (!this.isEmpty() && this.head === this.tail) {
        const removedData = this.head.data;
        this.head = null;
        this.tail = null;
        return removedData;
    }
  
    /**
     * Determines if this list is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean} Indicates if this list is empty.
     */
    isEmpty() {
        return this.head === null;
    }
  
    /**
     * Converts this list to an array of the node's data.
     * - Time: O(n) linear, n = list length.
     * - Space: O(n) linear, array grows as list length increases.
     * @returns {Array<any>} All the data of the nodes.
     */
    toArray() {
        const vals = [];
        let runner = this.head;
    
        while (runner) {
            vals.push(runner.data);
            runner = runner.next;
        }
        return vals;
    }
  
    /**
     * Adds all the given items to the back of this list.
     * @param {Array<any>} items Items to be added to the back of this list.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBackMany(items = []) {
        items.forEach((item) => this.insertAtBack(item));
        return this;
    }
}
  
const emptyList = new DoublyLinkedList();
emptyList.insertAtFront(5);
emptyList.insertAtFront(2);
emptyList.insertAtBack(10);
emptyList.insertAtBack(25);
console.log(emptyList.toArray());