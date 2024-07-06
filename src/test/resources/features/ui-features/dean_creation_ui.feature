Feature: US142013_Yeni_Dekan_Olusturma

  @ui1
  Scenario: TC01_dean_creation_ui

    Given kullanici "https://managementonschools.com/" sayfasina "admin" olarak giris yapar
    And dean sayfasina gider ve su verilerle dean olusturulur : name "ahmet4", surname "bayram1", birth_place "istanbul", gender "male", date_of_birth "10-10-2000", phone "839-683-7310", ssn "111-22-4333", username "ay73n6l!1", password "Kadfasdf!g2"
    Then dean olusturuldugunu ve "Dean Saved" mesajini dogrulanir
    Then uygulama kapalitir

  @ui2
  Scenario Outline: TC02_dean_creation_ui_scenario_outline

    Given kullanici "https://managementonschools.com/" sayfasina "admin" olarak giris yapar
    And dean sayfasina gider ve su verilerle dean olusturulur : name "<name>", surname "<surname>", birth_place "<birth_place>", gender "<gender>", date_of_birth "<date_of_birth>", phone "<phone>", ssn "<ssn>", username "<username>", password "<password>"
    Then dean olusturuldugunu ve "Dean Saved" mesajini dogrulanir
    Then uygulama kapalitir


    Examples: dean_bilgileri
      | name  | surname | birth_place | gender | date_of_birth | phone        | ssn         | username  | password    |
      | john  | lenon   | LA          | male   | 10-10-2000    | 839-683-7310 | 111-22-4233 | ay73n771  | Kadfasdf!g2 |
      | sam   | walton  | NYC         | male   | 10-10-2000    | 839-683-7366 | 111-22-4326 | ay73nyy1  | Uadfasdf!g2 |
      | simon | bales   | Dallas      | male   | 10-10-2000    | 839-683-7322 | 111-22-4362 | bs73n6l!1 | Ysffasdf!g2 |


#    EXCEL UI DATALARI ILE DEAN OLUSTURMA