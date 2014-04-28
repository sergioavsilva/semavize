package br.com.semavize.pmm.tracking.model;

/**
 * Entidade que representa o tipo de envio.
 * 
 * @author S�rgio Augusto
 * 
 * 
 *         C�digo Servi�o 40010 SEDEX sem contrato 40045 SEDEX a Cobrar, sem
 *         contrato 40126 SEDEX a Cobrar, com contrato 40215 SEDEX 10, sem
 *         contrato 40290 SEDEX Hoje, sem contrato 40096 SEDEX com contrato
 *         40436 SEDEX com contrato 40444 SEDEX com contrato 40568 SEDEX com
 *         contrato 40606 SEDEX com contrato 41106 PAC sem contrato 41068 PAC
 *         com contrato
 * 
 *         NAO CODIFICADO 81019 e-SEDEX, com contrato 81027 e-SEDEX Priorit�rio,
 *         com conrato 81035 e-SEDEX Express, com contrato 81868 (Grupo 1)
 *         e-SEDEX, com contrato 81833 (Grupo 2) e-SEDEX, com contrato 81850
 *         (Grupo 3) e-SEDEX, com contrato
 */

public enum SendType {
	SEDEX(40010), SEDEX_ACSC(40045), SEDEX_ACCC(40126), SEDEX_10(40215), SEDEX_TODAY(
			40290), SEDEX_CC1(40096), SEDEX_CC2(40436), SEDEX_CC3(40444), SEDEX_CC4(
			40568), SEDEX_CC5(40606), PAC_SC(41106), PAC_CC(41068);

	private int codigo;

	private SendType(int cod) {
		codigo = cod;
	}

	public int getCodigo() {
		return codigo;
	}
};
