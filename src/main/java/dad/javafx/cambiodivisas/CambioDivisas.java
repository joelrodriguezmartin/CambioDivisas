package dad.javafx.cambiodivisas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisas extends Application {
	private TextField divisaText1;
	private TextField divisaText2;
	private ComboBox<Divisa> divisaBox1;
	private ComboBox<Divisa> divisaBox2;
	private Button calcularButton;
	private Divisa Euro = new Divisa("Euro", 1.0);
	private Divisa Libra = new Divisa("Libra", 0.8873);
	private Divisa Dolar = new Divisa("Dolar", 1.2007);
	private Divisa Yen = new Divisa("Yen", 133.59);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		divisaText1 = new TextField();
		divisaText1.setPromptText("Cantidad de divisa 1");
		divisaText1.setPrefColumnCount(10);
		divisaText1.setAlignment(Pos.CENTER);
		
		divisaText2 = new TextField();
		divisaText2.setPromptText("Cantidad de divisa 2");
		divisaText2.setPrefColumnCount(10);
		divisaText2.setEditable(false);
		divisaText2.setAlignment(Pos.CENTER);
		
		divisaBox1 = new ComboBox<Divisa>();
		divisaBox1.getItems().addAll(Euro, Libra, Dolar, Yen);
		divisaBox1.setPromptText("Divisa 1");
		
		
		divisaBox2 = new ComboBox<Divisa>();
		divisaBox2.getItems().addAll(Euro, Libra, Dolar, Yen);
		divisaBox2.setPromptText("Divisa 2");
		
		
		calcularButton = new Button("Calcular");
		calcularButton.setDefaultButton(true);
		calcularButton.setOnAction(e -> onCalcularButtonAction(e));
		
		HBox box1 = new HBox(5, divisaText1, divisaBox1);
		box1.setAlignment(Pos.CENTER);
		HBox box2 = new HBox(5, divisaText2, divisaBox2);
		box2.setAlignment(Pos.CENTER);
		VBox root = new VBox(5, box1, box2, calcularButton);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Cambio Divisas");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	private void onCalcularButtonAction(ActionEvent e) {
		Divisa origen = divisaBox1.getSelectionModel().getSelectedItem();
		Divisa destino = divisaBox2.getSelectionModel().getSelectedItem();
		
		String cantidad = divisaText1.getText();
		
		try {
			divisaText2.setText(destino.fromEuro(origen.toEuro(Double.parseDouble(cantidad))).toString());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			divisaText2.setText("Introduce numeros");
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
