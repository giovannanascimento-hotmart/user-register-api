package com.example.userregisterapi.entities

import javax.persistence.*

@Entity
@Table
data class Degrees(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var name: User,

    @Column
    var institution: String? = "",

    )
