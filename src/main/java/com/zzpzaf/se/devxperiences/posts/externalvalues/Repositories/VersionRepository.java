package com.zzpzaf.se.devxperiences.posts.externalvalues.Repositories;

import org.springframework.stereotype.Repository;

import com.zzpzaf.se.devxperiences.posts.externalvalues.DataObjects.VersionDTO;

@Repository
public class VersionRepository {
    

    public VersionDTO getAPIVersion() {
        return new VersionDTO();
    }


}
