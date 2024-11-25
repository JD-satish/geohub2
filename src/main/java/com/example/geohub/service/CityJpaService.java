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

import com.example.geohub.model.*;
import com.example.geohub.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.http.HttpStatus;

@Service
public class CityJpaService implements CityRepository {
    @Autowired
    public CityJpaRepository cityRepository;

    @Autowired
    public CountryJpaRepository countryRepository;

    @Override
    public ArrayList<City> getCities() {
        List<City> citiesList = cityRepository.findAll();
        ArrayList<City> cities = new ArrayList<>(citiesList);
        return cities;
    }

    @Override
    public City getCityById(int cityId) {
        try {
            return cityRepository.findById(cityId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCity(int cityId) {
        try {
            cityRepository.deleteById(cityId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public City addCity(City city) {
        try {
            Country country = city.getCountry();
            int countryId = country.getCountryId();
            Country newCountry = countryRepository.findById(countryId).get();
            city.setCountry(newCountry);
            cityRepository.save(city);
            return city;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City updateCity(int cityId, City city) {
        try {
            City newCity = cityRepository.findById(cityId).get();
            if (city.getCityName() != null) {
                newCity.setCityName(city.getCityName());
            }
            if (city.getPopulation() != 0) {
                newCity.setPoplupation(city.getPopulation());
            }
            if (city.getLatitude() != null) {
                newCity.setLatitude(city.getLatitude());
            }
            if (city.getLongitude() != null) {
                newCity.setLongitude(city.getLongitude());
            }
            if (city.getCountry() != null) {
                Country country = city.getCountry();
                int countryId = country.getCountryId();
                Country newCountry = countryRepository.findById(countryId).get();
                newCity.setCountry(newCountry);
            }
            return newCity;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country getCityCountry(int cityId) {
        try {
            City city = cityRepository.findById(cityId).get();
            return city.getCountry();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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