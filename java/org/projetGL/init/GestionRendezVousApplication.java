package org.projetGL.init;

import java.util.Date;
import java.util.List;

import org.projetGL.init.Dao.HopitalRepository;
import org.projetGL.init.Dao.MedecinRepository;
import org.projetGL.init.Dao.PatientRepository;
import org.projetGL.init.Dao.PlageHoraireRepository;
import org.projetGL.init.Dao.RendezVousRepository;
import org.projetGL.init.Entites.Hopital;
import org.projetGL.init.Entites.Medecin;
import org.projetGL.init.Entites.Patient;
import org.projetGL.init.Entites.PlageHoraire;
import org.projetGL.init.Entites.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;import org.springframework.data.repository.query.Param;

@SpringBootApplication
public class GestionRendezVousApplication implements CommandLineRunner{
	@Autowired
	PatientRepository patientDao;
	
	@Autowired
	MedecinRepository medecinDao;
	
	@Autowired
	HopitalRepository hopitalDao;
	
	@Autowired
	PlageHoraireRepository plageHoraire;
	
	@Autowired
	RendezVousRepository rendezvousRepository;
	
	private String chaineAdecouper ="bonjour tous le monde";

	public static void main(String[] args) {
		SpringApplication.run(GestionRendezVousApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		//hopital
//		Hopital hospital1 = new Hopital("hopital Banka", "Rue de saint paul 19");
//		hospital1.setTelefoneHopital(848657869);
//		hopitalDao.save(hospital1);
//		
//		Hopital hospital2 = new Hopital("Hanoi Family Medical Practice", "Building A1, Van Phuc");
//		hospital2.setTelefoneHopital(847552145);
//
//		hopitalDao.save(hospital2);
//		
//		Hopital hospital3 = new Hopital("Franco-Vietnamese Hospital", "MD5-1 Saigon South");
//		hospital3.setTelefoneHopital(835448956);
//
//		hopitalDao.save(hospital3);
//		
//		Hopital hospital4 = new Hopital("Hanoi Dental Clinic", "Building A2, Van Phuc");
//		hospital4.setTelefoneHopital(330211585);
//
//		hopitalDao.save(hospital4);
//		
//		
//		
//		//medecin
//		Medecin medecin1 = new  Medecin("MDC1", "Dongmo", "Robertine", "Douala-Bedi",679139026, "Churigien");
//		medecinDao.save(medecin1);
//		
//		Medecin medecin2 = new  Medecin("MDC2", "Founang", "Kouchi", "Porto-novo",673374102, "Pediatre");
//		medecinDao.save(medecin2);
//		
//		Medecin medecin3 = new  Medecin("MDC3", "Diakité", "Djeila Brovosky", "Konakri",673374102, "Pediatre");
//		medecinDao.save(medecin3);
//		
//		Medecin medecin4 = new  Medecin("MDC4", "Lamah", "Richard Spinatana", "Ha noi",673374102, "Pediatre");
//		medecinDao.save(medecin4);
//		
//		Medecin medecin5 = new  Medecin("MDC5", "Rakotoassimbola", "Nagazaki", "Malagazi",673374102, "Pediatre");
//		medecinDao.save(medecin5);
//		
//		Medecin medecin6 = new  Medecin("MDC6", "Azemena", "Henri Joel furher", "Yaoundé-Hawai",673374102, "Pediatre");
//		medecinDao.save(medecin6);
//		
//		Medecin medecin7 = new  Medecin("MDC7", "Henry", "Kpakilé Parino", "Joanesbourg",673374102, "Gastroantérologue20");
//		medecinDao.save(medecin7);
//		
//		Medecin medecin8 = new  Medecin("MDC8", "Mezatio", "Eric Escoba", "Dschang-Bafou",673374102, "Gastroantérologue");
//		medecinDao.save(medecin8);
//	
//		Medecin medecin9 = new  Medecin("MDC9", "Inoussa", "Oudrago Salama", "SAnkarito",673374102, "Gastroantérologue");
//		medecinDao.save(medecin9);
//		
//		Medecin medecin10 = new  Medecin("MD10", "Adoum", "Okim-Bokar", "Djamena",673374102, "Gastroantérologue");
//		medecinDao.save(medecin10);
//		
//		Medecin medecin11= new  Medecin("MDC11", "Kenley", "Favard Amigos", "Santo-Rico",673374102, "Gastroantérologue");
//		medecinDao.save(medecin11);
//		
//		Medecin medecin12 = new  Medecin("MDC12", "Sammuel", "Jean SAbatané", "Ile de Comoré",673374102, "Gastroantérologue");
//		medecinDao.save(medecin12);
//		
//		Medecin medecin13 = new  Medecin("MDC13", "Dalby", "Auguste Kirkorff", "Douala-Bedi",673374102, "Laborantain");
//		medecinDao.save(medecin13);
//		
//		Medecin medecin14 = new  Medecin("MDC14", "Nelka", "Delux Micouri", "Saragévo",673374102, "Laborantain");
//		medecinDao.save(medecin14);
//		
//		Medecin medecin15 = new  Medecin("MDC15", "Steven", "Cibambo Yaka", "el dorado",673374102, "Laborantain");
//		medecinDao.save(medecin15);
//		
//		Medecin medecin16 = new  Medecin("MDC16", "Hoan", "Kim Bich", "Dai-bai",673374102, "Laborantain");
//		medecinDao.save(medecin16);
//		
//		Medecin medecin17 = new  Medecin("MDC17", "Timothé", "Bohinbo Bémann", "Garoul",673374102, "Laborantain");
//		medecinDao.save(medecin17);
//		
//		Medecin medecin18 = new  Medecin("MDC18", "Ben", "Cissoko Nack-Bitt", "Mali-Malinké",673374102, "Laborantain");
//		medecinDao.save(medecin18);
//		
//		Medecin medecin19 = new  Medecin("MDC19", "Richmond", "Réel Olembo Tchaka", "Brazavilia",673374102, "Dentiste");
//		medecinDao.save(medecin19);
//		
//		Medecin medecin20 = new  Medecin("MDC20", "Koffi", "Hervé Kamto", "Cotonou",673374102, "Dentiste");
//		medecinDao.save(medecin20);
//		
//		Medecin medecin21 = new  Medecin("MDC21", "DEGUE", "Mama Sita", "YAoundé-cradat",673374102, "Dentiste");
//		medecinDao.save(medecin21);
//		
//		Medecin medecin22 = new  Medecin("MDC22", "Cissé", "Abdoulaye Mona", "yakamora",673374102, "Dentiste");
//		medecinDao.save(medecin22);
//		
//		Medecin medecin23 = new  Medecin("MDC23", "ZAmbo", "Anguissa Lisou", "ombessala",673374102, "Dentiste");
//		medecinDao.save(medecin23);
//		
//		Medecin medecin24 = new  Medecin("MDC24", "Lê", "Ega Spinto", "YAmousoucrous",673374102, "Dentiste");
//		medecinDao.save(medecin24);
//		
//		Medecin medecin25 = new  Medecin("MDC25", "Thành Hà", "Fosso Birdanov", "Abidjan",673374102, "Chirurgien");
//		medecinDao.save(medecin25);
//		
//		Medecin medecin26 = new  Medecin("MDC26", "Thành Lốn", "Jean Sperctzi", "Cairo-caire",673374102, "Chirurgien");
//		medecinDao.save(medecin26);
//		
//		Medecin medecin27 = new  Medecin("MDC27", "Ngô", "Marie", "East-lobel",673374102, "Chirurgien");
//		medecinDao.save(medecin27);
//		
//		Medecin medecin28 = new  Medecin("MDC28", " Dũng Bi Qwo", "Dagobert", "Kasablanca",673374102, "Chirurgien");
//		medecinDao.save(medecin28);
//		
//		Medecin medecin29 = new  Medecin("MDC29", "Đặng", "zibi Tamanga", "Kaboul",673374102, "Chirurgien");
//		medecinDao.save(medecin29);
//		
//		Medecin medecin30 = new  Medecin("MDC30", "Phạm", "souley Wayai", "Pretoria",673374102, "Chirurgien");
//		medecinDao.save(medecin30);
//		
//		Medecin medecin31 = new  Medecin("MDC31", "Dang", "Sankara", "Saint John's",673374102, "Neurologue");
//		medecinDao.save(medecin31);
//		
//		Medecin medecin32 = new  Medecin("MDC32", "Duong", "Thomas WAyayoui", "Bakou",673374102, "Neurologue");
//		medecinDao.save(medecin32);
//		
//		Medecin medecin33 = new  Medecin("MDC33", "Hoang", "Felix Arrangemento", "Manama",673374102, "Neurologue");
//		medecinDao.save(medecin33);
//		
//		Medecin medecin34 = new  Medecin("MDC34", "Pham", "Moumié On-theMix", "Nassau",673374102, "Neurologue");
//		medecinDao.save(medecin34);
//		
//		Medecin medecin35 = new  Medecin("MDC35", "Tran", "Manga-Bell Hitman", "Dacca",673374102, "Neurologue");
//		medecinDao.save(medecin35);
//		
//		Medecin medecin36 = new  Medecin("MDC36", "Nguyen", "Matin paul Samba", "Alger",673374102, "Neurologue");
//		medecinDao.save(medecin36);
//		
//		
//		//patient
//		Patient patient1 = new Patient("Mezatio", "Eric Papain", "KTX MY DINH HANOI", 699864101, "ericpapainmezatio@gmail.com");
//		patientDao.save(patient1);
//		
//		Patient patient2 = new Patient("Azemena", "Henri Joel", "Metri DINH HANOI", 691603819, "azemhenri@gmail.com");
//		patient2.setChoixServices("neo natologie");
//		patientDao.save(patient2);	
//		
//		//plageHoraire
//		PlageHoraire plage1= new PlageHoraire(00, 03, true, medecin1);
//		plageHoraire.save(plage1);
//		
//		PlageHoraire plage2= new PlageHoraire(03,6, true, medecin2);
//		plageHoraire.save(plage2);
//		
//		PlageHoraire plage3= new PlageHoraire(6, 10, true, medecin1);
//		plageHoraire.save(plage3);
//		
//		PlageHoraire plage4= new PlageHoraire(11,16, true, medecin2);
//		plageHoraire.save(plage4);
//		
//		PlageHoraire plage5= new PlageHoraire(17, 20, true, medecin1);
//		plageHoraire.save(plage5);
//		
//		PlageHoraire plage6= new PlageHoraire(20,23, true, medecin2);
//		plageHoraire.save(plage6);
//		
//		//rendezvous
//		RendezVous rendezvous1 = new RendezVous(plage1,patient1, hospital1, medecin1);
//		rendezvousRepository.save(rendezvous1);
//		
//		RendezVous rendezvous2 = new RendezVous(plage2, patient2, hospital1, medecin2);
//		rendezvousRepository.save(rendezvous2);
//
//
//		
//		//insertion dans des tables patient
//		patient1.setHopitalPatient(hospital1);
//		patient1.setMedecinAffecter(medecin1);
//		patient1.setDateEnregistrement(new Date());
//		patient1.setCodePatient("code1");
//		patient1.setReservation(rendezvous1);
//		
//
//		//insertion dans des tables patient
//				patient2.setHopitalPatient(hospital1);
//				patient2.setMedecinAffecter(medecin2);
//				patient2.setDateEnregistrement(new Date());
//				patient2.setCodePatient("code2");
//				patient2.setReservation(rendezvous2);
//		
//				
//		//insertion dans des tables medecin
//		medecin1.setHopitalMedecin(hospital1);
//		medecin1.getListHoraireMedecin().add(plage1);
//		medecin1.setRdvMedecin(rendezvous1);
//		medecin1.getListPatientMed().add(patient1);
//		medecin1.setEmailMedecin("nanaton@gmail.com");
//
//		
//		
//		
//		//insertion dans des tables medecin
//				medecin2.setHopitalMedecin(hospital1);
//				medecin2.getListHoraireMedecin().add(plage2);
//				medecin2.setRdvMedecin(rendezvous2);
//				medecin2.getListPatientMed().add(patient2);
//				medecin2.setEmailMedecin("nomanito@gmail.com");
//
//		//insertion dans la table hopital
//		hospital1.getListMedecinHopital().add(medecin1);
//		hospital1.getListPatientHopital().add(patient1);
//		hospital1.getListRendeVousHopital().add(rendezvous1);
//		
//		
//		//insertion dans la table hopital
//				hospital1.getListMedecinHopital().add(medecin2);
//				hospital1.getListPatientHopital().add(patient2);
//				hospital1.getListRendeVousHopital().add(rendezvous2);
//		
//		
//		//insertion dans la table rendez vous
//		
//		
//		
//		//enregistrement
//		hopitalDao.save(hospital1);
//		medecinDao.save(medecin1);
//		medecinDao.save(medecin2);		
//
//		patientDao.save(patient1);
//		patientDao.save(patient2);	
//
//		plageHoraire.save(plage1);
//		plageHoraire.save(plage2);
//
//		rendezvousRepository.save(rendezvous1);
//		rendezvousRepository.save(rendezvous2);
//		
//		//affectation des medecin dans les hopitaux
//		
//				List<Medecin> listMedecin = medecinDao.findAll();
//				
//				for (Medecin m : listMedecin) {
//					
//					if (m.getIdMedecin()==23|m.getIdMedecin()==5|m.getIdMedecin()==7|m.getIdMedecin()==13|m.getIdMedecin()==19|m.getIdMedecin()==25|m.getIdMedecin()==31|m.getIdMedecin()==35) {
//						
//						m.setHopitalMedecin(hospital1);
//						m.setEmailMedecin("medecinsos1@gmail.com");
//						m.setHeureRDV("06h--08h");			
//						medecinDao.save(m);
//					} else if(m.getIdMedecin()==24|m.getIdMedecin()==12|m.getIdMedecin()==36|m.getIdMedecin()==6|m.getIdMedecin()==14|m.getIdMedecin()==20|m.getIdMedecin()==26|m.getIdMedecin()==32|m.getIdMedecin()==36){
//						
//						m.setHopitalMedecin(hospital2);
//						m.setEmailMedecin("ericpapainmezatio@gmail.com");
//						m.setHeureRDV("08h--10h");			
//
//						medecinDao.save(m);
//					} else if(m.getIdMedecin()==30|m.getIdMedecin()==8|m.getIdMedecin()==3|m.getIdMedecin()==9|m.getIdMedecin()==15|m.getIdMedecin()==21|m.getIdMedecin()==27|m.getIdMedecin()==33){
//						
//						m.setHopitalMedecin(hospital3);
//						m.setEmailMedecin("deguemireille@gmail.com");
//						m.setHeureRDV("10h--12h");			
//
//						medecinDao.save(m);
//					} else if(m.getIdMedecin()==29|m.getIdMedecin()==18|m.getIdMedecin()==17|m.getIdMedecin()==11|m.getIdMedecin()==4|m.getIdMedecin()==10|m.getIdMedecin()==16|m.getIdMedecin()==22|m.getIdMedecin()==28|m.getIdMedecin()==34){
//						
//						m.setHopitalMedecin(hospital4);
//						m.setEmailMedecin("kenley.favard@gmail.com");
//						m.setHeureRDV("12h--14h");			
//
//						medecinDao.save(m);
//					}
//				}
//		
//		
//		
//		System.out.println("*******************VOICI LE DEBUT  DE TON POGRAMME DE TEST*****************************");
//		System.out.println("****************************"+hospital1.getIdHopital()+"*******************************");
//		System.out.println("*********************** RENDEZ VOUS : 1 *****************************");
//		List<Patient> lis = (List<Patient>) hospital1.getListPatientHopital();
//		
//		for (Patient patient : lis) {
//			
//			System.out.println("************************"+patient.getAdressePatient()+"*****************************");
//			System.out.println("************************"+patient.getEmailMenbre()+"********************************");
//			System.out.println("************************"+patient.getNomPatient()+"********************************");
//			System.out.println("***********************************************************************************");
//		}
//		
//		List<Medecin> listPediatre = medecinDao.findListMedecinCategorie("Pediatre");
//		
//		for (Medecin medecin : listPediatre) {
//			
//			System.out.println("************************"+medecin.getNomMedecin()+"*****************************");
//			System.out.println("************************"+medecin.getSpeciality()+"*****************************");
//			System.out.println("************************"+medecin.getIdMedecin()+"*****************************");
//
//		}


	}
	
}

