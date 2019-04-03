package org.projetGL.init.Metiers;

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
import org.springframework.stereotype.Service;


@Service
public class Metier implements IMetier {
	
	@Autowired
	private HopitalRepository hopitalRepository;
	
	@Autowired
	private MedecinRepository medecinRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private RendezVousRepository rendezvousRepository;
	
	@Autowired
	private PlageHoraireRepository plagehoraireRepository;

	
	// implementation des methodes de classe
	
	@Override
	public RendezVous createRendezVous(PlageHoraire plageRV, Patient patientRdv, Hopital hopitialDuRendezVous,Medecin medecinAssocierAuRDV) {
		RendezVous rv= new RendezVous();
	
		// information a entrer dans la classe de presentation pour la creation manuelle d'un rendez-vous
		
		rv.setPlageRV(plageRV);
		rv.setPatientRdv(patientRdv);
		rv.setHopitialDuRendezVous(hopitialDuRendezVous);
		rv.setMedecinAssocierAuRDV(medecinAssocierAuRDV);
	
		//cretaion automatiques 
		
		RendezVous rvSave=rendezvousRepository.save(rv);
	
		// TODO Auto-generated method stub
		return rvSave;
	}

	@Override
	public Medecin creatMedecin(String nomMedecin, String prenomMedecin, String adresseMedecin, long telefoneMedecin,
			String speciality) {
		
		Medecin mdc = new Medecin();
		
		mdc.setNomMedecin(nomMedecin);
		mdc.setPrenomMedecin(prenomMedecin);
		mdc.setAdresseMedecin(adresseMedecin);
		mdc.setTelefoneMedecin(telefoneMedecin);
		mdc.setSpeciality(speciality);
		mdc.setCodeMedecin("a modifier par nous nousn=nousnosnosnosundofsndfonsdo");
		
		
		medecinRepository.save(mdc);
		// TODO Auto-generated method stub
		return mdc;
	}

	
	@Override
	public Hopital createHopital(String nomHopital, String adresseHopital) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient createPatient(String nomPatient, String prenomPatient, String adressePatient, long telefonePatient,
			String emailPatient) {
		
		Patient patient = new Patient();
		
		patient.setNomPatient(nomPatient);
		patient.setPrenomPatient(prenomPatient);
		patient.setAdressePatient(adressePatient);
		patient.setTelefonePatient(telefonePatient);
		patient.setEmailPatient(emailPatient);
		patient.setCodePatient("a definir par moi meme memem me em e me me m em m em em em em em em");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlageHoraire createHoraire(long heureDebutRDV, long heureDeFinRDV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMedecin(String codeMedecin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHopital(String codePatient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRendezVous(long idRendezVous) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatient(String codePatient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> listPatienthopital(long idHopital) {
		Hopital hos = hopitalRepository.getOne(idHopital);
		
		List<Patient> lispa = (List<Patient>) hos.getListPatientHopital();
		// TODO Auto-generated method stub
		return lispa;
	}
	
	@Override
	public List<Patient> listPatient() {
		List<Patient> lisP = patientRepository.findAll();
		
		// TODO Auto-generated method stub
		return lisP;
	}

	@Override
	public List<Hopital> listHopital() {
		List<Hopital> lis  = hopitalRepository.findAll();
		// TODO Auto-generated method stub
		return lis;
	}

	@Override
	public List<RendezVous> listRendezVous(String nomHopital) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteRendezVous(String idTask) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public List<Medecin> listMedecinhopital(long idHopital) {
		Hopital hosp = hopitalRepository.getOne(idHopital);
		
		List<Medecin> listeMedecinhosp =(List<Medecin>) hosp.getListMedecinHopital();
		// TODO Auto-generated method stub
		return listeMedecinhosp;
	}

	
	
	@Override
	public Patient findPatient(String codePatient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medecin findMedecin(String codeMedecin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hopital findHopital(String nomHopital) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RendezVous assignRendezVousToMedecin(RendezVous rendezvousAAssigner, Medecin medecinAssigner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignPatientRendezVous(Patient patientAssigner, RendezVous rendezvousPatient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMedecinHopital(Medecin medecinassigner, Hopital hopitalassigner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignPlageHoraireMedecin(Medecin medecinAssigner, PlageHoraire plageHoraireAssigner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMedecinToPatient(Medecin medecin, Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient findByIdPatient(long idPatient) {
		
		Patient pat = patientRepository.getOne(idPatient);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hopital findByIdHopital(long idHopital) {
		Hopital hos = hopitalRepository.getOne(idHopital);
		// TODO Auto-generated method stub
		return hos;
	}

	@Override
	public RendezVous editRendezVous(long idRendezVous) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public RendezVous afficherRendezvous(long idRendezVous) {
		
		RendezVous rdv=rendezvousRepository.getOne(idRendezVous);
		
		return rdv;
	}

	@Override
	public List<RendezVous> findAllRdv() {

		List<RendezVous> listRDV=rendezvousRepository.findAll();
		return listRDV;
	}	

	
}
