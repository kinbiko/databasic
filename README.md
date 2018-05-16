# DataBasic
Requirements for database project

1. JSON structure
1. Document oriented database (flat-file hierarchy)
1. inserting
1. auto-ID, returns value when created
1. datatypes to include in database: strings, character, integers, float, complex, arrays, hashes, null, booleans.
1. how would they call it? CLI.
1. syntax of instruction: databasic insert <filepath (JSON file)>
1. databasic stat
1. databasic queries -> based on (Id && JsonPath) find value
1. return children of parent, or if value then value from a key  #clean order up
1. no need for sorted returns
1. preserve datatype on return


# Objects in application:
1. Main
    1. main(String[])
1. Inserter
    1. Id insert(File)
1. AutoIdGenerator
    1. Id generate()
1. Querier
    1. String findString(Id, JsonPath)
    1. Character findCharacter(Id, JsonPath)
    1. Integer findInteger(Id, JsonPath)
    1. Float findFloat(Id, JsonPath)
    1. ComplexNumber findComplexNumber(Id, JsonPath)
    1. List<?> findList(Id, JsonPath)
    1. Map<String, ?> findMap(Id, JsonPath)
    1. Boolean findBoolean(Id, JsonPath)
1. Stats
    1. void generateStats()
1. CLI
    1. void stats()
    1. void query(Id, JsonPath)
    1. void insert(String)
1. Formatter
    1. string formatQuery(Object)
    1. string formatInsert(Id)
1. Id
1. JsonPath




