package leetcode.design;

import java.util.*;

public class UndergroundSystem {
    static class Route {
        String startStation;
        String endStation;

        public Route(String startStation) {
            this.startStation = startStation;
        }

        public Route(String startStation, String endStation) {
            this(startStation);
            this.endStation = endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Route route = (Route) o;
            return Objects.equals(startStation, route.startStation) && Objects.equals(endStation, route.endStation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startStation, endStation);
        }
    }
    static class Trip {
        Route route;
        int checkInTime;
        int checkOutTime;

        public Trip(String startStationName, int checkInTime) {
            this.route = new Route(startStationName);
            this.checkInTime = checkInTime;
        }

        public void setCheckOutTime(int checkOutTime) {
            this.checkOutTime = checkOutTime;
        }

        public int getDuration() {
            return checkOutTime - checkInTime;
        }
    }

    static class TripStats {
        int count;
        int totalDuration;

        public TripStats(int totalDuration) {
            this.totalDuration = totalDuration;
            this.count = 1;
        }
        public TripStats(int totalDuration, int count) {
            this.totalDuration = totalDuration;
            this.count = count;
        }
        public static TripStats update(TripStats currentStats, int duration) {
            return new TripStats(currentStats.totalDuration+duration, currentStats.count+1);
        }
    }


    Map<Integer,Trip> trips;
    Map<Route, TripStats> tripStats;

    public UndergroundSystem() {
        trips = new HashMap<>();
        tripStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Trip trip = new Trip(stationName, t);
        trips.put(id, trip);
    }

    public void checkOut(int id, String stationName, int t) {
        Trip trip = trips.get(id);
        trip.setCheckOutTime(t);
        trip.route.setEndStation(stationName);
        trips.put(id, trip);
        tripStats.merge(trip.route, new TripStats(trip.getDuration()), (curentStats, newValue)-> TripStats.update(curentStats, trip.getDuration()));
    }

    public double getAverageTime(String startStation, String endStation) {
        TripStats stats = tripStats.get(new Route(startStation,endStation));
        if (stats == null)
            return 0;
        return (double) stats.totalDuration / stats.count;
    }
}
