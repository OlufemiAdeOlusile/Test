@ACMEExpediaAPI
Feature: Get API and perform assertions


  @AllCountryTest
  Scenario Outline: Test all resource
    When the user requests resource "<resource>"
    Then I validate name assertions "<resource>" "<name1>" "<name2>"
    And I validate alphacode assertions"<resource>" "<alpha2_code1>" "<alpha3_code2>"
    And I validate message assertions "<resource>" "<message1>" "<message2>"

    Examples:
      | resource         |  | name1       |  | name2 |  | alpha2_code1 |  | alpha3_code2 |  | message1                                                                            | message2                   |
      | /country/get/all |  | Afghanistan |  | Nepal |  | NL           |  | ZWE          |  | More webservices are available at http://www.groupkt.com/post/f2129b88/services.htm | Total [249] records found. |



  @PostiveISOTest
  Scenario Outline: Positive test IsoCode resource
    When the user requests resource "<resource>"
    Then I validate ISO name assertions "<resource>" "<name1>"
    And I validate ISO alphacode assertions "<resource>" "<alpha2_code1>" "<alpha3_code2>"
    And I validate ISO message assertions "<resource>" "<message1>"


    Examples:
      | resource                  |  | name1 |  | alpha2_code1 |  | alpha3_code2 |  | message1                           |
      | /country/get/iso2code/IN  |  | India |  | IN           |  | IND          |  | Country found matching code [IN].  |
      | /country/get/iso3code/IND |  | India |  | IN           |  | IND          |  | Country found matching code [IND]. |


  @SearchTest
  Scenario Outline: Search http search with text method
    When the user requests resource "<resource>"
    Then I validate name assertions "<resource>" "<name1>" "<name2>"
    And I validate alphacode assertions"<resource>" "<alpha2_code1>" "<alpha3_code2>"
    And I validate ISO message assertions "<resource>" "<message1>"


    Examples:
      | resource                |  | name1             |  | name2                    |  | alpha2_code1 |  | alpha3_code2 |  | message1                  |
      | /country/search?text=un |  | Brunei Darussalam |  | United States of America |  | WF           |  | REU          |  | Total [12] records found. |
      | /country/search?text=IN |  | Argentina         |  | Saint Lucia              |  | IN           |  | IND          |  | Total [44] records found. |


  @NegativeTests
  Scenario Outline: Negative test For IsoCode and Search resource for error response
    When the user requests resource "<resource>"
    Then I validate ISO message assertions "<resource>" "<message1>"

    Examples:
      | resource                  |  | message1                                             |
      | /country/get/iso2code/IU  |  | No matching country found for requested code [IU].   |
      | /country/get/iso3code/XYZ |  | No matching country found for requested code [XYZ].  |
      | /country/search?text=xx   |  | No matching country found for requested code [xx].   |
      | /country/search?text=yyyy |  | No matching country found for requested code [yyyy]. |



