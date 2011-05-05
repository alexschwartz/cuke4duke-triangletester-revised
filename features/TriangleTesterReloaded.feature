Feature: Triangle types are recognized for given side length value triples
  In order to practise my ATDD skills
  As test obsessed developer/qa guy
  I want 

Scenario: Valid triangles are recognized
	Given the side length values 2, 3, 1
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
      

