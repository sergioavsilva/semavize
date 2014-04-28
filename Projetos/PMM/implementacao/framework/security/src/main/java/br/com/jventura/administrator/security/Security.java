package br.com.jventura.administrator.security;

public interface Security {
	
	/**
	 * Retorna o usuário corrente.
	 */
	String currentUser();
	
	/**
	 * Cria um usuario para autenticação no sistema
	 * 
	 * @param name - nome do usuario
	 * @param password - senha
	 */
	void createUser(String name,String password);
}
