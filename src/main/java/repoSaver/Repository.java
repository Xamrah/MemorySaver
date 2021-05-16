package repoSaver;

import java.util.HashMap;

public interface Repository {
    void saveUser(HashMap userDataPack);
    HashMap getUser(Integer userID);

}
