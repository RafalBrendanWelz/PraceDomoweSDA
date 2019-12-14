package Grudzien.Slack2Gru.zadanie6;

import java.util.Arrays;
import java.util.List;

public class Deweloper {
    // budowlany (nie chodzi o branżę it)
    String nazwa;
    private List<Budynek> oferty;
    private double kapitalZaklad;
    private double ocenaDevelop;

    public Deweloper(String nazwa, List<Budynek> oferty, double kapitalZaklad, double ocenaDevelop) {
        this.nazwa = nazwa;
        this.oferty = oferty;
        this.kapitalZaklad = kapitalZaklad;
        this.ocenaDevelop = ocenaDevelop;
    }

    public String getNazwa() {
        return nazwa;
    }
    public List<Budynek> getOferty() {
        return oferty;
    }
    public double getKapitalZaklad() {
        return kapitalZaklad;
    }
    public double getOcenaDevelop() {
        return ocenaDevelop;
    }

    public void wypiszOfertyBudynk(){
        System.out.println("Oferta z budynków Dewelopera:");
        this.oferty.forEach(Budynek::wypiszOpisBudynek);
    }

    public void wypiszOfertyMieszkan(){
        System.out.println("Pełna oferta budynków i mieszkań Dewelopera:");
        this.oferty.forEach(Budynek::wypiszOpisBudPlusMieszkania);
    }

    public double lacznaInwestBrutto(){
        return this.oferty.stream().mapToDouble(Budynek::lacznaCenaBrutto).sum() ;
    }

    public double lacznaInwestNetto(){
        return this.oferty.stream().mapToDouble(Budynek::lacznaCenaNetto).sum() ;
    }











}
