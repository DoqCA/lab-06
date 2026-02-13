package com.example.listycity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns true if a city is or false if a city isn't in the cities list respectively.
     * @param city
     *      City to check for belonging
     * @return
     *      Return boolean for cities.contains(city)
     */
    public boolean hasCity(City city) {
        // Little confused about this function from the instructions as its just a wrapper for contains but yeah
        return cities.contains(city);
    }

    /**
     * This deletes a city if the city exists in the list
     * @param city
     *      This is the candidate city
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns the number of items in cities list
     * @return
     *      Return the number of items in cities
     */
    public int getCount() {
        return cities.toArray().length;
    }

}
