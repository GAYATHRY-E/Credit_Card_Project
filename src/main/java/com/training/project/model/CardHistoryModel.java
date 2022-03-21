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

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * class name: CardHistoryModel
 * description : Model class for CreditCardHistory in CreditCardproject.
 *
 */
@Data
@Component
@Entity 
public class CardHistoryModel {
	private String  username;
    @Id
	private int creditCardNumber;
    private LocalDate cancelDate;
    private String status;
    
	
}
