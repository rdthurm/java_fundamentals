package labs_examples.objects_classes_methods.labs.objects;

class Controller {
    public static void main(String[] args) {
        //exercise 2
        Pilot jim = new Pilot("Jim", 56, "Male", 13000);
        Path jimsPath = new Path("Toronto", "San Diego");
        System.out.println(jim.name + " is flying from " + jimsPath.startCity + " to " + jimsPath.endCity);
        //exercise 3 - overloading constructors
        Attendant mandy = new Attendant();
        Attendant guy = new Attendant(true);
        Attendant me = new Attendant("Riley", 24, 0, false);
        System.out.println(mandy.name);
        System.out.println(guy.age);
        System.out.println(me.yearsExp);
        //exercise 4
        Engines deltaEngines = new Engines(3, "Jet");
        Seats deltaSeats = new Seats(400, true);
        Pilot deltaPilot = new Pilot("Bob", 34, "Male", 5000);
        Path deltaPath = new Path("New York", "Seattle");
        Airplane deltaFlight40 = new Airplane("Delta", "blue", 110700, 3075, 2110, deltaEngines, deltaSeats, deltaPilot, deltaPath);
        System.out.println(deltaFlight40.toString());
        System.out.println(mandy.toString());

    }
}

public class Airplane {
    double fuelCapacity;
    double currentFuelLevel;
    String airline;
    String color;
    int weight;
    Engines engines;
    Seats seats;
    Pilot pilot;
    Path path;
    public Airplane(String airline, String color, int weight, double fuelCapacity, double currentFuelLevel, Engines engines, Seats seats, Pilot pilot, Path path){
        this.airline = airline;
        this.color = color;
        this.weight = weight;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.engines = engines;
        this.seats = seats;
        this.pilot = pilot;
        this.path = path;

    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelCapacity=" + fuelCapacity +
                ", currentFuelLevel=" + currentFuelLevel +
                ", airline='" + airline + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", engines=" + engines +
                ", seats=" + seats +
                ", pilot=" + pilot +
                ", path=" + path +
                '}';
    }
}

class Engines {
    int numOfEngines;
    String engineType;
    public Engines(int num, String type){
        this.numOfEngines = num;
        this.engineType = type;
    }

    @Override
    public String toString() {
        return "Engines{" +
                "numOfEngines=" + numOfEngines +
                ", engineType='" + engineType + '\'' +
                '}';
    }
}

class Seats {
    int numOfSeats;
    boolean legRoom;
    public Seats(int num, boolean leg){
        this.numOfSeats = num;
        this.legRoom = leg;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "numOfSeats=" + numOfSeats +
                ", legRoom=" + legRoom +
                '}';
    }
}

class Pilot {
    String name;
    int age;
    String gender;
    int flightHours;
    public Pilot(String name, int age, String gender, int flightHours){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.flightHours = flightHours;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", flightHours=" + flightHours +
                '}';
    }
}

class Path {
    String startCity;
    String endCity;
    public Path(String a, String b){
        this.startCity = a;
        this.endCity = b;
    }

    @Override
    public String toString() {
        return "Path{" +
                "startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                '}';
    }
}

class Attendant {
    String name;
    int age;
    int yearsExp;
    boolean happyAboutNewUniforms;
    public Attendant(){
        this.name = "Mandy";
        this.age = 25;
        this.yearsExp = 3;
        this.happyAboutNewUniforms = false;
    }
    public Attendant(boolean happy){
        this.name = "Uniform Guy";
        this.age = 46;
        this.yearsExp = 25;
        this.happyAboutNewUniforms = happy;
    }
    public Attendant(String name, int num, int total, boolean happy){
        this.name = name;
        this.age = num;
        this.yearsExp = total;
        this.happyAboutNewUniforms = happy;
    }

    @Override
    public String toString() {
        return "Attendant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", yearsExp=" + yearsExp +
                ", happyAboutNewUniforms=" + happyAboutNewUniforms +
                '}';
    }
}

