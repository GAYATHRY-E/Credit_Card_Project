package com.training.project.test.controller;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.training.project.controller.CreditCardController;
import com.training.project.model.CreditCardModel;
import com.training.project.model.UserRegisterModel;
import com.training.project.repository.UserRepository;
import com.training.project.service.CreditCardService;

import junit.framework.Assert;


class CreditCardControllerTest {
	
	@InjectMocks
    private CreditCardController controller;
	@Mock
	private CreditCardService service;
	@Mock
    private UserRepository userRepository;

	@Test
	public void testCreateCreditCard(){
		 UserRegisterModel user=new UserRegisterModel(); 
		 user.setUsername("gayu");
		 user.setAccountnumber(369);
		 user.setAge(21);
		 user.setPhonenumber(321);
		 user.setSalary(60000); 
	CreditCardModel cardModel=new CreditCardModel();
	cardModel.setUsername("gayu");
	Mockito.when(service.createCard(Mockito.any())).thenReturn(cardModel);
	CreditCardModel creditCard =controller.register(user);
	Assert.assertEquals(creditCard.getUsername(), user.getUsername());
	}
	
	@Test
	public void testUnBlockCard(){
		
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("Unblock");
		card.setCreditLimit(30000);
		Optional<CreditCardModel> optionCard=Optional.of(card);
	//	Mockito.when(CreditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		Mockito.when(service.unBlockCard(Mockito.anyInt())).thenReturn(card.getStatus());
		String cardStatus =controller.unBlockCard(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus, "unBlock");
	}
	

	@Test
	public void testBlockCard(){
		
		
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("Unblock");
		card.setCreditLimit(30000);
		Optional<CreditCardModel> optionCard=Optional.of(card);
	//	Mockito.when(CreditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		Mockito.when(service.blockCard(Mockito.anyInt())).thenReturn(card.getStatus());
		String cardStatus =controller.blockCard(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus, "Block");
	}
	

	@Test
	public void TestcardLimitUpdate(){
		
		
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("Unblock");
		card.setCreditLimit(30000);
		Optional<CreditCardModel> optionCard=Optional.of(card);
	//	Mockito.when(CreditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		Mockito.when(service.cardLimitUpdate(Mockito.anyInt())).thenReturn(card);
		CreditCardModel creditCard =controller.cardLimitUpdate(card.getCreditCardNumber());
		Assert.assertEquals(creditCard.getCreditLimit(), 25000);
	}
	@Test
	public void testAcceptDues(){
		
		
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("Unblock");
		card.setCreditLimit(30000);
		int amount=2000;
		Optional<CreditCardModel> optionCard=Optional.of(card);
	//	Mockito.when(CreditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		Mockito.when(service.acceptDues(Mockito.anyInt(), Mockito.anyInt())).thenReturn(card);
		CreditCardModel creditCard =controller.acceptDues(card.getCreditCardNumber(), amount);
		Assert.assertEquals(creditCard.getCreditLimit(), 35000);
	}
	@Test
	public void testCancelCard(){
		
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("cancel");
		card.setCreditLimit(30000);
		Optional<CreditCardModel> optionCard=Optional.of(card);
	//	Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		Mockito.when(service.cancelCard(Mockito.anyInt())).thenReturn(card.getStatus());
		String cardStatus =controller.cancelCard(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus, "Cancel");
	}
	
}
