package repoSaver;

import utils.User;
import java.util.LinkedList;

public class SaveInMemory implements Repository{


    LinkedList<User> databaseInMemory = new LinkedList<>();


    @Override
    public void saveUser(User user){
        databaseInMemory.add(user);
    }

    @Override
    public String getUser(Integer userID) { return databaseInMemory.get(userID).toString(); }
}
