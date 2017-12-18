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

/*

		Bar b1 = barRepository.save(new Bar("bar1","adress1"));
		Bar b2 = barRepository.save(new Bar("bar2","adress2"));
		Bar b3 = barRepository.save(new Bar("bar3","adress3"));
		Bar b4 = barRepository.save(new Bar("bar4","adress4"));




		Beer be1 = beerRepository.save(new Beer("beer1","type1",1));
		Beer be2 = beerRepository.save(new Beer("beer2","type2",1));
		Beer be3 = beerRepository.save(new Beer("beer3","type3",1));
		Beer be4 = beerRepository.save(new Beer("beer4","type4",1));
		Beer be5 = beerRepository.save(new Beer("beer5","type1",1));
		barInterfaceMetier.ajouterBeerToBar(be1,b1);
		barInterfaceMetier.ajouterBeerToBar(be1,b2);
		barInterfaceMetier.ajouterBeerToBar(be2,b4);
*/

	/*	Personne p1 = personneRepository.save(new Personne("personne1","prenom1", "login1","password1","status1","e","add"));
		Personne p2 = personneRepository.save(new Personne("personne2","prenom1", "login1","password1","status1","e","add"));
		Personne p3 = personneRepository.save(new Personne("personne3","prenom1", "login1","password1","status1","e","add"));

*/

		//List<Bar> listb = beerInterfaceMetier.trouverBarBeerNom("beer1");
		/*List<Bar> listb = beerInterfaceMetier.trouverBarBeerType("type2");
		for(int i=0 ; i < listb.size() ; i++){
				System.out.println(listb.get(i).toString());
			}*/


		//Beer be2 = beerRepository.save(new Beer("lilleBeer2","type2",2));
		//System.out.println(be2.toString());
		//Bar ba1 = barInterfaceMetier.chercherBarId(Long.parseLong(String.valueOf(9)));
		//Bar ba2 = barInterfaceMetier.chercherBarId(Long.parseLong(String.valueOf(5)));
		//System.out.println(ba1.toString());
		//Beer be1 = beerInterfaceMetier.ConsulterBeerId(Long.parseLong(String.valueOf(12)));
		//barInterfaceMetier.ajouterBeerToBar(be1,ba2);


		//List<Bar> listb = beerInterfaceMetier.trouverBarBeerNom("beer1");
		//for(int i=0 ; i < listb.size() ; i++){
		//	System.out.println(listb.get(i).toString());
		//}


		//barInterfaceMetier.ajouterBeerToBar(be2,ba1);



		//Personne p1 = personneRepository.save(new Personne("nom1","prenom1", "login1","password1","status1","e","add"));

		//p1.getBeersPreferes().add(be2);
		//personneInterfaceMeteir.ajouterBeerPrefere(p1,be2);


/*
		Personne p=personneRepository.save(new Personne("personne1","prenom4", "login1","password1","barman","e","add"));
		Bar ba2 = barInterfaceMetier.chercherBarId(Long.parseLong(String.valueOf(3)));
		personneInterfaceMeteir.ajouterBarPrefere(p,ba2);
		*/

		Bar ba = barInterfaceMetier.chercherBarNom("bar1");
		//System.out.println(ba.toString());
	}

}
