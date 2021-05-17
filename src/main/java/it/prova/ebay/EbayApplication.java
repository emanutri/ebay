package it.prova.ebay;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.StatoUtente;
import it.prova.ebay.model.Utente;
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;

@SpringBootApplication
public class EbayApplication implements CommandLineRunner {

	@Autowired
	private RuoloService ruoloServiceInstance;
	@Autowired
	private UtenteService utenteServiceInstance;


	public static void main(String[] args) {
		SpringApplication.run(EbayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
			ruoloServiceInstance.inserisci(new Ruolo("Administrator", "ROLE_ADMIN"));
		}

		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER") == null) {
			ruoloServiceInstance.inserisci(new Ruolo("Classic User", "ROLE_CLASSIC_USER"));
		}

		if (utenteServiceInstance.findByUserName("admin") == null) {
			Utente admin = new Utente("Mario", "Rossi", "admin", "admin", new Date(), StatoUtente.ATTIVO);
			admin.setCodiceFiscale("MNGGCM94P20D704Z");
			admin.setDataNascita(new SimpleDateFormat("dd/MM/yyyy").parse("20/09/1994"));
			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));
			utenteServiceInstance.inserisci(admin);
		}

		if (utenteServiceInstance.findByUserName("user") == null) {
			Utente classicUser = new Utente("Antonio", "Verdi", "user", "user", new Date(), StatoUtente.ATTIVO);
			classicUser.setCodiceFiscale("MNGGCM94P20D704Z");
			classicUser.setDataNascita(new SimpleDateFormat("dd/MM/yyyy").parse("20/09/1994"));
			utenteServiceInstance.inserisci(classicUser);
		}

		if (utenteServiceInstance.findByUserName("user1") == null) {
			Utente classicUser1 = new Utente("Andrea", "Blue", "user1", "user1", new Date(), StatoUtente.ATTIVO);
			classicUser1.setCodiceFiscale("MNGGCM94P20D704Z");
			classicUser1.setDataNascita(new SimpleDateFormat("dd/MM/yyyy").parse("20/09/1994"));
			utenteServiceInstance.inserisci(classicUser1);
		}

		if (utenteServiceInstance.findByUserName("user2") == null) {
			Utente classicUser2 = new Utente("Giorgio", "Viola", "user2", "user2", new Date(), StatoUtente.ATTIVO);
			classicUser2.setCodiceFiscale("MNGGCM94P20D704Z");
			classicUser2.setDataNascita(new SimpleDateFormat("dd/MM/yyyy").parse("20/09/1994"));
			utenteServiceInstance.inserisci(classicUser2);
		}

	}

}
