package com.alexleko.pontointeligente.services

import com.alexleko.pontointeligente.documents.Empresa

interface EmpresaService {

    fun buscarEmpresaCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa

}