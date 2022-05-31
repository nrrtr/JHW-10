package ru.netology;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int countOfStations = 10;
    private int firstStation = 0;
    private int lastStation = 9;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio() {
    }

    public Radio(int countOfChannels) {
        this.countOfStations = countOfChannels;
        this.lastStation = countOfChannels - 1;
    }

    public int getCountOfStations() {
        return countOfStations;
    }

    public int getFirstStation() {
        return firstStation;
    }

    public int getLastStation() {
        return lastStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentStation(int currentStation) {
        if ((currentStation < this.getFirstStation()) || (currentStation > this.getLastStation())) {
            return;
        } else {
            this.currentStation = currentStation;
        }
    }

    public void nextStation() {
        if (currentStation == getLastStation()) {
            currentStation = getFirstStation();
            return;
        } else {
            setCurrentStation(++currentStation);
        }
    }

    public void prevStation() {
        if (currentStation == getFirstStation()) {
            currentStation = getLastStation();
            return;
        } else {
            setCurrentStation(--currentStation);
        }
    }


    public void setCurrentVolume(int currentVolume) {
        if ((currentVolume > this.getMaxVolume()) || (currentVolume < this.getMinVolume())) {
            return;
        } else {
            this.currentVolume = currentVolume;
        }
    }

    public void increaseVolume() {
        if (currentVolume >= getMaxVolume()) {
            return;
        }
        setCurrentVolume(++currentVolume);
    }

    public void decreaseVolume() {
        if (currentVolume <= getMinVolume()) {
            return;
        } else {
            setCurrentVolume(--currentVolume);
        }
    }
}
