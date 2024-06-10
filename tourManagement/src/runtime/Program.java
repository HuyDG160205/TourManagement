/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import data.TourManagement;

/**
 *
 * @author Gia Huy
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "C:\\Users\\Gia Huy\\Documents\\GitHub\\TourManagement\\tourManagement\\Tour.txt";
        String url2 = "C:\\Users\\Gia Huy\\Documents\\GitHub\\TourManagement\\tourManagement\\Hotel.txt";
        TourManagement TourList = new TourManagement();
        TourList.loadFromFile(url);
        
        TourList.addNewTour();
        TourList.showTourList();
        TourList.updateTour();
        
        
    }
    
}
