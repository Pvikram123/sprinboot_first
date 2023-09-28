package com.java.springfirstapp.servive;

import com.java.springfirstapp.model.Customer;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    private int customerIdcount=1;
    private List<Customer> customerList=new CopyOnWriteArrayList<>() ;
       public Customer addCustomer(Customer customer){
           customer.setCustomer_id(customerIdcount ) ;
             customerList.add(customer);
             //customerList.add(customer);
             customerIdcount++;
             return customer;
       }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Customer getCustomer(int customer_id){
           return customerList
                   .stream()
                   .filter(c -> c.getCustomer_id()==customer_id )
                   .findFirst()
                   .get();
    }
    public Customer updatecustumer(int customet_id,Customer customer){
           customerList
                   .stream()
                   .forEach(c ->{
                       if(c.getCustomer_id()==customet_id){
                       c.setCustomername(customer.getCustomername());
                       c.setCustomeremail(customer.getCustomeremail());
                       }
                   });
           return customerList
                   .stream()
                   .filter(c->c.getCustomer_id()==customet_id)
                   .findFirst()
                   .get();
    }
     public void deletecustomer(int customer_id){
           customerList
               .stream()
               .forEach(c->{
                   if(c.getCustomer_id()==customer_id ){
                       customerList.remove(c);
                   }
               });
     }

}

