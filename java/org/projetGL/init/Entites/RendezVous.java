package org.projetGL.init.Entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class RendezVous implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idRendezVous;
	
	@OneToOne
	@JoinColumn(name="CODE_PLAGEHORAIRE")
	private PlageHoraire plageRV;

	
	public PlageHoraire getPlageRV() {
		return plageRV;
	}

	public void setPlageRV(PlageHoraire plageRV) {
		this.plageRV = plageRV;
	}

	public Hopital getHopitialDuRendezVous() {
		return hopitialDuRendezVous;
	}

	public void setHopitialDuRendezVous(Hopital hopitialDuRendezVous) {
		this.hopitialDuRendezVous = hopitialDuRendezVous;
	}

	// un redez vous est composé des informations d'un patient
	@OneToOne
	@JoinColumn(name="CODE_PATIENT")
	private Patient patientRdv;
	
	
	//un rdv est associer a un hopital bien definit
	@ManyToOne
	@JoinColumn(name="NOM_HOPITALRDV")
	private Hopital hopitialDuRendezVous;

	
	//un rdv correspond aussi a un médecin
	@OneToOne
	@JoinColumn(name="CODE_MEDECIN")
	private Medecin medecinAssocierAuRDV;
	
	
	public Medecin getMedecinAssocierAuRDV() {
		return medecinAssocierAuRDV;
	}

	public void setMedecinAssocierAuRDV(Medecin medecinAssocierAuRDV) {
		this.medecinAssocierAuRDV = medecinAssocierAuRDV;
	}

	public long getIdRendezVous() {
		return idRendezVous;
	}

	public Patient getPatientRdv() {
		return patientRdv;
	}

	public void setPatientRdv(Patient patientRdv) {
		this.patientRdv = patientRdv;
	}

	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setIdRendezVous(long idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public RendezVous(PlageHoraire plageRV, Patient patientRdv, Hopital hopitialDuRendezVous,Medecin medecinAssocierAuRDV) {
		super();
		this.plageRV = plageRV;
		this.patientRdv = patientRdv;
		this.hopitialDuRendezVous = hopitialDuRendezVous;
		this.medecinAssocierAuRDV = medecinAssocierAuRDV;
	}

	public RendezVous(Patient patientRdv, Hopital hopitialDuRendezVous, Medecin medecinAssocierAuRDV) {
		super();
		this.patientRdv = patientRdv;
		this.hopitialDuRendezVous = hopitialDuRendezVous;
		this.medecinAssocierAuRDV = medecinAssocierAuRDV;
	}
	
	
}
