package com.vuntt1412.equalsandhashcode;

public class FootballPlayer extends Player {
    private String club;

    public FootballPlayer(String name, String club) {
        super(name);
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        // every instance of Player always returns false
        if (!(o instanceof FootballPlayer)) return false;
        return super.equals(o) && club == ((FootballPlayer) o).club;
    }

}
