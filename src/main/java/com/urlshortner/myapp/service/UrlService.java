package com.urlshortner.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshortner.myapp.models.UrlModel;
import com.urlshortner.myapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlService {

    @Autowired
    private UserRepository userRepo;

    private final IdGenerator idGenerator; 

    public UrlService(IdGenerator idGenerator){
        this.idGenerator = idGenerator;
    }

    public void shortenUrl(UrlModel urlObj){
        String shortUrl = shortenUrl(urlObj.getUrl());
        urlObj.setSUrl(shortUrl);
        addToDB(urlObj);
    }

    public String getUrl(String sUrl) {
        List<UrlModel> url = dbGet(sUrl);
        if (!url.isEmpty()) {
            return url.get(0).getUrl();
        }
        return new String("/");
    }

    private String shortenUrl(String url){
        String sUrl = idGenerator.generateId(url);
        return sUrl;
    }

    private void addToDB(UrlModel urlObj){
        userRepo.save(urlObj);
    }

    private List<UrlModel> dbGet(String url){
        List<UrlModel> result = userRepo.findBysUrl(url);
        if(result.size()==1){
            return result;
        }
        return new ArrayList<>();
    }
}
