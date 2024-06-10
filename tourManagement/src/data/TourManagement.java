/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import utils.Inputter;

/**
 *
 * @author Gia Huy
 */
public class TourManagement {
    ArrayList<Tour> tourList = new ArrayList<>();
    
    public boolean loadFromFile(String url){
        File f = new File(url);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line != null){
                StringTokenizer st = new StringTokenizer(line, ",");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String destination = st.nextToken().trim();
                int duration = Integer.parseInt(st.nextToken().trim());
                String desc = st.nextToken().trim();
                double price = Double.parseDouble(st.nextToken().trim());
                String inclusions = st.nextToken().trim();
                String exclusions = st.nextToken().trim();
                
                tourList.add(new Tour(id, name, destination, duration, 
                            destination, price, inclusions, exclusions));
                
                line = reader.readLine();
            }
            return true;
        }catch(Exception e){
            System.out.println("Load from file failed: " + e);
            return false;
        }
    }
    
    //hàm search
    public int searchIndexById(String keyId){
        for(int i =0; i<= tourList.size() -1; i++){
            if(tourList.get(i).getTourId().equalsIgnoreCase(keyId)){
                return i;
            }
        }
        return -1;
    }
    
    public Tour searchTourById(String keyId){
        int pos = searchIndexById(keyId);
        
        Tour newT = pos == -1? null : tourList.get(pos);
        return newT;
    }
    
    public int searchDestinationById(String keyId){
        for(int i = 0; i <= tourList.size() - 1 ;i++){
            if(tourList.get(i).getTourDestination().equalsIgnoreCase(keyId) ||
               tourList.get(i).getTourDuration() == Integer.parseInt(keyId)||
               tourList.get(i).getPrice() == Double.parseDouble(keyId)){
                return i;
            }
        }
        return -1;
    }
    
    
    //
    public void addNewTour(){
        String id;
        boolean isDup;
        do{
            isDup = false;//tin rằng là chưa trùng
            id = Inputter.getString("Please input a tourId", 
                    "This field is required");
            int pos = searchIndexById(id);
            if(pos != -1){//pos != -1 thì bị trùng
                System.out.println("TourId already existed");
                isDup = true;
            }
        }while(isDup);//con trùng thì còn làm
        String name = Inputter.getString("Input tour name", 
                    "This field is required");
        String destination = Inputter.getString("Input destination: ", 
                "This field is required");
        int duration = Inputter.getAnInteger("Input duration: ", 
                "During must be higher than 0", 0, 100);
        String description = Inputter.getString("Input Tour description: ", "This field is required");
        double price = Inputter.getADouble("Input price", 
                "Price must be higher than 0", 0, Math.pow(2,50));
        String inclusions = Inputter.getString("Input inclusions: ", 
                "This field is required");
        String exclusions = Inputter.getString("Input exclusions: ", 
                "This field is required");
        
        tourList.add(new Tour(id, name, destination, duration, 
                description, price, inclusions, exclusions));
    }
    
    //update tour by destination, duration, or price
    public void updateTour(){
        String keyid = Inputter.getString("Please Input destination,duration or price", "This field is required");
        
        int pos = searchDestinationById(keyid);
        
        Tour tou = pos == -1? null : tourList.get(pos);
        
        if(tou == null){
            System.out.println("Tour does not found");
            return;
        }else{
            System.out.println("Tour information");
            tou.showInFor();
            System.out.println("Updating...");
            String name = Inputter.getString("Please input new name", "This field is required");
            String destination = Inputter.getString("Please input new destination", "This field is required");
            int duration = Inputter.getAnInteger("Please input duration", "Duration must be int");
            String description = Inputter.getString("Please input new description", "This field is required");
            double price = Inputter.getADouble("Please input price", "Price must be higher than 0", 0, Math.pow(2,50)-1);
            String inclusions = Inputter.getString("Please input new inclusions", "This field is required");
            String exclusions = Inputter.getString("Please input new exclusions", "This field is required");
            
            tou.setTourName(name);
            tou.setTourDestination(destination);
            tou.setTourDuration(duration);
            tou.setDescription(description);
            tou.setPrice(price);
            tou.setInclusions(inclusions);
            tou.setExclusions(exclusions);
        }
    }
    
    //show tour
    public void showTourList(){
        if(tourList.isEmpty()){
            System.out.println("Tour is empty");
            return;
        }
        for (Tour tour : tourList) {
            tour.showInFor();
        }
    }
    //remove tour
    public void removeTour(){
        String keyId = Inputter.getString("Please input tourId to remove", "This field is required");
        
        int pos = searchIndexById(keyId);
        
        if(pos == -1){
            System.out.println("Tour does not exist");
            return;
        }else{
            System.out.println("Tour Information: Before removing:");
            tourList.get(pos).showInFor();
            if(Inputter.getString("Do you want to remove this? (Y/N)", "This field is required").equalsIgnoreCase("Y")){
                tourList.remove(pos);
                System.out.println("Remove successful"); 
            }
        }
    }
    
    
}
