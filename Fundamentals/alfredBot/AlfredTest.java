public class AlfredTest {
    public static void main(String[] args) {
        // make an instance of AlfredQuotes to access all its methods
        AlfredQuotes alfredBot = new AlfredQuotes();
        // make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Lucy Rios", "morning");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String alexisTest = alfredBot.respondBeforeAlexis(
            "Alexis play some snake jazz"
            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I cant find my yo-yo. Maybe Alfred will know where it is"
            );
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe thats what batman is about. not winning, but failing.."
            );

        // print the greetings to test
        System.out.println(testGreeting);
        // Uncomment these one at a time as you implement each method.
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest.toUpperCase());

    }
}