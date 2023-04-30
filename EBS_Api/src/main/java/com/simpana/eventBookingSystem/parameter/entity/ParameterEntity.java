package com.simpana.eventBookingSystem.parameter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EBS_PARAMETERS")
public class ParameterEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PARAMETER_ID")
	private Integer idParameter;
	
	@Column(name = "PARAMETER_KEY")
	private String parameter_Key;
	
	@Column(name = "PARAMETER_VALUE")
	private String parameter_Value;

	public ParameterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdParameter() {
		return idParameter;
	}

	public void setIdParameter(Integer idParameter) {
		this.idParameter = idParameter;
	}

	public String getParameter_Key() {
		return parameter_Key;
	}

	public void setParameter_Key(String parameter_Key) {
		this.parameter_Key = parameter_Key;
	}

	public String getParameter_Value() {
		return parameter_Value;
	}

	public void setParameter_Value(String parameter_Value) {
		this.parameter_Value = parameter_Value;
	}
	
	

	
	 

}
