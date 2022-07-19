package id.guusbajoos.main;

import id.guusbajoos.util.GeneralUtility;

public class MainApplication {
    public static GeneralUtility generalUtility = new GeneralUtility();

    public static void main(String[] args) {
        Integer deadVillagers = generalUtility.countDeadVillagers(5);
        System.out.println("deadVillagers = " + deadVillagers);
    }
}
