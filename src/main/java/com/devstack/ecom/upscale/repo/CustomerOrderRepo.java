package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, String> {
}
