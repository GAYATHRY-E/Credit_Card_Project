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
package com.training.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * class name: CreditCardProject1Application
 * description : Application class for CreditCardproject.
 *
 */

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
public class CreditCardProject1Application {

	public static void main(String[] args) {
      SpringApplication.run(CreditCardProject1Application.class, args);
}
}




