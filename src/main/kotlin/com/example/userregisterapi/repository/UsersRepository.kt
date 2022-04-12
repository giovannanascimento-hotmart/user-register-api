package com.example.userregisterapi.repository

import com.example.userregisterapi.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: JpaRepository<User, Long> {
}