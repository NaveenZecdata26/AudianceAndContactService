package io.omoto.fms.infrastructure.adapters.scheduler;

import java.util.HashMap;
import java.util.List;

public class Schedule {
    private String integrationKey;
    private String timeZone;
    private List<UserSpecificArguments> userSpecificArguments;
    private ScheduleAt scheduleAt;
    private String scheduleEndpoint;
    private HashMap uniqueArguments;

    public HashMap getUniqueArguments() {
        return uniqueArguments;
    }

    public void setUniqueArguments(HashMap uniqueArguments) {
        this.uniqueArguments = uniqueArguments;
    }

    public String getScheduleEndpoint() {
        return scheduleEndpoint;
    }

    public void setScheduleEndpoint(String scheduleEndpoint) {
        this.scheduleEndpoint = scheduleEndpoint;
    }

    public ScheduleAt getScheduleAt() {
        return scheduleAt;
    }

    public void setScheduleAt(ScheduleAt scheduleAt) {
        this.scheduleAt = scheduleAt;
    }

    public String getIntegrationKey() {
        return integrationKey;
    }

    public void setIntegrationKey(String integrationKey) {
        this.integrationKey = integrationKey;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public List<UserSpecificArguments> getUserSpecificArguments() {
        return userSpecificArguments;
    }

    public void setUserSpecificArguments(List<UserSpecificArguments> userSpecificArguments) {
        this.userSpecificArguments = userSpecificArguments;
    }

    public static class ScheduleAt{
        private String min;
        private String hour;
        private String day;
        private String month;
        private String year;

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }

    public static class UserSpecificArguments{
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
