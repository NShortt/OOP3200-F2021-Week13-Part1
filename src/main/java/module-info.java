module ca.durhamcollege.oop3200f2021week13part1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.durhamcollege.oop3200f2021week13part1 to javafx.fxml;
    exports ca.durhamcollege.oop3200f2021week13part1;
}