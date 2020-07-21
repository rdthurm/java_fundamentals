package labs_examples.objects_classes_methods.labs.objects;

class Controller {
    public static void main(String[] args) {
        //exercise 2
        Pilot jim = new Pilot("Jim", 56, "Male", 13000);
        Path jimsPath = new Path("Toronto", "San Diego");
        System.out.println(jim.getName() + " is flying from " + jimsPath.getStartCity() + " to " + jimsPath.getEndCity());
        //exercise 3 - overloading constructors
        Attendant mandy = new Attendant();
        Attendant guy = new Attendant(true);
        Attendant me = new Attendant("Riley", 24, 0, false);
        System.out.println(mandy.getName());
        System.out.println(guy.getAge());
        System.out.println(me.getYearsExp());
        //exercise 4
        Engines deltaEngines = new Engines(3, "Jet");
        Seats deltaSeats = new Seats(400, true);
        Pilot deltaPilot = new Pilot("Bob", 34, "Male", 5000);
        Path deltaPath = new Path("New York", "Seattle");
        Airplane deltaFlight40 = new Airplane("Delta", "blue", 110700, 3075, 2110, deltaEngines, deltaSeats, deltaPilot, deltaPath);
        System.out.println(deltaFlight40.toString());
        System.out.println(mandy.toString());

        System.out.println(deltaEngines.toString());
        System.out.println(guy.toString());

    }
}

public class Airplane {
    private double fuelCapacity;
    private double currentFuelLevel;
    private String airline;
    private String color;
    private int weight;
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

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Engines getEngines() {
        return engines;
    }

    public void setEngines(Engines engines) {
        this.engines = engines;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
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
    private int numOfEngines;
    private String engineType;
    public Engines(int num, String type){
        this.numOfEngines = num;
        this.engineType = type;
    }

    public int getNumOfEngines() {
        return numOfEngines;
    }

    public void setNumOfEngines(int numOfEngines) {
        this.numOfEngines = numOfEngines;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
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
    private int numOfSeats;
    private boolean legRoom;
    public Seats(int num, boolean leg){
        this.numOfSeats = num;
        this.legRoom = leg;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public boolean isLegRoom() {
        return legRoom;
    }

    public void setLegRoom(boolean legRoom) {
        this.legRoom = legRoom;
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
    private String name;
    private int age;
    private String gender;
    private int flightHours;
    public Pilot(String name, int age, String gender, int flightHours){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.flightHours = flightHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(int flightHours) {
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
    private String startCity;
    private  String endCity;
    public Path(String a, String b){
        this.startCity = a;
        this.endCity = b;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
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
    private String name;
    private int age;
    private int yearsExp;
    private boolean happyAboutNewUniforms;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsExp() {
        return yearsExp;
    }

    public void setYearsExp(int yearsExp) {
        this.yearsExp = yearsExp;
    }

    public boolean isHappyAboutNewUniforms() {
        return happyAboutNewUniforms;
    }

    public void setHappyAboutNewUniforms(boolean happyAboutNewUniforms) {
        this.happyAboutNewUniforms = happyAboutNewUniforms;
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

