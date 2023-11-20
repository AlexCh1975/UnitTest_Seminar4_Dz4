package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seminars.second.hw.Car;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle moto;
    @BeforeEach
    void setUp(){
        car = new Car("Dodge", "Ram", 2010);
        moto = new Motorcycle("Honda", "CB1000R", 2023);
    }

    /**
     * Проверить, что экземпляр объекта Car также является экземпляром транспортного
     * средства (используя оператор instanceof).
     */
    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertTrue(car instanceof Vehicle);
    }

    /**
     * Проверить, что объект Car создается с 4-мя колесами.
     */

    @Test
    void testCarHasFourWheels(){
        assertEquals(4, car.getNumWheels());
    }

    /**
     *  Проверить, что объект Motorcycle создается с 2-мя колесами.
     */

    @Test
    void testMotoHasTwoWheels(){
        assertEquals(2, moto.getNumWheels());
    }

    /**
     * Проверить, что объект Car развивает скорость 60 в режиме тестового
     * вождения (используя метод testDrive()).
     */

    @Test
    void testSpeedCar(){
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    /**
     * Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового
     * вождения (используя метод testDrive()).
     */

    @Test
    void testSpeedMoto(){
        moto.testDrive();
        assertEquals(75, moto.getSpeed());
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция
     * движения транспорта) машина останавливается (speed = 0).
     */

    @Test
    void testDriveCar(){
        car.testDrive();
        int speedDrive = car.getSpeed();
        car.park();
        int speedStop = car.getSpeed();
        assertEquals(60, speedDrive);
        assertEquals(0, speedStop);
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е.
     * эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     */

    @Test
    void testDriveMoto(){
        moto.testDrive();
        int speedDrive = moto.getSpeed();
        moto.park();
        int speedStop = moto.getSpeed();
        assertEquals(75, speedDrive);
        assertEquals(0, speedStop);
    }

}