import java.util.Scanner;
public class Hello{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello World");
        System.out.println("What do you want to do?");
        System.out.println("A: Say Hello");
        System.out.println("B: Play codm");
        System.out.println("C: Sleep");

        String answer = scanner.nextLine();

        if(answer.equals("A")){
            System.out.println("Hello World");

        }
        else if(answer.equals("B")){
            System.out.println("Let's paly codm");

        }
        else if(answer.equals("C")){
            System.out.println("Have a good night");

        }
        else{
            System.out.println("The input was invalid");
        }
        scanner.close();
    }
       
}