package com.urlshortner.myapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name="urlTable")
public class UrlModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "web_url")
    private String url;

    @Column(name = "web_short_url", unique = true)
    private String sUrl;

    public UrlModel(){
    }

    public String getUrl(){
        return url;
    }

    public String getSUrl(){
        return sUrl;
    }

    public UrlModel seturl(String url){
        this.url = url;
        return this;
    }

    public UrlModel setSUrl(String surl){
        this.sUrl = surl;
        return this;
    }
}
