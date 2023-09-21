package org.example;

    public class Location {
        public int x;
        public int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Location(String s) {
            this.x = s.charAt(0) - 97;
            this.y = s.charAt(1) - 49;
        }

        public Location(Location l) {
            this.x = l.x;
            this.y = l.y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

