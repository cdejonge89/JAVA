public class Loops {
    public static void main(String[] args) {
        // for loop
        for(int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        for(int i = 0; i < 5; i+=2) {
            System.out.println(i);
        }

        //while loop
        int count = 0;
        while(count<5) {
            System.out.print(count);
            count++;
        }

        int i = 0;
        while(i < 7) {
            System.out.println("foo");
            i++;
        }

        // enhanced for loop
        String[] fruits = {"banana", "orange", "apple", "kiwi"};
        for(String s : fruits) {
            System.out.println(s);
        }

        
    }
}