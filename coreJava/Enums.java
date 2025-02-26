package Tutorials;

/*
 * Summary
    Enums provide a type-safe way to define and use a fixed set of constants.
    They behave like classes and can have fields, methods, and constructors.
    Useful built-in methods (values(), valueOf(), name(), ordinal()) make them versatile.
    They work well with switch-case statements, collections (EnumSet, EnumMap), and can implement interfaces.
    Enums offer a robust solution for handling fixed sets of constants with additional functionality if needed.
 */

enum TrafficLight {
    RED("Stop"), YELLOW("Caution"), GREEN("Go");    // instances of TrafficLight

    private final String action;

    public String getAction() {
        return action;
    }

    private TrafficLight(String action) {
        this.action = action;
    }

    public boolean isStopRequired() {
        return this == RED;
    }
}

enum OrderStatus {
    PENDING(1, "Order received, waiting for processing"),
    SHIPPED(2, "Order has been shipped"),
    DELIVERED(3, "Order delivered successfully"),
    CANCELED(4, "Order has been canceled");

    private final int code;
    private final String status;

    private OrderStatus(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}

interface Status {
    String getMessage();
}

enum OrderState implements Status {
    PENDING {
        public String getMessage() { return "Order is pending"; }
    },
    SHIPPED {
        public String getMessage() { return "Order has been shipped"; }
    },
    DELIVERED {
        public String getMessage() { return "Order delivered successfully"; }
    }
}

public class Enums {
    public static void main(String[] args) {
        TrafficLight tl = TrafficLight.RED;
        System.out.println(tl.getAction());
        System.out.println(tl.isStopRequired());

        // TrafficLight tl1 = TrafficLight.GREEN;
        // System.out.println(tl.hashCode());
        // System.out.println(tl1.hashCode());
        System.out.println(OrderState.SHIPPED.getMessage());
    }
    
}
