/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

/**
 *
 * @author arsalan
 */
public class Validations {

    /**
     * check for empty string
     *
     * @param str
     * @return
     */
    public boolean isEmpty(String str) {
        return (str.replaceAll(" ", "").length() == 0);
    }

    /**
     * check for equal strings
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isEquals(String str1, String str2) {
        return str1.equals(str2);
    }

    /**
     * checks correctness of phone number
     *
     * @param str
     * @return
     */
    public boolean isValidPhoneNo(String str) {
        boolean valid = false;
        if (str.length() == 11) {
            if (str.substring(0, 2).equals("03")) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                        valid = false;
                    }
                }
                valid = true;
            } else {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * check correctness of CNIC number
     *
     * @param str
     * @return
     */
    public boolean isValidCnic(String str) {
        if (str.length() != 15) {
            return false;
        }
        if (str.charAt(5) != '-' || str.charAt(13) != '-') {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) > '9' || str.charAt(i) < 0) && (i != 5 || i != 13)) {
                return false;
            }
        }
        return true;
    }
}
