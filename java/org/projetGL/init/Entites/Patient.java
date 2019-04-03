package org.projetGL.init.Entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Patient implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPatient;
	private String codePatient;
	
	private String nomPatient;
	private String prenomPatient;
	private String adressePatient;
	private long telefonePatient;
	private String emailPatient;
	private Date dateEnregistrement;
	private String choixServices;
	
	
	
	public Patient(String codePatient, String nomPatient, String prenomPatient, String adressePatient,
			long telefonePatient, String emailPatient, String choixServices) {
		super();
		this.codePatient = codePatient;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.adressePatient = adressePatient;
		this.telefonePatient = telefonePatient;
		this.emailPatient = emailPatient;
		this.choixServices = choixServices;
	}
	public Patient(String codePatient, String nomPatient, String prenomPatient, String adressePatient,
			long telefonePatient, String emailPatient, Date dateEnregistrement, String choixServices,
			Hopital hopitalPatient, RendezVous reservation, Medecin medecinAffecter) {
		super();
		this.codePatient = codePatient;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.adressePatient = adressePatient;
		this.telefonePatient = telefonePatient;
		this.emailPatient = emailPatient;
		this.dateEnregistrement = dateEnregistrement;
		this.choixServices = choixServices;
		this.hopitalPatient = hopitalPatient;
		this.reservation = reservation;
		this.medecinAffecter = medecinAffecter;
	}
	public Patient(String nomPatient, String prenomPatient, String adressePatient, String emailPatient) {
		super();
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.adressePatient = adressePatient;
		this.emailPatient = emailPatient;
	}

	@ManyToOne
	@JoinColumn(name="NOM_HOPITAL")
	private Hopital hopitalPatient;
	
	// maintenant nous allons gérer les relations les différentes classes qui ont été créer
	
	// un patient a droit  une reservation

	@OneToOne(mappedBy="patientRdv")
	private RendezVous reservation;
	
//	//pour chaque reservation de notre patient nous avons droit de l'affecter un medecin
	
	@ManyToOne
	@JoinColumn(name="CODE_MEDECIN")
	private Medecin medecinAffecter;
	
	public String getChoixServices() {
		return choixServices;
	}
	public void setChoixServices(String choixServices) {
		this.choixServices = choixServices;
	}
	
	public Medecin getMedecinAffecter() {
		return medecinAffecter;
	}
	public void setMedecinAffecter(Medecin medecinAffecter) {
		this.medecinAffecter = medecinAffecter;
	}
	public String getEmailPatient() {
		return emailPatient;
	}
	public void setEmailPatient(String emailPatient) {
		this.emailPatient = emailPatient;
	}
	public RendezVous getReservation() {
		return reservation;
	}
	public void setReservation(RendezVous reservation) {
		this.reservation = reservation;
	}

	public Hopital getHopitalPatient() {
		return hopitalPatient;
	}
	public void setHopitalPatient(Hopital hopitalPatient) {
		this.hopitalPatient = hopitalPatient;
	}
	public long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(long idPatient) {
		this.idPatient = idPatient;
	}
	public String getCodePatient() {
		return codePatient;
	}
	public void setCodePatient(String codePatient) {
		this.codePatient = codePatient;
	}
	public String getNomPatient() {
		return nomPatient;
	}
	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	public String getPrenomPatient() {
		return prenomPatient;
	}
	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}
	public String getAdressePatient() {
		return adressePatient;
	}
	public void setAdressePatient(String adressePatient) {
		this.adressePatient = adressePatient;
	}
	public long getTelefonePatient() {
		return telefonePatient;
	}
	public void setTelefonePatient(long telefonePatient) {
		this.telefonePatient = telefonePatient;
	}
	public String getEmailMenbre() {
		return emailPatient;
	}
	public void setEmailMenbre(String emailPatient) {
		this.emailPatient = emailPatient;
	}
	public Date getDateEnregistrement() {
		return dateEnregistrement;
	}
	public void setDateEnregistrement(Date dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public Patient(String nomPatient, String prenomPatient, String adressePatient, long telefonePatient,
			String emailPatient) {
		super();
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.adressePatient = adressePatient;
		this.telefonePatient = telefonePatient;
		this.emailPatient = emailPatient;
	}
	
	
	
	
	
//	@OneToMany(mappedBy="menbre",fetch=FetchType.LAZY)
//	private Collection<Medecin> listMedecins;

}
