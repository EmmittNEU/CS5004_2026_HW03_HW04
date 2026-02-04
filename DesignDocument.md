# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.

If you are using mermaid markup to generate your class diagrams, you may edit this document in the sections below to insert your markup to generate each diagram. Otherwise, you may simply include the images for each diagram requested below in your zipped submission (be sure to name each diagram image clearly in this case!)

## (INITIAL DESIGN): Class Diagram

Include a UML class diagram of your initial design for this assignment. If you are using the mermaid markdown, you may include the code for it here. For a reminder on the mermaid syntax, you may go [here](https://mermaid.js.org/syntax/classDiagram.html)

(Given Access Via Google Drive)
Check UML folder



## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 
1. Test that the `Employee` classes objects can be created will appropriate parameters
2. Test that the `Employee` classes throws an `IllegalArgumentException` when the pay rate is less than or equal to 0
3. Test that the `Employee` classes does not throw an error when given very low (0.01) or very high values
4. Test that the `Employee` classes throws an `IllegalArgumentException` when the `name` is null or blank
5. Test that the `Employee` classes throws an `IllegalArgumentException` when the `id` is null or blank
6. Test that the `Employee` classes throw an `IllegalArguementException` when `ytdEarnings` is negative
7. Test that the `Employee` classes throw an `IllegalArguementException` when `ytdTaxesPaid` is negative
8. Test that the `Employee` classes throw an `IllegalArguementException` when `pretaxDeductions` is negative
9. Test that the `Employee` classes properly returns `name` from `getName()`
10. Test that the `Employee` classes properly returns `id` from `getId()`
11. Test that the `Employee` classes properly returns `payRate` from `getPayRate`
12. Test that the `Employee` classes properly returns `ytdEarnings` from `getYTDEarnings`
13. Test that the `Employee` classes properly returns `ytdTaxesPaid` from `getYTDTaxesPaid`
14. Test that the `Employee` classes properly returns `pretaxDeductions` from `getPretaxDeductions`
15. Test that the `Employee` classes properly return a properly formatted `IPayStub` from `runPayroll`
16. Test that the `Employee` classes properly sends info to CSV format from `toCSV`
17. Test that the `Employee` classes properly output when values are 0
18. Test that the `Employee` classes properly output when values include decimals
19. Test that `runPayroll` behaves as expected with exactly 40 hours
20. Test that `runPayroll` behaves as expected with more than 40 hours (overtime)
21. Test that `runPayroll` behaves as expected with less than 40 hours
22. Test that `runPayroll` behaves as expected with 0 hours ($0 paystub)
23. Test that `runPayroll` has pre-tax deductions applied as expected
24. Test that `runPayroll` has taxes applied properly
25. Test that `ytdEarnings` are updated correctly after `runPayroll`
26. Test that `ytdTaxesPaid` are updated correctly after `runPayroll`
27. Test multiple consecutive `runPayroll` runs accumulate YTD correctly
28. Test rounding to nearest cent (2 decimal places)
29. Test that the `TimeCard` class properly returns `employeeID` from `getEmployeeID`
30. Test that the `TimeCard` class properly returns `hoursWorked` from `getHoursWorked`
31. Test that the `PayStub` class properly returns `pay` from `getPay`
32. Test that the `PayStub` class properly returns `taxesPaid` from `getTaxesPaid`
33. Test that the `PayStub` class throws an `IllegalArguementException` when initialized with a negative value
34. Test that the `PayStub` class does not throw an `IllegalArguementException` when initialized with a value of 0
35. Test that `toCSV` adds to the CSV file in the proper order and format
36. Test that the `Builder` class `buildEmployeeFromCSV()` can properly build `HourlyEmployee` from valid CSV string
37. Test that the `Builder` class `buildEmployeeFromCSV()` can properly build `SalaryEmployee` from valid CSV string
38. Test that the `Builder` class `buildEmployeeFromCSV()` can properly work with CSV containing all fields populated
39. Test that the `Builder` class `buildEmployeeFromCSV()` can properly work with CSV containing decimal values
40. Test that the `Builder` class `buildEmployeeFromCSV()` will throw an `IllegalArgumentException` with malformed CSV (wrong number of fields)
41. Test that the `Builder` class `buildEmployeeFromCSV()` will throw an `IllegalArgumentException` with invalid employee type
42. Test that the `Builder` class `buildEmployeeFromCSV()` will throw an `IllegalArgumentException` with empty CSV string
43. Test that the `Builder` class `buildEmployeeFromCSV()` will throw an `IllegalArgumentException` with null CSV string
44. Test that the `Builder` class `buildEmployeeFromCSV()` employee type detection works (first field should be `Hourly` or `Salary`)
45. Test that the `Builder` class `buildTimeCardFromCSV()` can properly build TimeCard from valid CSV string
46. Test that the `Builder` class `buildTimeCardFromCSV()` works with decimal hours
47. Test that the `Builder` class `buildTimeCardFromCSV()` throws an `IllegalArgumentException` with negative hours
48. Test that the `Builder` class `buildTimeCardFromCSV()` throws an `IllegalArgumentException` with malformed CSV
49. Test that the `Builder` class `buildTimeCardFromCSV()` throws an `IllegalArgumentException` with empty/null CSV string
50. Test that the `FileUtil` class `readFileToList()` can read a valid file with multiple lines
51. Test that the `FileUtil` class `readFileToList()` header line is removed
52. Test that the `FileUtil` class `readFileToList()` can read an empty file (only header)
53. Test that the `FileUtil` class `readFileToList()` can't read non-existent file and should throw `IllegalArguementException`
54. Test that the `FileUtil` class `readFileToList()` can read file with various line endings
55. Test that the `FileUtil` class `writeFile()` can write lines to new file
56. Test that the `FileUtil` class `writeFile()` creates backup file when file exists
57. Test that the `FileUtil` class `writeFile()` creates backup file with .bak extension
58. Test that the `FileUtil` class `writeFile()` writes with backup=false doesn't create backup
59. Test that the `FileUtil` class `writeFile()` handles IOException during writes
60. Test that the `FileUtil` class `writeFile()` overwrites existing backup file
61. Test complete payroll workflow run with sample employees and time cards
62. Test matching employees to time cards by ID
63. Test that employees with negative hours are skipped (no paystub added)
64. Test that employees with 0 hours generate $0 paystubs
65. Test that unmatched time cards are handled appropriately
66. Test that unmatched employees are handled appropriately
67. Test that multiple paystubs are generated correctly
68. Test that employee file is updated with new YTD values
69. Test that paystub file is written correctly
70. Test default values when no arguments provided
71. Test `-e` flag sets employee file correctly
72. Test `-t` flag sets time card file correctly
73. Test `-o` flag sets output file correctly
74. Test `-h` flag prints help and exits
75. Test invalid flag shows error and help
76. Test missing argument value shows error
77. Test multiple flags in combination


## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. We want both the diagram for your initial and final design, so you may include another image or include the finalized mermaid markup below. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect. 

> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.

(Give Access Through Google Drive)
Check UML Folder



## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two. 

First, when designing this code base, I did not fully read through the assignment before programming, leading me do things in the wrong order.
Before reading over everything, I tried to make the hourly and salary employee classes. 
I did this without having a prior design to reference, so I was using prior knowledge of a similar assignment to try and guide my design.
If I were to do this assignment again, I would make sure that I read through the details so that I do not have to back track. 
Through this process, I learned the importance of understanding the codebase before diving into programming/extending files. 

Throughout the design process, I found that the relationship between the different classes is what changed the most.
For instance, before diving into the code, I was using prior knowledge of payrolls from my working experience to guide my design.
This led me to think that a PayStub object could be used to create a time card.
Through once, I had a better understanding of the codebase, I learned to not make assumptions about the nature of codebases I am working on based on prior knowledge. 
Next time, just like for the paragraph above, I would make sure that I read through all the instructions again so that I do not have to back track and I can make the most of my time. 