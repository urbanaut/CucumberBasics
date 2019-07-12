Feature: UI wants to be able to schedule mock exam

  Scenario: User schedules a mock exam
    Given User navigates to the exam calendar page
    When The user opens the Mock exam tab
    And The user selects the day and time of the exam
    And The user verifies the correct date
    Then The mock exam is successfully scheduled