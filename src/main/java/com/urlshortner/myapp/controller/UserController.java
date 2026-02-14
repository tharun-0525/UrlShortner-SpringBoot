package com.urlshortner.myapp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortner.myapp.models.UrlModel;
import com.urlshortner.myapp.service.UrlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class UserController {

    private final UrlService urlService;

    public UserController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/")
    public UrlModel getShortUrl(@RequestParam String url) {
        UrlModel urlObj = new UrlModel();
        urlObj.seturl(url);
        urlService.shortenUrl(urlObj);;
        return urlObj;
    }

    @GetMapping("/{param}")
    public ResponseEntity<Void> getUrl(@PathVariable String param) {
        String url = urlService.getUrl(param);
        return ResponseEntity.status(302).header("Location",url).build();
    }

}
