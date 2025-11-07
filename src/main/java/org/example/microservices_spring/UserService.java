package org.example.microservices_spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public List<User>userList =new ArrayList<>();
    private Long nextId = 1L;
    public List<User> fetchAllUsers() {
        return userList;
    }

    public List<User> addUser(User user) {
        user.setId(nextId++);
        userList.add(user);
        return userList;
    }

    public Optional<User> fetchUser(Long id) {
       return userList.stream()
               .filter(user->user.getId().equals(id))
               .findFirst();
    }
    public boolean updateUser(Long id, User updatedUser) {
        return userList.stream()
                .filter(user->user.getId().equals(id))
                .findFirst()
                .map(exisitingUser->{
                    exisitingUser.setName(updatedUser.getName());
                    return true;
                }).orElse(false);

    }

}
