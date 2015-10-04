package ru.ncedu.java.tasks;

public class Group {
    private String groupName;
    private Type groupType;
    private Privacy groupPrivacy;

    public Group (){
        groupName = "";
        groupType = Type.NEWS;
        groupPrivacy = Privacy.CLOSED;
    }

    public Group ( String name, Type type, Privacy privacy ){
        this.groupName = name;
        this.groupType = type;
        this.groupPrivacy = privacy;
    }

    public Group ( Group group ){
        this.groupName = group.groupName;
        this.groupType = group.groupType;
        this.groupPrivacy = group.groupPrivacy;
    }

    public void setGroupName ( String groupName ){
        this.groupName = groupName;
    }

    public String getGroupName (){
        return this.groupName;
    }

    public void setGroupType ( Type groupType ){
        this.groupType = groupType;
    }

    public Type getGroupType (){
        return  this.groupType;
    }

    public void setGroupPrivacy ( Privacy groupPrivacy ){
        this.groupPrivacy = groupPrivacy;
    }

    public Privacy getGroupPrivacy (){
        return this.groupPrivacy;
    }

    public String toString(){
        String out = "name:    " + this.groupName +
                     "\ntype:    " + this.groupType +
                     "\nprivacy: " + this.groupPrivacy + "\n";
        return out;
    }
}