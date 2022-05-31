package ru.netology;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


public class RadioTest {
    @Test
    void shouldNotAcceptMoreThenMaximum() {
        Radio rd = new Radio();

        rd.setCurrentStation(10);
        int expected = 0;

        Assertions.assertEquals(expected, rd.getCurrentStation());
    }

    @Test
    void shouldNotAcceptLessThenMin() {
        Radio rd = new Radio();

        rd.setCurrentStation(-1);
        int expected = 0;

        Assertions.assertEquals(expected, rd.getCurrentStation());
    }

    @Test
    void shouldSelectNextStation() {
        Radio rd = new Radio();

        rd.setCurrentStation(2);
        rd.nextStation();
        int expected = 3;

        Assertions.assertEquals(expected, rd.getCurrentStation());
    }

    @Test
    void shouldSelectFirstStation() {
        Radio radivo = new Radio();

        radivo.setCurrentStation(9);
        radivo.nextStation();
        int expected = 0;

        Assertions.assertEquals(expected, radivo.getCurrentStation());
    }

    @Test
    void shouldSelectLastStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);
        radio.prevStation();
        int exptected = 9;

        Assertions.assertEquals(exptected, radio.getCurrentStation());
    }

    @Test
    void shouldSetVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(5);
        int er = 5;

        Assertions.assertEquals(er, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolume() {
        Radio rd = new Radio();

        rd.setCurrentVolume(150);
        int er = 0;

        Assertions.assertEquals(er, rd.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeLow() {
        Radio rd = new Radio();

        rd.setCurrentVolume(-10);
        int er = 0;

        Assertions.assertEquals(er, rd.getCurrentVolume());
    }

    @Test
    void shouldSetPrevStation() {
        Radio rd = new Radio();

        rd.setCurrentStation(7);
        rd.prevStation();
        int er = 6;

        Assertions.assertEquals(er, rd.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(5);
        radio.increaseVolume();
        int er = 6;

        Assertions.assertEquals(er, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolume() {
        Radio rd = new Radio();

        rd.setCurrentVolume(10);
        rd.increaseVolume();
        int er = 10;

        Assertions.assertEquals(er, rd.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolume() {
        Radio rad = new Radio();

        rad.setCurrentVolume(0);
        rad.decreaseVolume();
        int er = 0;

        Assertions.assertEquals(er, rad.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(5);
        radio.decreaseVolume();
        int er = 4;

        Assertions.assertEquals(er, radio.getCurrentVolume());
    }
}
