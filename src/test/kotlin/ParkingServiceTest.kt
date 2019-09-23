import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author Bondar Dmytro
 */
internal class ParkingServiceTest {
    val service = ParkingService()

    @Test
    fun `BigCarInOneSmallSpaceParking`() {
        var parking = Parking(1, 0, 0)
        var cars = listOf(Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertFalse(parkingResults.isEmpty())
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.NONE, parkingResults[0].parkingSpace)
    }

    @Test
    fun `BigCarInOneBigSpaceParking`() {
        var parking = Parking(0, 1, 0)
        var cars = listOf(Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertFalse(parkingResults.isEmpty())
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.BIG, parkingResults[0].parkingSpace)
    }

    @Test
    fun `BigCarInOneBusSpaceParking`() {
        var parking = Parking(0, 0, 1)
        var cars = listOf(Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertFalse(parkingResults.isEmpty())
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.NONE, parkingResults[0].parkingSpace)
    }

    @Test
    fun `SmallCarInOneSmallSpaceParking`() {
        var parking = Parking(1, 0, 0)
        var cars = listOf(Car(CarType.SMALL, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertFalse(parkingResults.isEmpty())
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.SMALL, parkingResults[0].parkingSpace)
    }

    @Test
    fun `SmallCarInOneBigSpaceParking`() {
        var parking = Parking(0, 1, 0)
        var cars = listOf(Car(CarType.SMALL, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertFalse(parkingResults.isEmpty())
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.BIG, parkingResults[0].parkingSpace)
    }

    @Test
    fun `SmallCarInOneBusSpaceParking`() {
        var parking = Parking(0, 0, 1)
        var cars = listOf(Car(CarType.SMALL, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertFalse(parkingResults.isEmpty())
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.NONE, parkingResults[0].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarInOneSmallSpaceParking`() {
        var parking = Parking(1, 0, 0)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(2, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.SMALL, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarInOneBigSpaceParking`() {
        var parking = Parking(0, 1, 0)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(2, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.BIG, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarInOneBusSpaceParking`() {
        var parking = Parking(0, 0, 1)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(2, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.NONE, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarInTwoSmallSpacesParking`() {
        var parking = Parking(2, 0, 0)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(2, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.SMALL, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarInTwoBigSpacesParking`() {
        var parking = Parking(0, 2, 0)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(2, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.BIG, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.BIG, parkingResults[1].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarInTwoBusSpacesParking`() {
        var parking = Parking(0, 0, 2)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "123"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(2, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.NONE, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
    }

    @Test
    fun `TwoBigCarsInOneSmallSpaceParking`() {
        var parking = Parking(1, 0, 0)
        var cars = listOf(Car(CarType.BIG, "123"), Car(CarType.BIG, "124"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(2, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.NONE, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarsAndOneBusInOneSmallAndOneBusSpacesParking`() {
        var parking = Parking(1, 0, 1)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "124"), Car(CarType.BUS, "125"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(3, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.SMALL, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
        assertEquals(cars[2], parkingResults[2].car)
        assertEquals(ParkingSpace.BUS, parkingResults[2].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarsAndOneBusInOneBigAndOneSmallSpacesParking`() {
        var parking = Parking(1, 1, 0)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "124"), Car(CarType.BUS, "125"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(3, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.SMALL, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.BIG, parkingResults[1].parkingSpace)
        assertEquals(cars[2], parkingResults[2].car)
        assertEquals(ParkingSpace.NONE, parkingResults[2].parkingSpace)
    }

    @Test
    fun `OneSmallAndOneBigCarsAndOneBusInOneBigAndOneBusSpacesParking`() {
        var parking = Parking(0, 1, 1)
        var cars = listOf(Car(CarType.SMALL, "123"), Car(CarType.BIG, "124"), Car(CarType.BUS, "125"))
        var parkingResults = service.manageCars(parking, cars)

        assertEquals(3, parkingResults.size)
        assertEquals(cars[0], parkingResults[0].car)
        assertEquals(ParkingSpace.BIG, parkingResults[0].parkingSpace)
        assertEquals(cars[1], parkingResults[1].car)
        assertEquals(ParkingSpace.NONE, parkingResults[1].parkingSpace)
        assertEquals(cars[2], parkingResults[2].car)
        assertEquals(ParkingSpace.BUS, parkingResults[2].parkingSpace)
    }
}