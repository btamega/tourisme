/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tamega.attractions;

/**
 *
 * @author BOUGARYTAMEGA
 */
public class NombreVisiteur {
    private Double nombreHomme;
    private Double nombreFemme;

    public Double getNombreHomme() {
        return nombreHomme;
    }

    public NombreVisiteur(Double nombreHomme, Double nombreFemme) {
        this.nombreHomme = nombreHomme;
        this.nombreFemme = nombreFemme;
    }

    public void setNombreHomme(Double nombreHomme) {
        this.nombreHomme = nombreHomme;
    }

    public Double getNombreFemme() {
        return nombreFemme;
    }

    public void setNombreFemme(Double nombreFemme) {
        this.nombreFemme = nombreFemme;
    }
}
