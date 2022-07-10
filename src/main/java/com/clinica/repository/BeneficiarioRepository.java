package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.dto.BeneficiarioDTO;

@Repository
public interface BeneficiarioRepository extends JpaRepository<BeneficiarioDTO, Integer> {

	BeneficiarioDTO findByIdbenef(int id);
	BeneficiarioDTO save(int id);
		
}
