Feature: Validate the API Jsonplaceholder

  Scenario: validate if the emails properly formatted
    Given that I search for the username "Delphine" to get its id
    When I use the id fetched to search for the posts written by the user
    Then I validate if the emails in the comment section are in the proper format

#  Scenario: validate if the emails properly formatted
#    Given that I search for the username "Delphine" to get its id
#    When I use the id fetched to search for the posts written by the user
#    Then I validate if the emails in the comment section are in the proper format
