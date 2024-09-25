package br.com.alura.forum.model.dto

data class NovoTopicoForm(

    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long,

)
