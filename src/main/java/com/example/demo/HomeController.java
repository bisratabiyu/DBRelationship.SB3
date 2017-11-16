package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepositor employeeRepository;
    @Autowired
    LaptopRepositor laptopRepository;

    @RequestMapping("/")
    public String index(Model model){
        Employee employee1 = new Employee();
        employee1.setName("Stephen Bullock");
        employee1.setAddress("123 abc ave");

        Laptop laptop = new Laptop();
        laptop.setBrands("Dell");
        laptop.setModel("7040");

        laptop.setEmployee(employee1);

        employee1.setLaptop(laptop);


        employeeRepository.save(employee1);
        laptopRepository.save(laptop);

        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("laptops", laptopRepository.findAll());
        return "index";
    }
}
