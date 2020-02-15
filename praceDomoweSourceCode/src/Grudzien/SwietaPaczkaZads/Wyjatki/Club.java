package Grudzien.SwietaPaczkaZads.Wyjatki;

class Club {
    private String nazwa;

    public Club(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void wejdz( Person taOsoba) throws NoAdultException {
        if (taOsoba.getWiek() < 18){
            throw new NoAdultException("Niepełnoletnim wstęp wzbroniony");
        }else {
            System.out.println("Dostałeś/aś się do klubu " + taOsoba.getImie() + " " + taOsoba.getNazwisko());
        }
    }


}
