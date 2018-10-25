#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Como usuario de la granja quiero poder añadir 
nuevos animales a la granja para poder
calcular el coste alimentario de todos ellos.

  @tag1
  Scenario: AnadirCerdo
    Given no hay ningun animal en la granja
    When añado 2 cerdos en la granja
    Then en la granja habra 2 cerdos
    
   @tag2
  Scenario: GranjaSinAnimales
    Given no hay ningun animal en la granja
    When cuando verifico el numero de animales
    Then obtengo 0 animales
    
    
