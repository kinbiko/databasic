package databasic;

class Formatter {


    String formatQuery(Object object) {
        if (object == null) {
            return NO_RESULTS;
        }
        if (object == "") {
            return STRING_IS_EMPTY;
        }

        if (object instanceof Object[]) {
            return makeArrayString((Object[]) object);
        }

        if (object instanceof char[]) {
            return makeArrayStringFromChar((char[]) object);
        }

        return String.valueOf(object);
    }

    private String makeArrayString(Object[] object) {
        String str = "[";
        for (Object i : object) {
            if (i instanceof String) {
                str += "\"";
                str += i + "\", ";
            } else {
                str += i + ", ";
            }
        }
        str = str.substring(0, str.length() - 2);
        return str + "]";
    }

    private String makeArrayStringFromChar(char[] character) {
        String str = "[";
        for (char i : character) {
            str += "\"";
            str += i + "\", ";
        }
        str = str.substring(0, str.length() - 2);
        return str + "]";
    }
}
