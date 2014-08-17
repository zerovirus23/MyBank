//=======================================================================
// ARCHIVO Movement.java
// FECHA CREACIÓN: 14/02/2014
//=======================================================================
package com.mybank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mybank.common.MyBankConstants;

/**
 * Clase que representa un movimiento en la cuenta de un cliente
 * @author Hernán Tenjo
 * @version 1.0
 */
@Entity
@Table(name=MyBankConstants.PERSISTENCE_TABLE_NAME_MOVEMENT, schema = MyBankConstants.PERSISTENCE_SCHEMA_CORE)
@SequenceGenerator(name = MyBankConstants.PERSISTENCE_SEQUENCE_NAME_MOVEMENT, sequenceName=MyBankConstants.PERSISTENCE_SEQUENCE_NAME_MOVEMENT, allocationSize=1)
public class Movement extends AbstractEntity{
	//Determina si el movimiento es crédito(resta) o débito(suma)
	private boolean credit;
	//Fecha en la que se genera el movimiento
	private Date date;
	//Cantidad que ha intervenido en el movimiento
	private double value;
	//Cuenta a la que pertenece el movimiento
	private Account account;
	
	//=======================================================================
	// 								METODOS GET/SET
	//=======================================================================
	/**
	 * Metodo que define como se debe generar el id de la entidad
	 * @return El identificador de la entidad que se desea persistir
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=MyBankConstants.PERSISTENCE_SEQUENCE_NAME_MOVEMENT)
	public long getId() {
		return this.id;
	}
	
	/**
	 * Determina si el movimiento realizado es crédito(resta) o débito(suma)
	 * @return true si el movimiento es crédito, false de lo contrario
	 */
	public boolean isCredit() {
		return credit;
	}
	
	/**
	 * Modifica la clase del movimiento realizado
	 * @param credit True si el movimiento es crédito, False si es débito
	 */
	public void setCredit(boolean credit) {
		this.credit = credit;
	}
	
	/**
	 * Obtiene la fecha en la que se generó el movimiento
	 * @return La fecha en la que se generó la transacción
	 */
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}
	
	/**
	 * Modifica la fecha en la que se generó el movimiento
	 * @param date La nueva fecha que actuará como fecha de creación del movimiento
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Obtiene la cantidad de dinero que se afectó en el movimiento
	 * @return Cantidad de dinero afectado en el movimiento
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Modifica la cantidad de dinero que fue afectada en el movimiento
	 * @param value La nueva cantidad de dinero que se registrará en el movimiento
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Obtiene la cuenta a la que pertenece el movimiento
	 * @return La cuenta en la que se ha registrado el movimiento
	 */
	@ManyToOne(optional=false)
	public Account getAccount() {
		return account;
	}

	/**
	 * Modifica la cuenta relacionada con el movimiento
	 * @param account La nueva cuenta asociada
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
}