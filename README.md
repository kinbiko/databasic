# DataBasic

## REQUIREMENTS

1. Compatible only with *nix operating systems. 
2. The software will run in CLI mode.
3. The software must read the data that will be inside of the database.
4. Data should be inserted into a database that will be persisted.
5. The software should allow to query the database according to the following structure:
	```shell
	databasic <id> <json-path>
	``` 
	Where `<id>` is a number and `<json-path>` is of the form `“a.b”`
6. The ID field of the database will be an odd integer number greater than or equal to 1.
7. The input file inserted into the database system should be a JSON file provided in the following way:
	```shell
	databasic insert <path-to-file>
	``` 
8. The datatypes supported in the database will be:
	- Integer
	- Float
	- String
	- Null
	- Boolean
	- datetime 
	- {Binary} (Under consideration) 
9. The datetime datatype inside the JSON input/output file will in in UTC and under the RFC-3999 standard.
10. When inserting a document, the registered ID for that document will printed to the stdout.
11. When doing a query, the JSON/value for that document and the JSON path will be printed to the stdout.

## DESIGN 

### Insert
About the input the software must:

- In the main method, open the JSON file provided in the path considering the following:
	- Validate the number of parameters received be 1, ignoring others and/or returning an error message to the user.
	- Validate the path is valid.
	- Test the format of the file given in the path corresponds to JSON, else print an error message to the user.
	- Check if file given in the path exists and open it, if there is some error print an error message to the user
- Generate an ID field for the inserted document/object and once data has been saved to database, print the ID to the user.
- Write/Update the saved file in a storing location (static). For example: `~/.databasic/`

This is an JSON sample of the datatypes we are going to be using:
```json
{
 "Integer": 12,
 "String": "hello world",
 "Null": null,
 "Boolean": true,
 "Datetime": "2002-10-02T15:00:00Z"
}
```

### Query
When there is a query:

- In main method, read the given query provided in the CLI considering the following:
	- Validate the number of parameters received be 2, ignoring others and/or returning an error message to the user.
	- Validate the first given parameter "ID" corresponds to a number (odd positive integer).
	- Validate the second given parameter "JSON PATH" be in the form “a.b”, else print an error message to the user.	
- Open the databasic JSON file, if there is some error print an error message to the user.
- Make a search in the JSON document using the given ID (first parameter) and JSON PATH.
- Print the query result to the user.

Example:

Having the following JSON Document:
```json
{
	"ID": 001, 
	"person": {
		"name": "Javier",
		"age": 35,		
	},
	"datetime": "2002-10-02T15:00:00Z"

}
```

The query:
```shell
databasic 001 person.name
```

Returns:
`“Javier”`

