package com.example.database.entity

import javax.persistence.*

@Entity
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountID")
    val accountID: Long? = null,

    @Column(name = "amount", nullable = false)
    var amount: Long = 0,

    @Column(name ="Title", nullable = false, unique = false)
    val title: String,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "Account_Item",
        joinColumns = [JoinColumn(name = "Account")],
        inverseJoinColumns = [JoinColumn(name = "Item")])

        val Accounts: MutableSet<Account> = mutableSetOf()
){
}