package Tinder;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        ProfileDetails user1Details = new ProfileDetails("1", 25, "Alice", Gender.FEMALE);
        Preference user1Preference = new Preference("p1", 24, 30, Gender.MALE);
        userManager.createProfile("1", user1Details, user1Preference);
        userManager.addInterest("1", Interest.FILM);
        userManager.addInterest("1", Interest.CRICKET);

        ProfileDetails user2Details = new ProfileDetails("2", 27, "Bob", Gender.MALE);
        Preference user2Preference = new Preference("p2", 22, 28, Gender.FEMALE);
        userManager.createProfile("2", user2Details, user2Preference);
        userManager.addInterest("2", Interest.FILM);
        userManager.addInterest("2", Interest.BOOKS);

        System.out.println("Best match for Alice: " + userManager.getBestProfile("1"));

        userManager.acceptProfile("1", "2");
        userManager.acceptProfile("2", "1");

        System.out.println("Matched profiles for Alice: " + userManager.listMatchedProfiles("1"));
    }
}
