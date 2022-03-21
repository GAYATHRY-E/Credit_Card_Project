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
package com.training.project.repository;

import org.springframework.data.repository.CrudRepository;
import com.training.project.model.CardHistoryModel;


/**
 * class name: CardHistoryRepository
 * description : Repository class for CreditCard history in CreditCardproject.
 *
 */

public interface CardHistoryRepository extends CrudRepository<CardHistoryModel, Integer> {

}
