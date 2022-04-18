package com.example.userregisterapi.controllers

import com.example.userregisterapi.entities.User
import com.example.userregisterapi.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var repository: UsersRepository

    @RequestMapping("/getUsers", method = [RequestMethod.GET])
    fun index():List<User>{
        return repository.findAll()
    }

    @RequestMapping("/createUser", method = [RequestMethod.POST])
    fun create(@RequestBody user: User): User {
        return repository.save(user)
    }

    @RequestMapping("/findUser", method = [RequestMethod.GET])
    fun findUser(@RequestBody user: User): User {
        return repository.findById(user.id!!).get()
    }
}