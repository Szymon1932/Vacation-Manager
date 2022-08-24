module com.example.edp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.dbcp2;
    requires commons.dbutils;
    requires org.apache.commons.lang3;
    requires java.net.http;
    requires com.google.gson;
    requires javax.annotation;
    requires java.management;
    requires guava;

    exports Events;
    exports Models;
    opens Models;
    exports Controllers;
    opens Controllers to javafx.fxml;
    exports DatabaseConnection;
    opens DatabaseConnection to javafx.fxml;
    exports Threads;
    opens Threads to javafx.fxml;
    exports com.example.edp;
}