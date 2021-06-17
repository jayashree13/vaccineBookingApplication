Dear candidate,

Before the next round of discussion with you, we would like you to perform the following exercise.
We will use this project as a discussion point in the next round of interview with you.
Please zip and send your project (code, schema design, assumptions) before the next round of discussion.
Be prepared to walk through, demo and discuss your approach

Problem Statement:
===================
	-Write a REST service for a Vaccination drive.
	-Choose any database of choice.
	-Choose any web server framework of choice.
	-Coding language: Java, Node.js, Golang
	-Use json for transmitting data
	-The focus is on code structure, organization,api design & best practices. Please use validations, exceptions, error responses as appropriate
	-Make assumptions where you feel the requirements are not clear or you cannot implement because of time constraints.
	-No authentication or authorization is needed to be provided for the API endpoints

Note: You are only required to code the APIs, no need to design any GUI
-----

Beneficiary Registration
=========================
The beneficiary should be able to register using the following details( registration only for 45+)
	-Name
	-DOB (DD-MM-YYYY)
	-Aadhaar number (12 digit random Number - shouldn't allow duplicate)
	-Phone number( 10 digit random number)

Note: Beneficiaries cannot delete or update registration once created.
Each beneficiary gets a system generated beneficiary ID on registration.

Booking appointment:
=====================
The beneficiary must be able to book an appointment using the date and time slot:
	-Beneficiary ID
	-Date ( DD-MM-YYYY)
	-Time slot(9.30 am to 11.30am, 2pm to 4pm and 6pm to 8pm)
	-First dose or second dose.
	-Vaccine center ( Nungambakkam, Tambaram, Velachery, Shozhinganallur)


Rules to be followed for Booking appointment:
==============================================
	-Assume only one type of vaccine for this problem.
	-Each time slot should allow only 10 users to register.
	-There are a total of 30 vaccinations available per day in each vaccine center.
	-Out of the total 30 vaccinations available per day in each vaccine center.
		-15 are available for first dose.
		-15 are available for second dose.
	-Time between first and second dose is minimum 15 days.
	-A slot cannot be booked before 90 days.
	-One beneficiary can at any time have at most two appointments ( one for first dose and one for second dose)
	-Beneficiary must be able to to cancel or reschedule their appointment.