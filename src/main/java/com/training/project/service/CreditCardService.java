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
package com.training.project.service;

import java.time.LocalDate;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.training.project.model.CardHistoryModel;
import com.training.project.model.CreditCardModel;
import com.training.project.model.UserRegisterModel;
import com.training.project.repository.CardHistoryRepository;
import com.training.project.repository.CreditCardRepository;
import com.training.project.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
/**
 * class name: CreditCardService
 * description : Service class for CreditCardproject.
 *
 */

@Slf4j
@Component
@Service
public class CreditCardService {
	@Autowired	
	UserRepository userRepository;
	@Autowired	
	CreditCardRepository creditCardRepository;
	@Autowired	
	CardHistoryRepository cardHistoryRepository;
	
	
	/**
	 * @param userRegister
	 * @return creditCardModel
	 */
	public CreditCardModel createCard(UserRegisterModel userRegister) 
	{   
		
		log.info("Service class createCard method started with passing parameter userRegister{}\",userRegister");
		CreditCardModel creditCardModel=new CreditCardModel();
		if(userRegister.getSalary()>20000 && userRegister.getAge()>18) 
		{	
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		creditCardModel.setUsername(userRegister.getUsername());
		creditCardModel.setCreditCardNumber(userRegister.getAccountnumber()+10);
		creditCardModel.setPassword(passwordEncoder.encode(userRegister.getUsername().substring(0, 3).concat("123")));
		creditCardModel.setStatus("unblock");
		creditCardModel.setCreditLimit(30000);
		creditCardRepository.save(creditCardModel);
		}
		log.debug("Service class createCard method ended");
		return creditCardModel;
	}
	/**
	 * @param creditCardNumber
	 * @return cardStatus
	 */
	public String unBlockCard(int creditCardNumber)
	{
		log.info("Service class unBlockCard method started with passing parameter creditCardNumber{}\",creditCardNumber");
		String cardStatus="null";
		if(!ObjectUtils.isEmpty( creditCardRepository.findById(creditCardNumber))){
			Optional<CreditCardModel> card=creditCardRepository.findById(creditCardNumber);
			CreditCardModel creditCard=card.get();
			creditCard.setStatus("unblock");
			creditCardRepository.save(creditCard);
		    	
			cardStatus="unblock";
		}
		else
		{
			cardStatus="fruad user ";
		}
		log.debug("Service class unBlockCard method ended");
		return cardStatus;
	}
	
	/**
	 * @param creditCardNumber
	 * @return cardStatus
	 */
	public String blockCard(int creditCardNumber)
	{ 
		log.info("Service class blockCard method started with passing parameter creditCardNumber{}\",creditCardNumber");
		String cardStatus="null";
		if(!ObjectUtils.isEmpty( creditCardRepository.findById(creditCardNumber))){
			Optional<CreditCardModel> card=creditCardRepository.findById(creditCardNumber);
			CreditCardModel creditCard=card.get();
			creditCard.setStatus("block");
			creditCardRepository.save(creditCard);
		    	
			cardStatus="block";
		}
		else
		{
			cardStatus="fruad user ";
		}
		log.debug("Service class blockCard method ended");
		return cardStatus;
		
	}

	/**
	 * @param creditCardNumber
	 * @return creditCardModel
	 */
	public CreditCardModel cardLimitUpdate(int creditCardNumber)
	{
		log.info("Service class cardLimitUpdate method started with passing parameter creditCardNumber{}\",creditCardNumber");     
			Optional<CreditCardModel> card=creditCardRepository.findById(creditCardNumber);
			CreditCardModel creditCard=card.get();
			creditCard.setCreditLimit(creditCard.getCreditLimit()+5000);
			creditCardRepository.save(creditCard);	

		log.debug("Service class cardLimitUpdate method ended");
		return creditCard;
	}
	
	/**
	 * @param creditCardNumber
	 * @param amount
	 * @return creditCardModel
	 */
	public CreditCardModel acceptDues(int creditCardNumber,Integer amount)
	{
		log.info("Service class acceptDues method started with passing parameters creditCardNumber:{} and amount:{}",creditCardNumber,amount);
		Optional<CreditCardModel> card=creditCardRepository.findById(creditCardNumber);
		CreditCardModel creditCard=card.get();
		creditCard.setCreditLimit(creditCard.getCreditLimit()+ amount);
		creditCardRepository.save(creditCard);
		log.debug("Service class acceptDues method ended");
		return creditCard;
	}

	 /**
	 * @param creditCardNumber
	 */
	public String cancelCard(int creditCardNumber)
	 {  
		 log.info("Service class cancelCard method started with passing parameter creditCardNumber{}\",creditCardNumber");
		 String cardStatus="null";
		 LocalDate date = LocalDate.now(); 
		 Optional<CreditCardModel> customer=creditCardRepository.findById(creditCardNumber);
		 CardHistoryModel historyModel=new CardHistoryModel();
		 historyModel.setUsername(customer.get().getUsername());
		 historyModel.setCreditCardNumber(creditCardNumber);
		 historyModel.setCancelDate(date); 
		 historyModel.setStatus("cancel");
		 cardStatus="cancel";
		 cardHistoryRepository.save(historyModel);
		 creditCardRepository.deleteById(creditCardNumber); 
		 log.debug("Service class cancelCard method ended");
		 
		 return cardStatus;
	 }
}
