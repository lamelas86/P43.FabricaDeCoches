import java.sql.SQLOutput;
import java.util.Scanner;

public class Factory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] garage = new Car[Car.getMaxCars()];
        int option=0;
        
        do {
            showOptions();
            option=sc.nextInt();
            sc.nextLine();          // anti errores

            switch (option) {
                case 1: createCarWPlate(sc, garage); break;
                case 2: createCarWDoorsPlaces(sc, garage); break;
                case 3: createCarWBrandModelColour(sc, garage); break;
                case 4: createCarWNothing(sc, garage); break;
                case 5: customizeCarAndPaint(sc, garage); break;
                case 6: customizeCarNoPaint(sc, garage); break;
                case 7: increaseKm(sc, garage); break;
                case 8: pickAndShowCar(sc, garage); break;
            }

        } while (option != 9);

    }

    private static void showOptions() {
        System.out.println(
                        "Fábrica de Coches. Selecciona una opción.\n" +
                        "1. Fabricar coche (conociendo la matrícula)\n" +
                        "2. Fabricar coche (a partir del núm. de puertas y el núm. de plazas\n"+
                        "3. Fabricar coche (a partir de la marca, el modelo y el color\n"+
                        "4. Fabricar coche (sin datos)\n"+
                        "5. Personalizar coche (pintándolo de un color)\n"+
                        "6. Personalizar coche (sin pintarlo)\n"+
                        "7. Avanzar kilómetros\n"+
                        "8. Mostrar características de un coche\n"+
                        "9. Salir del programa\n");
    }

    private static void createCarWPlate(Scanner sc, Car[] garage) {
        if (checkSlot()) {
            int carIndex = Car.getCarCount();

            System.out.println("Introduce la matrícula.");
            String plate = sc.nextLine();
            garage[carIndex] = new Car(plate);
            showCar(garage[carIndex]);
        }

    }

    private static void createCarWDoorsPlaces(Scanner sc, Car[] garage) {
        if (checkSlot()) {
            int carIndex = Car.getCarCount();

            System.out.println("Introduce el número de puertas.");
            int doors = sc.nextInt();
            System.out.println("Introduce el número de plazas.");
            int places = sc.nextInt();
            garage[carIndex] = new Car(randomPlate(), doors, places);
            showCar(garage[carIndex]);
        }

    }

    private static void createCarWBrandModelColour(Scanner sc, Car[] garage) {
        if (checkSlot()) {
            int carIndex = Car.getCarCount();

            System.out.println("Introduce la marca.");
            String brand = sc.nextLine();
            System.out.println("Introduce el modelo.");
            String model = sc.nextLine();
            System.out.println("Introduce el color.");
            String colour = sc.nextLine();
            garage[carIndex] = new Car(randomPlate(), brand, model, colour);
            showCar(garage[carIndex]);
        }
    }

    private static void createCarWNothing(Scanner sc, Car[] garage) {
        if (checkSlot()) {
            int carIndex = Car.getCarCount();

            garage[carIndex] = new Car(randomPlate());
            showCar(garage[carIndex]);
        }
    }

    private static void customizeCarAndPaint(Scanner sc, Car[] garage) {
        System.out.println("Introduce la matrícula del coche a modificar.");
        Car thatCar = pickCar(sc, garage);

        if (thatCar != null) {
            paintCar(sc, thatCar);
            customizeCar(sc, thatCar);
            showCar(thatCar);
        } else {
            System.out.println("No existe ningún coche con la matrícula especificada.\n");
        }
    }

    private static void customizeCarNoPaint(Scanner sc, Car[] garage) {
        System.out.println("Introduce la matrícula del coche a modificar.");
        Car thatCar = pickCar(sc, garage);

        if (thatCar != null) {
            customizeCar(sc, thatCar);
            showCar(thatCar);
        } else {
            System.out.println("No existe ningún coche con la matrícula especificada.\n");
        }
    }

    private static void increaseKm(Scanner sc, Car[] garage) {
        System.out.println("Introduce la matrícula del coche a incrementar sus km.");
        Car thatCar = pickCar(sc, garage);

        if (thatCar != null) {
            System.out.println("Introduce los km a incrementar.");
            int km = sc.nextInt();
            thatCar.setKm(thatCar.getKm() + km);
            showCar(thatCar);
        } else {
            System.out.println("No existe ningún coche con la matrícula especificada.\n");
        }
    }

    private static void pickAndShowCar(Scanner sc, Car[] garage) {
        System.out.println("Introduce la matrícula del coche a mostrar.");
        Car thatCar = pickCar(sc, garage);

        if (thatCar != null) {
            showCar(thatCar);
        } else {
            System.out.println("No existe ningún coche con la matrícula especificada.\n");
        }
    }

    private static boolean checkSlot() {
        if (Car.getCarCount() < Car.getMaxCars()) {
            return true;
        } else {
            System.out.println("No se pueden crear más de 5 coches.\n");
            return false;
        }
    }

    private static String randomPlate() {
        String plate = "";
        int randomNum;

        for (int i=0; i<5; i++) {
            randomNum = (int) (Math.random()*10);
            plate = plate + String.valueOf(randomNum);
        }

        return plate;
    }

    private static Car pickCar(Scanner sc, Car[] garage) {
        String plate = sc.nextLine();

        Car thatCar = searchCar(garage, plate);
        return thatCar;                             //pickCar() podría combinarse con searchCar(),
    }                                               //pero la práctica obliga a tener searchCar()

    private static Car searchCar(Car[] garage, String plate) {
        for (int i=0; i<Car.getCarCount(); i++) {
            if (garage[i].getPlate().equals(plate)) {
                return garage[i];
            }
        }
        return null;
    }

    private static void paintCar (Scanner sc, Car pickedCar) {
        System.out.println("Introduzca el color a pintar.");
        String newColour = sc.nextLine();

        pickedCar.setColour(newColour);
    }

    private static void customizeCar (Scanner sc, Car pickedCar) {
        int option;

        while (true) {
            customizeOptions();
            option = sc.nextInt();
            sc.nextLine();      //anti errores

            switch (option) {
                case 1: 
                    System.out.println("Introduce la nueva matrícula.");
                    pickedCar.setPlate(sc.nextLine());
                    break;
                case 2: 
                    System.out.println("Introduce la nueva marca.");
                    pickedCar.setBrand(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Introduce el nuevo modelo.");
                    pickedCar.setModel(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Introduce y si tiene techo abatible.");
                    if (sc.nextLine().charAt(0) == 'y') {pickedCar.setRoof(true);}
                    break;
                case 5: 
                    System.out.println("Introduce la cantidad de puertas.");
                    pickedCar.setDoors(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Introduce la cantidad de plazas.");
                    pickedCar.setPlaces(sc.nextInt());
                    break;
                case 7: return;
            }
        }
    }

    private static void customizeOptions() {
        System.out.println(
                        "Modificar coche: selecciona una opción.\n" +
                        "1. Cambiar matrícula.\n" +
                        "2. Cambiar marca.\n"+
                        "3. Cambiar modelo.\n"+
                        "4. Añadir/Eliminar techo abatible.\n"+
                        "5. Cambiar cantidad de puertas.\n"+
                        "6. Cambiar cantidad de plazas.\n"+
                        "7. Terminar modificación.\n");
    }

    private static void showCar(Car pickedCar) {
        System.out.println(
            "Este coche tiene los siguientes datos:\n" +
            "Matrícula: " + pickedCar.getPlate() + "\n" +
            "Marca: " + pickedCar.getBrand() + "\n" +
            "Modelo: " + pickedCar.getModel() + "\n" +
            "Color: " + pickedCar.getColour() + "\n" +
            "Kilómetros: " + pickedCar.getKm() + "\n" +
            "y " + checkRoof(pickedCar) + "tiene techo solar\n" +
            "Tiene " + pickedCar.getDoors() + " puertas y " +
            pickedCar.getPlaces() + " plazas.\n");
    }

    private static String checkRoof(Car pickedCar) {
        if (!pickedCar.getRoof()) {
            return "no ";
        } else {
            return "";
        }
    }
}