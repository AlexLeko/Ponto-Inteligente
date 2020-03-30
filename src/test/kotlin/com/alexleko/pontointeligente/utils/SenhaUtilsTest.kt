package com.alexleko.pontointeligente.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtilsTest {

    private val SENHA = "123456"
    private val bCriptEncoder = BCryptPasswordEncoder()

    @Test
    fun testGerarHashSenha() {
        val hash = SenhaUtils().gerarBCript(SENHA)
        Assertions.assertTrue(bCriptEncoder.matches(SENHA, hash))
    }

}