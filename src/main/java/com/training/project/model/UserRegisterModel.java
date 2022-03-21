/* ********************************************************************************
* Project Name : CreditCardproject
* Author : GAYATHRY E
*
* Copyright Notice
*
* Copyright (c) 2021 . All Right Reserved.
* This software is the confidential and proprietary information of WalMart
* You shall not disclose or use Confidential information without the express
*********************************************************************************/
package com.training.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;


/**
 * class name: UserRegisterModel
 * description : Model class for User registration details in CreditCardproject.
 *
 */

@Data
@Component
@Entity
public class UserRegisterModel {
	private String  username;
	@Id
	private int accountnumber;
	private int phonenumber;
	private int age;
	private int salary;
	
	
	
}
