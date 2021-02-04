=============== HOW TO BUILD AND RUN THE CODE: ===============

- You need to have Java installed. 
- It can be run via an IDE or through CLI using javac.
	- If IDE just opened the project folder/java file in your preferred IDE. You'll need to edit the run configuration to include CLI arguments.
	- for CLI, open your command prompt and navigate to the project folder directory, then type:
		
		javac ComputeStats.java
		
	Then allow it to compile, follow up with:
	
		java ComputeStats textfile.txt
		
	replace textfile.txt to the filepath of your txt file.
	
=============== HOW TO BUILD AND RUN THE CODE: ===============





=============== DESIGN AND FURTHER EXPLANATION: ===============

You have to choose the txt file via command line arguments rather edit the code directly to hard-code the path. 
This is because users shouldn't have access the raw code, and should be more inuitive. 
This could be expanded to include a file browser in more complex systems.

Using try and catch incase the user enters the wrong filepath.

Line count increments each time the loop runs, as it will run "while txt file has another line".

It calculates the word count by splitting the data using the regex (delimiter) "\\s+" which is a white space. 
After splitting all the words, it keeps a count of each word till the end.

Originally, I removed the whitespace and then counted the characters to get the total letter count, 
to work out the average letter count per word. However this became redundant when I created the frequency anaylsis, 
as it had to count all the letters anyway to work out the most common letter. Therefore I just counted all characters 
while working out the Mode character, and divided by the word count.

For the frequency analysis to work, I converted the .txt file to uppercase, as it make's it easier to count letters. 
ASCII alphabet in capital letters are indexed at 65 to 90, so turning a char into an int will return a number in that range. 
A for example will give 65, if we -65 to this int, you'll get its actual position in the alphabet, and it's index in an alphabet array. 
At the end, you would check which index has incremented the most, for example the letter E which is at index 4. 4 + 65 = 69, 
ASCII index 69 is E, and that is the most common letter.

In the very unlikely case there are two letters that both used the most often, I included an array to store them all to display at the end.

=============== DESIGN AND FURTHER EXPLANATION: ===============