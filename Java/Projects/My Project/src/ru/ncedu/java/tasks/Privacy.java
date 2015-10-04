package ru.ncedu.java.tasks;

public enum Privacy {
    CLOSED("CLOSED"),
    PAGE("PAGE"),
    GROUP("GROUP");

    private String privacyValue;

    private Privacy(String type) {
        privacyValue = type;
    }

    static public Privacy getPrivacy(String pType) {
        for (Privacy privacy: Privacy.values()) {
            if (privacy.getPrivacyValue().equalsIgnoreCase(pType)) {
                return privacy;
            }
        }
        throw new RuntimeException("unknown type");
    }

    public String getPrivacyValue() {
        return privacyValue;
    }

    public String toString(){
        return privacyValue;
    }
}