package com.example.userregisterapi.entities

import javax.persistence.*

@Entity
@Table(name = "address")
data class Address (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var city: String? = "",

    @Column
    var street: String? = "",

    @Column
    var number: String? = "",

    @Column
    var neighborhood: String? = "",

    @Column
    var country: String? = ""
)
