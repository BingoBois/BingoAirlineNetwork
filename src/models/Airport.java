package models;

    public class Airport<T extends Comparable<T>> {
        private String code, airPortName, city, country;
        private float latitude, longitude;

        public Airport(String code, String airPortName, String city, String country, float latitude, float longitude) {
            this.code = code;
            this.airPortName = airPortName;
            this.city = city;
            this.country = country;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getAirPortName() {
            return airPortName;
        }

        public void setAirPortName(String airPortName) {
            this.airPortName = airPortName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public float getLatitude() {
            return latitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }
    }
