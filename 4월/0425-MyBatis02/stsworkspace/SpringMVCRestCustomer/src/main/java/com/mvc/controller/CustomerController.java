package com.mvc.controller;

import com.mvc.service.CustomerService;
import com.mvc.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping(value = "/customers")
    public List<Customer> list(){
        List<Customer> list = service.selectAll();
        return list;
    }

    @GetMapping(value = "/customers/{num}")
    public Customer findOne(@PathVariable String num){
        Customer one = service.selectOne(num);
        return one;
    }

    @PostMapping(value = "/customers")
    public Map<String, String> register(@RequestBody Customer c){
        int x = service.insert(c);
        Map<String, String> map = new HashMap<>();
        map.put("result", "insert success");
        return map;
    }

    @PutMapping(value = "/customers")
    public Map<String, String> update(@RequestBody Customer c){
        int x = service.update(c);
        Map<String, String> map = new HashMap<>();
        map.put("result", "update success");
        return map;
    }

    @DeleteMapping(value = "/customers/{num}")
    public Map<String, String> deleteOne(@PathVariable String num){
        int x = service.delete(num);
        Map<String, String> map = new HashMap<>();
        map.put("result", "delete success");
        return map;
    }
}
