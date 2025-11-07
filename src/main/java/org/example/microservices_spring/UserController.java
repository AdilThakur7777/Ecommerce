package org.example.microservices_spring;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;
//   @GetMapping("/api/users")
    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {

//        return ResponseEntity.ok(userService.fetchAllUsers());
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAllUsers());
    }

//
   @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
//       User user = userService.fetchUser(id);
//       if(user == null){
//           return ResponseEntity.notFound().build();
//       }
//        return ResponseEntity.ok(user);
       return userService.fetchUser(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }



    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
       userService.addUser(user);
       return ResponseEntity.ok("User has been created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User updatedUser) {
        boolean updated=userService.updateUser(id,updatedUser);
        if(updated) {
            return ResponseEntity.ok("User has been updated");
        }
        return ResponseEntity.notFound().build();
    }

}
