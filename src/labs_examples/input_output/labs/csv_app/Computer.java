package labs_examples.input_output.labs.csv_app;

public class Computer {
    String brand;
    double processorSpeedGhz;
    int diskMemGB;
    int ramGB;

    public Computer(){}

    public Computer(String brand, double processorSpeedGhz, int diskMemGB, int ramGB) {
        this.brand = brand;
        this.processorSpeedGhz = processorSpeedGhz;
        this.diskMemGB = diskMemGB;
        this.ramGB = ramGB;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getProcessorSpeedGhz() {
        return processorSpeedGhz;
    }

    public void setProcessorSpeedGhz(double processorSpeedGhz) {
        this.processorSpeedGhz = processorSpeedGhz;
    }

    public int getDiskMemGB() {
        return diskMemGB;
    }

    public void setDiskMemGB(int diskMemGB) {
        this.diskMemGB = diskMemGB;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", processorSpeedGhz=" + processorSpeedGhz +
                ", diskMemGB=" + diskMemGB +
                ", ramGB=" + ramGB +
                '}';
    }
}
