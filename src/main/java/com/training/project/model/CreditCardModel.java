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
 * class name: CreditCardModel
 * description : Model class for CreditCard details in CreditCardproject.
 *
 */

@Data
@Component
@Entity
public class CreditCardModel{
	  
		private String  username;
	    @Id
		private int creditCardNumber;
		private String password;
		private String status;
		private int creditLimit;
		
		
}
