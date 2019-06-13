Feature: User panel setup

  @wordpress @login @userProfile
  Scenario: Setup user profile
    Given User start on main page
    When User log In to the user page
    Then User can modfied user profile

  @wordpress @notyfication
  Scenario: Setup notyfication
    Given User start on page "https://wordpress.com/"
    When User log In to the user page
    Then User can modfied notyfication