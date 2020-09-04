Please Follow This Instruction :
1. Create database in MySql with name demo_oauth.
2. Execute sql demo_oauth.sql in your MySql database, this file place in package or folder /src/main/resources.
3. This database not use password, only with user roor.
4. When all done and app was run, you can test in postman :
	Method : POST
	URL : http://localhost:8023/oauth/token?password=aris4321&grant_type=password&username=aris.setiawan
	
	Authorization
	Type : Basic Auth
	Username : my-client-id
	Password: password

For details you can see image : post login.png in package or folder /src/main/resources.