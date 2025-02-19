package Tinder;

class Preference {
    String id;
    int minAge;
    int maxAge;
    Gender gender;

    public Preference(String id, int minAge, int maxAge, Gender gender) {
        this.id = id;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
    }
}
