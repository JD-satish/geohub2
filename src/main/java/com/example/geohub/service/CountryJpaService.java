/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.geohub.service;

import java.util.*;
import com.example.geohub.model.*;
import com.example.geohub.repository.*;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CountryJpaService implements CountryRepository {

    @Autowired
    public CountryJpaRepository countryRepository;

    @Override
    public ArrayList<Country> getCountries() {
        List<Country> countriesList = countryRepository.findAll();
        ArrayList<Country> countries = new ArrayList<>(countriesList);

        return countries;
    }

    @Override
    public Country getCountryById(int countryId) {
        try {
            return countryRepository.findById(countryId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country addCountry(Country country) {
        countryRepository.save(country);
        return country;
    }

    @Override
    public Country updateCountry(int countryId, Country country) {
        try {
            Country newCountry = countryRepository.findById(countryId).get();
            if (country.getCountryName() != null) {
                newCountry.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                newCountry.setCurrency(country.getCurrency());
            }
            if (country.getPopulation() != 0) {
                newCountry.setPopulation(country.getPopulation());
            }
            if (country.getLatitude() != null) {
                newCountry.setLatitude(country.getLatitude());
            }
            if (country.getLongitude() != null) {
                newCountry.setLongitude(country.getLongitude());
            }
            countryRepository.save(newCountry);
            return newCountry;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCountry(int countryId) {
        try {
            countryRepository.deleteById(countryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}

/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here