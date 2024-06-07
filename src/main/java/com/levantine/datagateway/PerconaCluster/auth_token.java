package com.levantine.datagateway.PerconaCluster;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

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

    public String hashify(String token) throws NoSuchAlgorithmException { // Take a token and hash it
        // https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha-256-in-java
        // I know Argon2 is the new thing, but it looks much more complicated than this, so I'll deal with it later.
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(token.getBytes(StandardCharsets.UTF_8));
        return new String(hash);
    }

    // Getters
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

    // Setters
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTokenHash(String token) throws NoSuchAlgorithmException {
        this.tokenHash = hashify(token);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
}
