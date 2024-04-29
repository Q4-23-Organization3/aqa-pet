Feature: Test api pets store
  Scenario: Update pet name
    Given New pet added with id: 123 and name: 'test_pet'
    When Set pet name to 'new_test_name' and sent PUT request
    Then When I make GET request by 123 received pet new name equals to 'new_test_name'

  Scenario Outline: Test unique pet status
    Given Pet with status <status>
    When Send GET to receive map of statuses
    Then Count of statuses <status> is <count>
    Examples:
      | status                  | count |
      | uniq_test_status1234  | 1     |
      | uniq_test_status12345 | 1     |

