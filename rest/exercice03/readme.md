# Entry point:
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