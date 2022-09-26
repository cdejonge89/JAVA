import java.util.ArrayList;

class VoiceMessageTest {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // 6. dependeny injection (import other files)
        VoiceMessageUtil answeringMachine = new VoiceMessageUtil();
        System.out.println(answeringMachine.greeting());
        System.out.println(answeringMachine.greeting("Pepper"));
        System.out.println(answeringMachine.greeting(5));
        System.out.println(answeringMachine.greetWithDate());

        // 8. fixed array
        int[] messagesPerDay = new int[5]; // messagesPerDay = [0,0,0,0,0]
        messagesPerDay[0] = 5;
        messagesPerDay[1] = 3;
        messagesPerDay[2] = 6;
        System.out.println(messagesPerDay);

        String[] messages = {"Please call back", "make sure you install jdk", "help debug please"};

        // 9. Loops
        // traditional loop with i
        for(int i=0; i < messages.length; i++) {
            System.out.println(messages[i]);
        }

        for(String msg: messages) {
            System.out.println(msg);
        }

        System.out.println(answeringMachine.totalMessages(messagesPerDay));

        // 10. dynamic array
        //ArrayList creates a new data type using string type
        ArrayList <String> messagesList = new ArrayList<String>();
        messagesList.add("please ask me any questions");
        messagesList.add("feed the cat");
        messagesList.add("reach out for help when you struggled for more than 20 mins");
        System.out.println(messagesList);
        // messagesList.remove(1);
        // System.out.println(messagesList);
        System.out.println(messagesList.get(0));
        System.out.println(messagesList.size());
    }
}