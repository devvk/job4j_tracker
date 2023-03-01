package ru.job4j.enumeration;

/**
 * Перечисление статусов автомобиля в автосервисе.
 */
public enum Status {
    ACCEPTED("принят") {
        private final String message = "Автомобиль принят на СТО";

        @Override
        public String getMessage() {
            return message;
        }
    },
    IN_WORK("в работе") {
        private final String message = "Автомобиль находится в работе";

        @Override
        public String getMessage() {
            return message;
        }
    },
    WAITING("в ожидании") {
        private final String message = "Автомобиль ожидает запчасти";

        @Override
        public String getMessage() {
            return message;
        }
    },
    FINISHED("завершён") {
        private final String message = "Все работы завершены";

        @Override
        public String getMessage() {
            return message;
        }
    };

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public abstract String getMessage();
}
