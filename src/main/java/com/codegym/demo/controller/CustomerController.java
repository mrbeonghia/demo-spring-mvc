package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Province;
import com.codegym.demo.service.customer.CustomerService;
import com.codegym.demo.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("province")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("")
    public ModelAndView getAll(){
        ModelAndView modelAndView= new ModelAndView("list");
        Iterable<Customer> customers= customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("province",provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer){
        ModelAndView modelAndView= new ModelAndView("create");
        customerService.save(customer);
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("edit");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("province",provinceService.findAll());
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editCity(@ModelAttribute Customer city){
        ModelAndView modelAndView= new ModelAndView("edit");
        customerService.save(city);
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("list");
        customerService.remove(id);
        modelAndView.addObject("city",customerService.findAll());
        return modelAndView;
    }
}
