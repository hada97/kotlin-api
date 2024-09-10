package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topico(
    val id: Long? = null,
    val titulo: `String`,
    val mensagem: `String`,
    val dataCriaclo: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTópico = StatusTópico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)

