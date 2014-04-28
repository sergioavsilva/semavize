package br.com.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.objectlab.kit.datecalc.common.DateCalculator;
import net.objectlab.kit.datecalc.common.DefaultHolidayCalendar;
import net.objectlab.kit.datecalc.common.HolidayCalendar;
import net.objectlab.kit.datecalc.common.HolidayHandlerType;
import net.objectlab.kit.datecalc.joda.LocalDateKitCalculatorsFactory;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;

import de.jollyday.Holiday;
import de.jollyday.HolidayManager;
import de.jollyday.HolidayType;
import de.jollyday.config.Holidays;

public class CalculoDeDias {

	public static void main(String[] args) {

		DateTime dataInicial = new DateTime(2013, 2, 1, 00, 00);
		DateTime dataFinal = new DateTime(2013, 2, 28, 23, 59);
		
		//Feriado criado manualmente
		DateTime feriado = new DateTime(2013, 2, 25, 12, 0);

		HolidayManager gerenciadorDeFeriados = HolidayManager.getInstance(de.jollyday.HolidayCalendar.BRAZIL);
		Set<Holiday> feriados = gerenciadorDeFeriados.getHolidays(new DateTime().getYear());
		Set<LocalDate> dataDosFeriados = new HashSet<LocalDate>();
		
		
		//Adicionando um feriado
		dataDosFeriados.add(new LocalDate(feriado, ISOChronology.getInstance()));

		for (Holiday h : feriados) {
			dataDosFeriados.add(new LocalDate(h.getDate(), ISOChronology.getInstance()));
			// System.out.println("Feriado: " + h.toString());
		}

		HolidayCalendar<LocalDate> calendarioDeFeriados = new DefaultHolidayCalendar<LocalDate>(
				dataDosFeriados);
		LocalDateKitCalculatorsFactory.getDefaultInstance().registerHolidays(
				"BR", calendarioDeFeriados);
		DateCalculator<LocalDate> calendario = LocalDateKitCalculatorsFactory
				.getDefaultInstance().getDateCalculator("BR",
						HolidayHandlerType.FORWARD);

		int diasNaoUteis = 0;

		LocalDate dataInicialTemporaria = new LocalDate(dataInicial);
		LocalDate dataFinalTemporaria = new LocalDate(dataFinal);

		while (!dataInicialTemporaria.isAfter(dataFinalTemporaria)) {
			if (calendario.isNonWorkingDay(dataInicialTemporaria)
					&& !dataInicialTemporaria.dayOfWeek().getAsText().equalsIgnoreCase("sábado")) {

				System.out.println("Dia: "
						+ dataInicialTemporaria.dayOfWeek().getAsText() + " - "
						+ dataInicialTemporaria.dayOfWeek().getLocalDate());
				diasNaoUteis++;
			}
			dataInicialTemporaria = dataInicialTemporaria.plusDays(1);
		}

		System.out.println(diasNaoUteis);
 
		/*
		 * for (LocalDate localDate : dataDosFeriados) {
		 * System.out.println(localDate.toString()); }
		 */
	}

}
