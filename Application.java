import java.util.*;

class Profile {
    private String id;
    private String email;

    public Profile(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

interface ProfileIterator {
    Profile getNext();
    boolean hasMore();
}

class FacebookIterator implements ProfileIterator {
    private Facebook facebook;
    private String profileId;
    private String type;
    private int currentPosition = 0;
    private List<Profile> cache;

    public FacebookIterator(Facebook facebook, String profileId, String type) {
        this.facebook = facebook;
        this.profileId = profileId;
        this.type = type;
        lazyInit();
    }

    private void lazyInit() {
        cache = facebook.requestRelatedProfiles(profileId, type);
    }

    @Override
    public boolean hasMore() {
        return currentPosition < cache.size();
    }

    @Override
    public Profile getNext() {
        if (!hasMore()) return null;
        return cache.get(currentPosition++);
    }
}

interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileId);
    ProfileIterator createCoworkersIterator(String profileId);

}

class Facebook implements SocialNetwork {
    private List<Profile> contacts;

    public Facebook(List<Profile> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileId) {
        return new FacebookIterator(this, profileId, "friends");
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileId) {
        return new FacebookIterator(this, profileId, "coworkers");
    }

    public List<Profile> getContacts() {
        return contacts;
    }

    public List<Profile> requestRelatedProfiles(String profileId, String type) {
        return contacts;
    }
}

class SocialSpammer {
    public void send(ProfileIterator iterator, String message) {
        while (iterator.hasMore()) {
            Profile profile = iterator.getNext();
            System.out.println("Sending message to: " + profile.getEmail() + " - " + message);
        }
    }
}

public class Application {
    private SocialSpammer spammer;
    private SocialNetwork network;

    public Application(SocialNetwork network) {
        this.network = network;
        this.spammer = new SocialSpammer();
    }

    public void sendSpamToFriends(Profile profile) {
        ProfileIterator iterator = network.createFriendsIterator(profile.getId());
        spammer.send(iterator, "Hi friend! Here's a special offer just for you.");
    }

    public void sendSpamToCoworkers(Profile profile) {
        ProfileIterator iterator = network.createCoworkersIterator(profile.getId());
        spammer.send(iterator, "Hello coworker, don’t miss this professional opportunity.");
    }

    public static void main(String[] args) {
        List<Profile> contacts = Arrays.asList(
            new Profile("1", "arman@gmail.com"),
            new Profile("2", "abdullah@gmail.com"),
            new Profile("3", "mohammod@gmail.com")
        );

        SocialNetwork network = new Facebook(contacts);
        Application app = new Application(network);

        Profile self = new Profile("0", "ifty@gmail.com");
        app.sendSpamToFriends(self);
        app.sendSpamToCoworkers(self);
    }
}
