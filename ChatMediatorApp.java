import java.util.*;

public class ChatMediatorApp {
    public static void main(String[] args) {
        PrivateChatMediator privateMediator = new ConcretePrivateChatMediator();
        GroupChatMediator groupMediator = new ConcreteGroupChatMediator();

        User arman = new User("Arman", privateMediator, groupMediator);
        User abdullah = new User("Abdullah", privateMediator, groupMediator);
        User mohammod = new User("Mohammod", privateMediator, groupMediator);

        groupMediator.createGroup("group1");

        arman.joinGroup("group1");
        abdullah.joinGroup("group1");

        arman.sendPrivateMessage(abdullah, "Hi Abdullah!");
        abdullah.sendPrivateMessage(arman, "Hey Arman!");

        arman.sendGroupMessage("group1", "Hello group!");
        mohammod.sendGroupMessage("group1", "Am I in?");
        mohammod.joinGroup("group1");
        mohammod.sendGroupMessage("group1", "Now I am!");
    }
}

interface PrivateChatMediator {
    void sendMessage(User sender, User receiver, String message);
}

interface GroupChatMediator {
    void sendGroupMessage(User sender, String groupId, String message);
    void createGroup(String groupId);
    void addUserToGroup(User user, String groupId);
}

class ConcretePrivateChatMediator implements PrivateChatMediator {
    @Override
    public void sendMessage(User sender, User receiver, String message) {
        receiver.receivePrivateMessage(sender, message);
    }
}

class ConcreteGroupChatMediator implements GroupChatMediator {
    private Map<String, ChatGroup> groups = new HashMap<>();

    @Override
    public void createGroup(String groupId) {
        groups.put(groupId, new ChatGroup(groupId));
    }

    @Override
    public void addUserToGroup(User user, String groupId) {
        if (groups.containsKey(groupId)) {
            groups.get(groupId).addUser(user);
        }
    }

    @Override
    public void sendGroupMessage(User sender, String groupId, String message) {
        if (groups.containsKey(groupId)) {
            for (User user : groups.get(groupId).getUsers()) {
                if (!user.equals(sender)) {
                    user.receiveGroupMessage(sender, message);
                }
            }
        }
    }
}

class ChatGroup {
    private Set<User> users = new HashSet<>();

    public ChatGroup(String id) {
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public Set<User> getUsers() {
        return users;
    }
}

class User {
    private String name;
    private PrivateChatMediator privateMediator;
    private GroupChatMediator groupMediator;
    private Set<String> joinedGroups = new HashSet<>();

    public User(String name, PrivateChatMediator privateMediator, GroupChatMediator groupMediator) {
        this.name = name;
        this.privateMediator = privateMediator;
        this.groupMediator = groupMediator;
    }

    public void joinGroup(String groupId) {
        joinedGroups.add(groupId);
        groupMediator.addUserToGroup(this, groupId);
    }

    public boolean isInGroup(String groupId) {
        return joinedGroups.contains(groupId);
    }

    public void sendPrivateMessage(User to, String message) {
        privateMediator.sendMessage(this, to, message);
    }

    public void receivePrivateMessage(User from, String message) {
        System.out.println(name + " received private message from " + from.name + ": " + message);
    }

    public void sendGroupMessage(String groupId, String message) {
        if (isInGroup(groupId)) {
            groupMediator.sendGroupMessage(this, groupId, message);
        } else {
            System.out.println(name + " is not in group " + groupId);
        }
    }

    public void receiveGroupMessage(User from, String message) {
        System.out.println(name + " received group message from " + from.name + ": " + message);
    }

    @Override
    public String toString() {
        return name;
    }
}
