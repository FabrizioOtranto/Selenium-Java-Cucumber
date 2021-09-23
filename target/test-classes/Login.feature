Feature: Login Funcionality

	In order to do rendering functions
	As a valid administrator 
	I want to login successfully

	
Scenario Outline: Login Succesful

Given The user is in the login page of automationPractice
When The user enter valid <username> and <password> with <userFullName>
Then The user should be taken to my account

Examples:
|username|password|userFullName|
|"qs123@gmail.com"|"qs123"| "a a"|
|"qs123@gmail.com"|"qs123"| "a a"|
