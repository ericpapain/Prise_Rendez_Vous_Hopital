package org.projetGL.init.Dao;

import org.projetGL.init.Entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	@Query("select p from Patient p where p.codePatient=:x") 
	public Patient recherchPatient(@Param("x")String codePatient);
}
