package ru.ncedu.java.tasks;

public enum Type {
    IT("IT"),
    MUSIC("MUSIC"),
    ART("ART"),
    POLICY("POLICY"),
    NEWS("NEWS"),
    SCIENTIFIC("SCIENTIFIC"),
    COMICS("COMICS");

    private String typeValue;

    private Type(String type) {
        typeValue = type;
    }

    static public Type getType(String pType) {
        for (Type type: Type.values()) {
            if (type.getTypeValue().equalsIgnoreCase(pType)) {
                return type;
            }
        }
        throw new RuntimeException( pType );
    }

    public String getTypeValue() {
        return typeValue;
    }
}