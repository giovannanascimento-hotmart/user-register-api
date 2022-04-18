package com.example.userregisterapi.entities

import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    var name: String? = "",

    @Column
    var cpf: String? = ""
)

