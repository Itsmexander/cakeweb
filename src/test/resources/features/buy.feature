Feature: Buy products
  As a customer
  I want to buy products

  Background:
    Given the store is ready to service customers
#    And a product "Chocolate" with price 359 and stock of 10 exists
#    And a product "Carrot" with price 359 and stock of 10 exists
#    And a product "Strawberry" with price 359 and stock of 10 exists
#    And a product "Raspberry" with price 359 and stock of 10 exists
    And a product "db793de2-9ab4-434f-80f4-5aab984f23f6" is "Chocolate" with weight 1, price 359, and stock of 10 exists

    # อันนี้ยังไม่ได้แก้
    And a product "db793de1-9ab4-434f-80f4-5aab984f23f6" is "Carrot" with weight 1, price 359, and stock of 10 exists
    And a product "db793de3-9ab4-434f-80f4-5aab984f23f6" is "Strawberry" with weight 1, price 359, and stock of 10 exists
    And a product "db793de44-9ab4-434f-80f4-5aab984f23f6" is "Raspberry" with weight 1, price 359, and stock of 10 exists

  Scenario: Buy one product
    When I buy "Chocolate" with quantity 2
    Then total should be 718

  Scenario: Buy multiple products
    When I buy "Carrot" with quantity 2
    And I buy "Strawberry" with quantity 1
    Then total should be 1077