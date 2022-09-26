class AlfredTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Lee", "morning");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String alexisTest = alfredBot.respondBeforeAlexis(
            "Alexis, play some snake jazz"
        );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "Apologies Alfred, play some snake jazz"
        );
        String defaultConvo = alfredBot.respondBeforeAlexis(
            "Are you there?"
        );

        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(defaultConvo);
        System.out.println(defaultConvo.toUpperCase());
    }
}