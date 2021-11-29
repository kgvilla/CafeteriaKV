package com.kevinvilla.cafeteriaKV.model

import javax.persistence.*

@Entity
@Table(name = "registration")
class Registration {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var lugar: String? = null
    var fecha: String? = null
    var hora: String? = null
    @Column(name = "cliente_id")
    var clienteid: String? = null
    @Column(name = "cafeteria_id")
    var cafeteria_id: String? = null
}