package org.projetGL.init.Entites;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Medecin implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idMedecin;
	private String codeMedecin;
	private String nomMedecin;
	private String prenomMedecin;
	private String adresseMedecin;
	private long telefoneMedecin;
	private String speciality;
	private boolean disponibility=true;
	private String emailMedecin;
	private String heureRDV ;
	
	
	
	
	public String getHeureRDV() {
		return heureRDV;
	}



	public void setHeureRDV(String heureRDV) {
		this.heureRDV = heureRDV;
	}



	public String getEmailMedecin() {
		return emailMedecin;
	}



	public void setEmailMedecin(String emailMedecin) {
		this.emailMedecin = emailMedecin;
	}



	//un medecin a une plage horaire auquels ils est associer
	@OneToMany(mappedBy="plageHoraireMedecin",fetch=FetchType.LAZY)
	
	private Collection<PlageHoraire> listHoraireMedecin = new ArrayList<PlageHoraire>();

	
	public Collection<PlageHoraire> getListHoraireMedecin() {
		return listHoraireMedecin;
	}



	public boolean getDisponibility() {
		return disponibility;
	}



	public void setDisponibility(boolean disponibility) {
		this.disponibility = disponibility;
	}



	public void setListHoraireMedecin(Collection<PlageHoraire> listHoraireMedecin) {
		this.listHoraireMedecin = listHoraireMedecin;
	}



	//un  medecin a un ensemble de rendez vous a des plage horaire differentes
	@OneToOne(mappedBy="medecinAssocierAuRDV")
	private RendezVous rdvMedecin ;
	
	
	public RendezVous getRdvMedecin() {
		return rdvMedecin;
	}



	public void setRdvMedecin(RendezVous rdvMedecin) {
		this.rdvMedecin = rdvMedecin;
	}



	//un a plusieurs medecin son associer a un hopital
	@ManyToOne
	@JoinColumn(name="NOM_HOPITAL")
	private Hopital hopitalMedecin;
	
	//un medecin a plusieurs patient
	
	@OneToMany(mappedBy="medecinAffecter")
	private Collection<Patient> listPatientMed = new ArrayList<Patient>();

	public Collection<Patient> getListPatientMed() {
		return listPatientMed;
	}



	public void setListPatientMed(Collection<Patient> listPatientMed) {
		this.listPatientMed = listPatientMed;
	}



	public long getIdMedecin() {
		return idMedecin;
	}



	public Hopital getHopitalMedecin() {
		return hopitalMedecin;
	}



	public void setHopitalMedecin(Hopital hopitalMedecin) {
		this.hopitalMedecin = hopitalMedecin;
	}


	public String getSpeciality() {
		return speciality;
	}



	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
	public void setIdMedecin(long idMedecin) {
		this.idMedecin = idMedecin;
	}



	public String getCodeMedecin() {
		return codeMedecin;
	}



	public void setCodeMedecin(String codeMedecin) {
		this.codeMedecin = codeMedecin;
	}



	public String getNomMedecin() {
		return nomMedecin;
	}



	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}



	public String getPrenomMedecin() {
		return prenomMedecin;
	}



	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
	}



	public String getAdresseMedecin() {
		return adresseMedecin;
	}



	public void setAdresseMedecin(String adresseMedecin) {
		this.adresseMedecin = adresseMedecin;
	}



	public long getTelefoneMedecin() {
		return telefoneMedecin;
	}



	public void setTelefoneMedecin(long telefoneMedecin) {
		this.telefoneMedecin = telefoneMedecin;
	}



	public Medecin(String codeMedecin, String nomMedecin, String prenomMedecin, String adresseMedecin,
			long telefoneMedecin, String speciality) {
		super();
		this.codeMedecin = codeMedecin;
		this.nomMedecin = nomMedecin;
		this.prenomMedecin = prenomMedecin;
		this.adresseMedecin = adresseMedecin;
		this.telefoneMedecin = telefoneMedecin;
		this.speciality= speciality;
	}



	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
