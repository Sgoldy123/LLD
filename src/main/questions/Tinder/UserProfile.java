package Tinder;

import Tinder.ProfileDetails;

import java.util.HashSet;
import java.util.Set;

class UserProfile {
    String userProfileID;
    ProfileDetails profileDetails;
    Set<Interest> ownInterests;
    Preference preference;
    Set<String> matchedList;

    public UserProfile(String userProfileID, ProfileDetails profileDetails, Preference preference) {
        this.userProfileID = userProfileID;
        this.profileDetails = profileDetails;
        this.preference = preference;
        this.ownInterests = new HashSet<>();
        this.matchedList = new HashSet<>();
    }

    public void addInterest(Interest interest) {
        ownInterests.add(interest);
    }
}
