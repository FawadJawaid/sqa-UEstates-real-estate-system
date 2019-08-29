/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import java.math.BigInteger;

/**
 *
 * @author arsalan
 */
public class SecurityAlgorithm {

    /**
     * Function to encode provides String
     *
     * @param text
     * @return
     */
    public String encode(String text) {
        if (text.length() > 0) {
            byte[] textBytes = text.getBytes();
            int j = 0;
            int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            for (int i = 0; i < textBytes.length; i++) {
                textBytes[i] = (byte) (textBytes[i] - elements[j]);
                j++;

                if (j >= elements.length) {
                    j = 0;
                }
            }
            String str = new String(textBytes);
            BigInteger bigInt = new BigInteger(str.getBytes());
            text = bigInt.toString();
        }
        return text;
    }

    /**
     * Function to decode provides String
     *
     * @param bigIntStr
     * @return
     */
    public String decode(String bigIntStr) {
        if (bigIntStr.length() > 0) {
            BigInteger bigInt = new BigInteger(bigIntStr);
            byte[] text = bigInt.toByteArray();
            String textBack = new String(text);

            byte[] textBytes = textBack.getBytes();
            int j = 0;
            int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            for (int i = 0; i < textBytes.length; i++) {
                textBytes[i] = (byte) (textBytes[i] + elements[j]);
                j++;

                if (j >= elements.length) {
                    j = 0;
                }
            }
            bigIntStr = new String(textBytes);
        }
        return bigIntStr;
    }
}
