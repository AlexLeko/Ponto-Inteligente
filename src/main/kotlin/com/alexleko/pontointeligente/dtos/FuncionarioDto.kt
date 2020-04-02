package com.alexleko.pontointeligente.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class FuncionarioDto (

        @get:NotEmpty(message = "Nome não pode ser vazio.")
        @get:Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
        val nome: String = "",

        @get:NotEmpty(message = "E-mail não pode ser vazio.")
        @get:Length(min = 5, max = 200, message = "E-mail deve conter entre 3 e 200 caracteres.")
        @get:Email(message = "E-mail inválido.")
        val email: String = "",

        val senha: String? = null,
        val valorHora: String? = null,
        val qtdHorasTrabalhadas: String? = null,
        val qtdHorasAlmoco: String? = null,
        val id: String? = null

)