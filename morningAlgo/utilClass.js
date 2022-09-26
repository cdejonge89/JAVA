class UtilClass {
    totalCount(numArr) {
        // Given an array of numbers,  return the sum of the array
        let count = 0;
        for(let i = 0; i < numArr.length; i ++) {
            count += numArr[i]
        }
        return count
    }

    printMessages(msgArr) {
        // Given an array of String, write a function to print messages
        // for(let i = 0; i < msgArr.length; i ++) {
        //     console.log(msgArr[i]);
        // for of loop is the same shorthand version of a for loop
        for(const msg of msgArr) {
            console.log(msg)
        }
        //}
        return msgArr
    }
}

console.log("Hello World");

var messagesPerDay = [5, 8, 6];
var messages = [
    "Please call back!",
    "Make sure you install jdk",
    "Help debug please!",
];

var newBot = new UtilClass();

console.log(newBot.totalCount(messagesPerDay));
newBot.printMessages(messages);
