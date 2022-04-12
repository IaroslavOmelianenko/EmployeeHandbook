package com.omelianenko.employeehandbook.controllers;

import com.omelianenko.employeehadbook.services.EmployeeService;
import com.omelianenko.employeehandbook.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeeService.searchEmployee(id));
        return "employees/show_employee";
    }

    @GetMapping("/new_employee")
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "employees/new_employee";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") Employee employee){
        employeeService.registerEmployee(employee);
        return "redirect:/employees";
    }


    @GetMapping("/{id}/edit_employee")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeeService.searchEmployee(id));
        return "employees/edit_employee";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("employee") Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}

