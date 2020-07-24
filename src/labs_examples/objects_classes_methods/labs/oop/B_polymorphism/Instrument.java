package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Instrument implements Maintenance {

    boolean tuned;

    public Instrument() {
        this.tuned = true;
    }

    @Override
    public void replacePart(String part) {
        System.out.println("Replace " + part + " with a new one.");
    }

    @Override
    public void polish() {
        System.out.println("Put in some elbow grease and git 'er polished.");
    }

    @Override
    public void logMaintenanceInRecords() {
        System.out.println("Logging maintenance in records.");
    }

    public boolean isTuned() {
        return tuned;
    }

    public void setTuned(boolean tuned) {
        this.tuned = tuned;
    }

}
