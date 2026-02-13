package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        // cityList is instantiated with Edmonton Alberta.
        CityList cityList = mockCityList();

        // Checking if Edmonton Alberta is in the list
        City city0 = new City("Edmonton", "Alberta");

        // Checking combinations of city matching and province matching
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Edmonton", "Calgary");
        City city3 = new City("Vancouver", "BC");

        assertTrue(cityList.hasCity(city0));
        assertFalse(cityList.hasCity(city1));
        assertFalse(cityList.hasCity(city2));
        assertFalse(cityList.hasCity(city3));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city0 = new City("Edmonton", "Alberta");

        cityList.delete(city0);
        assertFalse(cityList.hasCity(city0));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city0 = new City("Calgary", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city0);
        });
    }

    @Test
    void testGetCount() {
        CityList cityList = mockCityList();
        City city0 = new City("Edmonton", "Alberta");
        City city1 = new City("Calgary", "Alberta");

        assertEquals(1, cityList.getCount());

        cityList.add(city1);
        assertEquals(2, cityList.getCount());

        cityList.delete(city0);
        cityList.delete(city1);
        assertEquals(0, cityList.getCount());
    }
}
