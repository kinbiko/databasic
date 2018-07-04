# DataBasic
Requirements for database project

1. Data is stored using JSON objects.
1. The database schema is of type: Document oriented database (flat-file hierarchy).
1. The user should be able to insert a JSON object.
1. When a JSON object is inserted, it should generate an auto-ID value.
1. The datatypes to include in the database: strings, character, integers, float, complex, arrays, hashes, null, booleans.
1. A CLI will be used as UI.
1. The general syntax of instruction at the CLI will be: databasic insert <filepath (JSON file)>
1. The command <<databasic stat>> should return statistics on the whole database.
1. A databasic query can be made using the auto-Id or a JsonPath.
1. Return children of parent, or if value then value from a key.
1. There is no need for returns to be sorted.
1. Databasic should preserve datatype on return.


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