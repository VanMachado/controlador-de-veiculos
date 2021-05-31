package com.van.log.api.dtos.responses;

public enum DiaRodizio {

	CASO_0(0, "segunda-feira", 2), CASO_1(1, "segunda-feira", 2), CASO_2(2, "terça-feira", 3),
	CASO_3(3, "terça-feira", 3), CASO_4(4, "quarta-feira", 4), CASO_5(5, "quarta-feira", 4),
	CASO_6(6, "quinta-feira", 5), CASO_7(7, "quinta-feira", 5), CASO_8(8, "sexta-feira", 6),
	CASO_9(9, "sexta-feira", 6);

	private Integer ultimoNumero;
	private String valor;
	private Integer diaDaSemana;

	private DiaRodizio(Integer ultimoNumero, String valor, Integer diaDaSemana) {

		this.ultimoNumero = ultimoNumero;
		this.valor = valor;
		this.diaDaSemana = diaDaSemana;

	}

	public static boolean isDiaRodizio(int dayOfWeek, Integer ultimoNumeroDoAno) {

		if (dayOfWeek < 1 || dayOfWeek > 6) {
			return true;
		}

		/*
		 * 2 - seg - caso 0 1 3 - ter - caso 2 3 4 - qua - caso 4 5 5 - qui - caso 6 7 6
		 * - sex - caso 8 9
		 */

		DiaRodizio diaRodizio = getDiaRodizioByUltimoNumero(ultimoNumeroDoAno);

		if (diaRodizio.diaDaSemana == dayOfWeek) {
			return true;
		}

		return false;

	}

	private static DiaRodizio getDiaRodizioByUltimoNumero(Integer ultimoNumero) {

		for (DiaRodizio diaRodizio : DiaRodizio.values()) {

			if (diaRodizio.ultimoNumero.equals(ultimoNumero)) {
				return diaRodizio;
			}

		}

		return null;

	}

	public static String getValorByUltimoNumero(Integer ultimoNumero) {

		for (DiaRodizio diaRodizio : DiaRodizio.values()) {

			if (diaRodizio.ultimoNumero.equals(ultimoNumero)) {
				return diaRodizio.valor;
			}

		}

		return null;

	}

}
