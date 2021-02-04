=============== HOW TO BUILD AND RUN THE CODE: ===============

- You need to have Java 8+ installed. 
- It can be run through an IDE or CLI.
	- For IDE, open the project folder/java file in your preferred IDE. You'll need to edit the run configuration to include CLI arguments.
	- for CLI, open your command prompt and navigate to the project folder directory, then type:
		
		javac ComputeStats.java
		
	This will compile ComputeStats, follow up with:
	
		java ComputeStats textfile.txt
		
	replace textfile.txt to the filepath of your txt file.
	
================================================================





=============== DESIGN AND FURTHER EXPLANATION: ===============

You have to choose the .txt file via command line arguments rather edit the code directly to hard code the path. 
This is because users shouldn't have access the raw code, and should be more intuitive. 
This could be expanded to include a file browser in more advanced systems.

I used 'try' and 'catch' in case the user enters the wrong filepath.

I added a line count that increments each time the loop runs, as it will run "while .txt file has another line".

It calculates the word count by splitting the data using a delimiter identified by regex. "\\s+" matches any whitespace character 1 or more times.
After splitting all the words, it keeps a count of each word till the end.

Originally, I removed the whitespace and then counted the characters to get the total letter count, 
to work out the average letter count per word. However, this became redundant when I created the frequency anaylsis, 
as it had to count all the letters anyway to work out the most common letter. Therefore, I just counted all characters 
while working out the modal character and divided by the word count.

For the frequency analysis to work, I converted the .txt file to uppercase, as it makes it easier to count letters. 
ASCII alphabet in capital letters have decimal values from 65 to 90, so casting a char into an int will return a number in that range. 
'A' for example will have a decimal value of 65, if we subtract 65 to this int, you'll get its actual position in the alphabet and its index in an alphabet array. 
At the end, the program would check which index has incremented the most. For example, the letter at index 4 in the array has incremented the most, 4 + 65 = 69, 
in ASCII 69 is 'E', and that is the most common letter.

In the unlikely case there are more than one letters that are both used the most often, I included an array to store them all to display at the end.

================================================================
