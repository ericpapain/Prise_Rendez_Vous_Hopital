package org.projetGL.init.Entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlageHoraire {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long idPlageHoraire;
		private long heureDebutRDV;
		private long heureDeFinRDV;
		private boolean etatMedecin;
		
		// une plage horaire appartient a un medecin
		@ManyToOne
		@JoinColumn(name="CODE_MEDECIN")
		private Medecin plageHoraireMedecin ;
		
		public PlageHoraire(long heureDebutRDV, long heureDeFinRDV, boolean etatMedecin, Medecin plageHoraireMedecin) {
			super();
			this.heureDebutRDV = heureDebutRDV;
			this.heureDeFinRDV = heureDeFinRDV;
			this.etatMedecin = etatMedecin;
			this.plageHoraireMedecin = plageHoraireMedecin;
		}


		


		public Medecin getPlageHoraireMedecin() {
			return plageHoraireMedecin;
		}


		public void setPlageHoraireMedecin(Medecin plageHoraireMedecin) {
			this.plageHoraireMedecin = plageHoraireMedecin;
		}


		public boolean isEtatMedecin() {
			return etatMedecin;
		}


		public void setEtatMedecin(boolean etatMedecin) {
			this.etatMedecin = etatMedecin;
		}


		public long getIdPlageHoraire() {
			return idPlageHoraire;
		}


		public void setIdPlageHoraire(long idPlageHoraire) {
			this.idPlageHoraire = idPlageHoraire;
		}


		public long getHeureDebutRDV() {
			return heureDebutRDV;
		}


		public void setHeureDebutRDV(long heureDebutRDV) {
			this.heureDebutRDV = heureDebutRDV;
		}


		public long getHeureDeFinRDV() {
			return heureDeFinRDV;
		}


		public void setHeureDeFinRDV(long heureDeFinRDV) {
			this.heureDeFinRDV = heureDeFinRDV;
		}


		public PlageHoraire() {
			super();
			// TODO Auto-generated constructor stub
		}


}
