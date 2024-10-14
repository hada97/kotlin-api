package br.com.alura.forum.service

import br.com.alura.forum.mapper.TopicoFormMapper;
import br.com.alura.forum.mapper.TopicoViewMapper;
import br.com.alura.forum.repository.TopicoRepository;
import io.mockk.every;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

class TopicoServiceTest {

    val paginacao: Pageable = mockk()

    val topicos = PageImpl(ListOf(TopicoTest.build()))

    val topicoRepository: TopicoRepository = mockk {
        every { findByCursoNome(any(), any()) } returns topicos
    }

    val topicoViewMapper: TopicoViewMapper = mockk()
    val topicoFormMapper: TopicoFormMapper = mockk()

    val topicoService = TopicoService(
            topicoRepository,topicoViewMapper,topicoFormMapper
    )

    @Test
    fun `deve listar topicos a partir do nome do curso`() {
        topicoService.listar("Kotlin avançado", paginacao)
    }

}