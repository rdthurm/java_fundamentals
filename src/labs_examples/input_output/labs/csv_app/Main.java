package labs_examples.input_output.labs.csv_app;

import labs_examples.input_output.examples.csv_parser.Student;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Computer> compArr = new ArrayList<>();
        String filePath = "/Users/Riley/Documents/CodingNomads/labs/online-java-fundamentals/src/labs_examples/input_output/labs/csv_app/";
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath + "computers.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                compArr.add(makeComputer(values));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Computer computer : compArr){
            System.out.println(computer.toString());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + "computers_copy.csv"))){
            for (Computer computer : compArr){
                writer.write(computer.getBrand() + ",");
                writer.write(computer.getProcessorSpeedGhz() + ",");
                writer.write(computer.getDiskMemGB() + ",");
                writer.write(computer.getRamGB() + ",\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static Computer makeComputer(String[] values){
        Computer computer = new Computer();
         computer.setBrand(values[0]);
         computer.setProcessorSpeedGhz(Double.parseDouble(values[1]));
         computer.setDiskMemGB(Integer.parseInt(values[2]));
         computer.setRamGB(Integer.parseInt(values[3]));
         return computer;
    }
}
