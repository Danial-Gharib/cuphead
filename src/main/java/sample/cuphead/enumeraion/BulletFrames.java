package sample.cuphead.enumeraion;

public enum BulletFrames {
    FIRE("/sample/cuphead/assets/img/Plane/EX/Bullet/");

    private String address;

    public String getAddress() {
        return address;
    }

    BulletFrames(String address) {
        this.address = address;
    }
}
