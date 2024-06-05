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
    
    
    
    //
    public void addNewTour(){
        String id = Inputter.getString("Please input a tourId", 
                    "This field is required");
        boolean isDup;
        do{
            
            isDup = false;//tin rằng là chưa trùng
        }while(isDup);//con trùng thì còn làm
    }
}
