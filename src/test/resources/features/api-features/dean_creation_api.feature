Feature: api_dean_creation

  @api_get
  Scenario: TC01_dean_get_api

    Given "admin" yetkisi ile giris yapilir
    And Dean icin "get" URL olusturulur
    When Dean icin "get" Request gonderilir ve Response alinir
    Then Status kodunun 200 oldugu dogrulanir
    Then dean olusturuldugu dogrulanir username "paul.atreides49", ssn "139-91-2518", phone number "520-123-1401" api



