Feature: Validate Parabank navigation

  Scenario: Create a new user at the Parabank page
    Given Navigate to the page ParaBank
    And ParaBank page, Click on the field with the name "Register"
    And ParaBank page, send data on the field "First Name:" with the value "Fab"
    And ParaBank page, send data on the field "Last Name:" with the value "Del"
    And ParaBank page, send data on the field "Address:" with the value "Avenida siempre viva 123"
    And ParaBank page, send data on the field "City:" with the value "Springfield"
    And ParaBank page, send data on the field "State:" with the value "Activated"
    And ParaBank page, send data on the field "Zip Code:" with the value "987456"
    And ParaBank page, send data on the field "Phone #:" with the value "3698521"
    And ParaBank page, send data on the field "SSN:" with the value "43210"
    And ParaBank page, send data on the field "Username:" with the value "Fabdel782"
    And ParaBank page, send data on the field "Password:" with the value "1234"
    And ParaBank page, send data on the field "Confirm:" with the value "1234"
    And ParaBank page, Click on the element with the name "Register"

