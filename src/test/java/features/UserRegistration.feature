Feature: User Registration
 	I want to check that the user can register to our e-commerce website.
		
	Scenario Outline: User Registration
	Given The user in the home page
	When The user click on the register link
	And The user entered "firstName", "lastName", "email", "companyName", "password"
	Then The registraion page displayed successfully
	
	Examples:
	
		| firstName | lastName | email | companyName | password |
		| mahmo | Mong | mamo3@mail.com | MONJ | 12345678 |
		| mau | Kls | Moi3@test.com | KIU | 12343434 |
		