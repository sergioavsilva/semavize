package br.com.jventura.commonsresource.controller;
/**
 * 
 * @author henrique Classe base para todo ManagerBean que execute alguma
 *         operação. Ex: Inserir, Filtrar, Remover, Modificar.
 */
public abstract class BaseController<T>{

	/**
	 * Esse método é utilizado pelo botão Executar padrão da tela,dentro dele
	 * deve conter um switch case com as opções do selectOneMenu. 
	 * Ex: Inserir,Filtrar, Remover, Modificar.
	 * 
	 * @return O valro do método escolhido no swicth case
	 */
	public abstract void execute();
	
	/**
	 * Esse método é utilizado pelo listener <p:ajax /> dentro da tag
	 * <p:dataTable /> que é responsavel por pegar o objeto que foi 
	 * selecionado (<b>selected</b>) no dataTable e atualizar os inputs da tela.
	 * Ex: people = selected;
	 */
	public abstract void refrehInputs();

	/**
	 * 
	 */
	public abstract void refrehInputsMandatory();
	
	/**
	 * Operacao - essa variavel recebe o valor do selectOneMenu,ela é utilizada
	 * dentro do método execute() no switch case para que o método correto seje
	 * executado.
	 */
	private Integer operacao = 1;
	
	/**
	 * Selected - Variavel que recebe o item selecionado da tabela
	 */
	private T selected;	
	
	/**
	 * isMandatory - Define qual campo é obrigatorio
	 */
	private boolean isMandatory = false;
	
	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	public Integer getOperacao() {
		return operacao;
	}

	public void setOperacao(Integer operacao) {
		this.operacao = operacao;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}
	
	
	
	
}
