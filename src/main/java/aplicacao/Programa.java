package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		/*
		 * XXX Criamos os objetos da classe normalmente, a unica diferen�a �:
		 * o campo ID foi colocado como um campo que � gerido pelo banco de dados
		 * ent�o criamos como null aqui no programa
		 */
//		Pessoa p1 = new Pessoa(null,"Carlos Silva", "Carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null,"Alberto Mendon�a", "Alberto@gmail.com");
//		Pessoa p3 = new Pessoa(null,"Maria Albuquerque", "Maria@gmail.com");
		/*
		 * XXX antes de iniciar uma transa��o no banco que n�o seja um "Select" temos que 
		 * iniciar a transa��o e no final 'comitar' ela
		 */
//		em.getTransaction().begin();
		/*
		 * XXX a fun��o persist salva o objeto da classe no banco.
		 */
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		
//		em.getTransaction().commit();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		System.out.println(p);
		/*
		 * XXX removendo uma linha
		 * para isso n�o podemos apenas criar um objeto com o id da linha que queremos apagar
		 * temos que pegar a linha/objeto usando o em.find para depois remover
		 * lembrando que o em.remove deve ser acompanhado da abertura e comit de transa��o
		 * como no em.persist 
		 */
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		System.out.println("Pronto");


	}

}
