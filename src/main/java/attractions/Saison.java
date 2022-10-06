/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package attractions;

/**
 *
 * @author BOUGARYTAMEGA
 */
public class Saison {
    private String periode;
    private NombreVisiteur visiteurs;

    public Saison(String periode, NombreVisiteur visiteurs) {
        this.periode = periode;
        this.visiteurs = visiteurs;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public NombreVisiteur getVisiteurs() {
        return visiteurs;
    }

    public void setVisiteurs(NombreVisiteur visiteurs) {
        this.visiteurs = visiteurs;
    }
}
