package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    @ParameterizedTest
    @CsvSource(value = {
            "lowerPreLimitValue  | -1 | 0",
            "equalLowerLimitValue|  0 | 0",
            "lowerPostLimitValue |  1 | 1",
            "upperPreLimitValue  |  8 | 8",
            "equalUpperLimitValue|  9 | 9",
            "upperPostLimitValue | 10 | 0",
    }, delimiter = '|')
    void shouldSetCurrentStationCorrectly(String testName, int inputStation, int expected) {
        Radio rd = new Radio();

        rd.setCurrentStation(inputStation);

        Assertions.assertEquals(expected, rd.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "shouldSelectNextStation  | 8 | 9",
            "shouldSelectFirstStation | 9 | 0"
    }, delimiter = '|')
    void shouldChangeStation(String testName, int currentSt, int expected) {
        Radio radevo = new Radio();

        radevo.setCurrentStation(currentSt);
        radevo.nextStation();

        Assertions.assertEquals(expected, radevo.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "shouldSelectPrevStation  | 9 | 8",
            "shouldSelectLastStation  | 0 | 9"
    }, delimiter = '|')
    void shouldChangeStation2(String testName, int currentSt, int expected) {
        Radio radevo = new Radio();

        radevo.setCurrentStation(currentSt);
        radevo.prevStation();

        Assertions.assertEquals(expected, radevo.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "lowerPreLimitValue  |  -1 |  0",
            "equalLowerLimitValue|   0 |  0",
            "lowerPostLimitValue |   1 |  1",
            "upperPreLimitValue  |  98 | 98",
            "equalUpperLimitValue|  99 | 99",
            "upperPostLimitValue | 100 |  0",
    }, delimiter = '|')
    void setCurrentStForCustomConstruct(String testName, int inputStation, int expected) {
        Radio rd = new Radio(100);

        rd.setCurrentStation(inputStation);

        Assertions.assertEquals(expected, rd.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "shouldSelectNextStation  | 98 | 99",
            "shouldSelectFirstStation | 99 |  0"
    }, delimiter = '|')
    void shouldChangeStationForCustom(String testName, int currentSt, int expected) {
        Radio radevo = new Radio(100);

        radevo.setCurrentStation(currentSt);
        radevo.nextStation();

        Assertions.assertEquals(expected, radevo.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "shouldSelectPrevStation  | 99 | 98",
            "shouldSelectLastStation  |  0 | 99"
    }, delimiter = '|')
    void shouldChangeStationForCustom2(String testName, int currentSt, int expected) {
        Radio radevo = new Radio(100);

        radevo.setCurrentStation(currentSt);
        radevo.prevStation();

        Assertions.assertEquals(expected, radevo.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "lowerPreLimitValue  |  -1 |   0",
            "equalLowerLimitValue|   0 |   0",
            "lowerPostLimitValue |   1 |   1",
            "upperPreLimitValue  |  99 |  99",
            "equalUpperLimitValue| 100 | 100",
            "upperPostLimitValue | 101 |   0",
    }, delimiter = '|')
    void shouldSetVolumeCorrectly(String testName, int inputVolume, int expected) {
        Radio rd = new Radio();

        rd.setCurrentVolume(inputVolume);

        Assertions.assertEquals(expected, rd.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "preMaxLimitValue | 99 | 100",
            "MaxLimitValue    | 100 | 100"
    }, delimiter = '|')
    void shouldIncreaseVolume(String testname, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();

        Assertions.assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "preMinLimitValue | 1 | 0",
            "MinLimitValue    | 0 | 0"
    }, delimiter = '|')
    void shouldDecreaseVolume(String testname, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();

        Assertions.assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "50", "100500", "-100500"}, delimiter = ',')
    void shouldReturnCountOfStations(int inputValue) {
        Radio radio = new Radio(inputValue);

        Assertions.assertEquals(inputValue, radio.getCountOfStations());
    }
}
