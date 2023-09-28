package com.java.springfirstapp.api;
import com.java.springfirstapp.model.Customer;
import com.java.springfirstapp.servive.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class Customerservicepathfirst {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
          return customerService.addCustomer(customer);
    }
    @GetMapping(value = "/get")
    public List<Customer> getCustomerList(){
       return customerService.getCustomerList();
    }
    @GetMapping(value = "/{customer_id}")
    public Customer  getcustomer(@PathVariable("customer_id") int customer_id){
        return customerService.getCustomer(customer_id);

    }
    @PutMapping(value = "/{customer}")
    public Customer  updatedata(@PathVariable("customer") int customer_id,@RequestBody Customer customer ){
        return customerService.updatecustumer(customer_id,customer);
    }
@DeleteMapping(value = "/{delete}")
    public void deleteuser(@PathVariable("delete")int delete){
            customerService.deletecustomer(delete );
    }
}
