package org.sid;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;


import java.util.List;

import org.sid.Entities.*;

import org.sid.dao.BarRepository;
import org.sid.dao.BeerRepository;
import org.sid.dao.PersonneRepository;
import org.sid.services.BarServiceInterface;
import org.sid.services.BeerServiceImplementation;
import org.sid.services.BeerServiceInterface;
import org.sid.services.PersonneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProjetBeerApplication implements CommandLineRunner{

	@Autowired
	BeerRepository beerRepository;
	@Autowired
	BarRepository barRepository;
	//@Autowired
	//PersonneRepository personneRepository;
	
	@Autowired
	private BeerServiceInterface beerInterfaceMetier;
	@Autowired
	private BarServiceInterface barInterfaceMetier;
	//@Autowired
	//private PersonneInterface personneInterfaceMeteir;

	public static void main(String[] args) {
		SpringApplication.run(ProjetBeerApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(ProjetBeerApplication.class);

	@Override
	public void run(String... strings) throws Exception {

		System.out.println("totooooooooooooooooooooooooooooooooooooooooooooo");
		Bar ba = barRepository.save(new Bar("bar5", "rue de toto"));
		Beer be = beerRepository.save(new Beer("beerdebar6","lite",2));
		//Beer be2 = beerRepository.save(new Beer("beerdebar3","lite",2));

		//ba.getBeers().add(be);
		//ba.getBeers().add(be2);
		//barRepository.save(ba);

		//System.out.println("la taille du "+ba.getBeers().size()) ;

		/*Personne p1 = personneRepository.save(new Personne("ELAZZAM", "Mustapha", "azzam", "password", "client", "toto@toto", "alunivbat"));

		personneInterfaceMeteir.ajouterBarPrefere(p1, ba);
		personneInterfaceMeteir.ajouterBeerPrefere(p1, be);

		List<Beer> lBeer = personneInterfaceMeteir.beerPrefereParPersonne(p1);
*/

	}

}
