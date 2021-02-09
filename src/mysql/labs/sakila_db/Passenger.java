package mysql.labs.sakila_db;

public class Passenger {
    private int passengerID;
    private String firstName;
    private String lastName;
    private String Email;
    private String phoneNumber;
    private String birthday;
    private boolean PrefersWindow;

    public Passenger(int passengerID, String firstName, String lastName, String email) {
        this.passengerID = passengerID;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
    }

    public Passenger(int passengerID, String firstName, String lastName, String email, String phoneNumber, String birthday, boolean prefersWindow) {
        this.passengerID = passengerID;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        PrefersWindow = prefersWindow;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isPrefersWindow() {
        return PrefersWindow;
    }

    public void setPrefersWindow(boolean prefersWindow) {
        PrefersWindow = prefersWindow;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerID=" + passengerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Email='" + Email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", PrefersWindow=" + PrefersWindow +
                '}';
    }
}
