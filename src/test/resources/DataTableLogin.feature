Feature: Login Funcionality DataTable

	In order to do rendering functions
	As a valid administrator 
	I want to login successfully

	
Scenario: Login Succesful DataTable

Given The user is in the login page of Rendring webDB
When The user enter valid credentials
|"Danny"|"Danny123"|
Then The user should be taken to the index pageDB

