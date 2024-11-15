package sg.edu.nus.iss.vttp5a_ssf_day12l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day12l.model.Country;

@Repository
public class CountryRepo {

    private List<Country> countryList = new ArrayList<>(); // Initialize once

    public List<Country> getCountries() {
        // Check if list is empty before adding countries
        if (countryList.isEmpty()) {
            // Only add countries if the list is empty
            addDefaultCountries();
        }

        return countryList;
    }

    private void addDefaultCountries() {
        Country city = new Country("SG", "Singapore", 6000000);
        countryList.add(city);

        city = new Country("IL", "Israel", 10000000);
        countryList.add(city);

        city = new Country("CN", "China", 100000000);
        countryList.add(city);

        city = new Country("HK", "Hong Kong", 7000000);
        countryList.add(city);
    }

    public Boolean createCountry(Country city) {
        return countryList.add(city); // Add the country and return the result
    }
}