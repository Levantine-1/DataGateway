package com.levantine.datagateway;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@Entity
public class auth_token {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "token_hash")
    private String tokenHash;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_accessed")
    private Date lastAccessed;

    // getters and setters
    public int getId() {
        return id;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastAccessed() {
        return lastAccessed;
    }
}