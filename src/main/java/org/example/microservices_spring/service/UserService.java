package org.example.microservices_spring.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices_spring.dto.AddressDTO;
import org.example.microservices_spring.dto.UserResponse;
import org.example.microservices_spring.repository.UserRepository;
import org.example.microservices_spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    public List<User>userList =new ArrayList<>();
    private Long nextId = 1L;
//  or we can use the @RequiredArgsConstructor
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<UserResponse> fetchAllUsers() {
        List<User> userList = userRepository.findAll();
        return userRepository.findAll().stream().map(this::mapToUserResponse).toList();

    }

    public void addUser(User user) {
//        user.setId(nextId++);

        userRepository.save(user);

    }

    public Optional<UserResponse> fetchUser(Long id) {

       return userRepository.findById(id).map(this::mapToUserResponse);
    }
    public boolean updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);
    }
        private UserResponse mapToUserResponse (User user)
        {
            UserResponse response = new UserResponse();
            response.setId(String.valueOf(user.getId()));
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setRole(user.getRole());
            response.setPhoneNumber(user.getPhoneNumber());

            if(user.getAddress() != null) {
                AddressDTO addressDTO = new AddressDTO();
                addressDTO.setStreet(user.getAddress().getStreet());
                addressDTO.setCity(user.getAddress().getCity());
                addressDTO.setState(user.getAddress().getState());
                addressDTO.setZipCode(user.getAddress().getZipCode());
                addressDTO.setCountry(user.getAddress().getCountry());
                response.setAddress(addressDTO);

            }
            return response;

        }
}




//                stream()
//                .filter(user->user.getId().equals(id))
//                .findFirst()
//                .map(exisitingUser->{
//                    exisitingUser.setName(updatedUser.getName());
//                    return true;
//                }).orElse(false);


