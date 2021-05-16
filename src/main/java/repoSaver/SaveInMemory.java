package repoSaver;

import service.Restore;
import java.util.HashMap;


public class SaveInMemory implements Repository{

    Restore restore = new Restore();

    HashMap<Integer, HashMap> databaseInMemory = new HashMap<>();

    static Integer freeUserID = 0;

    @Override
    public void saveUser(HashMap userDataPack){
        databaseInMemory.put(freeUserID, userDataPack);
        freeUserID++;
        restore.restart();
    }

    @Override
    public HashMap getUser(Integer userID) {
        return databaseInMemory.get(userID);
    }
}
