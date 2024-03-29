package com.felintro.leonard.repository.pessoa;

import com.felintro.leonard.enums.TipoEmpresa;
import com.felintro.leonard.model.pessoa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author allan
 **/

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    boolean existsByNrCnpj(String nrCnpj);

    Empresa findByNrCnpj(String nrCnpj);

    Empresa findByTipoEmpresa(TipoEmpresa tipoEmpresa);

}