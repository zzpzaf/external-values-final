package com.zzpzaf.se.devxperiences.posts.externalvalues.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzpzaf.se.devxperiences.posts.externalvalues.DataObjects.VersionDTO;
import com.zzpzaf.se.devxperiences.posts.externalvalues.Repositories.VersionRepository;

@RestController
public class VersionController {
   
    @Autowired
    VersionRepository versionRepo;
    
    @GetMapping(value = "/version")
    //@GetMapping(value = "${endPoint.version:/version}")
    public ResponseEntity<VersionDTO> version() {
        VersionDTO version = versionRepo.getAPIVersion();
        return new ResponseEntity<>(version, HttpStatus.OK);
    }


}
