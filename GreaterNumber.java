import java.util.*;

public class GreaterNumber {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("enter 2 number");
      int number1 = sc.nextInt();
      int number2 = sc.nextInt();
      System.out.println("greater number is " + greater(number1, number2));
   }

   public static int greater(int num1, int num2) {
      if (num1 > num2) {
         return num1;
      } else {
         return num2;
      }
   }
}
