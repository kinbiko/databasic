package databasic;


class Cli {

    Cli() {
    }

    void stats() {
        System.out.println("The statistics on the database are: ");
    }

    void query(DatabasicId id, JsonPath jsonpath) {
        System.out.println("Cli.query");
    }

    void insert(String string) {
        System.out.println("Cli.insert");
    }

}

