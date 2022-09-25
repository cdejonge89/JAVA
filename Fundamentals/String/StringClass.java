public class StringClass {
    public static void main(String[] args) {
        // length
        String ninja = "coding dojo is dope";
        int length = ninja.length();
        System.out.println("string length is : " + length);

        // concatenate
        String string1 = "my name is ";   
        String string2 = "Lee";   
        String string3 = string1.concat(string2);   
        System.out.println(string3);   

        // format
        String ninja2 = String.format("Hi %s, you owe me $%.2f !", "Keanu", 25.0);
        System.out.println(ninja2);

        // indexOf
        String ninja3 = "welcome to the danger zone";
        int a = ninja3.indexOf("danger");
        int b = ninja3.indexOf("zo");
        int c = ninja3.indexOf("pizza");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        // trim
        String sentence = "   spaces everywhere   ";
        System.out.println(sentence.trim());

        // upper and lower case
        String d = "HELLO";
        String e = "world";
        System.out.println(d.toLowerCase()); // hello
        System.out.println(e.toUpperCase()); // WORLD

        // equality
        // Normal string assignment
    String f = "same string";
    String g = "same string";
    System.out.println(f == g); // true
    // Creating new strings as separate objects (another way to create a String)
    f = new String("same letters");
    g = new String("same letters");
    System.out.println(f == g); // false. Not the same object in memory.
    System.out.println(f.equals(g)); // true. same exact characters.
    }
}