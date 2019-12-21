package com.dimensions.mw.utils;

public class OFMException
extends Exception {
    private String techMessage;
    private String techDetails;

    public OFMException(String techMessage, Exception ex) {
        if (ex != null) {
            this.techDetails = "[" + ex.getClass() + " | " + ex.getCause() + " - " + ex.getLocalizedMessage() + " | " + ex.getMessage();
            if (ex.getCause() != null) {
                this.techDetails = this.techDetails + " - " + ex.getCause().toString();
            }
            int count = 0;
            for (StackTraceElement trace : ex.getStackTrace()) {
                if (count > 8) break;
                this.techDetails = this.techDetails + " - " + trace.toString();
                ++count;
            }
            this.techDetails = this.techDetails + "]";
        } else {
            this.techDetails = "[ NULL EX ]";
        }
        this.techMessage = techMessage + " | " + this.techDetails;
    }

    public void setTechMessage(String techMessage) {
        this.techMessage = techMessage;
    }

    public String getTechMessage() {
        return this.techMessage;
    }

    public void setTechDetails(String techDetails) {
        this.techDetails = techDetails;
    }

    public String getTechDetails() {
        return this.techDetails;
    }
}

