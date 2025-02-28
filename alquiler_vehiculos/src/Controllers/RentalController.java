package Controllers;
import java.time.Duration;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class RentalController {
    // Variables para llevar control de los días de salida y regreso del vehículo
    private LocalDate exitDate;
    private LocalDate estimateReturnDate;
    private LocalDate returnDate;

    // Variables para llevar el tiempo total que se prestó el vehículo
    private int totalDays;
    private int extraDays;

    // Uso de metodos get y set para las variables private

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public LocalDate getExitDate() {
        return this.exitDate;
    }

    public void setEstimateReturnDate(LocalDate estimateReturnDate) {
        this.estimateReturnDate = estimateReturnDate;
    }

    public LocalDate getEstimateReturnDate() {
        return this.estimateReturnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getReturnDate() {
        return this.returnDate;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getExtraDays() {
        return this.extraDays;
    }

    public void setExtraDays(int extraDays) {
        this.extraDays = extraDays;
    }

    // Método para calcular los días totales de alquiler agregando la variable estimateReturnDate para que calcule las fechas
    public void calculateTotalDays() {
        if (this.exitDate != null && this.estimateReturnDate != null) {
            this.totalDays = Math.toIntExact(Duration.between(this.exitDate.atStartOfDay(), this.estimateReturnDate.atStartOfDay()).toDays());
        } else {
            System.out.println("Las fechas no están correctamente asignadas.");
            this.totalDays = 0; // Asignamos 0 si alguna fecha es nula
        }
    }

    // Método para calcular los días extra de retraso
    public void calculateExtraDays() {
        if (this.estimateReturnDate != null && this.returnDate != null) {
            this.extraDays = Math.toIntExact(Duration.between(this.estimateReturnDate.atStartOfDay(), this.returnDate.atStartOfDay()).toDays());
        } else {
            System.out.println("Las fechas de regreso no están correctamente asignadas.");
            this.extraDays = 0;
        }
    }

    // Método para calcular el costo total, incluyendo días extras
    public double calculateBillingTotal(double pricePerDay) {
        double total = pricePerDay;

        // Calcular el costo extra por días de retraso
        if (this.extraDays > 1) {
            total += 1.00;
            System.out.println("Extra day 1");
        }
        if (this.extraDays > 3) {
            total += 5.00;
            System.out.println("Extra day 2");
        }
        if (this.extraDays > 5) {
            total += 10.00;
            System.out.println("Extra day 3");
        }
        if (this.extraDays > 7) {
            total += 20.00;
            System.out.println("Extra day 4");
        }

        return total;
    }
}