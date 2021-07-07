package com.GameRec.GameRecSystem.userprofile;

import java.util.Objects;
import java.util.UUID;

public class UserProfile {
    private UUID userProfileId;
    private String username;
    private String userProfileModelLink;

    public UserProfile(UUID userProfileId, String username) {
        this.userProfileId = userProfileId;
        this.username = username;
    }

    public UserProfile(UUID userProfileId, String username, String userProfileModelLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileModelLink = userProfileModelLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserProfileModelLink() {
        return userProfileModelLink;
    }

    public void setUserProfileModelLink(String userProfileModelLink) {
        this.userProfileModelLink = userProfileModelLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId,that.userProfileId) &&
                Objects.equals(username,that.username) &&
                Objects.equals(userProfileModelLink,that.userProfileModelLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, username, userProfileModelLink);
    }
}
