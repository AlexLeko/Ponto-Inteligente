package com.alexleko.pontointeligente.services

import com.alexleko.pontointeligente.documents.Funcionario
import com.alexleko.pontointeligente.enums.PerfilEnum
import com.alexleko.pontointeligente.repositories.FuncionarioRepository
import com.alexleko.pontointeligente.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureDataMongo
class FuncionarioServiceTest {

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    @Autowired
    private val funcionarioService: FuncionarioService? = null

    private val email: String = "email@gmail.com"
    private val cpf: String = "22233344455"
    private val id: String = "1"

    private fun funcionario(): Funcionario =
            Funcionario("Nome", email,
                                SenhaUtils().gerarBCript("123456"),
                                cpf, PerfilEnum.ROLE_USUARIO, id)

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
                .willReturn(funcionario())

        BDDMockito.given(funcionarioRepository?.findById(id))
                .willReturn(Optional.of(funcionario()))

        BDDMockito.given(funcionarioRepository?.findByEmail(email))
                .willReturn(funcionario())

        BDDMockito.given(funcionarioRepository?.findByCpf(cpf))
                .willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorId() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorId(id)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorEmail() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorEmail(email)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorCpf() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorCpf(cpf)
        Assertions.assertNotNull(funcionario)
    }

}