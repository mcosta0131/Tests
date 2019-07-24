import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Pessoa;

/*
 *CLASSE PARA TESTAR OPERACOES COM LAMBDA 
 * */
public class Lambda {
	public static void main(String[] args) {

//		Runnable r = () -> System.out.println("Thread com lambda");
//			
//		new Thread(r).start();

//		imprimeElementosSemLambda();
//		imprimeElementosComLambda();

//		juntaListasComLambda();

//		ordenaPessoa();
		varreListaString();
	}

	public static void juntaListasComLambda() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> list2 = new ArrayList<Integer>();

		list.forEach(n -> list2.add(n));
		System.out.println(list2);

	}

	/*
	 * DENTRO DE UMA FUNC LAMBDA É POSSIVEL REALIZAR DIVERSOS COMANDOS E
	 * VERIFICAÇÕES, ABAIXO ESTAMOS PRINTANDO O QUADRADO DE TODOS OS ELEMENTOS E
	 * FAZENDO UMA VERIFICAÇÃO SE O NUMERO É DIFERENTE DE 2
	 */
	public static void imprimeElementosComLambda() {
		System.out.println("Imprime todos os elementos da lista usando lambda!");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> {
			System.out.println("O quadrado do elemento " + n + " da lista : " + n * n);
			if (n != 2) {
				System.out.println(n);
			}
		});
	}

	/*
	 * Ordena uma collection de objetos usando lambda method Collections.sort();
	 */
	public static void ordenaPessoa() {
		List<Pessoa> listPessoas = Arrays.asList(new Pessoa("Eduardo", 29), new Pessoa("Zé Luiz", 32),
				new Pessoa("Bruna", 26));
		System.out.println("Ordenando pessoas pelo nome:");

		Collections.sort(listPessoas,
				(Pessoa pessoa1, Pessoa pessoa2) -> pessoa2.getNome().compareTo(pessoa1.getNome()));
		listPessoas.forEach(pessoa -> System.out.println(pessoa.getNome()));

		System.out.println("Ordenando pessoas pela idade:");
		Collections.sort(listPessoas,
				(Pessoa pessoa1, Pessoa pessoa2) -> pessoa1.getIdade().compareTo(pessoa2.getIdade()));

		listPessoas.forEach(pessoa -> System.out.println(pessoa.getIdade()));
	}

	public static void varreListaString() {
		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura online");
		palavras.add("Casa do codigo");
		palavras.add("Caelum");

		palavras.forEach(s -> System.out.println(palavras));

	}

}
