package com.GameRec.GameRecSystem.userprofile;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserProfileService {
    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
        this.userProfileDataAccessService=userProfileDataAccessService;
    }


}
