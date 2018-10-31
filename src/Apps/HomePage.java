package Apps;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Text type =  new Text("Select Car Type: ");
		RadioButton rbType1 = new RadioButton("Normal");
		RadioButton rbType2 = new RadioButton("Hatch Back");
		RadioButton rbType3 = new RadioButton("MPV");
		Text model = new Text("Enter Model: ");
		TextField tfName = new TextField();
		Text brand = new Text("Enter Brand: ");
		TextField tfBrand = new TextField();
		Text marketPrice = new Text("Enter Market\nPrice(RM): ");
		TextField  tfMarketPrice = new TextField();
		Text coverage = new Text("Select Coverage: ");
		RadioButton rbCoverage1 = new RadioButton("Comprehensive");
		RadioButton rbCoverage2 = new RadioButton("Third Party");
		Text location = new Text("Select Location: ");
		RadioButton rbLocation1 = new RadioButton("Peninsular Malaysia");
		RadioButton rbLocation2 = new RadioButton("West Malaysia");
		Text discount = new Text("Discount\nClaim(%): ");
		TextField tfDiscount = new TextField();
		Text total = new Text("Yearly Payment: ");
		TextField tfTotal = new TextField();
		Button btSubmit = new Button("Calculate");
		Button btClear = new Button("Clear");
		
		ToggleGroup groupCov = new ToggleGroup();
		rbCoverage1.setToggleGroup(groupCov);
		rbCoverage2.setToggleGroup(groupCov);
		
		ToggleGroup groupT = new ToggleGroup();
		rbType1.setToggleGroup(groupT);
		rbType2.setToggleGroup(groupT);
		rbType3.setToggleGroup(groupT);
		
		ToggleGroup groupL = new ToggleGroup();
		rbLocation1.setToggleGroup(groupL);
		rbLocation2.setToggleGroup(groupL);
		
		btSubmit.setOnAction(e ->{
			double cov = 0.0;
			double loc = 0.0;
			if(rbType1.isSelected()) {
				Normal norm = new Normal(tfName.getText().toString(),tfBrand.getText().toString());
				if(rbCoverage1.isSelected()) cov = 300;
				else if(rbCoverage2.isSelected()) cov = 150;
				if(rbLocation1.isSelected()) loc = 150;
				else if(rbLocation2.isSelected()) loc = 300;
				norm.setAll(cov, loc);
				norm.setMarketPrice(Double.parseDouble(tfMarketPrice.getText()));
				norm.setDiscount(Double.parseDouble(tfDiscount.getText()));
				tfTotal.setText(String.format("RM%.2f",norm.calculateTotal()));
			}
			else if(rbType2.isSelected()) {
				HatchBack hb = new HatchBack(tfName.toString(),tfBrand.toString());
				if(rbCoverage1.isSelected()) cov = 300;
				else if(rbCoverage2.isSelected()) cov = 150;
				if(rbLocation1.isSelected()) loc = 150;
				else if(rbLocation2.isSelected()) loc = 300;
				hb.setAll(cov, loc);
				hb.setMarketPrice(Double.parseDouble(tfMarketPrice.getText()));
				hb.setDiscount(Double.parseDouble(tfDiscount.getText()));
				tfTotal.setText(String.format("RM%.2f",hb.calculateTotal()));
			}
			else if(rbType3.isSelected()) {
				MPV mpv = new MPV(tfName.toString(),tfBrand.toString());
				if(rbCoverage1.isSelected()) cov = 300;
				else if(rbCoverage2.isSelected()) cov = 150;
				if(rbLocation1.isSelected()) loc = 150;
				else if(rbLocation2.isSelected()) loc = 300;
				mpv.setAll(cov, loc);
				mpv.setMarketPrice(Double.parseDouble(tfMarketPrice.getText()));
				mpv.setDiscount(Double.parseDouble(tfDiscount.getText()));
				tfTotal.setText(String.format("RM%.2f",mpv.calculateTotal()));
			}
			
		});
		
		btClear.setOnAction(e->{
			tfName.clear();
			tfBrand.clear();
			tfMarketPrice.clear();
			tfDiscount.clear();
			tfTotal.clear();
			if(rbType1.isSelected()) groupT.selectToggle(null);
			if(rbType2.isSelected()) groupT.selectToggle(null);
			if(rbType3.isSelected()) groupT.selectToggle(null);
			if(rbCoverage1.isSelected()) groupCov.selectToggle(null);
			if(rbCoverage2.isSelected()) groupCov.selectToggle(null);
			if(rbLocation1.isSelected()) groupL.selectToggle(null);
			if(rbLocation2.isSelected()) groupL.selectToggle(null);			
		});
		
		//Placement
		GridPane mainGrid = new GridPane();
		GridPane rbTGrid = new GridPane();
		GridPane nb = new GridPane();
		GridPane rbCGrid = new GridPane();
		GridPane rbLGrid = new GridPane();
		GridPane rbDGrid = new GridPane();
		GridPane rbYGrid = new GridPane();
		GridPane btGrid = new GridPane();
		mainGrid.setMinSize(400, 250);
		mainGrid.setAlignment(Pos.CENTER);
		mainGrid.setPadding(new Insets(10,10,10,10));
		mainGrid.setHgap(10);
		mainGrid.setVgap(20);
		//main
		mainGrid.add(nb, 0, 0);
		mainGrid.add(rbTGrid, 1, 0);
		mainGrid.add(rbCGrid, 0, 1);
		mainGrid.add(rbLGrid, 1, 1);
		mainGrid.add(rbDGrid, 0, 2);
		mainGrid.add(rbYGrid, 1, 2);
		mainGrid.add(btGrid, 1, 3);
		//nb
		nb.add(model, 0, 0);
		nb.add(tfName, 1, 0);
		nb.add(brand, 0, 1);
		nb.add(tfBrand, 1, 1);
		//rbT
		rbTGrid.add(type, 0, 0);
		rbTGrid.add(rbType1, 1, 0);
		rbTGrid.add(rbType2, 1, 1);
		rbTGrid.add(rbType3, 1, 2);
		//rbC
		rbCGrid.add(coverage, 0, 0);
		rbCGrid.add(rbCoverage1, 1, 0);
		rbCGrid.add(rbCoverage2, 1, 1);
		//rbL
		rbLGrid.add(location, 0, 0);
		rbLGrid.add(rbLocation1, 1, 0);
		rbLGrid.add(rbLocation2, 1, 1);
		//rbD
		rbDGrid.add(marketPrice, 0, 0);
		rbDGrid.add(tfMarketPrice,1,0);
		rbDGrid.add(discount, 0, 1);
		rbDGrid.add(tfDiscount, 1, 1);
		//rbY
		rbYGrid.add(total, 0, 0);
		rbYGrid.add(tfTotal, 1, 0);
		//btGrid
		btGrid.add(btClear, 1, 0);
		btGrid.add(btSubmit, 0, 0);
		
		//properties
		tfMarketPrice.setAlignment(Pos.BOTTOM_RIGHT);
		tfDiscount.setAlignment(Pos.BOTTOM_RIGHT);
		btGrid.setAlignment(Pos.CENTER_RIGHT);
		btGrid.setHalignment(btSubmit, HPos.CENTER);
		btGrid.setHalignment(btClear, HPos.RIGHT);
		tfTotal.setEditable(false);
		
		//Add scene into stage
		Scene scene = new Scene(mainGrid);
		primaryStage.getIcons().add(new Image("/Apps/icon.png"));
		primaryStage.setTitle("Car Insurance Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
