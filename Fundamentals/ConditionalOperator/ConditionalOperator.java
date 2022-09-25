// conditionals
// public class ConditionalOperator {
//     public static void main(String[] args) {
//         boolean isRaining = true;

//         if(isRaining) {
//             System.out.println("Bring a rain coat");
//         }
//     }
// }

// else
// public class ConditionalOperator {
//     public static void main(String[] args) {
//         boolean isRaining = false;

//         if(isRaining) {
//             System.out.println("Bring a rain coat");
//         } else  {
//             System.out.println("All clear");
//         }
//     }
// }

// else if
// public class ConditionalOperator {
//     public static void main(String[] args) {
//         boolean isRaining = true;
//         boolean isCold = false;

//         if(isRaining) {
//             System.out.println("Bring a rain coat");
//         } else if(isCold) {
//             System.out.println("Wear a coat");
//         } else {
//             System.out.println("All clear");
//         }
//     }
// }

// public class ConditionalOperator {
//     public static void main(String[] args) {    

//         int temperature = 85;
//         boolean isCloudy = true;

//         if(temperature < 40 && isCloudy){
//             System.out.println("It might snow.");
//         }else if(isCloudy){
//             System.out.println("It might rain.");
//         }else{
//             System.out.println("We should have nice weather today.");
//         }

//     }
// }

// ternary
// public class ConditionalOperator {
//     public static void main(String[] args) { 
//         boolean isRaining = true;
        
//         if(isRaining) {
//             System.out.println("Bring an umbrella.");
//         }
//         else {
//             System.out.println("Have fun!");
//         }
//     }
// }

// System.out.println(isRaining ? "Bring an umbrealla" : "Have fun!");

// Switch
public class ConditionalOperator {
    public static void main(String[] args) {
        int day = 2;
switch(day){
	case 1:
		System.out.println("Monday");
		break;
	case 2:
		System.out.println("Tuesday");
		break;
	case 3:
		System.out.println("Wednesday");
		break;
	case 4:
		System.out.println("Thursday");
		break;
	case 5:
		System.out.println("Friday");
		break;
	case 6:
		System.out.println("Saturday");
		break;
	case 7:
		System.out.println("Sunday");
		break;
	default:
		System.out.println("There are only seven days in a week...");
}

    }
}