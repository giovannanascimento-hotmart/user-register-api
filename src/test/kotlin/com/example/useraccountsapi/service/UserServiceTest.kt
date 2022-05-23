package com.example.useraccountsapi.service

import com.example.userregisterapi.entities.User
import com.example.userregisterapi.repository.UsersRepository
import com.example.userregisterapi.service.UserService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@ExtendWith(MockKExtension::class)
class UserServiceTest {

    @RelaxedMockK
    private lateinit var userRepository: UsersRepository

    @InjectMockKs
    private lateinit var userService: UserService

    @Test
    fun `search all users and return all users`() {
        val user = User(id = 1, nome = "Test", cpf = "111.111.111.11")
        val user2 = User(id = 2, nome = "Test2", cpf = "222.222.222.22")
        val listUsers: List<User> = listOf(user, user2)
        every { userRepository.findAll() } returns listOf(user,user2);
        val result = userService.findAll();
        verify(exactly = 1){userRepository.findAll()}
        Assertions.assertEquals(listUsers, result)
    }

    @Test
    fun `search all users and return empty`() {
        val user = User(id = 1, nome = "Test", cpf = "111.111.111.11")
        val user2 = User(id = 2, nome = "Test2", cpf = "222.222.222.22")
        val listUsers: List<User> = listOf(user , user2)
        every { userRepository.findAll() } returns listOf();
        val result = userService.findAll();
        verify(exactly = 1){userRepository.findAll()}
        Assertions.assertTrue(listUsers != result)
    }

    @Test
    fun `search user and return user`() {
        val user = User(id = 1, nome = "Test", cpf = "111.111.111.11")
        val id = user.id
        every { userRepository.findById(id) } returns Optional.of(user);
        val result = userService.findUser(1);
        verify(exactly = 1){userRepository.findById(1)}
        Assertions.assertEquals(user, result)
    }

    @Test
    fun `update user and return user`() {
        val user = User(id = 1, nome = "Test", cpf = "111.111.111.11")
        val userId = user.id
        every { userRepository.findById(userId)} returns Optional.of(user);
        every { userRepository.save(user)} returns user;
        val result = userService.updateUser(user);
        verify(exactly = 1){userRepository.findById(1)}
        verify(exactly = 1){userRepository.save(user)}
        Assertions.assertEquals(user, result)
    }

    @Test
    fun `delete user and return ok`() {
        val user = User(id = 1, nome = "Test", cpf = "111.111.111.11")
        val userId = user.id
        every { userRepository.findById(userId)} returns Optional.of(user);
        every { userRepository.delete(user)} returns Unit;
        val result = userService.deleteUser(user);
        verify(exactly = 1){userRepository.findById(1)}
        verify(exactly = 1){userRepository.delete(user)}
        Assertions.assertEquals(Unit, result)
    }


}







