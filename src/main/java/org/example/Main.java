package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        String id;
        String name;
        String region;
        String district;
        String population;
        String foundation;

        ArrayList<City> array = new ArrayList<>();
        File file = new File("C:\\Users\\moroz\\Downloads\\Задача ВС Java Сбер.csv");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(";|\r");

        while(scanner.hasNext()){
             id = scanner.next();
             name = scanner.next();
             region = scanner.next();
             district = scanner.next();
             population = scanner.next();
             foundation = scanner.next();
             array.add(new City(name, region, district, population, foundation));
        }
        sortByName(array);
        sortByNameAndDistrict(array);
    }
    public static void sortByName(ArrayList<City> array){
        Collections.sort(array, new Comparator<City>(){
            @Override
            public int compare(City o1, City o2) {

                if( o1.getName().compareTo(o2.getName()) != 0){
                    return o1.getName().compareTo(o2.getName());
                }
                return 0;
            }
        });
        for(City city: array){

            System.out.println(city);
        }
    }

    public static void sortByNameAndDistrict(ArrayList<City> array){
        Collections.sort(array, new Comparator<City>(){
            @Override
            public int compare(City o1, City o2) {

                if( o1.getDistrict().compareTo(o2.getDistrict()) != 0){
                    return o1.getDistrict().compareTo(o2.getDistrict());
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        for(City city: array){

            System.out.println(city);
        }
    }
}