package Grudzien.SeriaLambd;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class zadanieLambdy {


    public static void main(String[] args) {
        lambdyStart();
    }


    private static void lambdyStart() {
        Product productFiat = new Product("Fiat Fullback", 82000);
        Product productSkoda = new Product("Skoda Octavia", 45000);
        Product productAudi = new Product("Audi A4", 90000);
        Product productFord = new Product("Ford mustang", 20000);
        Product productFiatTipo = new Product("Fiat Tipo", 52000);
        Product productCatering = new Product("Catering for event", 1300);
        Product productOfficeRent = new Product("Office rent", 25000);
        Product productFuelGasoline = new Product("Fuel, gasoline 95", 5.13);
        Product productFuelON = new Product("Fuel, oil", 5.02);
        Product productScrew = new Product("Screw", 3.2);
        Product productHammer = new Product("Hammer", 15.99);
        Product productPowerbank = new Product("Power bank", 15.99);
        Product productPhoneSamsung = new Product("Samsung Phone", 999.0);
        Product productPhoneApple = new Product("Apple Phone", 1299.99);
        Product productLaptopDell = new Product("Laptop, Dell Latitude", 1399.0);
        Product productLaptopApple = new Product("Laptop, Apple MacBook Pro", 1799.0);
        Product productServerDellPrecision = new Product("Server, Server Dell Precision", 2490.0);
        Product productPC = new Product("PC, Asus", 790.0);
        Product productCase = new Product("Case", 500.0);
        Product productSwitch = new Product("Network Switch", 130.0);
        Product productCoffeA = new Product("Coffee, Arabica", 29.99);
        Product productCoffeR = new Product("Coffee, Robusta", 39.99);
        Product productMug = new Product("Mug", 5.00);
        Product productPen = new Product("Pen", 0.99);
        Product productPencil = new Product("Pencil", 0.50);
        Product productClip = new Product("Clip", 2.49);
        Product productPuncher = new Product("Puncher", 0.79);
        Product productPaper = new Product("Paper", 9.99);
        Product productScisors = new Product("Scisors", 0.99);
        Product productFlour = new Product("Flour", 1.39);
        Product productSugar = new Product("Sugar", 1.87);
        Product productChocolate = new Product("Chocolate", 1.99);

        Company companyFallen = new Company("Fallen", "Detroit", 320, new ArrayList<>(Arrays.asList(
                new Purchase(productFiat, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 4), 18.1, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 9), 23.9, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 18), 41.8, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 23), 37.2, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 30), 7.3, UNIT.UNIT),
                new Purchase(productHammer, LocalDate.of(2018, 1, 29), 1.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 2), 21.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 3), 43.3, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 10), 13.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 5), 25.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 13), 38.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 19), 111.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 20), 59.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 21), 230.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 26), 18.3, UNIT.UNIT),

                new Purchase(productCoffeA, LocalDate.of(2018, 2, 15), 10.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 20), 10.0, UNIT.UNIT)
        )));

        Company companyPetersWifesCookies = new Company("Peters wifes cookies", "London", 12, new ArrayList<>(Arrays.asList(
                new Purchase(productFlour, LocalDate.of(2018, 1, 1), 10, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 1), 25, UNIT.KILOGRAM),

                new Purchase(productFlour, LocalDate.of(2018, 1, 7), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 1, 14), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 1, 21), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 1, 28), 10, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 21), 25, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 1), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 7), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 14), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 21), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 28), 7, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 15), 25, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 6), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 13), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 20), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 27), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 28), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 6), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 13), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 20), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 27), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 28), 10, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 28), 25, UNIT.KILOGRAM)
        )));

        Company companyTheOffice = new Company("Dunder Mifflin", "Detroit", 17, new ArrayList<>(Arrays.asList(
                new Purchase(productPaper, LocalDate.of(2018, 1, 1), 20.0, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 2), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 3), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 4), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 5), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 6), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 7), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 8), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 9), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 10), 20.0, UNIT.UNIT),
                new Purchase(productScisors, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productPuncher, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productClip, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productMug, LocalDate.of(2018, 1, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 10), 20, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 11), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 12), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 13), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 14), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 15), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 16), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 17), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 18), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 19), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 20), 13.0, UNIT.UNIT),

                new Purchase(productScisors, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productPuncher, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productClip, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productMug, LocalDate.of(2018, 1, 20), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 20), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 20), 20, UNIT.KILOGRAM),

                new Purchase(productPaper, LocalDate.of(2018, 1, 21), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 22), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 23), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 24), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 25), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 26), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 27), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 28), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 29), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 30), 20.0, UNIT.UNIT),

                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 1), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 2), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 3), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 4), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 5), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 6), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 7), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 8), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 9), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 10), 20.0, UNIT.UNIT),

                new Purchase(productScisors, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productPuncher, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productClip, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productMug, LocalDate.of(2018, 2, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 10), 20, UNIT.KILOGRAM),

                new Purchase(productPaper, LocalDate.of(2018, 2, 11), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 12), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 13), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 14), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 15), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 16), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 17), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 18), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 19), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 20), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 21), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 22), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 23), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 24), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 25), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 26), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 27), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 20.0, UNIT.UNIT)
        )));

        Company transporting = new Company("Take me home", "London", 5, new ArrayList<>(Arrays.asList(
                new Purchase(productSkoda, LocalDate.of(2018, 1, 1), 2.0, UNIT.UNIT),
                new Purchase(productFiatTipo, LocalDate.of(2018, 1, 1), 2.0, UNIT.UNIT),
                new Purchase(productAudi, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 1), 330.32, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 2.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 3), 327.58, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 5), 317.44, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 7), 332.11, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 9), 325.13, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 11), 325.17, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 13), 325.18, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 15), 302.82, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 17), 321.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 19), 395.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 21), 330.32, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 23), 327.58, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 25), 317.44, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 27), 332.11, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 29), 325.13, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 2.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 1), 325.17, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 3), 325.18, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 5), 302.82, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 7), 321.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 9), 395.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 11), 325.17, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 13), 325.18, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 15), 302.82, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 17), 321.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 19), 395.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 21), 330.32, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 23), 327.58, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 25), 317.44, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 27), 332.11, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 28), 325.13, UNIT.UNIT)
        )));

        Company companyTonysHardware = new Company("Tony's hardware", "Detroit", 2, new ArrayList<>(Arrays.asList(
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productScrew, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productHammer, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productFord, LocalDate.of(2018, 2, 20), 2, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 20), 70.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 13), 20.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 28), 35.0, UNIT.UNIT)
        )));

        Company companyTailor = new Company("Tailor Swift", "New York City", 3, new ArrayList<>(Arrays.asList(
                new Purchase(productScisors, LocalDate.of(2018, 1, 1), 3, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 1), 3, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 1), 3, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 2, UNIT.KILOGRAM),

                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 2, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 1, 13), 3, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 1, 18), 3, UNIT.UNIT)
        )));

        Company companyGoogleDublin = new Company("Google", "Dublin", 91, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 5), 91, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 15), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 30), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 5), 91, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 20), 50.0, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 3), 20, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 15), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 28), 91, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 5, UNIT.UNIT)
        )));


        Company companyGoogleLondon = new Company("Google", "London", 76, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 20, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 5), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 15), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 30), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 5), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 15), 76, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 50.0, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 28), 76, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 4, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 4, UNIT.UNIT)
        )));


        Company companyGoogleKijev = new Company("Google", "Kijev", 23, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 15, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 5), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 15), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 30), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 5), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 15), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 28), 23, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 10, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 3), 30.0, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT)
        )));


        Company companyFintech = new Company("Fintech", "London", 9, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 15, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 23, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 1), 23, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 5), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT)
        )));

        Company companyFintechNewYork = new Company("Fintech", "New York City", 19, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 7, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 1), 23, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT),
                new Purchase(productPowerbank, LocalDate.of(2018, 1, 1), 10, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 1), 15.0, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 10), 3, UNIT.UNIT),
                new Purchase(productPhoneSamsung, LocalDate.of(2018, 2, 10), 4, UNIT.UNIT),
                new Purchase(productPhoneSamsung, LocalDate.of(2018, 2, 10), 4, UNIT.UNIT),
                new Purchase(productCase, LocalDate.of(2018, 1, 15), 2, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT)
        )));

        Company bakeryDetroit = new Company("Detroit Bakery", "Detroit", 11, new ArrayList<>(Arrays.asList(
                new Purchase(productFlour, LocalDate.of(2018, 1, 1), 200, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 1), 50, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 1), 100, UNIT.KILOGRAM),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 1), 132.53, UNIT.UNIT),
                new Purchase(productFlour, LocalDate.of(2018, 2, 1), 190, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 62, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 1), 79, UNIT.KILOGRAM)
        )));

        Company baltimoreFishing = new Company("Fisz", "Baltimore", 5, new ArrayList<>(Arrays.asList(
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 3), 500, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 15), 500, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 15), 100, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 30), 500, UNIT.UNIT),
                new Purchase(productPC, LocalDate.of(2018, 1, 20), 500, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 20), 500, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 15), 500, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 15), 100, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 28), 500, UNIT.UNIT)
        )));

        Company solwit = new Company("Solwit", "Kijev", 68, new ArrayList<>(Arrays.asList(
                new Purchase(productAudi, LocalDate.of(2018, 1, 2), 2, UNIT.UNIT),
                new Purchase(productPC, LocalDate.of(2018, 1, 2), 5, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 2), 89, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 12), 73.13, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 29), 67.33, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 13), 91.44, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 25), 47.12, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 2), 1, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 3), 1, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 23), 20.0, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 4), 1, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 25), 47.12, UNIT.UNIT)

        )));

        Company solwitGda = new Company("Solwit", "Gdansk", 68, new ArrayList<>(Arrays.asList(
                new Purchase(productPC, LocalDate.of(2018, 1, 2), 5, UNIT.UNIT),
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 10), 20.0, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 7), 1.0, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 2, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 1), 15, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 15, UNIT.UNIT)
        )));

        Company intelD = new Company("Intel", "Detroit", 755, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 100, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 1), 100, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 1), 100, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 10), 10, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 1), 100, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 3), 23.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 100, UNIT.KILOGRAM),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productCase, LocalDate.of(2018, 2, 20), 10, UNIT.UNIT)
        )));

        Company intelGda = new Company("Intel", "Gdansk", 161, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 100, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 5), 50, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 9), 20.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 10, UNIT.KILOGRAM)

        )));

        Company intelKij = new Company("Intel", "Kijev", 161, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 100, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 5), 50, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 15, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 9), 20.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 10, UNIT.KILOGRAM)

        )));

        List<Company> companies = new ArrayList<>(Arrays.asList(
                companyFallen,
                companyPetersWifesCookies,
                companyTheOffice,
                transporting,
                companyTonysHardware,
                companyTailor,
                companyGoogleDublin,
                companyGoogleLondon,
                companyGoogleKijev,
                companyFintech,
                companyFintechNewYork,
                bakeryDetroit,
                baltimoreFishing,
                solwitGda,
                solwit,
                intelD,
                intelGda,
                intelKij
        ));
        //Odtąd zaczynają się rozwiązania zadań z Lambdami:
        //*************************************************
       // zad10(companies);     // metoda nie chce zadzialac blad unsuported operation
        System.out.println("\n ");
        System.out.println( zad28(companies) + "\n " );
        System.out.println( zad33(companies) + "L. / samochód" );
    }

    private static void zad1( List<Company> firmy ){
        firmy.forEach(System.out::println);
    }
    private static void zad2( List<Company> firmy ){
        firmy.forEach( (cmp) -> {
            if ( cmp.getCityHeadquarters().equals("Detroit") ){
                System.out.println( cmp );
            }
        } );
    }
    private static void zad3( List<Company> firmy ){
        System.out.println( firmy.stream().filter(t -> t.getCityHeadquarters().equals("London")).max(Company::compareTo) );
    }
    private static void zad4( List<Company> firmy ){
        System.out.println( firmy.stream().filter(t -> t.getCityHeadquarters().equals("Warszawa")).max(Company::compareILZakupiPraco) );
    }
    private static Company zad5( List<Company> firmy ){
        return firmy.stream().filter( cm -> cm.getCityHeadquarters().equals("Kijev") ).sorted(Company::compareTo).collect( toList() ).get(0);
    }
    private static Company zad6 ( List<Company> firmy){
        return firmy.stream().sorted(Company::porownDlNazwy).collect(toList()).get(0) ;
    }
    private static Company zad7 (List<Company> firmy){

        return firmy.stream().filter( t -> !t.getCityHeadquarters().equals("London") && !t.getCityHeadquarters().equals("Detroit") && !t.getCityHeadquarters().equals("Kijev") )
                .min( Company::compareIlZakup ).orElse((null));
    }
    private static void zad8( List<Company> firmy ){
        firmy.forEach( cmp -> {
            if (cmp.getCityHeadquarters().equals("Kijev") || cmp.getCityHeadquarters().equals("Detroit") ){
                cmp.setEmployees( cmp.getEmployees() + 1 );
            }
        } );
    }
    private static Map< String, Integer > zad9 ( List<Company> firmy){
        return firmy.stream().collect( Collectors.toMap( Company::getName, Company::getEmployees ));
    }
    private static Map< String, List<Company> > zad10 ( List<Company> firmy){

        Map<String, List<Company> > wynik = new HashMap<>();
        firmy.forEach(t -> {
            if ( wynik.containsKey(t.getCityHeadquarters()) ){
                List<Company> nowa = new LinkedList<>(  wynik.get(t.getCityHeadquarters())  );
                nowa.add(t);
                wynik.replace( t.getCityHeadquarters(), nowa );

            }else {
                wynik.put( t.getCityHeadquarters(), Arrays.asList(t) );
            }

        });
        return wynik;
    }
    private static Company zad11 (List<Company> firmy){
        Double maxymalnyZakup = firmy.stream().map( t -> t.getPurchaseList().stream().mapToDouble(zk -> zk.getProduct().getPrice()*zk.getQuantity()).sum() )
                .sorted(Double::compareTo).collect(toList()).get(firmy.size()-1);

        for (Company fr: firmy) {
            if ( fr.getPurchaseList().stream().mapToDouble(zk -> zk.getProduct().getPrice()*zk.getQuantity()).sum() ==
                    maxymalnyZakup ){
                return fr;
            }
        }
        return null;
    }
    private static Company zad12 (List<Company> firmy){
        Long ileZakupowPonad10000 = firmy.stream().map( t -> t.getPurchaseList().stream().mapToDouble(zk -> zk.getProduct().getPrice()*zk.getQuantity())
                .filter( wartoscZak -> wartoscZak > 10000 )
                .count() )
                .collect(toList()).get(firmy.size()-1) +1;

        for (Company fr: firmy) {
            if ( fr.getPurchaseList().stream().mapToDouble(zk -> zk.getProduct().getPrice()*zk.getQuantity())
                    .filter( wartoscZak -> wartoscZak > 10000 ).count() ==
                    ileZakupowPonad10000 ){

                System.out.println(ileZakupowPonad10000 + "  " + fr);
                //return fr;
            }
        }

        //second way of doing this
        Map<Company, Integer> wynik = new TreeMap<>();
        for (Company cmp : firmy) {
            wynik.put(cmp, cmp.getPurchaseList().stream().mapToInt( lz -> (lz.getQuantity() * lz.getProduct().getPrice() > 10000) ? (1) : (0) ).sum() );
        }
        //System.out.println( (int) wynik.values().toArray()[wynik.size()-1] ); //ile max zakupow > 10000 ma max firma

        return (Company) wynik.keySet().toArray()[wynik.size()-1] ;
    }
    private static String zad13 (List<Company> firmy){
        Map<String, Double> wynik = new LinkedHashMap<>();

        for (Company cmp : firmy) {
            Double sumaZakFirmy = cmp.getPurchaseList().stream()
                    .mapToDouble( lstZak -> lstZak.getQuantity() * lstZak.getProduct().getPrice() )
                    .sum();

            if ( wynik.containsKey(cmp.getCityHeadquarters()) ){
                wynik.replace( cmp.getCityHeadquarters(),  wynik.get(cmp.getCityHeadquarters()) , wynik.get(cmp.getCityHeadquarters()) + sumaZakFirmy );
            }else {
                wynik.put( cmp.getCityHeadquarters(), sumaZakFirmy );
            }
        }

        List<Map.Entry<String, Double>> listaMiastPosortowane = wynik.entrySet().stream().map( Map.Entry::getValue ).sorted( Double::compareTo )
                .map( wart -> wezEntryOdWart(wart, wynik) )
                .collect(Collectors.toList());

        System.out.println( listaMiastPosortowane.get(listaMiastPosortowane.size()-1).getValue() );
        return listaMiastPosortowane.get(listaMiastPosortowane.size()-1).getKey();
    }
    private static void zad14 (List<Company> firmy){

        firmy.stream()
                .filter( fir -> fir.getPurchaseList().stream()
                        .anyMatch( zak -> zak.getPurchaseDate().equals(LocalDate.of(2018,1,15))
                                && zak.getProduct().getName().equals("Network Switch") ) )
                .collect( Collectors.toList() ).forEach( System.out::println );

    }
    private static Company zad15(List<Company> firmy){
        return firmy.stream()
                .sorted( Company::compareIloscZakKawyPrzezDwieFirmy)
                .collect(Collectors.toList()).get(0);
    }
    private static double zad16(List<Company> firmy){
        return firmy.stream()
                .mapToDouble(fir -> fir.getPurchaseList().stream()
                        .filter( zak -> zak.getProduct().getName().equals("Coffee, Arabica") )
                        .mapToDouble( Purchase::getQuantity ).sum() )
                .sum();
    }
    private static double zad17(List<Company> firmy){
        return firmy.stream()
                .mapToDouble(fir -> fir.getPurchaseList().stream()
                        .filter( zak -> (zak.getProduct().getName().equals("Coffee, Arabica") || zak.getProduct().getName().equals("Coffee, Robusta")) && zak.getPurchaseDate().getDayOfMonth()%2==0 )
                        .mapToDouble( Purchase::getQuantity ).sum() )
                .sum();
    }
    private static Map<Product, Set<Company>> zad18 (List<Company> firmy){
        Set<Company> arabica = firmy.stream()
                .filter( fir -> fir.getPurchaseList().stream()
                        .anyMatch( zak -> zak.getProduct().getName().equals("Coffee, Arabica") ))
                .collect( Collectors.toSet() );

        Set<Company> robusta = firmy.stream()
                .filter( fir -> fir.getPurchaseList().stream()
                        .anyMatch( zak -> zak.getProduct().getName().equals("Coffee, Robusta") ))
                .collect( Collectors.toSet() );

        Product kawaArabica = arabica.iterator().next().getPurchaseList().stream()
                                .filter( zak -> !zak.getProduct().getName().equals("Coffee, Arabica") )
                                .map( Purchase::getProduct ).iterator().next();

        Product kawaRobusta = robusta.iterator().next().getPurchaseList().stream()
                .filter( zak -> !zak.getProduct().getName().equals("Coffee, Robusta") )
                .map( Purchase::getProduct ).iterator().next();

        return Map.of(kawaArabica, arabica, kawaRobusta, robusta);
    }
    private static Company zad19(List<Company> firmy){
        List<Company> teKupilyPaliw = firmy.stream()
                .filter( fir -> fir.getPurchaseList().stream()
                        .anyMatch( zak -> (zak.getProduct().getName().equals("Fuel, gasoline 95") || zak.getProduct().getName().equals("Fuel, oil"))
                                && zak.getPurchaseDate().getMonth().equals(Month.JANUARY) ) )
                .collect(Collectors.toList());

        return posortujPoNajwiecejZakupuPaliwa(teKupilyPaliw).get(0);
    }
    private static List<Company> posortujPoNajwiecejZakupuPaliwa( List<Company> teFirmyKupilyPaliwo ){
        List<Double> ilosciKupionegoPaliwa =
                teFirmyKupilyPaliwo.stream()
                .map( fir -> fir.getPurchaseList().stream()
                            .filter( zak -> zak.getPurchaseDate().getMonth().equals(Month.JANUARY) &&
                            (zak.getProduct().getName().equals("Fuel, gasoline 95") || zak.getProduct().getName().equals("Fuel, oil")) )
                            .mapToDouble( zak -> zak.getProduct().getPrice()*zak.getQuantity() ).sum())
                .collect(toList());

        Map<Company, Double> firmyIIlosciPaliw = new TreeMap<>();
        for (int i = 0; i < teFirmyKupilyPaliwo.size(); i++) {
            firmyIIlosciPaliw.put( teFirmyKupilyPaliwo.get(i), ilosciKupionegoPaliwa.get(i) );
        }

        return List.copyOf( firmyIIlosciPaliw.keySet() ) ;
    }
    private static Map.Entry<String, Double> wezEntryOdWart( Double wart, Map<String, Double> zrodlo ){
        for (Map.Entry<String, Double> poz: zrodlo.entrySet()) {
            if ( poz.getValue().equals(wart) ){
                return poz;
            }

        }
        return null;
    }
    private static Company zad20 (List<Company> firmy ){
        //daj firme z highest proportion wydatki / pracownicy
        return firmy.stream()
                .sorted(new Comparator<Company>() {
                    @Override
                    public int compare(final Company o1, final Company o2) {
                        double wydatki01 = o1.getPurchaseList().stream()
                                .mapToDouble( zak -> zak.getQuantity() * zak.getProduct().getPrice() ).sum();
                        double wydatki02 = o2.getPurchaseList().stream()
                                .mapToDouble( zak -> zak.getQuantity() * zak.getProduct().getPrice() ).sum();

                        return Double.compare( wydatki01 / o1.getEmployees() , wydatki02 / o2.getEmployees() )*-1;
                    }
                }).collect(Collectors.toList()).get(0);
    }
    private static Company zad21 (List<Company> firmy){
        //firma która max wydaje na art. biurowe (czyli poniżej:)
        List<String> artBiurowe = List.of( "Mug", "Pen", "Pencil", "Clip", "Puncher", "Paper", "Scisors", "Sugar", "Coffee, Arabica", "Coffee, Robusta" );

        return firmy.stream()
                .sorted(new Comparator<Company>() {
                    @Override
                    public int compare(final Company o1, final Company o2) {
                        double wydArtBiur01 = o1.getPurchaseList().stream()
                                .filter( zak -> artBiurowe.contains(zak.getProduct().getName()) )
                                .mapToDouble(zak -> zak.getQuantity() * zak.getProduct().getPrice() ).sum();

                        double wydArtBiur02 = o2.getPurchaseList().stream()
                                .filter( zak -> artBiurowe.contains(zak.getProduct().getName()) )
                                .mapToDouble(zak -> zak.getQuantity() * zak.getProduct().getPrice() ).sum();

                        return Double.compare(wydArtBiur01, wydArtBiur02)*-1;
                    }
                }).collect(toList()).get(0);
    }
    private static List<Company> zad22 (List<Company> firmy){
        //firmy posortowane po ilosc kasy za paliwo

        return firmy.stream()
                .sorted(new Comparator<Company>() {
                    @Override
                    public int compare(final Company o1, final Company o2) {
                        double zaPaliwo01 = o1.getPurchaseList().stream()
                                .filter(zak -> zak.getProduct().getName().contains("Fuel") )
                                .mapToDouble( zak -> zak.getProduct().getPrice() * zak.getQuantity() ).sum();
                        double zaPaliwo02 = o2.getPurchaseList().stream()
                                .filter(zak -> zak.getProduct().getName().contains("Fuel") )
                                .mapToDouble( zak -> zak.getProduct().getPrice() * zak.getQuantity() ).sum();

                        return Double.compare(zaPaliwo01, zaPaliwo02);
                    }
                }).collect(toList());
    }
    private static List<Product> zad23(List<Company> firmy){
        //daj produkty kupowane na kg

        return firmy.stream()
                .map( Company::getPurchaseList )
                .flatMap( listZak -> listZak.stream() )
                .filter( zak -> zak.getUnit().equals(UNIT.KILOGRAM) )
                .map( Purchase::getProduct )
                .collect(toList());
    }
    private static List<Purchase> zad24(List<Company> firmy){
        //daj liste zakupow kupionych przez tych z detroit z lutego i posortuj po kwocie
        return firmy.stream()
                .filter( fir -> fir.getCityHeadquarters().equals("Detroit") )
                .map( fir -> fir.getPurchaseList() )
                .flatMap( Collection::stream )
                .filter( zak -> zak.getPurchaseDate().getMonth().equals(Month.FEBRUARY) )
                .sorted(new Comparator<Purchase>() {
                    @Override
                    public int compare(final Purchase o1, final Purchase o2) {
                        double kwotao1 = o1.getQuantity() * o1.getProduct().getPrice();
                        double kwotao2 = o2.getQuantity() * o2.getProduct().getPrice();

                        return Double.compare(kwotao1, kwotao2);
                    }
                }).collect(toList());
    }
    private static int zad25(List<Company> firmy){
        //biura wynajete w lutym ile ich
        return (int) firmy.stream()
                .map(Company::getPurchaseList)
                .flatMap(Collection::stream)
                .filter(zak -> zak.getProduct().getName().equals("Office rent"))
                .filter(zak -> zak.getPurchaseDate().getMonth().equals(Month.FEBRUARY)).count();

    }
    private static Map<Company, Long> zad26 (List<Company> firmy){
        //mapa firm i ile wynajeli biur

        return firmy.stream()
                .filter(new Predicate<Company>() {
                    @Override
                    public boolean test(final Company fir) {
                        return fir.getPurchaseList().stream()
                                .filter(zak -> zak.getProduct().getName().equals("Office rent")).count() > 0;
                    }
                }).collect(Collectors.toMap( fir -> fir, fir -> fir.getPurchaseList().stream()
                .filter(zak -> zak.getProduct().getName().equals("Office rent")).count()  ));
    }
    private static void zad27 (List<Company> firmy){
        firmy.stream()
                .filter(fir -> fir.getPurchaseList().stream().anyMatch(zak -> zak.getProduct().getName().equals("Apple Phone")))
                .collect(Collectors.toMap(fir -> fir, fir -> fir.getPurchaseList().stream()
                        .filter(zak -> zak.getProduct().getName().equals("Apple Phone"))
                        .count() ))
                .entrySet().stream()
                    .sorted(new Comparator<Map.Entry<Company, Long>>() {
                        @Override
                        public int compare(final Map.Entry<Company, Long> o1, final Map.Entry<Company, Long> o2) {
                            Long ileO1 = o1.getValue();
                            Long ileO2 = o2.getValue();

                            return Long.compare(ileO1, ileO2);
                        }
                    })
                    .forEach( poz -> {
                    System.out.println("Nazwa Firmy: " + poz.getKey().getName() + " Ilośc zakupionych telefonów apple: " + poz.getValue());
                } );

    }
    private static Map<String, Integer> zad28(List<Company> firmy){
        //firmy z siedziba w > 1 miejscu

        final Map<String, Integer> wynik = new LinkedHashMap<>();

        firmy.stream()
                .collect( Collectors.groupingBy( fir -> fir.getName() ) )
                .entrySet().stream().collect(Collectors.toMap(nazFir -> nazFir.getKey(), nazFir -> nazFir.getValue().size() ))
                        .entrySet().stream()
                            .filter( poz -> poz.getValue()>1 )
                            .sorted(new Comparator<Map.Entry<String, Integer>>() {
                                @Override
                                public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {
                                    Integer o1IleSied = o1.getValue();
                                    Integer o2IleSied = o2.getValue();
                                    return Integer.compare(o1IleSied, o2IleSied);
                                }
                            })
                            .forEach( poz -> wynik.put(poz.getKey(), poz.getValue()) );

        return wynik;
    }
    private static double zad29(List<Company> firmy){
        //ile cukru przez Detroit Bakery
        return firmy.stream()
                .filter( firm -> firm.getName().equals("Detroit Bakery") )
                .map( Company::getPurchaseList )
                .flatMap( Collection::stream )
                .filter( zak -> zak.getProduct().getName().equals("Sugar") )
                .mapToDouble( zak -> zak.getQuantity() * ( (zak.getUnit().equals(UNIT.KILOGRAM)) ? (1) : (zak.getUnit().equals(UNIT.GRAM)) ? (0.001) : (0)) )
                .sum();
    }
    private static void zad30(List<Company> firmy){
        //zakupy solwita
        firmy.stream()
                .filter(firm -> firm.getName().equals("Solwit"))
                .map( Company::getPurchaseList )
                .flatMap( Collection::stream )
                .forEach( System.out::println );

    }
    private static List<Product> zad31(List<Company> firmy){
        //produkty tańsze niż 3$
        return firmy.stream()
                .map( Company::getPurchaseList )
                .flatMap( Collection::stream )
                .map( Purchase::getProduct )
                .distinct()
                .filter( prod -> prod.getPrice()<3 )
                .collect(toList());
    }
    private static double zad32(List<Company> firmy){
        //ile sprzedano najtańszego produkt

        List<Purchase> produktyPosortowane = firmy.stream()
                .map( Company::getPurchaseList )
                .flatMap( Collection::stream )
                .sorted(new Comparator<Purchase>() {
                    @Override
                    public int compare(final Purchase o1, final Purchase o2) {
                        double cenaO1 = o1.getProduct().getPrice();
                        double cenaO2 = o2.getProduct().getPrice();

                        return Double.compare(cenaO1, cenaO2);
                    }
                })
                .collect(toList());

        return produktyPosortowane.stream()
                .filter( prod -> prod.getProduct().getPrice() == produktyPosortowane.get(0).getProduct().getPrice() )
                .mapToDouble( zak -> zak.getQuantity() ).sum();
    }
    private static double zad33(List<Company> firmy){
        //ile srednio pala benzyny te z Take Me Home

        int iloscAut = (int) firmy.stream()
                .filter(fir -> fir.getName().equals("Take me home"))
                .map(Company::getPurchaseList)
                .flatMap(Collection::stream)
                .filter(zak -> zak.getProduct().getName().contains("Fiat") || zak.getProduct().getName().equals("Skoda Octavia")
                        || zak.getProduct().getName().equals("Audi A4") || zak.getProduct().getName().equals("Ford mustang")).count();

        double ilePaliwaZaku = firmy.stream()
                .filter(fir -> fir.getName().equals("Take me home"))
                .map(Company::getPurchaseList)
                .flatMap(Collection::stream)
                .filter(zak -> zak.getProduct().getName().contains("Fuel") )
                .mapToDouble( Purchase::getQuantity ).sum();

        return ilePaliwaZaku / iloscAut;
    }
    private static Company zad34(List<Company> firmy){
        //the most coffee
        return firmy.stream()
                .filter( fir -> fir.getPurchaseList().stream().anyMatch( zak -> zak.getProduct().getName().contains("Coffee")) )
                .sorted(new Comparator<Company>() {
                    @Override
                    public int compare(final Company o1, final Company o2) {
                        double ileKawyo1 = o1.getPurchaseList().stream()
                                            .filter( zak -> zak.getProduct().getName().contains("Coffee") )
                                            .mapToDouble(Purchase::getQuantity).sum();
                        double ileKawyo2 = o2.getPurchaseList().stream()
                                .filter( zak -> zak.getProduct().getName().contains("Coffee") )
                                .mapToDouble(Purchase::getQuantity).sum();

                        return Double.compare(ileKawyo1, ileKawyo2)*-1;
                    }
                }).collect(Collectors.toList()).get(0);
    }




