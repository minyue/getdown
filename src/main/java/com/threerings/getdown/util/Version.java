package com.threerings.getdown.util;

public class Version {
    private int[] codes;

    static public Version fromString(String version) throws NumberFormatException {
        String subStrings[] = version.split("\\.");
        int[] subNumbers = new int[subStrings.length];
        int i = 0;
        for (String s : subStrings) {
            subNumbers[i++] = Integer.parseInt(s.trim());
        }
        return new Version(subNumbers);
    }

    public Version(int[] codes) {
        this.codes = codes;
    }

    public boolean isNewerThan(Version comp) {
        int[] compCodes = comp.getCodes();
        int i = 0;
        for (int c : codes) {
            if (i >= compCodes.length || c > compCodes[i++])
                return true;
        }
        return false;
    }

    public int[] getCodes() {
        return codes;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int c : codes) {
            stringBuilder.append(c);
            stringBuilder.append('.');
        }
        if (stringBuilder.length() > 1) {
           return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return null;
    }
}
