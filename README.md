# DataBasic
Requirements for database project

1. JSON structure
1. Document oriented database (flat-file hierarchy)
1. inserting
1. auto-ID, returns value when created
1. queries
1. stats on the database
1. datatypes to include in database: strings, character, integers, float, complex, arrays, hashes, null, booleans.
1. how would they call it? CLI.
1. syntax of instruction: databasic insert <filepath (JSON file)>
1. databasic stat
1. databasic queries -> based on (ID | JSONpath) find value
1. return children of parent, or if value then value from a key  #clean order up
1. no need for sorted returns
1. preserve datatype on return


# Objects in application:
1. Main
1. Inserter
1. AutoIdGenerator
1. Querier
1. Stats
1. CLI
1. Printer

