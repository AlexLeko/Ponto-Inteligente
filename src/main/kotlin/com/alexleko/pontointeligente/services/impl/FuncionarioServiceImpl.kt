package com.alexleko.pontointeligente.services.impl

import com.alexleko.pontointeligente.documents.Funcionario
import com.alexleko.pontointeligente.repositories.FuncionarioRepository
import com.alexleko.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl (val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario = funcionarioRepository.save(funcionario)

    override fun buscarPorId(id: String): Funcionario? = funcionarioRepository.findById(id).get()

    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)

    override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)

}