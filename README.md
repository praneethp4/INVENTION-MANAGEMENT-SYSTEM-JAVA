# INVENTION-MANAGEMENT-SYSTEM-JAVA
The main aim of this project is to develop a system which helps to manage all the invention information that exists in the world wise with the details of inventors, jury who awarded them etc. managing efficiently with convenience. We will develop a complete Java Application with front end and backend. Any user can access the system to view the data by logging in with the valid credentials. Person can also register to the system if he is a new user. If the login credentials are invalid then, an error message will be displayed on the screen accordingly. User can be just a viewer or a one person who can insert the details of the invention (basically an inventor). Inventions can also receive the nominations from the user (only the viewer). It is not mandatory that every inventor should receive the award. Secondary actor Admin updates all the information made by the users. Awards are given by nominations to inventor’s inventions for which the jury’s decision is final. Jury can login to the system with the valid credentials and can give verdict for the invention based on the nominations. If the jury login credentials are invalid, then error message will be displayed on the screen. On the other hand, database stores the invention details like invention, inventors(s), category (like science, engineering etc), the year of invention, the story behind, awards/recognitions received, the year in which that was received etc. The inventor details include name, country, and job type. The list of jury members, details of nominations, awards can also be maintained in database. 

## Use Case Diagram
![image](https://github.com/praneethp4/INVENTION-MANAGEMENT-SYSTEM-JAVA/assets/123055147/f126be02-1f67-46b5-bb60-1e6d8577f847)

## Class Diagram
![image](https://github.com/praneethp4/INVENTION-MANAGEMENT-SYSTEM-JAVA/assets/123055147/74bf84a1-c973-4fe1-a78a-194834194a7d)

## Functionality
### 1. User:  
•	User needs to register with system and login with the valid credentials. He can nominate for the invention and can view the details of the invention. 
•	User can also insert details of the invention 
### 2. Jury 
• Jury registers and login to the system and can give verdict for the invention based on the nominations. 
### 3. Admin 
• Admin updates the info of the user, inventor, and jury. 
