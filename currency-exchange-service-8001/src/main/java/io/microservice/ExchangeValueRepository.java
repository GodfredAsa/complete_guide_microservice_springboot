package io.microservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue getByFromAndTo(String from, String to);

    List<ExchangeValue> findByTo(String to);

}
