package com.ap.Cliente_micro_service.repository;

import com.ap.Cliente_micro_service.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {


}
