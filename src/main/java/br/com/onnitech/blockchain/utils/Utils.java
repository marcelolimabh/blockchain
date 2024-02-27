package br.com.onnitech.blockchain.utils;

public class Utils {

    public static String zeros(int length) {
        StringBuilder builder = new StringBuilder();

        builder.append("0".repeat(Math.max(0, length)));
        return builder.toString();
    }
}


