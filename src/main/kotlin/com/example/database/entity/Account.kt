package com.example.database.entity

import javax.persistence.*

@Entity

class Account(

    @ManyToOne(optional = false)
    @JoinColumn(name = "Customer_Identity")
    var customer: Customer? = null,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1,

    @Column(name = "Branch", nullable = false, unique = false)
    val branch:  String,

    @Column(name = "accountNumber", nullable = false, unique = true)
    val accountNumber: Int = 0){
}
