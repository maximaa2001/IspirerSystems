package org.ispirer.systems.desktop.constant;

public class LocaleManager {
    private static String CURRENT_LANG = LocaleConst.INITIAL_LANG;

    public static void setCurrentLang(String currentLang) {
        CURRENT_LANG = currentLang;
    }

    public static String getCurrentLang() {
        return CURRENT_LANG;
    }
}
