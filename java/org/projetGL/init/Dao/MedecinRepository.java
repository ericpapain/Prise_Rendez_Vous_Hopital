package org.projetGL.init.Dao;

import java.util.List;

import org.projetGL.init.Entites.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{
	
	@Query("select m from Medecin m where m.speciality=:x") 
	public List<Medecin> findListMedecinCategorie(@Param("x")String specialite);
	
	@Query("select m from Medecin m where m.idMedecin=:x") 
	public Medecin findByIdentifiant(@Param("x")long idMedecin);
	
	@Query("select m from Medecin m where m.disponibility=:x") 
	public List<Medecin> medecinLibre(@Param("x")boolean disponibility);

}
