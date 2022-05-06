"""Activity 20

Using Pandas:

Use pandas to read data the Excel file

Print the number of rows and columns
Print the data in the emails column only
Sort the data based on FirstName in ascending order and print the data
 

Hint: You can use DataFrame.shape to get the number of rows and columns"""

# Import pandas
import pandas

# Read data from Excel sheet
dataframe = pandas.read_excel('sample.xlsx')

# Print the dataframe
print(dataframe)

# Print the number of rows and columns
print("====================================")
print("Number of rows and columns:", dataframe.shape)

# Print the data in the emails column only
print("====================================")
print("Emails:")
print(dataframe['Email'])

# Sort the data based on FirstName in ascending order and print the data
print("====================================")
print("Sorted data:")
print(dataframe.sort_values('FirstName'))