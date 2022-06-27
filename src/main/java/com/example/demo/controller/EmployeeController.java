package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/show")
    private ModelAndView show() {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = employeeRepository.findAll();
        mav.addObject("employees", list);
        return mav;
    }

}
