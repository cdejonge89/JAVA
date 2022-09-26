class VoiceMessageTest {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // 6. dependeny injection (import other files)
        VoiceMessageUtil answeringMachine = new VoiceMessageUtil();
        System.out.println(answeringMachine.greeting());
        System.out.println(answeringMachine.greeting("Pepper"));
        System.out.println(answeringMachine.greeting(5));
        System.out.println(answeringMachine.greetWithDate());
    }
}