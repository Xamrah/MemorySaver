package repoSaver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileRepoImpl implements Repository {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final String fileName = "userlist.json";

    @Override
    public void saveUser(User user) {
        List<User> users = readAll();
        users.add(user);
        try {
           String resultValue = mapper.writeValueAsString(users);
           Files.writeString(Paths.get(fileName), resultValue + "\r\n", Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUsers() {
        String result = "";
        List<User> users = readAll();
        if (users.isEmpty()){
            System.out.println("File is empty!");
        } else {
        for (User user: users) {
            result += user + "\n";
        }
    }
        return result;
    }

    private static List<User> readAll(){
        String s;
        List<User> users = new ArrayList<>();
        try {
            s = Files.readString(Paths.get(fileName));
            users = mapper.readValue(s, new TypeReference<List<User>>(){});
        } catch (IOException e) {}
        return users;
    }
}
