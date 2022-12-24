import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a quadratic equation in the following format : ax^2+bx+c=0 ");
        String equation = scanner.nextLine();
        String[] array = new String[3];
        if (isQuadratic(array, equation)) {

            int a = findA(array[0]);
            int b = findB(array[1]);
            int c = findC(array[2]);
            solution(a, b, c);
        }
    }

    public static boolean isQuadratic(String[] partOfEquation, String equation) {
        boolean check = false;
        if (!equation.contains("x^2")) {
            System.out.println("error");
        } else if (!equation.contains("x")) {
            System.out.println("error");
        } else if (equation.contains("=0")) {
            System.out.println("error");

        } else {
            String[] quadByChar = equation.split("x" + Pattern.quote("^") + "2");
            String[] quadByChar2 = quadByChar[1].split("x");
            String A = quadByChar[0];
            String B = quadByChar2[0];
            String C = quadByChar2[1];
            String zero = "=0";
            if (C.contains(zero)) {
                check = true;
            }
            partOfEquation[0] = A;
            partOfEquation[1] = B;
            partOfEquation[2] = C;
            System.out.println(A + " " + B + " " + C);
        }
        return check;


    }

    public static int findA(String A) {
        int valueA = Integer.parseInt(A);
        System.out.println(valueA);
        return valueA;

    }

    public static int findB(String B) {
        int valueB = Integer.parseInt(B);
        System.out.println(valueB);
        return valueB;
    }

    public static int findC(String C) {
        String[] array = C.split("=0");
        int valueC = Integer.parseInt(array[0]);
        System.out.println(valueC);
        return valueC;
    }

    public static void solution(int A, int B, int C) {
        double X1;
        double X2;
        if (B * B - 4 * A * C < 0) {
            System.out.println("Error");
        } else {
            X1 = (-B + Math.sqrt(B * B - 4 * A * C)) / (2 * A);
            X2 = (-B - Math.sqrt(B * B - 4 * A * C)) / (2 * A);
            if (X1 == X2) {
                System.out.println("one solution X= " + X1);
            } else
                System.out.println("X1= " + X1 + "X2= " + X2);

        }
    }
}