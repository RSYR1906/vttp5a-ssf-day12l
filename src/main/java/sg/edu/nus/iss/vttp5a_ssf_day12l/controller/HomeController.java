package sg.edu.nus.iss.vttp5a_ssf_day12l.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Using @Controller since I am returning HTML pages
@RequestMapping("/home")
public class HomeController {

    @GetMapping(path = { "", "/landing" })
    public String index(Model model) {
        model.addAttribute("currTime", (new Date()).toString());

        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));
        return "home";

    }

}
