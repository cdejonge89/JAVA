// importing teh Date class
import java.util.Date;
class Greetings {

        public String getCurrentDate() {
            Date date = new Date();
            return "current date is: " + date;
        }
        public String greetEnglish(String name) {
            return "hello, " + name;
        }
        public String greetSpanish(String name) {
            return "hola, " + name;
        }
}