import java.util.Scanner;
interface CalculatorInterface {
    static double add(double num1, double num2){
        return num1+num2;
    }
    static double subtract(double num1, double num2){
        return num1-num2;
    }
    static double multiply(double num1, double num2){
        return num1*num2;
    }
    static double divide(double num1, double num2){
        return num1/num2;
    }
    static double remainder(double num1, double num2){
        return num1%num2;
    }
}
class CalculatorMain implements CalculatorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double c = 0;
        int operation;
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("1) Addition\t2) Subtraction\t3) Multiply\t4) Divide\t5) Remainder");
        System.out.println("\nEnter a type: ");
        operation=scanner.nextInt();

        switch (operation) {
            case 1:
                c = CalculatorInterface.add(num1,num2);
                break;
            case 2:
                c = CalculatorInterface.subtract(num1,num2);
                break;
            case 3:
                c = CalculatorInterface.multiply(num1,num2);
                break;
            case 4:
                c = CalculatorInterface.divide(num1,num2);
                break;
            case 5:
                c = CalculatorInterface.remainder(num1,num2);
                break;
        }
        System.out.println("RESULT: "+c);

    }
}
