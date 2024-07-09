package practiceLLD.TaskManagementSystem.Repositories;

import practiceLLD.TaskManagementSystem.Models.Task;
import practiceLLD.TaskManagementSystem.Models.User;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

    ConcurrentHashMap<Long, User> userStorage;

    public UserRepository() {
        this.userStorage = new ConcurrentHashMap<>();
    }

    public User save(User user){

        userStorage.put(user.getId(), user);
        return user;
    }

    public User getUser(User user){
        return userStorage.get(user.getId());
    }

    public List<Task> getTasksByUserId(Long id){

        return userStorage.get(id).getTasks();
    }


}
