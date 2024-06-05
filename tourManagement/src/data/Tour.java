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
    
    
    
}