// Polecenie 1:
// Dane to Firmy oraz ich zakupy z miesiąca styczeń/luty 2018.

// Wszystkie rozwiązania zapisz w oddzielnych metodach statycznych w klasie Main.
// 1. Wylistuj (system out println) wszystkie firmy
//        company_1_wylistuj(companies);

// 2. Wylistuj wszystkie firmy które są z Detroit
// 3. Wylistuj wszystkie firmy z Londynu, posortuj je po ilości pracowników (rosnąco).
// 4. Wylistuj wszystkie firmy z Warszawy. Posortuj je po ilości zakupów (rosnąco) i ilości pracowników (malejąco).
// 5. Zwróć firmę z największą ilością pracowników, która pochodzi z Kijowa.
// 6. Zwróć firmę z najkrótszą nazwą
// 7. Zwróć firmę która nie pochodzi z Kijowa, Londynu i Detroit, która ma najmniej kupionych produktów.
// 8. Każdej firmie dodaj po 1 pracowniku, jeśli pochodzi z Kijowa lub Detroit
// 9. ** Zwróć MAPĘ w której kluczem jest nazwa firmy, a wartością ilość pracowników w tej firmie (https://howtodoinjava.com/java8/collect-stream-to-map/)
// 10.** Zwróć Mapę w której kluczem jest miejscowość a wartością jest LISTA FIRM z tamtej miejscowości (Map<String, List<Company>) (https://stackoverflow.com/questions/24917053/collecting-hashmapstring-liststring-java-8)
// 11. Zwróć firmę która dokonała zakupów na największą kwotę
//        company_11_zakupy_najwieksze(companies);
// 12. Zwróć firmę która kupiła najwięcej produktów za kwotę wyższą niż 10 k
//        company_12_zakupy_10k(companies);
// 13. *Zwróć miejscowość która wydała najwięcej pieniędzy. Stwórz mapę Map<String, Double> gdzie kluczem jest miejscowość, a wartością jest kwota wydana przez firmy pochodzące z tamtej miejscowości
//        company_13_najwiecej_hajsu(companies);
// 14. Wypisz firmy które 15 stycznia 2018 kupiły "Network Switch"
//        company_14_network(companies);
// 15. Znajdź firmę która kupuje najwięcej kawy

