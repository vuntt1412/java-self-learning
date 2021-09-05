package com.vuntt1412.equalsandhashcode;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) return false;
        // this comparison ignore all the fields in subclass
        Player p = (Player) o;
        return name == p.name;
    }

}
