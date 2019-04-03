package org.projetGL.init.Dao;

import java.util.List;

import org.projetGL.init.Entites.Hopital;
import org.projetGL.init.Entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HopitalRepository extends JpaRepository<Hopital, Long> {
	
//	@Query("select h from Hopital h where h.idHopital=:x") 
//	public List<Patient> listPatientHopital(long idHopital);

}
