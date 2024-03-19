package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        for(City city: array){
            System.out.println(city);
        }

    }
}