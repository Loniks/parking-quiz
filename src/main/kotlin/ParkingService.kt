/**
 * @author Bondar Dmytro
 */
class ParkingService {
    fun manageCars(parking: Parking, cars: List<Car>) = cars.map { car -> getParkingResult(car, parking) }

    private fun getParkingResult(car: Car, parking: Parking): ParkingResult {
        var space = ParkingSpace.NONE;
        if (car.type == CarType.SMALL && parking.numberOfSmallCarsParkingSpaces > 0) {
            space = ParkingSpace.SMALL
            parking.numberOfSmallCarsParkingSpaces--
        } else if ((car.type == CarType.BIG || car.type == CarType.SMALL) && parking.numberOfBigCarParkingSpaces > 0) {
            space = ParkingSpace.BIG
            parking.numberOfBigCarParkingSpaces--
        } else if (car.type == CarType.BUS && parking.numberOfBusParkingSpaces > 0) {
            space = ParkingSpace.BUS
            parking.numberOfBusParkingSpaces--
        }
        return ParkingResult(car, space)
    }
}


