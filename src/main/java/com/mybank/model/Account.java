//=======================================================================
// ARCHIVO Account.java
// FECHA CREACIÓN: 14/02/2014
//=======================================================================
package com.mybank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mybank.common.MyBankConstants;

/**
 * Clase que representa la cuenta de un cliente de MyBank
 * @author Hernán Tenjo
 * @version 1.0
 */
@Entity
@Table(name=MyBankConstants.PERSISTENCE_TABLE_NAME_ACCOUNT, schema = MyBankConstants.PERSISTENCE_SCHEMA_CORE)
@SequenceGenerator(name = MyBankConstants.PERSISTENCE_SEQUENCE_NAME_ACCOUNT, sequenceName=MyBankConstants.PERSISTENCE_SEQUENCE_NAME_ACCOUNT, allocationSize=1)
public class Account extends AbstractEntity{
	//Número único de la cuenta
	private String number;
	//Saldo actual de la cuenta
	private double balance;
	//Persona a la que pertenece la cuenta
	private Client client;
	
	//=======================================================================
	// 								METODOS GET/SET
	//=======================================================================
	/**
	 * Metodo que define como se debe generar el id de la entidad
	 * @return El identificador de la entidad que se desea persistir
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=MyBankConstants.PERSISTENCE_SEQUENCE_NAME_ACCOUNT)
	public long getId() {
		return this.id;
	}
	
	/**
	 * Obtiene el número que identifica de forma única a la cuenta
	 * @return Número asociado a la cuenta
	 */
	@Column(unique=true)
	public String getNumber() {
		return number;
	}
	
	/**
	 * Modifica el número que identifica de forma única a la cuenta
	 * @param number El nuevo número que identificará a la cuenta
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Obtiene el saldo que se encuentra en la cuenta
	 * @return La cantidad de dinero que permanece en la cuenta
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Modifica el saldo que tiene la cuenta
	 * @param balance La nueva cantidad de dinero que permanece en la cuenta
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Obtiene cliente que se encuentra asociado a la cuenta
	 * @return El dueño de la cuenta
	 */
	@ManyToOne(optional=false)
	public Client getClient() {
		return client;
	}

	/**
	 * Modifica el cliente asociado a la cuenta
	 * @param client El nuevo cliente que será el dueño de la cuenta
	 */
	public void setClient(Client client) {
		this.client = client;
	}
}