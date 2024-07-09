
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Admin;
import models.Book;
import models.User;
import services.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    private LibraryService libraryService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<Book> books = new ArrayList<>();
        List<User> users = new ArrayList<>();
        libraryService = new LibraryService(books, users);

        Admin admin = new Admin("admin001", "Admin User", true);
        users.add(admin);

        primaryStage.setTitle("Library Management System");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 300, 200);

        Button addBookButton = new Button("Add Book");
        addBookButton.setOnAction(e -> addBook(admin));

        Button deleteBookButton = new Button("Delete Book");
        deleteBookButton.setOnAction(e -> deleteBook(admin));

        vbox.getChildren().addAll(addBookButton, deleteBookButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addBook(User admin) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Book");
        dialog.setHeaderText("Enter Book Details");

        dialog.setContentText("ISBN:");
        String isbn = dialog.showAndWait().orElse("");

        dialog.setContentText("Title:");
        String title = dialog.showAndWait().orElse("");

        dialog.setContentText("Author:");
        String author = dialog.showAndWait().orElse("");

        try {
            libraryService.addBook(isbn, title, author, false);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book added successfully.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    private void deleteBook(User admin) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Delete Book");
        dialog.setHeaderText("Enter Book ISBN");
        dialog.setContentText("ISBN:");

        String isbn = dialog.showAndWait().orElse("");

        try {
            libraryService.deleteBook(isbn);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book deleted successfully.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
}

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}