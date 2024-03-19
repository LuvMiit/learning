package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        System.out.println(groupByRegion(array));
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

    public static String maxValuePopulation(ArrayList<City> array){
        int maxValue = 0;
        int index = 0;
        int myIndex = 0;
        for(City city: array){

            if(Integer.parseInt(city.getPopulation()) > maxValue){
                maxValue = Integer.parseInt(city.getPopulation());
                myIndex = index;
            };
            ++index;
        }
        if (maxValue == 0){
            return "ОШИБКА";
        }
        return "[" + myIndex + "]" + "=" + maxValue;
    }
    public static HashMap<String, Integer> groupByRegion(ArrayList<City> array){
        HashMap<String, Integer> regionsMap = new HashMap<>();
        for(City element: array){
            if (regionsMap.get(element.getRegion()) != null){
                //Увеличиваем количество городов если есть какое-то значние
                int value = regionsMap.get(element.getRegion());
                value++;
                regionsMap.put(element.getRegion(), value);
            }else{// Добавляем в мап и значение 1, так как одна запись уже точно есть
                regionsMap.put(element.getRegion(), 1);
            }
        }
        return regionsMap;
    }
}