package com.ecom.order.repo;

import com.ecom.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Long> {

    //  custom finder method
    Order findByOrderDescription(String orderDesc);
}
