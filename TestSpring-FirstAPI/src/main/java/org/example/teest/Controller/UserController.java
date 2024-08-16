package org.example.teest.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@Component
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<String> getMessage(@PathVariable long userId) {
        String message = "Hello User: " + userId;
        return ResponseEntity.ok(message);
    }
}
