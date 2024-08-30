package com.example.student_management.controller;

import com.example.student_management.model.Customer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(0001, "Jareth", "magandajareth@gmail.com", 28, "Ciencias"),
            new Customer(0002, "Yamileth", "magandayamileth@gmail.com", 24, "Matematicas"),
            new Customer(0003, "Leslie", "magandaleslie@gmail.com", 10, "Fisica"),
            new Customer(0004, "Evelyn", "magandaevelyn@gmail.com", 6, "Quimica")

    ));

   @GetMapping
   public List<Customer> getCustomers(){
       return customers;
   }

   @GetMapping("/nombre")
   public Customer getAlumnos(@RequestBody Customer customer){
       for (Customer a : customers){
           if(a.getNombre().equalsIgnoreCase(customer.getNombre())){
            return a;
           }
       }
       return null;
   }

   @GetMapping("/id")
    public Customer getAlumnosId(@RequestBody Customer customer){
       for(Customer a : customers){
           if(a.getId() == customer.getId()){
               return a;
           }
       }
       return null;
   }

    @GetMapping("/{id}")
    public Customer getAlumnosid(@PathVariable int id){
        for(Customer a : customers){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    @PostMapping
    public Customer postAlumnos(@RequestBody Customer customer){
       boolean existe = false;
       for(Customer a : customers){
           if (a.getId() == customer.getId()){
               existe = true;
               System.out.println("El Id se repite");
               break;

           }else {
               customers.add(customer);
               return customer;
           }

       }
       return null;

    }

    @PutMapping
    public Customer putCustomer(@RequestBody Customer customer){
       for (Customer a : customers){
           if(a.getId() == customer.getId()){
               a.setNombre(customer.getNombre());
               a.setCorreo(customer.getCorreo());
               a.setEdad(customer.getEdad());
               a.setCurso(customer.getCurso());

               return a;
           }
       }
    return null;
    }

    @PatchMapping
    public Customer patchAlumnos(Customer customer){
       for (Customer a : customers){
           if(a.getId() == customer.getId()){
               if(customer.getNombre() != null){
                   a.setNombre(customer.getNombre());
               }
               if(customer.getEdad() != 0){
                   a.setEdad(customer.getEdad());
               }
               if(customer.getCorreo() != null){
                   a.setCorreo(customer.getCorreo());
               }
               if(customer.getCurso() != null){
                   a.setCurso(customer.getCurso());
               }
           }
           return a;
       }
       return null;
    }

    @DeleteMapping
    public Customer deleteAlumnos(@RequestBody Customer customer){
       for (Customer a : customers){
           if(a.getId() == customer.getId()){
               customers.remove(a);
               return a;
           }
       }
       return null;
    }

}
