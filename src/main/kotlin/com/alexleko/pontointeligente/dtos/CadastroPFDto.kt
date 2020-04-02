package com.alexleko.pontointeligente.dtos

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class CadastroPFDto (

        @get:NotEmpty(message = "Nome não pode ser vazio.")
        @get:Length(min = 3, max = 200, message = "Nome deve ter entre 3 e 200 caracteres.")
        val nome: String = "",

        @get:NotEmpty(message = "E-mail não pode ser vazio.")
        @get:Length(min = 5, max = 200, message = "E-mail deve ter entre 5 e 200 caracteres.")
        @get:Email(message = "E-mail Inválido.")
        val email: String = "",

        @get:NotEmpty(message = "Senha não pode ser vazia.")
        val senha: String = "",

        @get:NotEmpty(message = "CPF não pode ser vazio.")
        @get:CPF(message = "CPF Inválido.")
        val cpf: String = "",

        val empresaId: String = "",

        val valorHora: String? = null,
        val qtdHorasTrabalhoDia: String? = null,
        val qtdHorasAlmoco: String? = null,

        val id: String? = null

)