package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines the city object.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * Constructs a City with the given city name and province
     * @param city
     *      the name of the city
     * @param province
     *      the province where the city is located
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;

    }

    /**
     * Returns the name of the city
     * @return
     *      the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the province of the city
     * @return
     *      the province name
     */
    public String getProvince() {
        return province;
    }

    /**
     * Compares this City to another City based on city name
     * @param
     *      o other City to compare to
     * @return
     *      a negative integer, zero, or a positive integer as this city's name is less than, equal
     *      to, or greater than the other city's name
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCity());
    }

    /**
     * Checks if other object is equal to this one
     * Two City objects are only equal if both the city and province fields are equal
     * @param
     *      o the object to compare with
     * @return
     *      true if this object is equal to the given object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(getCity(), city.getCity()) && Objects.equals(getProvince(), city.getProvince());
    }

    /**
     * Returns a hash code value for this City based on the city and province strings
     * @return a hash code for this City
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getProvince());
    }
}
