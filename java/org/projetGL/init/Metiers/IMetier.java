package org.projetGL.init.Metiers;

import java.util.Date;
import java.util.List;

import org.projetGL.init.Entites.Hopital;
import org.projetGL.init.Entites.Medecin;
import org.projetGL.init.Entites.Patient;
import org.projetGL.init.Entites.PlageHoraire;
import org.projetGL.init.Entites.RendezVous;

public interface IMetier {
	
	
	//
	//permet de faire la creation de nos differernt entités
	//
	
	//creation d'un rendez vous associer a un medecin a un patient a un hopital abstrait pour l'utilisateur qui remplis les informations
	public RendezVous createRendezVous(PlageHoraire plageRV,Patient patientRdv,Hopital hopitialDuRendezVous,Medecin medecinAssocierAuRDV);
	
	//creation d'un medecin avec juste ses infromation avant son affectation dans un hopital donnée
	public Medecin creatMedecin(String nomMedecin,String prenomMedecin,String adresseMedecin,long telefoneMedecin,String speciality);
	
	//creation tous simplement d'un hopital sans mettre en place ses parametre comme ensemble de medecin
	public Hopital createHopital(String nomHopital,String adresseHopital);
	
	
	// creation simplement d'un patient
	public Patient createPatient(String nomPatient,String prenomPatient,String adressePatient,long telefonePatient,String emailPatient);
	
	//creation des plage horaire opération abstraite pour l'utilisateur
	public PlageHoraire createHoraire(long heureDebutRDV,long heureDeFinRDV);
	
	//2019-03-16 23:42:38.0
	//permet de supprimer les entités creer
	//
	
	//methode de l'interface permettant de supprimer un patient enregistrer
		public void deleteMedecin(String codeMedecin);
		
		//methode de l'interface permettant de supprimer un patient enregistrer
		public void deleteHopital(String codePatient);
		
		//methode de l'interface permettant de supprimer un patient enregistrer
		public void deleteRendezVous(long idRendezVous);
		
		
	//methode de l'interface permettant de supprimer un patient enregistrer
	public void deletePatient(String codePatient);
	
	//
	//permet d'afficher la liste des medecin des hopitaux des patients qui sont deja enregistrer
	//

	//methode de l'interface liste des patient associer a un hopital
	public List<Patient> listPatienthopital(long idHopital);
	
	//methode de l'interface
	public List<Hopital> listHopital();
	
	//methode de l'interface associer a un hopital donnée
	public List<RendezVous> listRendezVous(String nomHopital);
	
	public RendezVous editRendezVous(long idRendezVous);
	
	public void deleteRendezVous(String idTask);

	//permet d'afficher la liste des medecins qui appatienent a un hopital données
	public List<Medecin> listMedecinhopital(long idHopital);
	


	//
	//fonction de recherches
	//
	
	
	//permet de rechercher un patient a partir de son code
	public Patient findPatient(String codePatient) ;
	
	public Patient findByIdPatient(long idPatient);
	
	public Hopital findByIdHopital(long idHopital);
		
	//permet de rechercher un medecin donné a partir de son id ou de son nom
	public Medecin findMedecin(String codeMedecin);
	
	//permet de rechercher un hopital a partir de son nom ou de son identifiant
	public Hopital findHopital(String nomHopital);
	
	
	//
	//fonction permettant de faire des assignations
	//
	
	//methode de l'interface
	public RendezVous assignRendezVousToMedecin(RendezVous rendezvousAAssigner, Medecin medecinAssigner);
	
	//permet de assigner un patient a un rendez vous  creer ou en cours de creation
	public void assignPatientRendezVous(Patient patientAssigner, RendezVous rendezvousPatient);
	
	//permet d'affecter  un medecin a un hopital donné
	public void assignMedecinHopital(Medecin medecinassigner, Hopital hopitalassigner);
	
	//permet d'attribuer une plage horaire a un medecin
	public void assignPlageHoraireMedecin(Medecin medecinAssigner, PlageHoraire plageHoraireAssigner);
	
	//permet d'assigner un  medecin a un patient$
	public void assignMedecinToPatient(Medecin medecin, Patient patient);

	public List<Patient> listPatient();

	public RendezVous afficherRendezvous(long idRendezVous);

	public List<RendezVous> findAllRdv();
	
	
}
