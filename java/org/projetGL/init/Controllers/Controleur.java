package org.projetGL.init.Controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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
import org.projetGL.init.Entites.SendEmail;
import org.projetGL.init.Metiers.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller 
@RequestMapping(value="/index")
public class Controleur {
	
	@Autowired
	private IMetier objetCoucheMetier;
	@Autowired
	private PatientRepository patientDao;
	
	@Autowired
	private MedecinRepository medecinDao;
		
	@Autowired
	private PlageHoraireRepository plageHoraire;
	
	@Autowired
	private RendezVousRepository rendezvousRepository;
	
	@Autowired
	private HopitalRepository hopitalDao;
	
	
	@RequestMapping(value="/tableauMedecin")
	public String tableauMedecin(Model model) {
			List<Medecin> medecinn= medecinDao.medecinLibre(true);

			model.addAttribute("medecins", medecinn);
			
		return "medecin";
	}
	
	// creation de la page services
	
	@RequestMapping(value="/services")
	public String Services(Model model) {
		
		return "services";
	}
	
	@RequestMapping(value="/about")
	public String about(Model model) {
		
		return "about";
	}
	
	
	@RequestMapping(value="/contact")
	public String contact(Model model) {
		
		return "contact";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		
		return "index";
	}
	
	@RequestMapping(value="/elements")
	public String elements(Model model) {
		
		return "elements";
	}
	
	@RequestMapping(value="/elementsform")
	public String medecinlist(Model model) {
		List<Medecin> medecinn= medecinDao.findAll();

		model.addAttribute("medecins", medecinn);
		return "elementsform";
	}
	
	@RequestMapping(value="/news")
	public String news(Model model) {
		
		return "news";
	}
	
	
	//recherche
	@RequestMapping(value="/findPatient")
	public String recherchePatient(Model model, String codePatient) {
		
		try {
			Patient paFind = patientDao.recherchPatient(codePatient);
			
			model.addAttribute("patientsauver", paFind);
			
			return "affichagePatient";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			model.addAttribute("exception", e); 
			
			return "redirect:/index/elements";
		}
	}
	
	
	// creation du formulaire du patient
	Patient patientSave = new Patient();
	
	@RequestMapping(value="/saveform", method=RequestMethod.POST)
	public String formulairePatient(@Valid Patient patient, BindingResult bindingResult) throws InterruptedException {
		
		patient.setDateEnregistrement(new Date());			
		Patient pSave =patientDao.save(patient);	
		
		
		
		patient.setCodePatient("code"+patient.getIdPatient()+"_"+pSave.getNomPatient());
		
		pSave.setCodePatient(patient.getCodePatient());
		
		patientDao.saveAndFlush(pSave);

//	RendezVous rdv = new RendezVous();
//		
//		pSave.getReservation().setMedecinAssocierAuRDV(pSave.getMedecinAffecter());
//		pSave.getReservation().setPatientRdv(pSave);
//		pSave.getReservation().setHopitialDuRendezVous(pSave.getMedecinAffecter().getHopitalMedecin());
//		
//		rdv.setHopitialDuRendezVous(pSave.getHopitalPatient());
//		rdv.setMedecinAssocierAuRDV(pSave.getMedecinAffecter());
//		rdv.setPatientRdv(pSave);
		
		
//		rendezvousRepository.save(rdv);
		
		//trie et selection d'un medecin
		List<Medecin> listMedecinChoix = medecinDao.findListMedecinCategorie(pSave.getChoixServices());

				for (Medecin medecin : listMedecinChoix) {
					
					if (medecin.getDisponibility()==true) {
						
						pSave.setMedecinAffecter(medecin);
						medecin.setDisponibility(false);
						
						patientDao.saveAndFlush(pSave);
						
						break;
					} 
				}
		
		//envoi de mail
		SendEmail.sendEmail(patient.getEmailMenbre(),"Merci de nous avoir fait confiance!\n-------------------------------------------\n\nPATIENT"
				+"\nCode :.................................................."+pSave.getCodePatient()
				+"\nNom :..................................................."+pSave.getNomPatient()
				+"\nPrénom :.............................................."+pSave.getPrenomPatient()
				+"\nAdresse :............................................."+pSave.getAdressePatient()
				+"\nTéléfone :...........................................+"+pSave.getTelefonePatient()
				+"\nType de service :................................."+pSave.getChoixServices()
				+"\nEmail :........................................"+pSave.getEmailPatient()
				+"\nDate d'enregistrement :......................."+pSave.getDateEnregistrement()+"\n\nMEDECIN du Rendez-vous"
				+"\nCode :.................................................."+pSave.getMedecinAffecter().getCodeMedecin()
				+"\nNom :..................................................."+pSave.getMedecinAffecter().getNomMedecin()
				+"\nPrénom :.............................................."+pSave.getMedecinAffecter().getPrenomMedecin()
				+"\nTéléfone :...........................................+"+pSave.getMedecinAffecter().getTelefoneMedecin()
				+"\nEmail :............................................"+pSave.getMedecinAffecter().getEmailMedecin()
				+"\nSpécialité :............................................"+pSave.getMedecinAffecter().getSpeciality()
				+"\nHeure du Rendez-vous :............................................"+pSave.getMedecinAffecter().getHeureRDV()+"\n\nHÔPITAL du Rendez-vous"
				+"\nNom :..................................................."+pSave.getMedecinAffecter().getHopitalMedecin().getNomHopital()
				+"\nAdresse :............................................"+pSave.getMedecinAffecter().getHopitalMedecin().getAdresseHopital()
				+"\nTéléfone :............................................"+pSave.getMedecinAffecter().getHopitalMedecin().getTelefoneHopital()
				+"\nHeure du Rendez-vous :............................................"+pSave.getMedecinAffecter().getHeureRDV()
				+"\n\n vous allez recevoir votre fiche de rendez-vous vous pouvez\n l'imprimer et vous rendre\n à l'hôpital comme prévu sur \n votre fiche merci de nous faire part de la qualité de service après votre reception en \n nous repondant directement par mail\n bonne guérison! "
				);
		
		SendEmail.sendEmail(patient.getMedecinAffecter().getEmailMedecin(),"Bonjour"+patient.getMedecinAffecter().getNomMedecin()+",\nVous avez un rendez-vous prévu aujourdhui:\n\\nPATIENT "
				+"\nCode :.................................................."+pSave.getCodePatient()
				+"\nNom :..................................................."+pSave.getNomPatient()
				+"\nPrénom :.............................................."+pSave.getPrenomPatient()
				+"\nAdresse :............................................."+pSave.getAdressePatient()
				+"\nTéléfone :...........................................+"+pSave.getTelefonePatient()
				+"\nSpécialité :................................."+pSave.getChoixServices()
				+"\nEmail :........................................"+pSave.getEmailPatient()+"\n\nHôpital du rendez-vous"
				+"\nNom :..................................................."+pSave.getMedecinAffecter().getHopitalMedecin().getNomHopital()
				+"\nAdresse :............................................"+pSave.getMedecinAffecter().getHopitalMedecin().getAdresseHopital()
				+"\nTéléfone :............................................"+pSave.getMedecinAffecter().getHopitalMedecin().getTelefoneHopital()
				+"\nHeure du Rendez-vous :............................................"+pSave.getMedecinAffecter().getHeureRDV());
		
		SendEmail.sendEmail(patient.getMedecinAffecter().getHopitalMedecin().getEmailHopital(), "Vous avez un rendez-vous enregistrer pour aujourdhui dans votre hopital voici les details:\n<PATIENT>"
				+"\nCode :.................................................."+pSave.getCodePatient()
				+"\nNom :..................................................."+pSave.getNomPatient()
				+"\nPrénom :.............................................."+pSave.getPrenomPatient()
				+"\nTéléfone :...........................................+"+pSave.getTelefonePatient()+"\n<MEDECIN>"

				+"\nCode :.................................................."+pSave.getCodePatient()
				+"\nNom :..................................................."+pSave.getNomPatient()
				+"\nTéléfone :...........................................+"+pSave.getTelefonePatient()
				+"\nHeure du Rendez-vous :............................................"+pSave.getMedecinAffecter().getHeureRDV()
				);
		
		patientSave.setNomPatient(pSave.getNomPatient());
		patientSave.setPrenomPatient(pSave.getPrenomPatient());
		patientSave.setAdressePatient(pSave.getAdressePatient());
		patientSave.setTelefonePatient(pSave.getTelefonePatient());
		patientSave.setChoixServices(pSave.getChoixServices());
		patientSave.setCodePatient(pSave.getCodePatient());
		patientSave.setDateEnregistrement(pSave.getDateEnregistrement());
		patientSave.setEmailPatient(pSave.getEmailPatient());
		patientSave.setMedecinAffecter(pSave.getMedecinAffecter());

		ModelAndView mav = new ModelAndView();
		mav.addObject("mode","SAVE");
		mav.setViewName("form");
		
		return "redirect:/index/rendezvouspatient";
	}
	
	
	
