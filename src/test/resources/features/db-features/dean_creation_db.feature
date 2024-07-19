Feature: db_dean_creation

  @db_test1
  Scenario: TC01_kayitli_dean_bilgisi_dogrulama

    Given Database baglantisi kurulur
    Then database de dean olusturuldugu dogrulanir username "DeanMuratt", ssn "222-22-2222", phone number "222-222-2222" database "dean" table