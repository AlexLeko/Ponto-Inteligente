package com.alexleko.pontointeligente.repositories

import com.alexleko.pontointeligente.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository : MongoRepository<Empresa, String>{

    fun findByCnpj(cnpj: String): Empresa?

}