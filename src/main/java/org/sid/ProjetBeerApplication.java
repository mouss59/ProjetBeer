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
	@Autowired
	PersonneRepository personneRepository;
	
	@Autowired
	private BeerServiceInterface beerInterfaceMetier;
	@Autowired
	private BarServiceInterface barInterfaceMetier;
	@Autowired
	private PersonneInterface personneInterfaceMeteir;

	public static void main(String[] args) {
		SpringApplication.run(ProjetBeerApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(ProjetBeerApplication.class);

	@Override
	public void run(String... strings) throws Exception {



		//Beer be2 = beerRepository.save(new Beer("lilleBeer2","type2",2));
		//System.out.println(be2.toString());
		Bar ba1 = barInterfaceMetier.chercherBarId(Long.parseLong(String.valueOf(9)));
		Bar ba2 = barInterfaceMetier.chercherBarId(Long.parseLong(String.valueOf(5)));
		//System.out.println(ba1.toString());
		Beer be1 = beerInterfaceMetier.ConsulterBeerId(Long.parseLong(String.valueOf(12)));
		barInterfaceMetier.ajouterBeerToBar(be1,ba2);


		List<Bar> listb = beerInterfaceMetier.trouverBarBeerNom("beer1");
		for(int i=0 ; i < listb.size() ; i++){
			System.out.println(listb.get(i).toString());
		}


		//barInterfaceMetier.ajouterBeerToBar(be2,ba1);



		//Personne p1 = personneRepository.save(new Personne("nom1","prenom1", "login1","password1","status1","e","add"));

		//p1.getBeersPreferes().add(be2);
		//personneInterfaceMeteir.ajouterBeerPrefere(p1,be2);
	}

}
