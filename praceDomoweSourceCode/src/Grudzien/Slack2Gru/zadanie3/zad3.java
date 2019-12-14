package Grudzien.Slack2Gru.zadanie3;

public class zad3 {

    public static void zad2Start(){


    }

    //SCHEMATY TUTAJ:
    /*
        3a.:                                                                     zasilacz UPS (ang. uninterruptible power supply – niezakłócone zasilanie energią)
                                                                                    – urządzenie lub system, którego funkcją jest utrzymanie zasilania innych urządzeń elektrycznych
                                                                                       lub elektronicznych w przypadku zaniku lub nieprawidłowych parametrów zasilania sieciowego. source:https://pl.wikipedia.org/wiki/Zasilacz_awaryjny

           Komputer has:  PodzespolKomputerowy[]


                                 PodzespolKomputerowy (abstract)
           extends:     UkladObliczeniowy(abstract)       PamięćRAM      MagazynDanych(abstract)    PamiecRAM    ŹródłoZasilania(abstract)     PłytaGłówna     Wentylator

                        UkladObliczeniowy(abstract)
           extends:    Procesor

                                                                         MagazynDanych(abstract)
           extends:    DyskTwardy

                                                                                                                 ŹródłoZasilania(abstract)
           extends:    Zasilacz                 UPS



        3b.:

           Państwo has: Województwo[], Prezydent
           Województwo   has:  Powiat[]
           Powiat  has: Gmina[], Prezydent
           Gmina has: Miasto[] lub Miasto, Sołtys


                                    Obszar (abstract)
            extends:        ObszarGeograficzny          ObszarPolityczny

                            ObszarGeograficzny
            extends:      KrainaGeograficzna


            KrainaGeograficzna has: Powiat[]




        3c.:

                          IGrawitacja (interfejs)

                                                CiałoNiebieskie (abstract)
           extends:                 Księżyc                         Pluton


                                                Gwiazda
           extends:                Słońce


                                                Planeta
           extends:                   Ziemia                Mars


                   CzarnaDziura         i       Atmosfera



           Planeta, Gwiazda, CiałoNiebieskie i CzarnaDziura implements  IGrawitacja
           Planeta has: Atmosfera


     */




}