	@RequestMapping(value="/rendezvouspatient",method=RequestMethod.GET)
	public String formulairePatientEnre(Model model) throws InterruptedException {
		
		try {
			Thread.sleep(2000);
			model.addAttribute("patientsauver", patientSave);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "rendezvouspatient";
	}
	

	@RequestMapping(value="/form")
	public ModelAndView formulairePatient(Model model) {
			
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("patient",new Patient());
		
	//	patientDao.save(patient);			
		modelAndView.addObject("mode","NEW");
		modelAndView.setViewName("form");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/rendezVouss")
	public String AffichageRendezVous(Model model) {
		
		//List<Patient> listPatient = objetCoucheMetier.listPatienthopital(1);
		List<Patient> listPatient = objetCoucheMetier.listPatient();
		model.addAttribute("patient", listPatient);
		
		return "patient";
	}

	
	
	@RequestMapping(value="/hopitals")
	public String hopitaux(Model model) {
		
		//List<Patient> listPatient = objetCoucheMetier.listPatienthopital(1);
		List<Hopital> listhopital = hopitalDao.findAll();
		model.addAttribute("patient", listhopital);
		
		return "hopital";
	}
	
	
	@RequestMapping(value="/rendezvous")
	public String AffichageRendezVousPatient(Model model) {
		
		//RendezVous rdv = objetCoucheMetier.afficherRendezvous(1);
		
		List<RendezVous> rdv = objetCoucheMetier.findAllRdv();
	
		
		for (RendezVous rendezVous : rdv) {
			
			List<PlageHoraire> lisPlMed = (List<PlageHoraire>) rendezVous.getPlageRV().getPlageHoraireMedecin().getListHoraireMedecin();
					
			for (PlageHoraire plagehoraireM : lisPlMed) {
					
				if(plagehoraireM.getIdPlageHoraire()== rendezVous.getIdRendezVous()) {
					
					long debut =plagehoraireM.getHeureDebutRDV();
					long fin = plagehoraireM.getHeureDeFinRDV();
					String heureD = String.valueOf(debut);
					String heureF = String.valueOf(fin);
					String heure = heureD+"h - "+heureF+"h";
					
					model.addAttribute("rendezVous", rdv);
					model.addAttribute("heure", heure);

					break;
				}
			}
			
		}
		
		return "rendezvous";
	}

}

