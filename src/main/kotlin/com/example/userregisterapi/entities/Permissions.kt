package com.example.userregisterapi.entities

import javax.persistence.*

@Entity
@Table
data class Permissions(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    var name: String? = "",

    @Column
    var permission: String? = "",

    )