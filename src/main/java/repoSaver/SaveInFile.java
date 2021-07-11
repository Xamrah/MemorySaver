package repoSaver;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.User;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SaveInFile implements Repository {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void saveUser(User user) {
        try {
            mapper.writeValue(new File("userlist.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUser(Integer userID) {
        List<User> userList = new LinkedList();

        try {
            userList = Arrays.asList(mapper.readValue(new File("userlist.json"), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(User v : userList){
            if(v.getId().equals(userID)){
                return v.toString();
            }
        }
        return null;
    }
}
