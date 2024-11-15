package sg.edu.nus.iss.vttp5a_ssf_day12l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_ssf_day12l.model.Country;
import sg.edu.nus.iss.vttp5a_ssf_day12l.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public String displayCountriesList(Model model) {
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        return "countrylist";
    }

    @GetMapping("/filterCountries")
    public String filterCountries(@RequestParam(name = "countryPopulation") String population, Model model) {

        // Filter countries based on population threshold
        List<Country> countries = countryService.getCountries()
                .stream()
                .filter(country -> country.getPopulation() == Integer.parseInt(population))
                .collect(Collectors.toList());

        // Add the filtered countries list to the model
        model.addAttribute("countries", countries);

        // Return the view name
        return "countrylist";
    }
}