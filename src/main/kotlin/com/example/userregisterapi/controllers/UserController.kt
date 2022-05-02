package com.example.userregisterapi.controllers

import com.example.userregisterapi.entities.User
import com.example.userregisterapi.repository.UsersRepository
import com.example.userregisterapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/users")
class UserController(var userService: UserService) {

    @GetMapping("/findAll")
    fun index():ResponseEntity<List<User>>{
        return ResponseEntity.ok(userService.findAll())
    }

    @PostMapping("/createUser")
    fun create(@RequestBody user: User): User {
        return userService.create(user)
    }

    @GetMapping("/findUser")
    fun findUser(@RequestBody user: User): User {
        return userService.findUser(user)
    }

    @PutMapping("/updateUser")
    fun updateUser(@RequestBody user: User): User {
       return userService.updateUser(user)
    }

    @DeleteMapping("/deleteUser")
    fun deleteUser(@RequestBody user: User) {
        return userService.deleteUser(user)
    }
}