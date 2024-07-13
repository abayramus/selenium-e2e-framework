Feature: api_dean_creation

  @api_get
  Scenario: TC01_dean_get_api

    Given "admin" yetkisi ile giris yapilir
    And Dean icin "get" URL olusturulur
    When Dean icin "get" Request gonderilir ve Response alinir
    Then Status kodunun 200 oldugu dogrulanir
    Then dean olusturuldugu dogrulanir username "Livia", ssn "218-45-6780", phone number "546-456-1233" api
#    Then dean olusturuldugu dogrulanir username "Livia"
#    Then dean olusturuldugu dogrulanir ssn "218-45-6780"
#    Then dean olusturuldugu dogrulanir phone number "546-456-1233" api

  @api_post
  Scenario: TC02_dean_post_api
    Given "admin" yetkisi ile giris yapilir
    And Dean icin "post" URL olusturulur
    And Dean icin payload duzenlenir name "ahmet4", surname "bayram1", birth_place "istanbul", gender "MALE", date_of_birth "1999-01-01", phone "839-983-6178", ssn "111-22-6291", username "jfdjert8", password "Kadfasdf!g2"
    When Dean icin "post" Request gonderilir ve Response alinir
    Then Status kodunun 200 oldugu dogrulanir
    Then Dean Save icin Response Body dogrulanir

    @api_put
    Scenario: TC03_dean_put_api
      Given "admin" yetkisi ile giris yapilir
      And Kayitli Dean username "jfdjert6" icin userID numarasi alinir
      And Dean icin "put" URL olusturulur
      And Dean icin payload duzenlenir name "johnny", surname "brown", birth_place "TX", gender "MALE", date_of_birth "1999-01-01", phone "839-983-1678", ssn "111-22-5267", username "lastput", password "Kadfasdf!g2"
      When Dean icin "put" Request gonderilir ve Response alinir
      Then Status kodunun 200 oldugu dogrulanir
      Then Dean Save icin Response Body dogrulanir


      @api_delete
      Scenario: TC04_dean_delete_api
        Given "admin" yetkisi ile giris yapilir
        And Kayitli Dean username "lastput" icin userID numarasi alinir
        And Dean icin "delete" URL olusturulur
        When Dean icin "delete" Request gonderilir ve Response alinir
        Then Status kodunun 200 oldugu dogrulanir