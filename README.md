# DataBasic

## REQUIREMENTS

1. The database will be run in *nix. 
2. The system will run in CLI
3. Read the data that will be inside of the database
4. The software will be able to insert data into the database that will be persisted
5. Should be able to query the database in the following structure:
	`databasic <id> <json-path>` where <id> is a number and <json-path> is of the form “a.b”
6. The ID field of the database will be an odd integer number >= 1
7. The input file inserted into the database system should be a JSON file in the following way:
	`databasic insert <path-to-file>` 
8. The datatype supported in the database are:
	- Integer
	- Float
	- String
	- Null
	- Boolean
	- datetime 
	- {Binary}
9. The datetime datatype inside the JSON input/output file will be under the RFC-3999
10. When inserting a document the stdout will print the registered ID for that document
11. When doing a query the stdout will print the JSON/value for that document and JSON path

## DESIGN 

### Insert
About the input the software must:

- Validate the path be string value and validate the number of parameters be 1 (or ignore the others)
- To open the JSON file provided in the path field or the main method. 
- To test the type of file corresponds to the JSON format (some Jave method)
- To see the file exists (some file opening method in Java if throws error so catch it and print a error message to user)
- To generate an ID and print to the user once we have saved the data to the database.
- Write/Update a the saved file to a storing location. For example:
	~/.databasic/

This is an JSON sample of the datatypes we are going to be using:
{
 "Integer": 12,
 "String": "hello world",
 "Null": null,
 "Boolean": true,
 "Datetime": "2002-10-02T15:00:00Z"
}

### Query  
To design ...

JSON Document:
{a: {b: “hello”}, c: 23}

a.b Returns:
“hello”

Query:
`databasic <id> <json-path>` where <id> is a number and <json-path> is of the form “a.b”

