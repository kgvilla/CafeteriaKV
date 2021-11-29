package com.kevinvilla.cafeteriaKV.model

import javax.persistence.*

@Entity
@Table(name = "cliente")
class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var name: String? = null
    var apellido: String? = null
    var cedula: String? = null

}