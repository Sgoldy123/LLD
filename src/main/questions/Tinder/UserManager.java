package Tinder;

import java.util.*;

class UserManager {
    Map<String, UserProfile> users = new HashMap<>();
    Map<String, List<String>> matchedUsers = new HashMap<>();
    Map<String, List<String>> acceptedUsers = new HashMap<>();
    Map<String, List<String>> declinedUsers = new HashMap<>();

    public void createProfile(String userId, ProfileDetails details, Preference preference) {
        UserProfile profile = new UserProfile(userId, details, preference);
        users.put(userId, profile);
    }

    public void addInterest(String userId, Interest interest) {
        if (users.containsKey(userId)) {
            users.get(userId).addInterest(interest);
        }
    }

    public String getBestProfile(String userId) {
        UserProfile user = users.get(userId);
        if (user == null) return null;

        List<UserProfile> rankedProfiles = new ArrayList<>();

        for (UserProfile potentialMatch : users.values()) {
            if (potentialMatch.userProfileID.equals(userId)) continue; // Skip self
            if (declinedUsers.getOrDefault(userId, new ArrayList<>()).contains(potentialMatch.userProfileID))
                continue; // Skip declined

            boolean isPreferred = isMatchingPreference(user.preference, potentialMatch.profileDetails);
            boolean isAccepted = acceptedUsers.getOrDefault(potentialMatch.userProfileID, new ArrayList<>()).contains(userId);

            if (isPreferred || isAccepted) {
                rankedProfiles.add(potentialMatch);
            }
        }

        rankedProfiles.sort((a, b) -> Integer.compare(
                commonInterestsCount(user, b),
                commonInterestsCount(user, a)
        ));

        return rankedProfiles.isEmpty() ? "No matches available" : rankedProfiles.get(0).userProfileID;
    }

    public void acceptProfile(String userId, String acceptedId) {
        acceptedUsers.computeIfAbsent(userId, k -> new ArrayList<>()).add(acceptedId);

        if (acceptedUsers.getOrDefault(acceptedId, new ArrayList<>()).contains(userId)) {
            matchedUsers.computeIfAbsent(userId, k -> new ArrayList<>()).add(acceptedId);
            matchedUsers.computeIfAbsent(acceptedId, k -> new ArrayList<>()).add(userId);
        }
    }

    public void declineProfile(String userId, String declinedId) {
        declinedUsers.computeIfAbsent(userId, k -> new ArrayList<>()).add(declinedId);
    }

    public List<String> listMatchedProfiles(String userId) {
        return matchedUsers.getOrDefault(userId, new ArrayList<>());
    }

    private boolean isMatchingPreference(Preference preference, ProfileDetails profile) {
        return profile.age >= preference.minAge && profile.age <= preference.maxAge
                && profile.gender == preference.gender;
    }

    private int commonInterestsCount(UserProfile user, UserProfile other) {
        Set<Interest> common = new HashSet<>(user.ownInterests);
        common.retainAll(other.ownInterests);
        return common.size();
    }
}
