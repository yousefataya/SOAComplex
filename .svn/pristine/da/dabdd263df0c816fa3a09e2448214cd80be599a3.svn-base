package com.dimensions.mw.utils.errorManagement.Helper;

public class ErrorLogic {
    public static boolean doesItContain(String inputValue, String DBValue) {
        boolean returnedFlage = false;
        if (inputValue != null && DBValue != null) {
            if (inputValue.contains(DBValue)) {
                returnedFlage = true;
            }
        } else if (DBValue == null) {
            returnedFlage = true;
        }
        return returnedFlage;
    }

    public static void main(String[] args) {
    }
}

