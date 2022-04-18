package com.example.userregisterapi.controllers

import com.example.userregisterapi.entities.User
import com.example.userregisterapi.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

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
        val userDocument = repository.findById(user.id).orElseThrow { EntityNotFoundException() }
        return userDocument
    }

    @RequestMapping("/updateUser", method = [RequestMethod.PUT])
    fun updateUser(@RequestBody user: User): User {
        val userDocument = repository.findById(user.id).orElseThrow { EntityNotFoundException() }
        userDocument.apply {
            this.name = user.name
            this.cpf = user.cpf
        }
        return repository.save(userDocument)
    }
}