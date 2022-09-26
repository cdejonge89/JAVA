// class name must be the same as file name
class JavaBasic{
    public static void main(String[] args) {
        // 1. compile java (javac JavaBasic.java)
        // run the file (java JavaBasic)
        System.out.println("Hello Java");

        // 2. variables (int, double, boolean, char, String)
        String projectTitle = "Cafe Java"; // String must be ""
        String language = "Java";
        int totalFiles = 1;
        boolean isDone = false;
        double requiredTime = 0.5;
        char difficulty = 'B'; // char must be ''

        // primitave type: int, double, boolean, char
        // Object type: String, Integer, Double, Boolean
        // wrapper class: integer, Double, Boolean - can use built in methods

        // System.out.println("Title " + projectTitle);
        // System.out.println("Language " + language);
        // System.out.println("totalFiles " + totalFiles);
        // System.out.println("isDone " + isDone);
        // System.out.println("requiredTime " + requiredTime);
        // System.out.println("difficulty " + difficulty);
        // System.out.println("Max integer " + Integer.MAX_VALUE);

        // 3. conditionals & ternary
        // can only be run on true/false statements
        if(isDone) {
            System.out.println("this project is completed");
        } else {
            System.out.println("this project is NOT completed");
        }

        if(totalFiles > 0) {
            System.out.println("total file is good");
        }

        if(requiredTime < 1) {
            System.out.println("this assignment shouldn't take too long to complete");
        } else {
            System.out.println("it may take some time to finish this assignment");
        }

        // ternary
        System.out.println(requiredTime < 1? "this assignment shouldn't take too long to complete" :
        "it may take some time to finish this assignment");
        
        // strings - built in functions - length, concatenate, format
        //length
        System.out.println("Project title length: " + projectTitle.length());
        //concat
        String projectDetails = projectTitle.concat("----").concat(language);
        System.out.println("Project Details: " + projectDetails);
        //format
        String projectDetails2 = String.format("Project Title: %s | Estimated Time: %.2f hours", projectTitle, requiredTime);
        System.out.println("Project Details: " + projectDetails2);

        // .equals
        String creator1 = "Lee";
        String creator2 = "Lee";
        System.out.println(creator1 == creator2);
        System.out.println(creator1.equals(creator2));
    }
}