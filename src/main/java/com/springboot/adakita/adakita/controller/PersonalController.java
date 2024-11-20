package com.springboot.adakita.adakita.controller;

import java.util.List;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class PersonalController {

    private AccountService accountService;

    @Autowired
    public PersonalController(AccountService theEmployeeService) {
        accountService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/home")
    public String listEmployees(Model theModel) {

        // get the employees from db
        List<AccountPersonal> theEmployees = accountService.getAllUsers();

        // add to the spring model
        theModel.addAttribute("account_personal", theEmployees);

        return "homeAdmin";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        AccountPersonal theEmployee = new AccountPersonal();

        theModel.addAttribute("employee", theEmployee);

        return "/adminForm";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // get the employee from the service
        AccountPersonal theEmployee = accountService.getUserById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "adminForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") AccountPersonal theEmployee) {

        // save the employee
        accountService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        accountService.deleteUser(theId);

        // redirect to /employees/list
        return "redirect:/homeAdmin";

    }
}
