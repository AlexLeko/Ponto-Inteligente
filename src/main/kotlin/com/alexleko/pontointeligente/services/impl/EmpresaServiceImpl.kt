package com.alexleko.pontointeligente.services.impl

import com.alexleko.pontointeligente.documents.Empresa
import com.alexleko.pontointeligente.repositories.EmpresaRepository
import com.alexleko.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl (val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)

}