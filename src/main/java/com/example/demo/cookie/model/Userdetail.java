package com.example.demo.cookie.model;

import com.example.demo.cookie.constants.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.io.Serializable;

@JsonIgnoreProperties(value = "passkey", allowGetters = false, allowSetters = true)
public class Userdetail extends AcUser implements User, Serializable {
    private static final long serialVersionUID = 1L;
    private transient static BeanCopier beanCopier = BeanCopier.create(AcUser.class, Userdetail.class, false);
    private long runtimeCreated = System.currentTimeMillis();
    private long expireAt = runtimeCreated;
    private String fullUsername;
    private String token;

    public Userdetail update(AcUser acUser) {
        beanCopier.copy(acUser, this, null);
        return this;
    }

    public String fullUsername() {
        if (this.fullUsername == null) {
            String origin = getOrigin();
            if (StringUtils.isBlank(origin)) {
                origin = Constants.USER_ORIGIN_LOCAL;
            }
            fullUsername = origin + "/" + getUsername();
        }
        return this.fullUsername;
    }

    public long getRuntimeCreated() {
        return runtimeCreated;
    }

    public long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(long expireAt) {
        this.expireAt = expireAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "{" +
                "origin:" + getOrigin() + "," +
                "username:" + getUsername() +
                "}";
    }
}
