Feature: Triangle types are recognized for given side length value triples
  In order to practise my ATDD skills
  As test obsessed developer/qa guy
  I want 

Scenario: Valid triangles are recognized
	Given the side length values 10, 8, 3
	When ask the triangle type oracle is asked
	Then the triangle type is "Scalene"

Scenario Outline: Valid triangles are recognized
    Given the side length values <side1>, <side2>, <side3>
    When ask the triangle type oracle is asked
    Then the triangle type is "Invalid"
    
    Examples:
      | side1 | side2 | side3 | comment           |
      |     1 |     1 |   100 | smoke test        |
      |   100 |     1 |     1 | smoke test, order |
      |     1 |   100 |     1 | smoke test, order |
      |     1 |     2 |     1 | boundary test     |
      

Scenario Outline: Equilateral triangles are recognized
    Given the side length values <side1>, <side1>, <side1>
    When ask the triangle type oracle is asked
    Then the triangle type is "Equilateral"
  
    Examples:
      | side1 | comment           |
      |     1 | smoke test        |
      |    10 | smoke test        |
      |   100 | smoke test        |
      
Scenario Outline: Isosceles triangles are recognized
    Given the side length values <side1>, <side2>, <side3>
    When ask the triangle type oracle is asked
    Then the triangle type is "Isosceles"
    
    Examples:
      | side1 | side2 | side3 | comment           |
      |     3 |     2 |     2 | smoke test        |
      |     2 |     3 |     2 | smoke test, order |
      |     2 |     2 |     3 | smoke test, order |
      |   101 |    20 |   101 | smoke test     |
      |   101 |   100 |   101 | boundary test     |
      
Scenario: an Isosceles but invalid triangle is recognized
    Given the side length values 100, 100, 999
    When ask the triangle type oracle is asked
    Then the triangle type is "Invalid"

Scenario: a "Right Scalene" triangle is recognized
    Given the side length values 3, 4, 5
    When ask the triangle type oracle is asked
    Then the triangle type is "Right_Scalene"

Scenario: a "Right Isosceles" triangle is recognized
    Given the side length values 2, 2, 2.82842712
    When ask the triangle type oracle is asked
    Then the triangle type is "Right_Isosceles"

    