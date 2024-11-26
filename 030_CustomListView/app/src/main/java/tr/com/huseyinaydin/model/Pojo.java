package tr.com.huseyinaydin.model;

public class Pojo {
    private String yazi;
    private String aciklama;
    private int simge;

    public String getYazi() {
        return yazi;
    }

    public void setYazi(String yazi) {
        this.yazi = yazi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getSimge() {
        return simge;
    }

    public void setSimge(int simge) {
        this.simge = simge;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "yazi='" + yazi + '\'' +
                ", aciklama='" + aciklama + '\'' +
                ", simge=" + simge +
                '}';
    }
}