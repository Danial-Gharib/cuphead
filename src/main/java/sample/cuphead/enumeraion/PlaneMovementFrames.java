package sample.cuphead.enumeraion;

import sample.cuphead.App;

public enum PlaneMovementFrames {

    MOVE("/sample/cuphead/assets/img/Plane/Idle/");

    private final String address;
    PlaneMovementFrames( String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
