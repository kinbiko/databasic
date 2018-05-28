package databasic;

class JsonPath {
    private String jsonPath;

    void setJsonPath(String jsonPath) {
        checkNull(jsonPath);
        checkEmpty(jsonPath);
        checkSpaces(jsonPath);
        this.jsonPath = jsonPath;
    }

    private void checkSpaces(String jsonPath) {
        if (jsonPath.contains(" ")){
            throw new RuntimeException("Please enter a JsonPath, spaces in the string is invalid!");
        }
    }

    private void checkEmpty(String jsonPath) {
        if (jsonPath.isEmpty()){
            throw new RuntimeException("Please enter a JsonPath, empty string is invalid!");
        }
    }

    private void checkNull(String jsonPath) {
        if (jsonPath == null) {
            throw new RuntimeException("Please enter a JsonPath, null is invalid!");
        }
    }

    public String getJsonPath() {
        return this.jsonPath;
    }
}
