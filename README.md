# geekseat-witch-saga
Geekseat Witch Saga Application

How to clone this project into your IDE :
- Go to your IDE projects folder
- Open your terminal / command window in this folder
- Run this syntax : git clone git@github.com:guusbajoos/geekseat-witch-saga.git

Run Project directly in IDE (using Java command) as Console Application :
- In your IDE, open folder src/main/java/id/guusbajoos/runconsole/
- Right click on file MainApplication, click on Run 'MainApplication.main()'
- Geekseat Witch Saga Application will run, check for any error or issue
	- If there isn't any error nor issue, Geekseat Witch Saga Application has been run in your IDE

Run Project directly in IDE (using Java command) as API Server :
- In your IDE, open folder src/main/java/id/guusbajoos/
- Right click on file WitchSagaApplication, click on Run 'WitchSagaApplication.main()'
- Geekseat Witch Saga Server will run, check for any error or issue
    - If there isn't any error nor issue, Geekseat Witch Saga Server has been run in your IDE
	
How to process many people data using API Server (using Postman) :
- Make sure Geekseat Witch Saga Server has been run before
- Open Postman, and then type http://localhost:8080/api/main on the address bar (set HTTP method to POST)
- Move tab into tab Body. Choose raw option with JSON format 
- On the request body field, input this JSON format request :
  ```javascript
  {
    "personIdentity" : [
      {
        "ageOfDeath": 1,
        "yearOfDeath": 2
      },
      {
        "ageOfDeath": 2,
        "yearOfDeath": 4
      },
      ...
      {
        "ageOfDeath": 4,
        "yearOfDeath": 10
      }
    ]
  }
  ```
- Hit send button. Endpoint will give response based on request