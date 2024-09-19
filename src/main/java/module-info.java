module com.example.cadastroclientesjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;

    opens com.example.cadastroclientesjavafx to javafx.fxml;
    exports com.example.cadastroclientesjavafx;
}