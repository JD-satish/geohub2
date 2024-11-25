/*
 *
 * You can use the following import statements
 * 
 * java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.geohub.repository;

import com.example.geohub.model.*;
import java.util.*;

public interface CountryRepository {
    ArrayList<Country> getCountries();

    Country getCountryById(int countryId);

    Country addCountry(Country coountry);

    Country updateCountry(int countryId, Country country);

    void deleteCountry(int countryId);
}

/*
 *
 * You can use the following import statements
 * 
 * java.util.ArrayList;
 * 
 */

// Write your code here