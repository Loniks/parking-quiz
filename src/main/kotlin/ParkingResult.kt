/**
 * @author Bondar Dmytro
 */
class ParkingResult(val car: Car, val parkingSpace: ParkingSpace)

enum class ParkingSpace {
    SMALL,
    BIG,
    BUS,
    NONE,
}
