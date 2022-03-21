package com.training.project.service;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.training.project.model.CreditCardModel;
import com.training.project.model.UserRegisterModel;
import com.training.project.repository.CardHistoryRepository;
import com.training.project.repository.CreditCardRepository;
import com.training.project.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestCreditCardService {
	@InjectMocks
	private CreditCardService creditCardService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private CreditCardRepository creditCardRepository;
	@Mock
	CardHistoryRepository cardHistoryRepository;
    @Before
     public void setUp() {
    	 MockitoAnnotations.initMocks(this);
     }
	@Test
	public void testCreateCard(){
		
		 UserRegisterModel user=new UserRegisterModel(); 
		 user.setUsername("gayu");
		 user.setAccountnumber(369);
		 user.setAge(21);
		 user.setPhonenumber(321);
		 user.setSalary(60000); 
		 CreditCardModel card=creditCardService.createCard(user);
		 Assert.assertEquals(card.getUsername(),user.getUsername());	 
	}
	@Test
	   public void testUnblockCard(){
			
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("block");
		card.setCreditLimit(30000);
		Optional<CreditCardModel> optionCard=Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String cardStatus=creditCardService.unBlockCard(card.getCreditCardNumber());
			Assert.assertEquals(cardStatus,"unblock");	
			
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
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String cardStatus=creditCardService.blockCard(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus,"block");	
			
		}
	@Test
	   public void testcardLimitUpdate(){
			
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("Unblock");
		card.setCreditLimit(30000);
		Optional<CreditCardModel> optionCard=Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		CreditCardModel creditCardModel=creditCardService.cardLimitUpdate(card.getCreditCardNumber());
		Assert.assertEquals(creditCardModel.getCreditLimit(),35000);	
			
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
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		CreditCardModel creditCardModel=creditCardService.acceptDues(card.getCreditCardNumber(),amount);
		Assert.assertEquals(creditCardModel.getCreditLimit(),32000);	
			
		}
	@Test
	   public void testCancelCard(){
			
		CreditCardModel card=new CreditCardModel();
		card.setUsername("gayu");
		card.setCreditCardNumber(369);
		card.setPassword("gayu123");
		card.setStatus("Unblock");
		card.setCreditLimit(30000);
		LocalDate date = LocalDate.now();
		Optional<CreditCardModel> optionCard=Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String cardStatus=creditCardService.cancelCard(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus,"cancel");	
			
		}
		

}
