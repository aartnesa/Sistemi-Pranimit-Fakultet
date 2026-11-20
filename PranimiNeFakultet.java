public class Nxenesi {
    private double nota10;
    private double nota11;
    private double nota12;
    private double mesatarja;

    public Nxenesi(double nota10, double nota11, double nota12) {
        this.nota10 = nota10;
        this.nota11 = nota11;
        this.nota12 = nota12;
        this.mesatarja = (nota10 + nota11 + nota12) / 3.0;
    }

    public double getNota10() {
        return nota10;
    }

    public double getNota11() {
        return nota11;
    }

    public double getNota12() {
        return nota12;
    }

    public double getMesatarja() {
        return mesatarja;
    }
}
