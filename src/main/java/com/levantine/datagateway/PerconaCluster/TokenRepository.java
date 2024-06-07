package com.levantine.datagateway.PerconaCluster;

import com.levantine.datagateway.PerconaCluster.auth_token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<auth_token, Long> {
}
