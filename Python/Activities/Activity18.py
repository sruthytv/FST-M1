"""
Reading CSV Files
Using Pandas:

Read the CSV made in the previous program:

Print the values only in the Usernames column
Print the username and password of the second row
Sort the Usernames column data in ascending order and print data
Sort the Passwords column in descending order and print data
Hint: You can use DataFrame.sort_values("column") to sort your data

Hint: You can use DataFrame.sort_values("column", ascending=false) to sort your data in descending order."""
# Import pandas
import pandas

# Read the CSV file and store it into a DataFrame
dataframe = pandas.read_csv("sample.csv")

# Print the full data
print("Full Data: ")
print(dataframe)

# Print the values in the Usernames column only
print("===============")
print("Usernames:")
print(dataframe["Usernames"])

# Print the username and password of the second row
print("===============")
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))

#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))