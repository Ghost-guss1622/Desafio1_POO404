import Controllers.RentalController;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        RentalController rentalController = new RentalController();

        // Ingresando el día de salida del vehículo
        System.out.print("Ingrese la fecha de salida del vehiculo en formato YYYY-MM-DD: ");
        String exitDate = reader.nextLine();
        rentalController.setExitDate(LocalDate.parse(exitDate));

        // Ingresando la fecha estimada a regresar el vehículo
        System.out.print("Ingrese la fecha estimada a regresar el vehiculo en formato YYYY-MM-DD: ");
        String estimateDate = reader.nextLine();
        rentalController.setEstimateReturnDate(LocalDate.parse(estimateDate));

        // Función para calcular el tiempo total
        rentalController.calculateTotalDays();

        // Número de veces que se prestó el vehículo
        if (rentalController.getTotalDays() > 0) {
            System.out.println("Número de días del alquiler " + rentalController.getTotalDays());
        }

        // Ingresando el día real de regreso del vehículo
        System.out.print("Ingrese la fecha en la que regreso el vehiculo en formato YYYY-MM-DD: ");
        String realDate = reader.nextLine();
        rentalController.setReturnDate(LocalDate.parse(realDate));

        // Función para calcular los días de retraso
        rentalController.calculateExtraDays();

        // Función para calcular el importe extra por los días de retraso
        double pricePerDay = 1.50 * rentalController.getTotalDays();
        double billingTotal = rentalController.calculateBillingTotal(pricePerDay);
        System.out.println("El total por el alquiler del vehiculo es de: $" + billingTotal);
    }
}