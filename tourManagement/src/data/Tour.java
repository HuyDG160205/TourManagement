/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Gia Huy
 */
public class Tour {
    private String tourId;
    private String tourName;
    private String tourDestination;
    private int tourDuration;
    private String description;
    private double price;
    private String inclusions;
    private String exclusions;

    public Tour(String tourId, String tourName, String tourDestination, int tourDuration, String description, double price, String inclusions, String exclusions) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourDestination = tourDestination;
        this.tourDuration = tourDuration;
        this.description = description;
        this.price = price;
        this.inclusions = inclusions;
        this.exclusions = exclusions;
    }

    public String getTourId() {
        return tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public String getTourDestination() {
        return tourDestination;
    }

    public int getTourDuration() {
        return tourDuration;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getInclusions() {
        return inclusions;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public void setTourDestination(String tourDestination) {
        this.tourDestination = tourDestination;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInclusions(String inclusions) {
        this.inclusions = inclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }
    
    

    @Override
    public String toString() {
        return tourId + ", " + tourName + ", " + tourDestination + ", " + tourDuration + ", " + description + ", " + price + ", " + inclusions + ", " + exclusions;
    }
    
    public void showInFor(){
        System.out.println(tourId + ", " + tourName + ", " + tourDestination + ", " + tourDuration + ", " + description + ", " + price + ", " + inclusions + ", " + exclusions);
    }
    
    
}
