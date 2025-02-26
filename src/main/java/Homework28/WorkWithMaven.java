package Homework28;

import bil.vania.ArrayGenerated.PasswordGenerator;
public class WorkWithMaven {
    public static void main(String[] args) {
        String password = PasswordGenerator.generatePassword(12);
        System.out.println("Generated password: " + password);

    }
}
