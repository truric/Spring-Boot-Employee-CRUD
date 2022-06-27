package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/show", "/", "/list"})
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = employeeRepository.findAll();
        mav.addObject("employees", list);
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = new Employee();
        mav.addObject("employee", employee);
        return mav;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee, RedirectAttributes ra) {
        employeeRepository.save(employee);
        ra.addFlashAttribute("message", employee.getName() + " employee saved successfully");
        return "redirect:/list";
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam Long employeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = employeeRepository.findById(employeeId).get();
        mav.addObject("employee", employee);
        return mav;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long employeeId, RedirectAttributes ra) {
        employeeRepository.deleteAllById(Collections.singleton(employeeId));
        ra.addFlashAttribute("message", "Employee ID:" + employeeId + " deleted successfully");
        return "redirect:/list";
    }

}