// 16. Wypisz ile łącznie zostało kupionej kawy Arabica w miesiącu styczniu
//        company_16_arabica_january(companies);
// 17. Wypisz ile łącznie kawy (Arabica i Roubsta) zostało kupionej w dni parzyste.
//        company_17_arabica_robusta_even(companies);
// 18. Zwróć Mapę (Map<Product, Set<Company>>) w której kluczem jest typ kawy (powinny być dwie, Arabica i Robusta) i wartością są listy firm które kupiły podaną kawę chociaż raz.
//        company_18_mapa_kaw(companies);
// 19. Zwróć firmę która w styczniu kupiła najwięcej paliwa (ropy)
//        company_19_most_oil_january(companies);
// 20. Zwróć firmę której proporcja wydanych pieniędzy do ilości pracowników jest najwyższa
//        company_20_money_vs_employees(companies);
// 21. Zwróć firmę która najwięcej wydaje na artykuły biurowe
//        company_21_most_sheeets(companies);
// 22. Zwróć firmy posortowane po ilości wydanych pieniędzy na paliwo
//        company_22_sort_money(companies);
// 23. Zwróć wszystkie produkty które kupione były na kilogramy
//        company_23_wszystkie_produkty_na_kilogramy(companies);
// 24. Zwróć listę zakupów (obiektów purchase) kupionych przez firmy z Detroit w miesiącu lutym. posortuj je po kwocie.
//        company_24_detroit_shopping_in_february(companies);
// 25. Zwróć ilość biur które wynajęte były w miesiącu lutym.
//        company_25_rent_in_february(companies);
// 26. Zwróć Mapę (Map<Company, Integer>). w mapie umieść wpisy Firma - > ilość biur które wynajęły w dowolnym okresie.
//        company_26_company_and_offices(companies);
// 27. *Wypisz "Nazwa firmy: XYZ, ilość zakupionych telefonów apple: X" dla każdej firmy która kupiła telefon apple. Wypisy powinny być posortowane (na szczycie powinna być firma która kupiła ich najwięcej).
//        company_27_apple_lovers(companies);
// 28. Znajdź firme która posiada siedzibę w więcej niż jednym mieście. Posortuj firmy po ilości siedzib, wypisz tylko te które mają więcej niż 1 siedzibę.
//        company_28_rich_multi_city_companies(companies);
// 29. Wypisz ilość kilogramów cukru zużywaną przez "Detroit Bakery"
//        company_29_detroit_bakery(companies);
// 30. Wypisz wszystkie zakupy firmy "Solwit".
    //company_30_solwit_shopping(companies);
