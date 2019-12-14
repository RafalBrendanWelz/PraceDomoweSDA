package Grudzien.Slack2Gru.zadanie7;

import java.time.LocalDateTime;
import java.util.Date;

public class PojazdInfo {
    private String numerRejestrac;
    private TypPojazdu jaki;
    private LocalDateTime godzWjazdu;

    public PojazdInfo(String numerRejestrac, TypPojazdu jaki) {
        this.numerRejestrac = numerRejestrac;
        this.jaki = jaki;
        this.godzWjazdu = LocalDateTime.of(0,1,1,0,0, 0) ;

    }

    public String getNumerRejestrac() {
        return numerRejestrac;
    }
    public TypPojazdu getJaki() {
        return jaki;
    }
    public LocalDateTime getGodzWjazdu() {
        return godzWjazdu;
    }
    public void setGodzWjazdu(LocalDateTime godzWjazdu) {
        this.godzWjazdu = godzWjazdu;
    }

    public void wypiszInfo(){
        System.out.print(this.jaki.toString().toLowerCase() + " o numerze rejestr. " + this.getNumerRejestrac() );
    }



}
