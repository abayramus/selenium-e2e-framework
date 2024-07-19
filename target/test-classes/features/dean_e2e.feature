Feature: dean_e2e

  Scenario: admin yetkisiyle dean olusturma testi

    #UI
    Given kullanici "https://managementonschools.com/" sayfasina "admin" olarak giris yapar
    And dean sayfasina gider ve su verilerle dean olusturulur : name "ahmet4", surname "bayram1", birth_place "istanbul", gender "male", date_of_birth "10-10-2000", phone "481-683-7310", ssn "481-22-4333", username "ay73n481", password "Kadfasdf!g2"
    Then dean olusturuldugunu ve "Dean Saved" mesajini dogrulanir
    Then uygulama kapalitir

    #API
    Given "admin" yetkisi ile giris yapilir
    And Dean icin "get" URL olusturulur
    When Dean icin "get" Request gonderilir ve Response alinir
    Then Status kodunun 200 oldugu dogrulanir
    Then dean olusturuldugu dogrulanir username "ay73n481", ssn "481-22-4333", phone number "481-683-7310" api

    #DATABASE
    Given Database baglantisi kurulur
    Then database de dean olusturuldugu dogrulanir username "ay73n481", ssn "481-22-4333", phone number "481-683-7310" database "dean" table

#    API DELETE - son olusturdugumuz kullaniciyi silelim. bu sekilde tekrar o kullaniciyi olusturabiliriz.
    Given "admin" yetkisi ile giris yapilir
    And Kayitli Dean username "ay73n481" icin userID numarasi alinir
    And Dean icin "delete" URL olusturulur
    When Dean icin "delete" Request gonderilir ve Response alinir
    Then Status kodunun 200 oldugu dogrulanir