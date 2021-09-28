Feature: Request example



  @GET
  Scenario: GET from endpoint test
  Given a GET request is sent to the https://gorest.co.in/public/v1/ endpoint
  Then a 200 status code is received