public class Car {
    private static int carCount=0;
    private static final int maxCars=5;
    private String plate, brand, model, colour;
    private boolean roof;
    private int km, doors, places;

    public Car() {                  //no hace falta definir la matricula
        this.brand="undefined";     //ya que siempre va a recibir un valor
        this.model="undefined";
        this.colour="undefined";
        this.roof=false;
        this.km=0;
        this.doors=5;
        this.places=5;
        carCount++;
    }

    public Car(String plate) {
        this();
        this.plate=plate;
    }

    public Car(String plate, int doors, int places) {
        this();
        this.plate=plate;
        this.doors=doors;
        this.places=places;
    }

    public Car(String plate, String brand, String model, String colour) {
        this();
        this.plate=plate;
        this.brand=brand;
        this.model=model;
        this.colour=colour;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    public boolean getRoof() {
        return roof;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getKm() {
        return km;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getPlaces() {
        return places;
    }

    public static int getMaxCars() {
        return maxCars;
    }

    public static int getCarCount() {
        return carCount;
    }
}

