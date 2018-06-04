# DataBasic

## REQUIREMENTS

- The database will be run in *nix. 
- The system will run in CLI
- Read the data that will be inside of the database
- The software will be able to insert data into the database that will be persisted
- Should be able to query the database in the following structure:
	`databasic <id> <json-path>` where <id> is a number and <json-path> is of the form “a.b”
- The ID field of the database will be an odd integer number >= 1
- The input file inserted into the database system should be a JSON file in the following way:
	`databasic insert <path-to-file>` 
- The datatype supported in the database are:
	- Integer
	- Float
	- String
	- Null
	- Boolean
	- datetime 
	- {Binary}
- The datetime datatype inside the JSON input/output file will be under the RFC-3999
- When inserting a document the stdout will print the registered ID for that document
- When doing a query the stdout will print the JSON/value for that document and JSON path

## DESIGN 
In desing we just put the strategy to follow not implentation details

We have to consider in our main Java method what kind of operation we are going to be using: Insert ot Query

### Insert
{
 "Integer": 12,
 "String": "hello world",
 "Null": null,
 "Boolean": true,
 "Datetime": "2002-10-02T15:00:00Z"
}

Validate the path be string value and validate the number of parameters be 1 (or ignore the others)
We have to open the JSON file provided in the path field or the main method. 
So we have to test the type of file corresponds to the JSON format (some Jave method)
And we have to see the file exists (some file opening method in Java if throws error so catch it and print a error message to 
user)

We have to generate an ID and print to the user once we have saved the data to the database.
We write/update a the saved file to a storing location. For example:
	~/.databasic/

### Query  
To design ...
