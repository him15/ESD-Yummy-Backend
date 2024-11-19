package com.himanshu.esd.esd_yummy.mapper;

import com.himanshu.esd.esd_yummy.dto.CustomerRequest;
import com.himanshu.esd.esd_yummy.dto.CustomerResponse;
import com.himanshu.esd.esd_yummy.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .address(request.address())
                .city(request.city())
                .pincode(request.pincode())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail() , customer.getAddress() , customer.getCity() , customer.getPincode());
    }
}
