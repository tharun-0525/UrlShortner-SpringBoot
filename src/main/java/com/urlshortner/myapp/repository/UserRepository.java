package com.urlshortner.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.urlshortner.myapp.models.UrlModel;
import java.util.List;



public interface UserRepository extends JpaRepository<UrlModel, Long> {

    List<UrlModel> findBysUrl(String sUrl);
}
