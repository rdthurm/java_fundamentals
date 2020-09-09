package labs_examples.input_output.labs;

import javax.xml.crypto.Data;
import java.io.*;

/**
 * Input/Output Exercise 3: variety
 *
 *    1) Demonstrate the usage of at least two additional Byte Streams
 *    2) Demonstrate the usage of at least two additional Character Streams
 *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
 *    4) Demonstrate the use of the DataInputStream and DataOutputStream
 *
 */

class Exercise3 {
    public static String filePath = "/Users/Riley/Documents/CodingNomads/labs/online-java-fundamentals/src/labs_examples/input_output/labs/";
    public static void main(String[] args) {
        //sequence();
        //buffer();
        //bytebuffer();
        dataStreams();
    }

    public static void sequence(){
        int c;
        try (FileInputStream f1 = new FileInputStream(filePath + "text.txt");
             FileInputStream f2 = new FileInputStream(filePath + "numbers.txt");
             SequenceInputStream sis = new SequenceInputStream(f1, f2);
             FileOutputStream fout = new FileOutputStream(filePath + "sequence.txt")){

            do {
                if ((c = sis.read()) != -1){
                    fout.write((char) c);
                }
            } while (c != -1);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void buffer(){
        try (BufferedReader input = new BufferedReader(new FileReader(filePath + "text.txt"));
             BufferedWriter output = new BufferedWriter(new FileWriter(filePath + "text_copy.txt"))) {
            String s;
            while ((s = input.readLine()) != null){
                output.write(s + "\n");
               output.write("-----------------------\n");
            }
        } catch (IOException e){
            e.getMessage();
        }
    }

    public static void bytebuffer(){
        try (BufferedInputStream buf = new BufferedInputStream(new FileInputStream(filePath + "text.txt"))){
            byte[] bytey = new byte[5];
            int c;
            while ((c = buf.read(bytey)) != -1){
                System.out.print(new String(bytey, 0, c));
            }
        } catch (IOException e){
            e.getMessage();
        }
    }

    public static void dataStreams(){
        double pi = 3.14;
        boolean up = true;

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath + "data.txt"))){
            dos.writeDouble(pi);
            dos.writeBoolean(up);
        } catch (IOException e){
            e.getMessage();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath + "data.txt"))){
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
        } catch (IOException e){
            e.getMessage();
        }
    }
}