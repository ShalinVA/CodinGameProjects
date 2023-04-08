package Defibrillators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double userLongitude = Double.parseDouble(in.nextLine().replace(",", "."));
        double userLatitude = Double.parseDouble(in.nextLine().replace(",", "."));
        List<Defibrillator> defibrillators = new ArrayList<>();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String[] defib = in.nextLine().split(";");
            Defibrillator defibrillator = new Defibrillator(Integer.parseInt(defib[0]), defib[1], defib[2], defib[3],
                    Double.parseDouble(defib[4].replace(",", ".")),
                    Double.parseDouble(defib[5].replace(",", ".")));

            defibrillators.add(defibrillator);
        }

        Defibrillator nearestDef = null;
        double minDistance = Double.MAX_VALUE;

        for (Defibrillator defibrillator : defibrillators) {
            double resultCalculation = calculation(userLongitude, userLatitude,
                    defibrillator.getLongitude(), defibrillator.getLatitude());
            if (defibrillator.getName().equals("Cimetiere Saint-Etienne") ||
                    defibrillator.getName().equals("Gymnase Albert Batteux")) {
                System.out.println(resultCalculation);

            }

            if (minDistance > resultCalculation) {
                minDistance = resultCalculation;
                nearestDef = defibrillator;
            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(Objects.requireNonNull(nearestDef).getName());
    }

    public static double calculation(double userLongitude, double userLatitude,
                                     double defLongitude, double defLatitude) {
        double x = (defLongitude - userLongitude) * Math.cos((userLatitude + defLatitude) / 2);
        double y = defLatitude - userLatitude;
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 6371;
    }
}

class Defibrillator {
    private final int id;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final double longitude;
    private final double latitude;

    public Defibrillator(int id, String name, String address, String phoneNumber, double longitude, double latitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
