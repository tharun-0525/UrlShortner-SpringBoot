package com.urlshortner.myapp.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UuidGenerator implements IdGenerator{
    
    @Override
    public String generateId(String url){
        return UUID.randomUUID().toString();
    }
}
