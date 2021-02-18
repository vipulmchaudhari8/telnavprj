# telnavprj

1. Download the project and run com.telnavprj.com.telnavprj as java application
2. Make a POST request with below details to generate JWT token for the first request
http://localhost:8080/authenticate
Body
{
	"username":"telenav",
	"password":"password"
}
Select application/json

Sample JWT Token:
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWxlbmF2IiwiZXhwIjoxNjEzNTExMjczLCJpYXQiOjE2MTM0OTMyNzN9.2jhkeNAbFxOoi7sNi5P_v_leaarMAgfoTurfY3J3NoA5Bvzcx5qZRKGmtw9NsVLu12oCnbjg188kM_bh85K78Q

3.	Use this JWT token and content type as application/json for the next request
http://localhost:8080/echo
{
"RecordType": "xxx",
"DeviceId": "357370040159770",
"EventDateTime": "2014-05-12T05:09:48Z",
"FieldA": 68,
"FieldB": "xxx",
"FieldC": 123.45
}

4.	Make post request to fetch only deviceId
http://localhost:8080/device
 
5.	‘/nocontent’ request with 204 response code

http://localhost:8080/nocontent

6.	For all other random URLs response will with be with status code 400
http://localhost:8080/nocontent1

7. Project include in-memory data base integration to store data
8. Project also include integration test and  Audit for the API calls

