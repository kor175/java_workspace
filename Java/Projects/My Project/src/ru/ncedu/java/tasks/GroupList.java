package ru.ncedu.java.tasks;

import java.util.ArrayList;
import java.util.List;

public class GroupList {
    private List<Group> groups;

    public GroupList(){
        groups = new ArrayList<Group> ();
    }

    public void setGroups ( List<Group> groups ){
        this.groups = groups;
    }

    public List<Group> getGroups (){
        List<Group> returnGroup = new ArrayList<Group> ();
        for (int i = 0; i < this.groups.size(); i++){
            returnGroup.add(groups.get(i));
        }
        return returnGroup;
    }

    public List<Group> getGroups ( Type type ){
        List<Group> returnGroup = new ArrayList<Group>();

        for ( int i = 0; i < groups.size(); i++ ){
            if ( groups.get(i).getGroupType().equals( type ))
                returnGroup.add(groups.get(i));
        }
        return returnGroup;
    }

    public void addGroup ( Group group ){
        this.groups.add( group );
    }

    public void addGroup ( List<Group> groups ){
        for ( int i = 0; i < groups.size(); i++ ) {
            this.groups.add( groups.get( i ) );
        }
    }

    public void deleteGroup( String name ){
        for ( int i = 0; i < this.groups.size(); i++ ) {
            if ( this.groups.get( i ).getGroupName().equals( name ) ){
                this.groups.remove( i );
                break;
            }
        }
    }

    public Group get(int index){
        Group g = new Group(this.groups.get(index));
        return g;
    }

    public String toString(){
        String out = "";
        if (this.groups.size() > 0) {
            for (int i = 0; i < this.groups.size() - 1; i++) {
                out += this.groups.get(i).toString() + "\n";
            }
            out += this.groups.get(this.groups.size() - 1);
        }
        return out;
    }

    public int size(){
        return this.groups.size();
    }
}