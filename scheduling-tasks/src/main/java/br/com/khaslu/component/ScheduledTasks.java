package br.com.khaslu.component;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The Class ScheduledTasks.
 *
 * @author Lucas Mota Vieira
 * @since 24/05/2016
 */
@Component
public class ScheduledTasks {

	/**
	 * Run.
	 */
	@Scheduled(fixedDelay = 5000)
	public void run() {

		final String mensagem = "O horário agora é {0}";
		final String horario = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(MessageFormat.format(mensagem, horario));
	}
}
