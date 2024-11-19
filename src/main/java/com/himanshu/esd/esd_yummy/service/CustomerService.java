package com.himanshu.esd.esd_yummy.service;

import com.himanshu.esd.esd_yummy.dto.CustomerRequest;
import com.himanshu.esd.esd_yummy.dto.CustomerResponse;
import com.himanshu.esd.esd_yummy.entity.Customer;
import com.himanshu.esd.esd_yummy.exception.CustomerNotFoundException;
import com.himanshu.esd.esd_yummy.helper.EncryptionService;
import com.himanshu.esd.esd_yummy.mapper.CustomerMapper;
import com.himanshu.esd.esd_yummy.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;


    public String createCustomer(CustomerRequest request) {

        Customer customer = customerMapper.toCustomer(request);

        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer created Successfully!";
    }

    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }


}
