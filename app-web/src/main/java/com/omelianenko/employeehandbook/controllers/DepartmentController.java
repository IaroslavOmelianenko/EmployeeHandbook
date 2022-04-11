package com.omelianenko.employeehandbook.controllers;

import com.omelianenko.employeehadbook.services.DepartmentService;
import com.omelianenko.employeehandbook.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String listDepartments(Model model){
        model.addAttribute("departments", departmentService.findAllDepartments());
    return "departments/all_departments";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("department", departmentService.searchDepartment(id));
    return "departments/show";
    }

    @GetMapping("/new")
    public String newDepartment(Model model){
        model.addAttribute("department", new Department());
        return "departments/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("department") Department department){
        departmentService.createDepartment(department);
        return "redirect:/departments";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("department", departmentService.searchDepartment(id));
        return "departments/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("department") Department department){
        departmentService.updateDepartment(department);
        return "redirect:/departments";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments";
    }
}
