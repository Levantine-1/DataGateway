package com.levantine.datagateway;

import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<auth_token, Long> {
}
