package com.alexleko.pontointeligente.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun gerarBCript(senha: String): String = BCryptPasswordEncoder().encode(senha)

}