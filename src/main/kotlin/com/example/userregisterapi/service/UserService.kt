package com.example.userregisterapi.service

import com.example.userregisterapi.entities.User
import com.example.userregisterapi.repository.UsersRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.persistence.EntityNotFoundException

@Service
class UserService (var userRepository: UsersRepository) {

    fun findAll ():List<User>{
        return userRepository.findAll()
    }

    fun create(user: User): User{
        return userRepository.save(user)
    }

    fun findUser(id: Long): User{
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return userDocument
    }

    fun updateUser(user: User): User{
        val userDocument = userRepository.findById(user.id).orElseThrow { EntityNotFoundException() }
        userDocument.apply {
            this.nome = user.nome
            this.cpf = user.cpf
        }
        return userRepository.save(userDocument)
    }

    fun deleteUser(user: User){
        val userDocument = userRepository.findById(user.id).orElseThrow { EntityNotFoundException() }
        return userRepository.delete(userDocument)
    }
}
