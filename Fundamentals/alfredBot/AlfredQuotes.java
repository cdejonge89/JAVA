import java.util.Date;

class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s %s", dayPeriod, name);
        
    }

    public String dateAnnouncement() {
        return "Today is " + new Date();
    }

    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") > -1) {
            return "Alexis? Never heard of her";
        } 
        if(conversation.indexOf("Alfred") > -1) {
            return "Alfred's got you boo boo";
        }
        return "Alfred here";
    }
}