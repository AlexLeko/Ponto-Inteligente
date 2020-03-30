package com.alexleko.pontointeligente.documents

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Empresa (

    var razaoSocial: String,
    var cnpj: String,
    @Id var id: String? = null

)

