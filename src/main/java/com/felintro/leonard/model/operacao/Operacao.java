package com.felintro.leonard.model.operacao;

import com.felintro.leonard.enums.StatusOperacao;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author allan
 **/

@MappedSuperclass
@Getter
@Setter
public abstract class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "dt_hr_realizacao")
    protected LocalDateTime dtHrRealizacao;

    @Column(name = "status_operacao")
    @Enumerated(EnumType.STRING)
    protected StatusOperacao statusOperacao;

}