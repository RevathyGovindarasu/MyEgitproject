Feature: Google Home Page
Scenario Outline: Happy Path for Google Homepage

Given when the url of "<page>" is given for the "<Test Case>"
When lauches the url for the "<page>"
Then page appears successfully

Examples:
 
 |Test Case|page| 
 |HappyPath |Google|
 #|HappyPath |Gmail| 
 #|HappyPath |Youtube| 