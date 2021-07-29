package com.example.database.entity

import javax.persistence.*


@Entity

class Customer (
    @Column(name = "Customer_Identity")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val identity:Long = -1,

    @Column(name ="Name", nullable = false, unique = false)
    val name: String){

}