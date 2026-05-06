package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.printf("A conta número: %d não foi encontrada!%n", numero);
		}
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.printf("A conta número %d foi criada com sucesso!%n", conta.getNumero());
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.printf("A conta número: %d foi atualizada com sucesso!%n", conta.getNumero());
		} else {
			System.out.printf("A conta número: %d não foi encontrada!%n", conta.getNumero());
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.printf("\nA Conta número: %d foi deletada com sucesso!%n", numero);
			}
		} else {
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		}
	}

	@Override
	public void sacar(int numero, float valor) {

		var conta = buscarNaCollection(numero);
		if(conta != null) {
			if (conta.sacar(valor) == true) {
				System.out.printf("\nO saque na Conta número: %d foi efetuado com sucesso!", numero);;
			}
		} else {
			System.out.printf("\nA Conta número: %d não foi encontrada!%n", numero);
		}
	}

	@Override
	public void depositar(int numero, float valor) {

		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.printf("\nO Depósito na Conta numero: %d foi efetuado com sucesso!", numero);
		}else { 
			System.out.printf("\nA conta número: %d não foi encontrada!%n", numero);
		}
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.printf("\nA transfêrencia da conta: %d, para a conta: %d foi efetuada com sucesso!",
						numeroOrigem, numeroDestino);
			}
		} else {
			System.out.println("\nA conta de Origem e/ou Destino não foram encontradas!");
		}
		
	}

	public int gerarNumero() {
		return ++numero;

	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;

			}
		}
		return null;

	}

}
