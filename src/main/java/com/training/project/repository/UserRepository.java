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
import org.springframework.stereotype.Repository;
import com.training.project.model.UserRegisterModel;

/**
 * class name: UserRepository
 * description : Repository class for Registered user details in CreditCardproject.
 *
 */

@Repository
public interface UserRepository extends CrudRepository<UserRegisterModel, Integer> {

}
