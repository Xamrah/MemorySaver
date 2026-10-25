package service;

import repoSaver.DatabaseRepoImpl;
import repoSaver.FileRepoImpl;
import repoSaver.MemoryRepoImpl;
import model.User;
import java.sql.*;

public class UserService {
    MemoryRepoImpl memoryRepo = new MemoryRepoImpl();
    DatabaseRepoImpl databaseRepo= new DatabaseRepoImpl();
    FileRepoImpl fileRepo = new FileRepoImpl();

    public void saveAll(User user) throws SQLException {
        fileRepo.saveUser(user);
        databaseRepo.saveUser(user);
        memoryRepo.saveUser(user);
    }

    public void saveInMemory(User user){
        memoryRepo.saveUser(user);
    }

    public void saveInFile(User user){
        fileRepo.saveUser(user);
    }

    public void saveInDatabase(User user) throws SQLException {
        databaseRepo.saveUser(user);
    }

    public void showAll() throws SQLException {
        System.out.println("########################\nUsers in Memory:");
        System.out.println(memoryRepo.getUsers());
        System.out.println("########################\nUsers in File:");
        System.out.println(fileRepo.getUsers());
        System.out.println("########################\nUsers in Database:");
        System.out.println(databaseRepo.getUsers());

    }
}
