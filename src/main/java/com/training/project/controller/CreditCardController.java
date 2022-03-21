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
package com.training.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.model.CreditCardModel;
import com.training.project.model.UserRegisterModel;
import com.training.project.repository.UserRepository;
import com.training.project.service.CreditCardService;

import lombok.extern.slf4j.Slf4j;
/**
 * class name: CreditCardController 
 * description : Controller  class for CreditCardproject.
 *
 */

@Slf4j
@RestController
public class CreditCardController 
{
	@Autowired
    CreditCardService creditCardService;
	@Autowired	
	UserRepository userRepository;
	
    /**
     * @param userRegister
     * @return UserRegistration
     */
    @PostMapping("/register")
   public CreditCardModel register(@RequestBody UserRegisterModel userRegister) 
    {
    log.info("Controller class register method started with passing parameter userRegister{}\",userRegister");
    CreditCardModel card=creditCardService.createCard(userRegister);
	userRepository.save(userRegister);
	log.debug("Controller class register method ended");
    return card;
    }
	
    /**
     * @param creditCardNumber
     * @return card
     */
    @PutMapping("/unBlockCard/{creditCardNumber}")
    public String unBlockCard(@PathVariable int creditCardNumber)
    {
        log.info("Controller class unBlockCard method started with passing parameter creditCardNumber{}\",creditCardNumber");
        String card=creditCardService.unBlockCard(creditCardNumber);
    	log.debug("Controller class unBlockCard method ended");
    	return card;
    }
    
    /**
     * @param creditCardNumber
     * @return card
     */
    @PutMapping("/blockCard/{creditCardNumber}")
    public String blockCard(@PathVariable int creditCardNumber)
    {
    	log.info("Controller class blockCard method started with passing parameter creditCardNumber{}\",creditCardNumber");
    	String card=creditCardService.blockCard(creditCardNumber);
    	log.debug("Controller class blockCard method ended");
    	return card;
    }
   
    /**
     * @param creditCardNumber
     * @return card
     */
    @PutMapping("/cardLimitUpdate/{creditCardNumber}")
    public CreditCardModel cardLimitUpdate(@PathVariable int creditCardNumber)
    {
    	log.info("Controller class cardLimitUpdate method started with passing parameter creditCardNumber{}\",creditCardNumber");
    	CreditCardModel card=creditCardService.cardLimitUpdate(creditCardNumber);
    	log.debug("Controller class cardLimitUpdate method ended");
    	return card;
    }
    
    /**
     * @param creditCardNumber
     * @param amount
     * @return card
     */
    @PutMapping("/acceptDues/{creditCardNumber}/{amount}")
    public CreditCardModel  acceptDues(@PathVariable  int creditCardNumber,@PathVariable Integer amount )
    {
    	log.info("Controller class acceptDues method started with passing parameters creditCardNumber:{} and amount:{}",creditCardNumber,amount);
    	CreditCardModel card=creditCardService.acceptDues(creditCardNumber,amount);
    	log.debug("Controller class acceptDues method ended");
    	return card;
    }
    
    /**
     * @param creditCardNumber
     */
    @DeleteMapping("/cancelCard/{creditCardNumber}")
    public String cancelCard(@PathVariable int creditCardNumber)
    {
    	log.info("Controller class cancelCard method started with passing parameter creditCardNumber{}\",creditCardNumber");
    	String card=creditCardService.cancelCard(creditCardNumber);
    	log.debug("Controller class cancelCard method ended");
    	return card;
    	
    }
	
}
