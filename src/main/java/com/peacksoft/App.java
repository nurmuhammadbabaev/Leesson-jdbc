package com.peacksoft;

import com.peacksoft.db.City;
import com.peacksoft.db.Country;
import com.peacksoft.db.Mayors;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
   static Scanner scanner=new Scanner(System.in);
   static int number=0;
   static String information=null;
   static Date date=null;
    public static void main( String[] args ) {

        ArrayList<Country>countries=new ArrayList<>();
        ArrayList<City>cities=new ArrayList<>();
        ArrayList<Mayors>mayors=new ArrayList<>();
        System.out.println("Выберите таблицу!");
        while (true){
            System.out.println("1-Country, 2-City, 3-Mayors ,0-break!");
        number= scanner.nextInt();
        if(number==1){
            countries.add(Country.printCountry());
            System.out.println("Хотите добавить информацию для для Country?" +
                    "\nесли да то нжмите 1 если нет то нажмите 0");
            number= scanner.nextInt();
            if(number==1){
                System.out.println("Добавьте информацию для таблицы Country:");
                System.out.println("1.countryName(String)\t|"+"2.countryArea(String)\t|"+"3.population(int)\t|"+"4.countryAge(int)\t|");
                Country.addCountry(information= scanner.next()+"\t",information= scanner.next()+"\t",number=scanner.nextInt(),number=scanner.nextInt());
                countries.add(Country.printCountry());
            }
            else {
                System.err.println("Вы не добавили информацию!");
            }
        }else if(number==2){
            cities.add(City.printCity());
            System.out.println("Хотите добавить информацию для для City?" +
                    "\nесли да то нжмите 1 если нет то нажмите 0");
            number= scanner.nextInt();
            if(number==1){
                System.out.println("Добавьте информацию для таблицы City:");
                System.out.println("1.cityName(String)\t|"+"2.cityArea(String)\t|"+"3.population(int)\t|"+"4.CountryOfThisCity(String)\t|");
                City.addCity(information= scanner.next()+"\t",information= scanner.next()+"\t",number=scanner.nextInt(),information=scanner.next());
                cities.add(City.printCity());
            }
            else {
                System.err.println("Вы не добавили информацию!");
            }
        }else if(number==3){
            mayors.add(Mayors.printMayors());
            System.out.println("Хотите добавить информацию для для Mayors?" +
                    "\nесли да то нжмите 1 если нет то нажмите 0");
            number= scanner.nextInt();
            if(number==1){
                System.out.println("Добавьте информацию для таблицы Mayors:");
                System.out.println("1.fist_name(String)\t|\t"+"2.last_name(String)\t|\t"+"3.data_birth_day(Date)\t|\t"+"4.nationality(String)\t|");
                Mayors.addMayors(information= scanner.next()+"\t",information= scanner.next()+"\t",date= Date.valueOf(scanner.next()),information=scanner.next());
                mayors.add(Mayors.printMayors());
            }
            else {
                System.err.println("Вы не добавили информацию!");
            }
        }else if(number==0){
            System.err.println("Вы вышли из программы!");break;
        }
        else {
            System.err.println("Нет такой таблицы!");
        }

    }
    }
}