// 31. Wypisz wszystkie produkty które są tańsze (jednostkowo) niż 3$.
// 32. Wypisz ile sprzedano najtańszego produktu
// 33. Firma "Take me home" zajmuje się transportem. Na początku działalności kupiła wiele samochodów do użytku. Oblicz ile litrów paliwa (średnio) spalają ich samochody (zakładamy że wszystkie palą benzynę i że tankowane są wszystkie.
// 34. Wypisz firmę która zużywa najwięcej kawy
// 35. Wypisz firmę która zużywa najwięcej na papier.
// 36. Wypisz wszystkie produkty które były kupowane w większych ilościach niż 50 (jednostek/kilogramów)
// 37. Wypisz ile każda z firm zużywa na kawę (ile pieniędzy wydaje) (jako wynik zwróć mapę Map<String, Double> gdzie kluczem jest nazwa firmy, wartością jest ilość pieniędzy wydawanej na kawę
// 38. Wypisz średnie zużycie kawy na pracownika (wypisz w postaci proporcji. Jeśli firma kupiła 30 kilogramów i ma 20 pracowników to ma 1.5 kg / pracownika [w całości okresu])
// 39. Wypisz jaki produkt poza paliwem cieszy się największą popularnością (zwróć go) (find first)
// 40. Znajdź produkty które były kupowane zarówno w kilogramach jak i w sztukach
// 40. Wymyśl 5 ciekawych zapytań i spróbuj je zrealizować.




}
