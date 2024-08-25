Feature: Add workspace user flow

  Background:
    Given User is logged In

  Scenario: Adding a workspace user flow

    When User clicks on menu button
    And Clicks on settings button inside menu
    And Clicks on user button under workspace section
    And Clicks on add user button
    And Enters workspace user email
    And Clicks on add user email button
    Then Verify the workspace user is added successfully