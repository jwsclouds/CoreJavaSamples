import java.util.Scanner;

public class VarTypeInferenceExample {

    int sum() {
        var a = 10;
        var b = 11;
        return a + b;
    }

    int sum(int in1, int in2) {
        var a = in1;
        var b = in2;
        return a + b;
    }

    float sum(int in1, float in2) {
        var a = in1;
        var b = in2;
        return a + b;
    }

    void main(String[] args) {
        System.out.println("Sum of two initalized var numbers = " + sum());
        System.out.println("Enter 1st number for addition");
        Scanner in1 = new Scanner(System.in);
        var a = in1.nextInt();
        System.out.println("Enter 2nd number for addition");
        Scanner in2 = new Scanner(System.in);
        var b = in2.nextInt();
        var result = sum(a, b);
        System.out.println("Sum of two numbers of same type initialized at runtime = " + result);


        System.out.println("Enter 1st int number for addition");
        Scanner in_1 = new Scanner(System.in);
        var a_1 = in_1.nextInt();
        System.out.println("Enter 2nd float number for addition");
        Scanner fl_2 = new Scanner(System.in);
        var b_1 = fl_2.nextFloat();
        var result_2 = sum(a_1, b_1);
        System.out.println("Sum of int & float numbers initialized at runtime and return with upcast = " + result_2);
    }

}