package de.tum.in.www1;

import de.tum.in.www1.model.Reservation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PedelecApp extends Application {
	
	private String title = "PedelecApp";

	@Override
    public void start(Stage primaryStage) {
		
		final VBox vboxLayout = new VBox(20);
		vboxLayout.setAlignment(Pos.CENTER);
		final Scene scene = new Scene(vboxLayout, 600, 500);
		
		final ImageView imageView = new ImageView();
		imageView.setImage(new Image(getClass().getResourceAsStream("Pedelec.png")));
		final Text pedelecNametext = new Text("Pedelec Magma 12");
		final Text chooseText = new Text("Choose Starting Time:");
		final DatePicker datePicker = new DatePicker();
		final TextField timeTextField = new TextField("2:00 pm");
		timeTextField.setMaxWidth(100);
		final Button reserveButton = new Button("Reserve"); 
		
		vboxLayout.getChildren().add(imageView);
		vboxLayout.getChildren().add(pedelecNametext);
		vboxLayout.getChildren().add(chooseText);
		vboxLayout.getChildren().add(datePicker);
		vboxLayout.getChildren().add(timeTextField);
		vboxLayout.getChildren().add(reserveButton);
		
		primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
		
		reserveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) { 
				System.out.println("Reserve Button clicked");
				LocalDate localDate = datePicker.getValue();

				if(startDate != null){
					final String time = timeTextField.getText(); 
					final String pedelecName = pedelecNametext.getText(); 
					final String confirmationMessage = "Please confirm your reservation of " + pedelecName + " at " +
						localDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + time; 
			
					ButtonType alert = new Alert(AlertType.CONFIRMATION, confirmationMessage).showAndWait().get();
					if (alert == ButtonType.OK) { 
						Reservation newReservation = new Reservation(); 
						newReservation.setBike(x_4);
						PedelecActivity.java
						newReservation.setStartDate(localDate);
						newReservation.setStartTime(time); 
						newReservation.setBike(pedelecName);
						newReservation.save();
						System.out.println("Reservation confirmed");
					}
					else{
						System.out.println("Reservation cancelled");
					}
				}
				else{
					System.out.println("Please choose a valid date time");
				}
			}
		});
    }

	public static void main(String[] args) {
        launch(args);
    }
}
