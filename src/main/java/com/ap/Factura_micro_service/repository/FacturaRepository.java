package com.ap.Factura_micro_service.repository;

import com.ap.Factura_micro_service.entity.Factura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends MongoRepository<Factura, String> {
	
}
