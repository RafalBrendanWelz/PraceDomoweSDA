package Grudzien.SeriaLambd;

import java.util.List;


public class Company implements Comparable{
    private String name; // nazwa firmy
    private String cityHeadquarters; // siedziba firmy
    private int employees; // ilość pracowników
    private List<Purchase> purchaseList; // lista zakupów wykonanych przez firmę (co firma kupiła)

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCityHeadquarters() {
        return cityHeadquarters;
    }
    public void setCityHeadquarters(String cityHeadquarters) {
        this.cityHeadquarters = cityHeadquarters;
    }
    public int getEmployees() {
        return employees;
    }
    public void setEmployees(int employees) {
        this.employees = employees;
    }
    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }
    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public Company(String name, String cityHeadquarters, int employees, List<Purchase> purchaseList) {
        this.name = name;
        this.cityHeadquarters = cityHeadquarters;
        this.employees = employees;
        this.purchaseList = purchaseList;
    }

    @Override
    public String toString(){
        return "Firma:  \"" + this.getName() + "\" z siedzibą w:  " + this.getCityHeadquarters();
    }

    int porownDlNazwy( Object o){
        if (o instanceof Company){
            Company druga = (Company) o;
            if ( this.getName().length() > druga.getName().length() ){
                return 1;
            }else {
                return -1;
            }
        }
        return 0;
    }

    int compareIlZakup(Object o ){
        if (o instanceof Company){
            Company drug = (Company) o;
            if (this.getPurchaseList().size() > drug.getPurchaseList().size() ){
                return 1;
            }else if ( this.getPurchaseList().size() < drug.getPurchaseList().size() ){
                return -1;
            }else {
                return 0;
            }

        }
        return 0;
    }

    int compareILZakupiPraco(Object o ){
        if (o instanceof Company){
            Company druga = (Company) o;
            if ( this.getPurchaseList().size() > druga.getPurchaseList().size() ){
                return 1;
            }else if ( this.getPurchaseList().size() < druga.getPurchaseList().size() ){
                return -1;
            }else if ( this.getEmployees() < druga.getEmployees() ){
                return 1;
            }else {
                return -1;
            }

        }

        return 0;
    }

    int compareIloscZakKawyPrzezDwieFirmy(Company firma2){

        Double iloscZakPierwszej = this.getPurchaseList().stream()
                .filter( zak -> zak.getProduct().getName().contains("Coffee") )
                .mapToDouble( zak -> zak.getQuantity() * zak.getProduct().getPrice() ).sum();

        Double iloscZakDrugiej = firma2.getPurchaseList().stream()
                .filter( zak -> zak.getProduct().getName().contains("Coffee") )
                .mapToDouble( zak -> zak.getQuantity() * zak.getProduct().getPrice() ).sum();

        if (iloscZakPierwszej > iloscZakDrugiej){
            return -1;
        }else if ( iloscZakPierwszej < iloscZakDrugiej){
            return 1;
        }else {
            return 0;
        }
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Company){
            Company druga = (Company) o;
            if ( this.getEmployees() > druga.getEmployees() ){
                return 1;
            }else if ( this.getEmployees() < druga.getEmployees() ){
                return -1;
            }
        }

        return 0;
    }



}


