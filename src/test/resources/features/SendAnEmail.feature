Feature: Send a new email from drafts

  Scenario Outline:
    Given I Sign in to Yandex mail
    When I Open new email
    And I Write "<to>", with "<subject>" and "<text>"
    And Close email choosing to save as draft
    And Open draft folder and check the "<subject>"
    And Send the email
    Then Assert that "Письмо отправлено."

    Examples:
      | to                          | subject        | text                             |
      | selenium.tester80@gmail.com | Hello brother! | I was born later and I'm Russian |

