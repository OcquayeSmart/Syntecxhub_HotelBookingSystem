import java.util.Scanner;

public class InputValidation {
    private final Scanner scanner;
    InputValidation(Scanner scanner){
        this.scanner = scanner;
    }
    public int checkInt(){
        while(true){
            try{
                return Integer.parseInt(scanner.nextLine().trim());
            }
            catch(NumberFormatException e){
                System.out.print("Invalid Input, please try again: ");
            }
        }
    }
    public int checkRange(int min, int max){
        while(true){
            int value = checkInt();
            if(value >= min && value <= max){
                return value;
            }
            else{
                System.out.println("Invalid input");
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }
    public String checkString(){
        while(true){
            String userInput = scanner.nextLine().trim();

            if(userInput.isEmpty()){
                System.out.println("Your input cannot be empty. Please try again. ");
                continue;
            }
            //using regex here
            if(!userInput.matches(".*[a-zA-Z]+.*")){
                System.out.println("Please enter the right string, not numbers etc.");
                System.out.println("Please try again");
            }
            else{
                return userInput;
            }
        }
    }
}
