#Owner : Wboufaden


@Scénario1
Feature: Recherche TV

  Scenario: 01 - Valider la recherche de TV
    Given Je suis sur la page "https://www.google.com/"
    And Naviguer a la page "https://www.ldlc.com/"
    Then Valider l'affichage de la page d'acceuil LDLC
    And Effectuer une recherche de "TV"
    Then Valider la recherche
