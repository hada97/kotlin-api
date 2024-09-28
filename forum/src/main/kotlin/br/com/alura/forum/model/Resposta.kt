package br.com.alura.forum.model

import jakarta.persistence.Entity
import java.time.LocalDateTime
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Resposta (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),@ManyToOne
    val autor: Usuario,@ManyToOne
    val topico: Topico,
    val solucao: Boolean
)