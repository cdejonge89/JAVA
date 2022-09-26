class AlfredTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();
        System.out.println(alfredBot.basicGreeting());
        System.out.println(alfredBot.guestGreeting("Lee", "morning"));
        System.out.println(alfredBot.dateAnnouncement());
        System.out.println(alfredBot.respondBeforeAlexis(
            "Alexis, play some snake jazz"));
        System.out.println(alfredBot.respondBeforeAlexis(
            "Apologies, Alfred, play some snake jazz"));
        System.out.println(alfredBot.respondBeforeAlexis(
            "thank you"));
    }
}