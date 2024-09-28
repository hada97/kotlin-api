package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.dto.NovoTopicoForm
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "tópico não encontrado!"
){

    fun listar(nomeCurso: String?): List<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll()
        } else {
            repository.findByCursoNome(nomeCurso)
        }
        return topicos.map { t ->  // 't' é o parâmetro que representa cada 'Topico'
            topicoViewMapper.map(t) // Chama o mapper passando 't'
        }
    }


    fun buscarPorId(id: Long): TopicoView {
        val topico =  repository.findById(id).stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico =  repository.findById(form.id).stream().filter { t -> t.id == form.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
       repository.deleteById(id)
    }

}