package sg.edu.nus.iss.vttp5a_ssf_day12l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_ssf_day12l.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
    List<Student> students = new ArrayList<>();

    @GetMapping("/studentlist")
    public String getStudentList(Model model) throws ParseException {

        students = new ArrayList<>();

        String dob = "18 Dec 1999 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDob = dDob.getTime();

        Student s1 = new Student(1, "Damien", "Cumming", epochDob, "damien@nus.edu.sg", "25 HMKT 119615");
        Student s2 = new Student(2, "Jack", "Daniels", epochDob, "jack@nus.edu.sg", "30 HMKT 119615");
        Student s3 = new Student(3, "Lily", "James", epochDob, "lily@nus.edu.sg", "11 HMKT 119615");
        Student s4 = new Student(4, "Sophia", "Turner", epochDob, "sophia@nus.edu.sg", "22 HMKT 119616");
        Student s5 = new Student(5, "Ethan", "Hunt", null, "ethan@nus.edu.sg", "18 HMKT 119617");
        Student s6 = new Student(6, "Mia", "Williams", null, "mia@nus.edu.sg", "7 HMKT 119618");
        Student s7 = new Student(7, "Lucas", "Brown", epochDob, "lucas@nus.edu.sg", "12 HMKT 119619");
        Student s8 = new Student(8, "Ava", "Wilson", null, "ava@nus.edu.sg", "5 HMKT 119620");
        // Add students to the list
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);

        model.addAttribute("students", students);

        return "studentlist";
    }
}
