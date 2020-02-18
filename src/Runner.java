import by.gsu.pms.BusinessTrip;

public class Runner {

    public static void main(String[] args) {
        BusinessTrip[] businessTrips = {
                new BusinessTrip("Anton Slutsk",50000,5),
                new BusinessTrip("Dmitry Zaycev",55500,7),
                null,
                new BusinessTrip("Aman Multai",90000,15),
                new BusinessTrip("Din Multai",64000,9),
                new BusinessTrip("Oleg Varonchik",70000,10),
                new BusinessTrip()
        };

        for (BusinessTrip trip : businessTrips){
            if (trip != null) {
                trip.show();
            }
            System.out.println("\n");
        }

        businessTrips[businessTrips.length-1].setTransport(9250);

        System.out.println("Duration = " + (businessTrips[0].getDays() + businessTrips[1].getDays()) );
        System.out.println("\n");

        for (BusinessTrip trip : businessTrips){
            System.out.println(trip);
        }


    }

}


