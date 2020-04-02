package com.alexleko.pontointeligente

import com.alexleko.pontointeligente.documents.Empresa
import com.alexleko.pontointeligente.documents.Funcionario
import com.alexleko.pontointeligente.enums.PerfilEnum
import com.alexleko.pontointeligente.repositories.EmpresaRepository
import com.alexleko.pontointeligente.repositories.FuncionarioRepository
import com.alexleko.pontointeligente.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PontointeligenteApplication (val empresaRepository: EmpresaRepository,
								   val funcionarioRepository: FuncionarioRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {

		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()

		val empresa: Empresa = Empresa("Empresa", "10443887000146")
		empresaRepository.save(empresa)

		val admin: Funcionario = Funcionario("Admin",
				"admin@empresa.com",
				SenhaUtils().gerarBCript("123456"),
				"25708317000", PerfilEnum.ROLE_ADMIN, empresa.id!!)
		funcionarioRepository.save(admin)

		System.out.println("Teste" + admin.id)

		val funcionario: Funcionario = Funcionario("Funcionario",
				"funcionario@empresa.com",
				SenhaUtils().gerarBCript("123456"),
				"44325441557", PerfilEnum.ROLE_USUARIO, empresa.id!!)
		funcionarioRepository.save(funcionario)
		System.out.println("Teste" + funcionario.id)


		println("Empresa ID: ${empresa.id}")
		println("Admin ID: ${admin.id}")
		println("Funcionario ID: ${funcionario.id}")

	}
}

fun main(args: Array<String>) {
	runApplication<PontointeligenteApplication>(*args)
}
