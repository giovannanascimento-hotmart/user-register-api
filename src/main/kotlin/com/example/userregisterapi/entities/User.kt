package com.example.userregisterapi.entities

import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    var nome: String? = "",

    @Column
    var cpf: String? = "",

    @OneToOne
    var adress: Address = Address(),

    @OneToMany(mappedBy = "users")
    var degrees: MutableSet<Degrees> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
    name = "users_permissions",
    joinColumns = [JoinColumn(name = "users", referencedColumnName = "id")],
    inverseJoinColumns = [JoinColumn(name = "permissions", referencedColumnName = "id")])
    var permissions: MutableSet<Permissions> = mutableSetOf()

    )


