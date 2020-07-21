package labs_examples.objects_classes_methods.labs.methods;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MethodTraining {

    public static void main(String[] args) {
        //2
        Box chest = new Box(10, 50, 10);
        System.out.println(chest.toString());
        cutBoxInHalf(chest);
        System.out.println(chest.toString());
        //3
        System.out.println(largest(2, 20, 4, 5));
        //1
        System.out.println(largest(45,90,125));
        //4
        System.out.println("Consonants in codswallop: " + consonantCount("codswallop"));
        //5
        asciiArt();
        //6
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int prime = scanner.nextInt();
        if(isPrime(prime)){
            System.out.println(prime + " is prime.");
        } else {
            System.out.println(prime + " is not prime.");
        }
        //7
        System.out.println("Highest and lowest: " + hilo(23,6545,1,456856,564));

        //8
        ArrayList<Integer> list = arrayListStuff(100, 3,4);
        System.out.println("Size of array list: " + list.size());

        //9
        int[] numbers = {4,8,15,16,23,42};
        reverseArray(numbers);
        System.out.println("Reversed array: " + Arrays.toString(numbers));
    }
    // 3
    public static String largest(int a, int b, int c, int d){
        int largestNum = 0;
        int[] nums = {a, b, c ,d};
        for (int num : nums){
            if (num > largestNum){
                largestNum = num;
            }
        }
        String largestNumStr = "" + largestNum;
        return "Largest of 4: " + largestNumStr;
    }
    public static String largest(int a, int b, int c){
        int largestNum = 0;
        int[] nums = {a, b, c};
        for (int num : nums){
            if (num > largestNum){
                largestNum = num;
            }
        }
        String largestNumStr = "" + largestNum;
        return "Largest of 3: " + largestNumStr;
    }
    //4
    public static int consonantCount(String word){
        String vowels = "aeiou";
        int counter = 0;
        for (int i = 0; i < word.length(); i++){
            if (!vowels.contains(Character.toString(word.charAt(i)))){
                counter++;
            }
        }
        return counter;
    }
    //5
    public static void asciiArt(){
        System.out.println("-(------)--");
        System.out.println("--(----)---");
        System.out.println("---(--)----");
        System.out.println("----||----");
        System.out.println("----||----");
        System.out.println("----||----");
        System.out.println("----/\\----");
        System.out.println("---/--\\---");
        System.out.println("--/----\\--");
        System.out.println("-/------\\-");
        System.out.println("/--------\\");

    }

    public static ArrayList<Integer> primes = new ArrayList<>();
    public static boolean isPrime(int x){
        double y = x;
        int squareRoot = (int)Math.sqrt(y);
        for (int i = primes.size() > 0 ? primes.get(primes.size() - 1) + 1 : 2; i <= squareRoot; i++){
            if (isPrime(i)){
                primes.add(i);
            }
        }
        for (int num : primes){
            if (x % num == 0){
                return false;
            }
        }
        return true;
    }

    //varargs
    public static String hilo(int...nums){
        int largestNum = nums[0];
        int smallestNum = nums[0];
        for (int num : nums){
            if (num < smallestNum){
                smallestNum = num;
            } else if (num > largestNum){
                largestNum = num;
            }
        }
        int[] hilo = {largestNum, smallestNum};
        return Arrays.toString(hilo);
    }

    public static ArrayList<Integer> arrayListStuff(int maxNum, int divisor1, int divisor2){
        ArrayList<Integer> allNums = new ArrayList<>();
        for (int i = 0; i <= maxNum; i++){
            if (i % divisor1 == 0 && i % divisor2 == 0) {
                allNums.add(i);
            }
        }
        return allNums;
    }

    public static void reverseArray(int[] x){
        for (int i = 0; i <= (x.length - 1) / 2; i++){
            int temp = x[x.length-(i + 1)];
            x[x.length-(i + 1)] = x[i];
            x[i] = temp;
        }
    }

    public static void cutBoxInHalf(Box box){
        box.width /= 2;
    }
}

class Box {
    public int height;
    public int width;
    public int depth;
    public Box(int height, int width, int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }
}


