import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/*
 * Classe de exemplos de uso de api's de datas 
 * */
public class TesteDatas {

	public static void main(String[] args) {
		Instant agora = Instant.now();

		System.out.println("DATA UTILIZANDO INSTANT: " + agora);

		Instant inicio = Instant.now();
		rodaAlgoritmo();
		Instant fim = Instant.now();

		Duration duracao = Duration.between(inicio, fim);
		long duracaoNanos = duracao.toNanos();
		System.out.println("TEMPO DE EXECUÇÃO DO ALGORITMO: " + duracaoNanos);

		LocalDate hoje = LocalDate.now();
		System.out.println("DATA UTILIZANDO LOCALDATE : " + hoje); // 2014-04-08 (formato ISO-8601)

		ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
		ZoneId fusoHorarioDeNovaYork = ZoneId.of("America/New_York");

		LocalDateTime saidaDeSaoPauloSemFusoHorario = LocalDateTime.of(2014, Month.APRIL, 4, 22, 30);

		LocalDateTime chegadaEmNovaYorkSemFusoHorario = LocalDateTime.of(2014, Month.APRIL, 5, 7, 10);

		ZonedDateTime saidaDeSaoPauloComFusoHorario = ZonedDateTime.of(saidaDeSaoPauloSemFusoHorario,
				fusoHorarioDeSaoPaulo);

		ZonedDateTime chegadaEmNovaYorkComFusoHorario = ZonedDateTime.of(chegadaEmNovaYorkSemFusoHorario,
				fusoHorarioDeNovaYork);
		System.out.println(chegadaEmNovaYorkComFusoHorario); // 2014-04-05T07:10-04:00[America/New_York]

		Duration duracaoDoVoo = Duration.between(saidaDeSaoPauloComFusoHorario, chegadaEmNovaYorkComFusoHorario);
		System.out.println(duracaoDoVoo); // PT9H40M
		
		
		LocalDate diaDeHoje = LocalDate.now();
		System.out.println(diaDeHoje + " SEM FORMATAR ");
		
		DateTimeFormatter formatador =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = diaDeHoje.format(formatador); //08/04/2014
		System.out.println(dataFormatada + " FORMATADA ");
		
		LocalDateTime agr = LocalDateTime.now();
		DateTimeFormatter formatadorDois = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
				.withLocale(new Locale("pt", "br"));
		String dataComLocale = agr.format(formatadorDois); // 08/04/14 10:02
		System.out.println("DATA COM LOCALE :" + dataComLocale);
		
		//CONVERTENDO CALENDAR PARA INSTANT E DATE PARA INSTANT
		Calendar calendar = Calendar.getInstance();
		Instant instantAPartirDoCalendar = calendar.toInstant();
		Date dateAPartirDoInstant = Date.from(instantAPartirDoCalendar);
		Instant instantAPartirDaDate = dateAPartirDoInstant.toInstant();    
		
		//NOVO CONSTRUTOR DO CALENDAR
		Calendar calendario =  
			      new Calendar.Builder()  
			        .setDate(2014, Calendar.APRIL, 8)  
			        .setTimeOfDay(10, 2, 57)  
			        .setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"))  
			        .setLocale(new Locale("pt", "br"))
			        .build(); 
	}

	public static void rodaAlgoritmo() {
		System.out.println("ALGORITMO");
	}

}
