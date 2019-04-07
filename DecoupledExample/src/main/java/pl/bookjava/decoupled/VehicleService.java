package pl.bookjava.decoupled;

public class VehicleService {

//      private Vehicle vehicle = new Bike();
        private Vehicle vehicle;


        public void driver() {
                System.out.println(vehicle.drive());
        }


        public void setVehicle(Vehicle vehicle) {
                this.vehicle = vehicle;
        }


}

