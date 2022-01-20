package com.peacksoft;

import com.peacksoft.db.City;
import com.peacksoft.db.Country;
import com.peacksoft.db.Mayors;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Country>countries=new ArrayList<>();
        ArrayList<City>cities=new ArrayList<>();
        ArrayList<Mayors>mayors=new ArrayList<>();

        countries.add(Country.printCountry());
        cities.add(City.printCity());
        mayors.add(Mayors.printMayors());
    }
}
