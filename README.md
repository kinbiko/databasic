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

