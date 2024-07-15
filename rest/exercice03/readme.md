# Entry point:

## Employee
- GET all employees **/api/employee**
- POST create employee **/api/employee/add**
  - ``{
          "firstname": "changeme",
          "lastname": "changeme",
          "email": "changeme",
          "password": "changeme",
          "admin": true,
          "salary": 2999,
          "birthdayStr": "dd-mm-yyyy",
          "phone": "0000000000",
          "address": "changeme",
          "observation" : "changeme",
          "occupation": "changeme",
          "contractStartStr": "dd-mm-yyyy",
          "contractEndStr": "dd-mm-yyyy"
          }``
- GET one employee **/api/employee/{id}**
- PUT update employee **/api/employee/{id}**
- DELETE delete employee **/api/employee/{id}**

## Candidate
- GET all candidates **/api/candidate**
  - POST create candidate **/api/candidate/add**
          - ``{
            "firstname": "changeme",
            "lastname": "changeme",
            "email": "changeme",
            "birthdayStr": "dd-mm-yyyy",
            "phone": "0000000000",
            "address": "changeme",
            "observation" : "changeme",
            "skill" : "changeme",
            "technicalArea" : "changeme",
            "rating" : 5,
            "jobInterviewDateStr" : "dd-mm-yyyy hh:mm"
  }``
- GET one candidate **/api/candidate/{id}**
- PUT update candidate **/api/candidate/{id}**
- DELETE delete candidate **/api/candidate/{id}**