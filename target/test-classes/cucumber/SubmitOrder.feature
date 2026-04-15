@tag
Feature: Purchase the order from ecommerce store 


	Background:
	Given I landed on Ecommerce Page
		
	@tag2
	Scenario Outline: Positive Test of submitting the order
		Given : I logged with username <name> and password <password>
		When :	I add a product <product> to Cart 
		And : Checkout <product> and submit the order
		Then : "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
		
		Examples:
			| name					|	password	| product
			| macguy@gmail.com		|   Unlock@001  | ZARA COAT 3