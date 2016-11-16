# Similar Doctors
Each doctor have attributes: ID, first name, last name, gender, age, specialty, review score and number of patient per month.
Given a doctor, provides a list of similar doctors, in a prioritized order.
Only Number of patients per month, Age and Review score can be sorted, assume the priority is reviewScore > age > numOfPatients.
Similar in reviewScore, age, numOfPatients means smaller absolute value of the reviewScore difference, age difference and numOfPatients difference.
Gender and Specialty are not sortable, so if either of those two fields are not equal to the given doctor's field value, 
we just remove current doctor from doctor list. Also, the similar doctors recommended DO NOT include the given doctor him/herself.
