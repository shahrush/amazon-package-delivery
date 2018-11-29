You’re an engineer working for the Amazon package sorting department. You need to make a package sorting algorithm so that they can remove an entire step in their sorting line. 

The packages you receive have the following traits:
Size: XL, Large, Medium, or Small
Fragile: True or False
SendDate: a date that the package is to be delivered
Prime: True or False
NextCity: a string value of the next city
Origin: string of the city where it arrived
Weight: weight of package in pounds

To correctly send the packages to the next level of sorting, the following needs to be done by your sorter:
1.	All packages must be sent in order of SendDate
2.	Small, then medium, then large packages
3.	If everything is the same between two packages, the Prime package gets priority.
4.	Fragile boxes need to be put into different queue.
5.	The origin city needs to be kept
6.	If a package is less than 2 days away from the send date it needs to get put in a special expedited queue so it meets the expected delivery.
The reason they had used humans before is because the data loading interface was not great. There are a lot of data integrity issues, and you should be able to skip packages if there isn’t enough data to put it in the right queue. Create a system to disposition the provided packages and test it to make sure it follows the rules above.

