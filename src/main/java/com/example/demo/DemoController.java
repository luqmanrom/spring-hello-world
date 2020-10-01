package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class DemoController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @GetMapping("/books")
    public ModelAndView getProducts(Map<String,Object> model){

        List<Book> bookList = IntStream.range(0,7)
                .mapToObj(i -> getBook(i))
                .collect(Collectors.toList());

        model.put("bookList",bookList);

        return new ModelAndView("book", model);
    }

    private Book getBook(int i){
        return new Book(Long.valueOf(i),
                "ISBN Number -" + i,
                "Book Name " + i,
                "Author " + i,
                Double.valueOf(100 * i));
    }

}
