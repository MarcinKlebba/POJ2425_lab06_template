package com.pjatk.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Person jan = new Person(1, "jan", LocalDate.of(1990, 1, 1));

        Person jan_kopia = jan.copy();

        if (jan == jan_kopia) {
            System.out.println("Błąd: kopia nie powinna wskazywać na ten sam obiekt.");
            return;
        }
        if (!jan.getName().equals(jan_kopia.getName()) || jan.getId() != jan_kopia.getId()
                || !jan.getDateOfBirth().equals(jan_kopia.getDateOfBirth())) {
            System.out.println("Błąd: kopia nie zawiera tych samych danych.");
            return;
        }

        if (!jan.equals(jan_kopia)) {
            System.out.println("Błąd: obiekty powinny być sobie równe (equals).\n" +
                    "Upewnij się, że metoda 'equals' porównuje wszystkie istotne pola.");
            return;
        }

        Person zdzislaw = jan.copy();
        zdzislaw.setName("zdzislaw");
        zdzislaw.setId(2);
        zdzislaw.setDateOfBirth(jan.getDateOfBirth().plusMonths(2));

        if (zdzislaw.equals(jan)) {
            System.out.println("Błąd: obiekty nie powinny być sobie równe, bo różnią się polami.");
            return;
        }

        Address adresJana = new Address(1, "Gdansk", "80-001");
        adresJana.getAddressLines().add("Brzegi 55");
        Address adresKopiiJana = new Address(1, "Gdynia", "80-002");
        adresKopiiJana.getAddressLines().add("Brzegi 55");

        jan.getAddresses().add(adresJana);
        jan_kopia.getAddresses().add(adresKopiiJana);

        if (jan.equals(jan_kopia)) {
            System.out.println("Błąd: jan i jego kopia mają różne adresy!\n" +
                    "Metoda 'equals' powinna porównywać również pola adresowe.");
            return;
        }

        adresJana.getAddressLines().add("dziekanat szkoly");
        System.out.println("Wypisanie obiektu jan:\n" + jan);

        HashMap<Person, ArrayList<Address>> addressesByPerson = new HashMap<>();
        addressesByPerson.put(jan, jan.getAddresses());
        addressesByPerson.put(jan_kopia, jan_kopia.getAddresses());
        addressesByPerson.put(zdzislaw, jan.getAddresses());

        Person drugaKopiaJana = jan.copy();
        addressesByPerson.put(drugaKopiaJana, drugaKopiaJana.getAddresses());

        if (addressesByPerson.keySet().size() > 3) {
            System.out.println("Błąd: druga kopia jana powinna zastąpić poprzednią wersję w HashMapie.\n" +
                    "Upewnij się, że hashCode() jest zgodny z equals().");
            return;
        }

        Person trzeciaKopiaJana = jan.copy();
        trzeciaKopiaJana.getAddresses().add(new Address(2, "Sopot", "80-003"));
        addressesByPerson.put(trzeciaKopiaJana, trzeciaKopiaJana.getAddresses());

        if (addressesByPerson.keySet().size() != 4) {
            System.out.println("Błąd: dodanie adresu do trzeciej kopii jana powinno zmienić wynik hashCode.");
            return;
        }

        System.out.println("Wszystko działa poprawnie!");
    }
}
