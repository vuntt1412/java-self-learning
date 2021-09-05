package com.vuntt1412.equalsandhashcode;

public class TennisPlayer extends Player {
    private boolean isRightHanded;

    public TennisPlayer(String name, boolean isRightHanded) {
        super(name);
        this.isRightHanded = isRightHanded;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) return false;

        // if o is a normal Player, do a non-isRightHanded comparison
        if (!(o instanceof TennisPlayer)) return super.equals(o);

        // else do a full comparison
        return super.equals(o) && isRightHanded == ((TennisPlayer) o).isRightHanded;
    }

}
