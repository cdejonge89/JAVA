import java.util.Date;
class VoiceMessageUtil {
    // 5. methods (overloading methods)
    // knows what method to call based on arguments that are passed
    public String greeting(){
        return "Hi, anonymous";
    }

    public String greeting(String name) {
        return "Hi, " + name + "!";
    }

    public String greeting(int count) {
        return "Hi for " + count + " times";
    }

    public String greetWithDate(){
        return "Hi, today is " + new Date();
    }

    // loops
    public int totalMessages(int[] numArr) {
        int sum = 0;
        for(int i = 0; i<numArr.length; i++) {
            sum += numArr[i];
        }
        return sum;
    }
}