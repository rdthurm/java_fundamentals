package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */

class Example
{
    public static String filePath = "/Users/Riley/Documents/CodingNomads/labs/online-java-fundamentals/src/labs_examples/input_output/labs/";
    public static void main(String[] args)
    {
        ex1();
        //ex2(-80);
    }

    public static void ex1(){
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(filePath + "numbers.txt"));
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(filePath + "numbers_copy.txt"))) {
            int i = 0;
            byte[] buffer = new byte[5];
            while ((i = input.read(buffer)) != -1) {
                output.write(buffer);
            }
        } catch (IOException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void ex2(int num){
        int c;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath + "text.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(filePath + "text_code.txt"))){
            while ((c = br.read()) != -1){
                if (c != 10 && c != 13) {
                    c += num;
                    bw.write(c);
                } else {
                    bw.write(c);
                }
            }
        } catch (IOException e){
            System.out.println(e.getLocalizedMessage());
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(filePath + "text_code.txt"));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(filePath + "text_decode.txt"))){
            while ((c = br2.read()) != -1){
                if (c != 10 && c != 13) {
                    c -= num;
                    bw2.write(c);
                } else {
                    bw2.write(c);
                }
            }
        } catch (IOException e){
            System.out.println(e.getLocalizedMessage());
        }

        try (FileInputStream fin1 = new FileInputStream(filePath + "text.txt");
             FileInputStream fin2 = new FileInputStream(filePath + "text_decode.txt")){
            int x = 0;
            int y = 0;
            do {
                x = fin1.read();
                y = fin2.read();
                if (x != y) break;
            } while (x != -1 && y != -1);

            if (x != y){
                System.out.println("Your files differ. Something went wrong in decoding.");
            } else {
                System.out.println("Decoding worked!");
            }
        } catch (IOException exc){
            exc.getMessage();
        }

    }

    public static void ex3(){

    }

}