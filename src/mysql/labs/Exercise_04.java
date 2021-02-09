package mysql.labs;
import mysql.labs.sakila_db.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
*  MySQL Exercise 4:
*
*   Now that you have mastered your air travel database, it's time to connect this DB to a Java application
*   using JDBC. You can start simple here and build your way up. Within a Java application, using JDBC, please
*   demonstrate how to:
*
*   Note: CRUD means (Create, Read, Update, Delete)
*
*       1.) CRUD new flights
*       2.) CRUD new passengers
*       3.) Bonus: flex those JDBC muscles! How nice, clean, useful can you make this? Show us what you've got!
*
 */

public class Exercise_04 {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Airport?" +
                    "user=root&password=Rdt2855!&useSSL=false");
            //createFlight(connection);
            //updateFlight(connection);
            //queryFlightPassengerCount(connection, "1009");
            //deleteFlight(connection, "1006");
            //createPassenger(connection);
            //queryPassengerEmail(connection, "21");
            //updatePassengerPrefWindow(connection);
            //deletePassenger(connection, "21");

           //ArrayList<Passenger> passengers = createArrayOfPassengers(connection);

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Exception occured - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /*
        Just as a casual example - each of these operations should be in it's own method. Feel free to
        create all required classes/methods to accomplish this.

        createFlight(...);
        queryFlight(...);
        updateFlight(...);
        deleteFlight(...);

        createPassenger(...);
        queryPassenger(...);
        updatePassenger(...);
        deletePassenger(...);

        ...


         */
    }

    public static void createFlight(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CREATE FLIGHT\n\nEnter PlaneID: ");
        String PlaneID = scanner.nextLine();
        System.out.println("Enter AirlineID: ");
        String AirlineID = scanner.nextLine();
        System.out.println("Enter StartPort (ID): ");
        String StartPort = scanner.nextLine();
        System.out.println("Enter EndPort (ID): ");
        String EndPort = scanner.nextLine();
        System.out.println("Enter Date (yyyy-mm-dd): ");
        String Date = scanner.nextLine();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Airport.Flight " +
                    "(PlaneID, AirlineID, StartPort, EndPort, Date) " +
                    "values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, PlaneID);
            preparedStatement.setString(2, AirlineID);
            preparedStatement.setString(3, StartPort);
            preparedStatement.setString(4, EndPort);
            preparedStatement.setString(5, Date);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    public static void queryFlightPassengerCount(Connection connection, String FlightID) {
        String PassengerCount = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(t.PassengerID) as count from Ticket t " +
                    "where t.FlightID = " + FlightID);
            if (resultSet.next()) {PassengerCount = resultSet.getString("count"); }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        System.out.println("Flight " + FlightID + " has " + PassengerCount + " passengers.");
    }

    public static void updateFlight(Connection connection, String FlightID) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("UPDATE FLIGHT\n\nEnter SQL string for update, except for the WHERE statement: ");
        String SQLString  = scanner.nextLine() + " WHERE FlightID = \"" + FlightID + "\"";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLString);
            statement.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    public static void deleteFlight(Connection connection, String FlightID) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Airport.Flight WHERE FlightID = " + FlightID);
            statement.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        System.out.println("Flight " + FlightID + " has been deleted.");
    }


    public static void createPassenger(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CREATE Passenger\n\nEnter FirstName: ");
        String FirstName = scanner.nextLine();
        System.out.println("Enter LastName: ");
        String LastName = scanner.nextLine();
        System.out.println("Enter Email: ");
        String Email = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Airport.Passenger " +
                    "(FirstName, LastName, Email, phoneNumber) " +
                    "values (?, ?, ?, ?)");
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setString(3, Email);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    public static void queryPassengerEmail(Connection connection, String PassengerID) {
        String email = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT p.Email from Passenger p " +
                    "where p.PassengerID = " + PassengerID);
            if (resultSet.next()) {email = resultSet.getString("p.Email"); }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        System.out.println("Passenger " + PassengerID + " can be reached at " + email);
    }

   public static void updatePassengerPrefWindow(Connection connection) {
        Scanner scanner = new Scanner(System.in);
       System.out.println("Enter PassengerID: ");
       String PassengerID = scanner.nextLine();
       System.out.println("Enter 1 to set Prefer Window to true, 0 to set false: ");
       String bool = scanner.nextLine();
       String SQLString = "UPDATE Airport.Passenger SET PrefersWindow = \"" + bool +
               "\" WHERE PassengerID = " + PassengerID;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLString);
            statement.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    public static void deletePassenger(Connection connection, String PassengerID) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Airport.Passenger WHERE PassengerID = " + PassengerID);
            statement.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        System.out.println("Passenger " + PassengerID + " has been deleted.");
    }

    public static ArrayList<Passenger> createArrayOfPassengers(Connection connection){
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Airport.Passenger");

            while (resultSet.next()) {
                int passengerID = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                Passenger p = new Passenger(passengerID, firstName, lastName, email);
                passengers.add(p);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return passengers;
    }


}
