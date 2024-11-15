package sg.edu.nus.iss.vttp5a_ssf_day12l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_ssf_day12l.model.Country;
import sg.edu.nus.iss.vttp5a_ssf_day12l.service.CountryService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    CountryService countryService;

    @GetMapping("")
    public String weather(@RequestParam(required = true, name = "country") String city,
            @RequestParam(name = "metrics", defaultValue = "centimeters") String metric, Model model) {

        model.addAttribute("city", city);
        model.addAttribute("metrics", metric);

        return "weather";
    }

    @GetMapping(path = { "/city/{country}/metrics/{metrics}", "/{country}/{metrics}" })
    public String weather2(@PathVariable(required = true, name = "country") String city,
            @PathVariable(name = "metrics") String metric, Model model) {

        model.addAttribute("city", city);
        model.addAttribute("metrics", metric);

        return "weather";
    }

    @GetMapping("/pagea")
    public String pageA(Model model) {
        String[] units = { "millimiter", "centimeter", "meter", "kilometer" };
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("metrics", units);
        return "pagea";
    }

    @GetMapping("/forma")
    public String showForm() {
        return "forma";
    }

    @PostMapping("/forma")
    public String handlePageA(@RequestBody MultiValueMap<String, String> form) {

        // Map<String, String> formData = new HashMap<>();

        for (String str : form.keySet()) {
            // formData.put(str, form.getFirst(str));
            System.out.println(str + ">>> " + form.getFirst(str));
        }

        return "forma";
    }

}