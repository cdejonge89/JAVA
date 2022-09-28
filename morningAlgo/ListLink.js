class ListNode {
    value;
    next;

    // define constructor - taking 2 arguments, 2nd argument is optional
    // default the value to zero
    constructor(value = 0, next = null) {
        this.value = value;
        this.next = next;
    }
}

// creating instances of ListNode
const node4 = new ListNode(16, null);
const node3 = new ListNode(0, node4);
const node2 = new ListNode(-5, node3);
const node1 = new ListNode(4, node2);

// checking
console.log("node1 value:", node1.value)
console.log("next node value", node1.next.value)

const SLLwith4Elements = node1;
const SLLwith3Elements = node2;
const SLLwith2Elements = node3;
const SLLwith1Elements = node4;
const SLLwith0Elements = null;


