package org.projetGL.init.Entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Hopital implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idHopital;
	private String nomHopital;
	private String adresseHopital;
	private long telefoneHopital;
	private String emailHopital;
	
	
	
	public String getEmailHopital() {
		return emailHopital;
	}



	public void setEmailHopital(String emailHopital) {
		this.emailHopital = emailHopital;
	}



	//un hopital a une collection de medecins
	@OneToMany(mappedBy="hopitalMedecin",fetch=FetchType.LAZY)
	private Collection<Medecin> listMedecinHopital = new ArrayList<Medecin>();
	
	//un hopital a une collection de patient
		@OneToMany(mappedBy="hopitalPatient",fetch=FetchType.LAZY)
		private Collection<Patient> listPatientHopital = new ArrayList<Patient>();
	
	//un hopital gere une collection de rendez vous
	@OneToMany(mappedBy="hopitialDuRendezVous")
	private Collection<RendezVous> listRendeVousHopital = new ArrayList<RendezVous>();
	
	
	
	public long getTelefoneHopital() {
		return telefoneHopital;
	}



	public void setTelefoneHopital(long telefoneHopital) {
		this.telefoneHopital = telefoneHopital;
	}



	public Collection<Medecin> getListMedecinHopital() {
		return listMedecinHopital;
	}



	public Collection<Patient> getListPatientHopital() {
		return listPatientHopital;
	}



	public void setListPatientHopital(Collection<Patient> listPatientHopital) {
		this.listPatientHopital = listPatientHopital;
	}



	public Collection<RendezVous> getListRendeVousHopital() {
		return listRendeVousHopital;
	}



	public void setListRendeVousHopital(Collection<RendezVous> listRendeVousHopital) {
		this.listRendeVousHopital = listRendeVousHopital;
	}



	public void setListMedecinHopital(Collection<Medecin> listMedecinHopital) {
		this.listMedecinHopital = listMedecinHopital;
	}


	public long getIdHopital() {
		return idHopital;
	}



	public void setIdHopital(long idHopital) {
		this.idHopital = idHopital;
	}



	public String getNomHopital() {
		return nomHopital;
	}



	public void setNomHopital(String nomHopital) {
		this.nomHopital = nomHopital;
	}



	public String getAdresseHopital() {
		return adresseHopital;
	}



	public void setAdresseHopital(String adresseHopital) {
		this.adresseHopital = adresseHopital;
	}



	public Hopital(String nomHopital, String adresseHopital) {
		super();
		this.nomHopital = nomHopital;
		this.adresseHopital = adresseHopital;
	}



	public Hopital(String nomHopital, String adresseHopital, Collection<Medecin> listMedecinHopital,
			Collection<RendezVous> listRendeVousHopital) {
		super();
		this.nomHopital = nomHopital;
		this.adresseHopital = adresseHopital;
		this.listMedecinHopital = listMedecinHopital;
		this.listRendeVousHopital = listRendeVousHopital;
	}



	public Hopital(String nomHopital, String adresseHopital, Collection<Medecin> listMedecinHopital) {
		super();
		this.nomHopital = nomHopital;
		this.adresseHopital = adresseHopital;
		this.listMedecinHopital = listMedecinHopital;
	}



	public Hopital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
