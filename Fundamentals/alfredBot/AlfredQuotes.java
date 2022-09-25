import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        // example - no coding here
        return "Hello, lovely to see you. How are you?";
    }
    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s. Lovely to see you", dayPeriod, name);
    }
    public String dateAnnouncement() {
        return String.format("it is currently %s", new Date());
    }
    public String respondBeforeAlexis(String phrase) {
        if(phrase.indexOf("Alexis") > -1) {
            return "she's really of no help. what can i get for you?";
        }
        if(phrase.indexOf("Alfred") > -1) {
            return "At your service, naturally. how may i be of assistance?";
        }
        return "right. and with that i shall retire";
    }
}