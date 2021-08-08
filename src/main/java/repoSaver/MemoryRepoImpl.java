package repoSaver;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepoImpl implements Repository{


    List<User> databaseInMemory = new ArrayList<>();


    @Override
    public void saveUser(User user){
        databaseInMemory.add(user);
    }

    @Override
    public String getUsers() {
        StringBuilder result = new StringBuilder();
        if (databaseInMemory.isEmpty()) {
            System.out.println("Memory is empty!");
        } else {
            for (User user : databaseInMemory) {
                result.append(user.toString()).append("\n");
            }
        }
        return result.toString();
    }
}
