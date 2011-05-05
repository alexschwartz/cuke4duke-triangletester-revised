Feature: Triangle types are recognized for given side length value triples
  In order to practise my ATDD skills
  As test obsessed developer/qa guy
  I want 

Scenario: Valid triangles are recognized
	Given the side length values 2, 3, 1
	When ask the triangle type oracle is asked
	Then the triangle type is "Scalene"

Scenario: Valid triangles are recognized
    Given the side length values 2, 3, 100
    When ask the triangle type oracle is asked
    Then the triangle type is "Invalid"

