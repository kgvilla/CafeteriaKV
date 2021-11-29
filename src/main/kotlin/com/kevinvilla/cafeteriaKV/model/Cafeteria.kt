package com.kevinvilla.cafeteriaKV.model

import javax.persistence.*

@Entity
@Table(name = "cafeteria")
class Cafeteria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var registration: String? = null
    var client: String? = null
    var entrega: String? = null
}