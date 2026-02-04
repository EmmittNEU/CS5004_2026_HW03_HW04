# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?

   Comma Separated File. 

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

   You would use `List<IEmployee>` if you wanted a list of interfaces rather than a list of particular objects. This would allow for a list of more abstract objects that fulfill the contract.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

   The relationship is called composition. An is-a relationship is called inheritance.

4. Can you provide an example of a has-a relationship in your code (if one exists)?

   A has-a relationship in the codebase is the arguments that are possessed by the PayrollGenerator class.  

5. Can you provide an example of an is-a relationship in your code (if one exists)?

   An example of an is-a relationship in my codebase is the IEmployee and Hourly or Salary employee classes. 

6. What is the difference between an interface and an abstract class?

   An interface allows for abstract methods to be defined and shared, while an abstract class allows for instances and constructors to be defined. 

7. What is the advantage of using an interface over an abstract class?

   When you need to define a strict contract for behavior across unrelated classes, require multiple inheritance of type, or want to maximize flexibility and reduce coupling.

   [Source 1](https://stackoverflow.com/questions/479142/when-to-use-an-interface-instead-of-an-abstract-class-and-vice-versa#:~:text=Usage%20Context:%20Abstract%20classes%20are%20generally%20preferred,that%20can%20be%20implemented%20by%20unrelated%20classes.)
8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 

   No it is not a valid line of code because it tries to use a generic to support a primitive type.
   The correct way to use this would to use the wrapper class for an int which is `Integer`.

9. Which class/method is described as the "driver" for your application? 
   PayrollGenerator.java. 


10. How do you create a temporary folder for JUnit Testing?
    Use the built-in Java NIO capabilities, specifically the `Files.createTempDirectory()`.
    [Source 2](https://docs.junit.org/6.0.1/writing-tests/built-in-extensions.html)
## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

To address salary inequality proactively, I would attempt to transition the payroll system from a disbursement tool to an auditing engine with real time monitoring. To achieve this, we would need more data points from employees like standardized job levels and years of relevant industry experience. According to “Payscale’s 2024 State of Gender Pay Gap Report”, even when controlled for qualifications, women in STEM face a “controlled gap” that begins at the entry level. By storing these specific metadata points, the system could perform some sort of regression analysis to ensure that two employees with identical grades and experience levels are within a similar payband. This could potentially allow for HR departments to focus on why they are paying employees certain rates. This could also allow for the departments to flag outliers before they start paying employees. The point of analysis within the payroll process must be at the Gross Base Salary level, rather than the net take-home pay. Analyzing data at this stage is essential because, as noted in research from the Harvard Business Review, employee-led choices regarding pre-tax benefits such as 401(k) contributions, healthcare tiers, or childcare flexible spending accounts can create significant variances in final checks that have nothing to do with employer fairness.

[Source 3](https://www.payscale.com/press-releases/parenthood-and-job-loyalty-are-hindering-pay-gap-progress-payscales-2024-gender-pay-gap-report-shows)
<br>
[Source 4](https://hbr.org/2023/02/research-the-complicated-effects-of-pay-transparency)