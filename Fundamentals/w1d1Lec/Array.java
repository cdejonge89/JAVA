class Array {
    public static void main(String[] args) {
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
    }
}