package application;

import java.io.File;
import java.sql.*;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

public class HallManagement extends Button{
	Label l=new Label("User Name");
	Label l2=new Label("Password");
	Label l3=new Label("Confirm Password");
	TextField tu=new TextField();
	PasswordField p2=new PasswordField();
	PasswordField p3=new PasswordField();
	Button b=new Button("Submit");
	Button b2=new Button("Register");
	Button b3=new Button();
	
	File file=new File("person.png");
	Image i=new Image(file.toURI().toString());
	ImageView ii=new ImageView(i);
	Connection connection;
	Statement statement;
	int j=1;
	int k=2;
	DatePicker dpm=new DatePicker();
	
	ComboBox<String> cb=new ComboBox<>();
	ComboBox<String> cb2=new ComboBox<>();
	ComboBox<String> cb3=new ComboBox<>();
	ComboBox<String> cb4=new ComboBox<>();
	ComboBox<String> cb5=new ComboBox<>();
	ComboBox<String> cb6=new ComboBox<>();
	
	TextField t=new TextField("");
	TextField t2=new TextField("");
	TextField t3=new TextField("");
	TextField t4=new TextField("");
	TextField t5=new TextField("");
	TextField t6=new TextField("");
	TextField t7=new TextField("");
	public void HallManagement (){
		initializeDB();
		Pane pane=new Pane();
		pane.setPrefSize(800, 450);
		pane.setStyle("-fx-background-color:rgb(6,90,157)");
		pane.getChildren().addAll(l,l2,l3,tu,p2,p3,b,b2,b3);
		l.relocate(330, 150);
		l.getStyleClass().add("lbl");
		l2.relocate(344, 200);
		l2.getStyleClass().add("lbl");
		l3.relocate(268, 250);
		l3.getStyleClass().add("lbl");
		tu.relocate(460, 150);
		tu.getStyleClass().add("txt");
		p2.relocate(460, 200);
		p2.getStyleClass().add("txt");
		p3.relocate(460, 250);
		p3.getStyleClass().add("txt");
		b.relocate(125, 375);
		b.getStyleClass().add("btn");
		b2.relocate(625, 375);
		b2.getStyleClass().add("btn");
		b3.setGraphic(ii);
		b3.setPrefSize(128, 128);
		b3.relocate(150, 140);
		b3.getStyleClass().add("btnt");
		Stage stage=new Stage();
		Scene scene=new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		b.setOnAction(e ->{
			try{
				String sql="select Name,Password,CPassword from user_information where Name='"+tu.getText()+"' and Password='"+p2.getText()+"' and CPassword='"+p3.getText()+"'";
				ResultSet rset=statement.executeQuery(sql);
				while(rset.next()){
					mealchart mc=new mealchart();
					mc.mealchart();
				}
			}catch(Exception ex){
				
			}
			
		});
		b2.setOnAction(e ->{
			register rg=new register();
			rg.register();
		});
	}

	private void initializeDB() {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","");
			statement=connection.createStatement();
	}
	catch(Exception ex){
		ex.printStackTrace();
		}
		
	}

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	launch(args);
	//}
	public class mealchart extends Button{
		Label l=new Label("PLAN A MEAL");
		Label l2=new Label("MEAL");
		Label l3=new Label("PRICE");
		Label l7=new Label("LAUNCH");
		
		Label ld2=new Label("MEAL");
		Label ld3=new Label("PRICE");
		Label l8=new Label("DINNER");
		

		Button bl=new Button("Submit");
		Button bd2=new Button("Submit");
		Button bs=new Button("Show Meal List");
		Button bp=new Button("Show total Cost");
		public void mealchart(){
			initializeDB();
			Pane pane=new Pane();
			pane.setPrefSize(800, 400);
			pane.setStyle("-fx-background-color:rgb(6,90,157)");
			pane.getChildren().addAll(l,l2,l3,ld2,ld3,l7,l8,t,t2,t3,t4,t5,t6,bl,bd2,cb,cb2,cb3,cb4,cb5,cb6,bs,bp);
			l.getStyleClass().add("lbl");
			l.relocate(340, 50);
			l2.getStyleClass().add("lbl");
			l2.relocate(120, 150);
			l3.getStyleClass().add("lbl");
			l3.relocate(240, 150);
			cb.getStyleClass().add("combo");
			cb.relocate(100, 200);
			cb2.getStyleClass().add("combo");
			cb2.relocate(100, 250);
			cb3.getStyleClass().add("combo");
			cb3.relocate(100, 300);
			l7.getStyleClass().add("lbl");
			l7.relocate(170, 100);
			l8.getStyleClass().add("lbl");
			l8.relocate(550, 100);
			ld2.getStyleClass().add("lbl");
			ld2.relocate(500, 150);
			ld3.getStyleClass().add("lbl");
			ld3.relocate(620, 150);
			cb4.getStyleClass().add("combo");
			cb4.relocate(480, 200);
			cb5.getStyleClass().add("combo");
			cb5.relocate(480, 250);
			cb6.getStyleClass().add("combo");
			cb6.relocate(480, 300);
			l7.getStyleClass().add("lbl");
			l7.relocate(170, 100);
			t.relocate(260, 202);
			t.setPrefWidth(50);
			t.setEditable(false);
			t2.relocate(260, 252);
			t2.setPrefWidth(50);
			t2.setEditable(false);
			t3.relocate(260, 302);
			t3.setPrefWidth(50);
			t3.setEditable(false);
			t4.relocate(640, 202);
			t4.setPrefWidth(50);
			t4.setEditable(false);
			t5.relocate(640, 252);
			t5.setPrefWidth(50);
			t5.setEditable(false);
			t6.relocate(640, 302);
			t6.setPrefWidth(50);
			t6.setEditable(false);
			bl.relocate(180, 350);
			bl.getStyleClass().add("btn");
			bd2.relocate(560, 350);
			bd2.getStyleClass().add("btn");
			bs.relocate(270, 350);
			bs.getStyleClass().add("btn");
			bp.relocate(415, 350);
			bp.getStyleClass().add("btn");
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage.setScene(scene);
			stage.show();
			try{
				String sql="select * from meal_rate";
				ResultSet rset=statement.executeQuery(sql);
				while(rset.next()){
					String s=rset.getString(j);
					//String s2=rset.getString(k);
					cb.getItems().add(s);
					//cb.itemsProperty().setValue(s);
				
					cb2.getItems().add(s);
					cb3.getItems().add(s);
					cb4.getItems().add(s);
					cb5.getItems().add(s);
					cb6.getItems().add(s);
					//ot.setText(rset.getString(2));
				}j++;
			}catch(Exception e){
				
			}
			//cb.setOnAction(e ->{t.setText(cb.getValue());});
			
			
			cb.setOnAction(e ->{
				t.setText(cb.getValue());
				try{
					String sql="select price from meal_rate where meal='"+t.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						String s=rset.getString(1);
						t.setText(s);
					}
					}catch(Exception ex){
						
					}
			});
			cb2.setOnAction(e ->{
				t2.setText(cb2.getValue());
				try{
					String sql="select price from meal_rate where meal='"+t2.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						String s=rset.getString(1);
						t2.setText(s);
					}
					}catch(Exception ex){
						
					}
			});
			cb3.setOnAction(e ->{
				t3.setText(cb3.getValue());
				try{
					String sql="select price from meal_rate where meal='"+t3.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						String s=rset.getString(1);
						t3.setText(s);
					}
					}catch(Exception ex){
						
					}
			});
			cb4.setOnAction(e ->{
				t4.setText(cb4.getValue());
				try{
					String sql="select price from meal_rate where meal='"+t4.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						String s=rset.getString(1);
						t4.setText(s);
					}
					}catch(Exception ex){
						
					}
			});
			cb5.setOnAction(e ->{
				t5.setText(cb5.getValue());
				try{
					String sql="select price from meal_rate where meal='"+t5.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						String s=rset.getString(1);
						t5.setText(s);
					}
					}catch(Exception ex){
						
					}
			});
			cb6.setOnAction(e ->{
				t6.setText(cb6.getValue());
				try{
					String sql="select price from meal_rate where meal='"+t6.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						String s=rset.getString(1);
						t6.setText(s);
					}
					}catch(Exception ex){
						
					}
			});
			bl.setOnAction(e ->{
				showprice sp=new showprice();
				sp.showprice();
			});
			bd2.setOnAction(e ->{
				showpriced sp=new showpriced();
				sp.showpriced();
			});
			bs.setOnAction(e ->{
				mlist ml=new mlist();
				ml.mlist();
			});
			bp.setOnAction(e ->{
				pricetotal pt=new pricetotal();
				pt.pricetotal();
			});
		}
	}
	public class register extends Button{
		Label l=new Label("Please Fill Up the Form");
		Label l2=new Label("User Name :");
		Label l3=new Label("Roll :");
		Label l4=new Label("Department :");
		Label l5=new Label("Password :");
		Label l6=new Label("Confirm Password :");
		
		TextField t=new TextField();
		TextField t2=new TextField();
		TextField t3=new TextField();
		PasswordField t4=new PasswordField();
		PasswordField t5=new PasswordField();
		Button b=new Button("Submit");
		public void register(){
			Pane pane=new Pane();
			pane.setPrefSize(700, 550);
			pane.setStyle("-fx-background-color:rgb(6,90,157)");
			pane.getChildren().addAll(l,l2,l3,l4,l5,l6,t,t2,t3,t4,t5,b);
			l.relocate(250, 50);
			l.getStyleClass().add("lbl");
			l2.relocate(210, 150);
			l2.getStyleClass().add("lbl");
			l3.relocate(275, 200);
			l3.getStyleClass().add("lbl");
			l4.relocate(203, 250);
			l4.getStyleClass().add("lbl");
			l5.relocate(227, 300);
			l5.getStyleClass().add("lbl");
			l6.relocate(150, 350);
			l6.getStyleClass().add("lbl");
			t.relocate(370, 150);
			t.getStyleClass().add("txt");
			t2.relocate(370, 200);
			t2.getStyleClass().add("txt");
			t3.relocate(370, 250);
			t3.getStyleClass().add("txt");
			t4.relocate(370, 300);
			t4.getStyleClass().add("txt");
			t5.relocate(370, 350);
			t5.getStyleClass().add("txt");
			b.relocate(480, 430);
			b.getStyleClass().add("btn");
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			b.setOnAction(e ->{
				try{
					String sql="insert into user_information (Name,Roll,Dept,Password,CPassword) values('"+t.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"')";
					statement.executeUpdate(sql);
					System.out.print("Data Updated");
				}catch(Exception ex){
					
				}
			});
		}
	}
	
	public class showprice extends Button{
		Label l=new Label("Price for the Order at Launch");
		Label l2=new Label();
		Label l3=new Label();
		Label l4=new Label();
		Label l5=new Label("------------------------------");
		Label l6=new Label("Total");
		Label l7=new Label();
		Label l8=new Label();
		Label l9=new Label();
		Label l0=new Label();
		Label l11=new Label();
		Button b=new Button("Order Now");
		TextField ts=new TextField();
		TextField ts2=new TextField();
		TextField ts3=new TextField();
		TextField ts4=new TextField();
		TextField ts5=new TextField();
		TextField ts6=new TextField();
		public void showprice(){
			
			Pane pane=new Pane();
			pane.setPrefSize(300, 400);
			pane.setStyle("-fx-background-color:rgb(6,90,157)");
			pane.getChildren().addAll(l,l2,l3,l4,l5,l6,l7,l8,l9,l0,l11,b);
			l.getStyleClass().add("lbl");
			l.relocate(25, 50);
			l2.relocate(40, 100);
			l2.getStyleClass().add("lbl");
			l2.setText(cb.getValue());
			l3.relocate(40, 150);
			l3.getStyleClass().add("lbl");
			l3.setText(cb2.getValue());
			l4.relocate(40, 200);
			l4.getStyleClass().add("lbl");
			l4.setText(cb3.getValue());
			l5.relocate(30, 225);
			l5.getStyleClass().add("lbl");
			l6.relocate(40, 260);
			l6.getStyleClass().add("lbl");
			l7.setText("Price : "+t.getText());
			l7.relocate(180, 100);
			l7.getStyleClass().add("lbl");
			l8.setText("Price : "+t2.getText());
			l8.relocate(180, 150);
			l8.getStyleClass().add("lbl");
			l9.setText("Price : "+t3.getText());
			l9.relocate(180, 200);
			l9.getStyleClass().add("lbl");
			//calculate SUM
			int s=Integer.valueOf(t.getText());
			int s2=Integer.valueOf(t2.getText());
			int s3=Integer.valueOf(t3.getText());
			String s4=String.valueOf(s+s2+s3);
			//
			
			l0.setText(s4);
			l0.relocate(240, 260);
			l0.getStyleClass().add("lbl");
			b.getStyleClass().add("btn");
			b.relocate(175, 330);
			
			
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			b.setOnAction(e ->{
				initializeDB();
				DatePicker dp=new DatePicker();
				//Label ls=new Label("Enter Roll");
				//ls.getStyleClass().add("lbl");
				Label ls2=new Label("Select Date");
				ls2.getStyleClass().add("lbl");
				Label ls3=new Label("Room No.");
				ls3.getStyleClass().add("lbl");
				ls2.relocate(152, 40);
				ts.relocate(125, 60);
				//ls2.relocate(152, 100);
				ls3.relocate(160,140 );
				dp.relocate(115, 90);
				//ts2.relocate(150, 100);
				ts2.setText(l0.getText());
				ts3.setText(l2.getText());
				ts4.setText(l3.getText());
				ts5.setText(l4.getText());
				ts6.relocate(125, 190);
				Button bs=new Button("Submit");
				bs.relocate(165, 250);
				bs.getStyleClass().add("btn");
				//ts2.setText(dp.getValue());
				Pane pane2=new Pane();
				pane2.getChildren().addAll(bs,dp,ls2,ls3,ts6);
				pane2.setStyle("-fx-background-color:rgb(6,90,167)");
				
				try{
					String sql="select Roll from user_information where Name='"+tu.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						ts.setText(rset.getString(1));
					}
				}catch(Exception ex){
					
				}
				Stage stage2=new Stage();
				Scene scene2=new Scene(pane2,400,330);
				scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
				stage2.setScene(scene2);
				stage2.show();
				bs.setOnAction(ex ->{
					try{
						String sql="insert into order_launch(Roll,Meal,Meal2,Meal3,Price,Date,RoomNo) values('"+ts.getText()+"','"+ts3.getText()+"','"+ts4.getText()+"','"+ts5.getText()+"','"+ts2.getText()+"','"+dp.getValue()+"','"+ts6.getText()+"')";
						statement.executeUpdate(sql);
						System.out.print("data updated");
					}catch(Exception ey){
						System.out.print("Problem");
					}
				});
				
			});
		}
	}
	
	
	public class showpriced extends Button{
		Label l=new Label("Price for the Order at Dinner");
		Label l2=new Label();
		Label l3=new Label();
		Label l4=new Label();
		Label l5=new Label("------------------------------");
		Label l6=new Label("Total");
		Label l7=new Label();
		Label l8=new Label();
		Label l9=new Label();
		Label l0=new Label();
		Label l11=new Label();
		Button b=new Button("Order Now");
		TextField ts=new TextField();
		TextField ts2=new TextField();
		TextField ts3=new TextField();
		TextField ts4=new TextField();
		TextField ts5=new TextField();
		TextField ts6=new TextField();
		public void showpriced(){
			
			Pane pane=new Pane();
			pane.setPrefSize(300, 400);
			pane.setStyle("-fx-background-color:rgb(6,90,157)");
			pane.getChildren().addAll(l,l2,l3,l4,l5,l6,l7,l8,l9,l0,l11,b);
			l.getStyleClass().add("lbl");
			l.relocate(25, 50);
			l2.relocate(40, 100);
			l2.getStyleClass().add("lbl");
			l2.setText(cb4.getValue());
			l3.relocate(40, 150);
			l3.getStyleClass().add("lbl");
			l3.setText(cb5.getValue());
			l4.relocate(40, 200);
			l4.getStyleClass().add("lbl");
			l4.setText(cb6.getValue());
			l5.relocate(30, 225);
			l5.getStyleClass().add("lbl");
			l6.relocate(40, 260);
			l6.getStyleClass().add("lbl");
			l7.setText("Price : "+t4.getText());
			l7.relocate(180, 100);
			l7.getStyleClass().add("lbl");
			l8.setText("Price : "+t5.getText());
			l8.relocate(180, 150);
			l8.getStyleClass().add("lbl");
			l9.setText("Price : "+t6.getText());
			l9.relocate(180, 200);
			l9.getStyleClass().add("lbl");
			//calculate SUM
			int s=Integer.valueOf(t4.getText());
			int s2=Integer.valueOf(t5.getText());
			int s3=Integer.valueOf(t6.getText());
			String s4=String.valueOf(s+s2+s3);
			//
			
			l0.setText(s4);
			l0.relocate(240, 260);
			l0.getStyleClass().add("lbl");
			b.getStyleClass().add("btn");
			b.relocate(175, 330);
			
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			b.setOnAction(e ->{
				initializeDB();
				DatePicker dp=new DatePicker();
				//Label ls=new Label("Enter Roll");
				//ls.getStyleClass().add("lbl");
				Label ls2=new Label("Select Date");
				ls2.getStyleClass().add("lbl");
				Label ls3=new Label("Room No.");
				ls3.getStyleClass().add("lbl");
				ls2.relocate(152, 40);
				ts.relocate(125, 60);
				//ls2.relocate(152, 100);
				ls3.relocate(160,140 );
				dp.relocate(115, 90);
				//ts2.relocate(150, 100);
				ts2.setText(l0.getText());
				ts3.setText(l2.getText());
				ts4.setText(l3.getText());
				ts5.setText(l4.getText());
				ts6.relocate(125, 190);
				Button bs=new Button("Submit");
				bs.relocate(165, 250);
				bs.getStyleClass().add("btn");
				//ts2.setText(dp.getValue());
				Pane pane2=new Pane();
				pane2.getChildren().addAll(bs,dp,ls2,ls3,ts6);
				pane2.setStyle("-fx-background-color:rgb(6,90,167)");
				
				try{
					String sql="select Roll from user_information where Name='"+tu.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						ts.setText(rset.getString(1));
					}
				}catch(Exception ex){
					
				}
				Stage stage2=new Stage();
				Scene scene2=new Scene(pane2,400,330);
				scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
				stage2.setScene(scene2);
				stage2.show();
				bs.setOnAction(ex ->{
					try{
						String sql="insert into order_dinner(Roll,Meal,Meal2,Meal3,Price,Date,RoomNo) values('"+ts.getText()+"','"+ts3.getText()+"','"+ts4.getText()+"','"+ts5.getText()+"','"+ts2.getText()+"','"+dp.getValue()+"','"+ts6.getText()+"')";
						statement.executeUpdate(sql);
						System.out.print("data updated");
					}catch(Exception ey){
						System.out.print("Problem");
					}
				});
				
			});
		}
	}
	public class mlist extends Button{
		Button b=new Button("For Launch");
		Button b2=new Button("For Dinner.");
		public void mlist(){
			
			Pane pane=new Pane();
			pane.setStyle("-fx-background-color:rgb(6,90,157)");
			pane.getChildren().addAll(b,b2,dpm);
			dpm.relocate(65, 80);
			b.relocate(105, 130);
			b.getStyleClass().add("btn");
			b2.relocate(105, 180);
			b2.getStyleClass().add("btn");
			Stage stage =new Stage();
			Scene scene=new Scene(pane,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			b.setOnAction(e ->{
				launchlist ll=new launchlist();
				ll.launchlist();
			});
			b2.setOnAction(e ->{
				dinnerlist dl=new dinnerlist();
				dl.dinnerlist();
			});
		}
	}
	public class launchlist extends Button{
		ObservableList<ObservableList> data;
	    TableView tableview=new TableView();
		public void launchlist(){
			
			data = FXCollections.observableArrayList();
			try{

				String query="select user_information.Name,order_launch.Roll,order_launch.RoomNo,order_launch.Meal,order_launch.Meal2,order_launch.Meal3,order_launch.Price,order_launch.Date from order_launch,user_information where order_launch.Roll=user_information.Roll and order_launch.Date='"+dpm.getValue()+"' and user_information.Name='"+tu.getText()+"'";
				ResultSet rset = statement.executeQuery(query);
	            for(int i=0 ; i<rset.getMetaData().getColumnCount(); i++){
	                final int j = i;                
	                TableColumn col = new TableColumn(rset.getMetaData().getColumnName(i+1));
	                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
	                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
	                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
	                    }                    
	                });
	                col.setMinWidth(60);
		               col.setStyle("-fx-font-size:15");
	                tableview.getColumns().addAll(col); 
	                //System.out.println("Column ["+i+"] ");
	            }
	            while(rset.next()){
	                ObservableList<String> row = FXCollections.observableArrayList();
	                for(int i=1 ; i<=rset.getMetaData().getColumnCount(); i++){
	                    row.add(rset.getString(i));
	                }
	               // System.out.println("Row [1] added "+row );
	                data.add(row);

	            }
	            tableview.setItems(data);
	           
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
			Stage stage=new Stage();
			
			Scene scene=new Scene(tableview);
			stage.setScene(scene);
			stage.show();

		}
	}
	public class dinnerlist extends Button{
		ObservableList<ObservableList> data;
	    TableView tableview=new TableView();
		public void dinnerlist(){
			data = FXCollections.observableArrayList();
			try{

				String query="select user_information.Name,order_dinner.Roll,order_dinner.RoomNo,order_dinner.Meal,order_dinner.Meal2,order_dinner.Meal3,order_dinner.Price,order_dinner.Date from order_dinner,user_information where order_dinner.Roll=user_information.Roll and order_dinner.Date='"+dpm.getValue()+"' and user_information.Name='"+tu.getText()+"'";
				ResultSet rset = statement.executeQuery(query);
	            for(int i=0 ; i<rset.getMetaData().getColumnCount(); i++){
	                final int j = i;                
	                TableColumn col = new TableColumn(rset.getMetaData().getColumnName(i+1));
	                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
	                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
	                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
	                    }                    
	                });
	                col.setMinWidth(60);
		               col.setStyle("-fx-font-size:15");
	                tableview.getColumns().addAll(col); 
	                //System.out.println("Column ["+i+"] ");
	            }
	            while(rset.next()){
	                ObservableList<String> row = FXCollections.observableArrayList();
	                for(int i=1 ; i<=rset.getMetaData().getColumnCount(); i++){
	                    row.add(rset.getString(i));
	                }
	               // System.out.println("Row [1] added "+row );
	                data.add(row);

	            }
	            tableview.setItems(data);
	           
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
			Stage stage=new Stage();
			
			Scene scene=new Scene(tableview);
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public class pricetotal extends Button{
		DatePicker dpp=new DatePicker();
		DatePicker dpp2=new DatePicker();
		Label lp=new Label("Enter Date from");
		Label lp2=new Label("to");
		Button bp=new Button("Cost for Launch");
		Button bp2=new Button("Cost for Dinner");
		public void pricetotal(){
			Pane pane=new Pane();
			pane.setStyle("-fx-background-color:rgb(6,90,157)");
			pane.getChildren().addAll(lp,lp2,dpp,dpp2,bp,bp2);
			lp.relocate(80, 80);
			lp.getStyleClass().add("lbl");
			lp2.relocate(140, 180);
			lp2.getStyleClass().add("lbl");
			dpp.relocate(65, 130);
			dpp2.relocate(65, 230);
			bp.relocate(90, 280);
			bp.getStyleClass().add("btn");
			bp2.relocate(90, 330);
			bp2.getStyleClass().add("btn");
			Stage stage =new Stage();
			Scene scene=new Scene(pane,300,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			bp.setOnAction(e ->{
				Label l=new Label("Student Name : ");
				Label l2=new Label("Roll : ");
				Label l3=new Label("Total Cost : ");
				Label l4=new Label();
				Label l5=new Label();						
				Label l6=new Label();
				Label l7=new Label();
				Pane pane2=new Pane();pane2.setStyle("-fx-background-color:rgb(6,90,157)");
				pane2.getChildren().addAll(l,l2,l3,l4,l5,l6,l7);
				l.relocate(50,50);
				l.getStyleClass().add("lbl");
				l2.relocate(145,100);
				l2.getStyleClass().add("lbl");
				l3.relocate(90,150);
				l3.getStyleClass().add("lbl");
				l4.relocate(220,50);
				l4.getStyleClass().add("lbl");
				l5.relocate(220,100);
				l5.getStyleClass().add("lbl");
				l6.relocate(220,150);
				l6.getStyleClass().add("lbl");
				l7.relocate(50,200);
				l7.getStyleClass().add("lbl");
				Stage stage2=new Stage();
				Scene scene2=new Scene(pane2,450,300);
				scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage2.setScene(scene2);
				stage2.show();
				try{
					String sql="select user_information.Name,order_launch.Roll,sum(Price) from order_launch,user_information where order_launch.Roll=user_information.Roll and order_launch.Date between '"+dpp.getValue()+"' and '"+dpp2.getValue()+"' and user_information.Name='"+tu.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						l4.setText(rset.getString(1));
						l5.setText(rset.getString(2));
						l6.setText(rset.getString(3));
						l7.setText("From :  "+dpp.getValue()+"  to :  "+dpp2.getValue());
					}
				}catch(Exception ex){
					
				}
			});
			bp2.setOnAction(e ->{
				Label l=new Label("Student Name : ");
				Label l2=new Label("Roll : ");
				Label l3=new Label("Total Cost : ");
				Label l4=new Label();
				Label l5=new Label();						
				Label l6=new Label();
				Label l7=new Label();
				Pane pane2=new Pane();pane2.setStyle("-fx-background-color:rgb(6,90,157)");
				pane2.getChildren().addAll(l,l2,l3,l4,l5,l6,l7);
				l.relocate(50,50);
				l.getStyleClass().add("lbl");
				l2.relocate(145,100);
				l2.getStyleClass().add("lbl");
				l3.relocate(90,150);
				l3.getStyleClass().add("lbl");
				l4.relocate(220,50);
				l4.getStyleClass().add("lbl");
				l5.relocate(220,100);
				l5.getStyleClass().add("lbl");
				l6.relocate(220,150);
				l6.getStyleClass().add("lbl");
				l7.relocate(50,200);
				l7.getStyleClass().add("lbl");
				Stage stage2=new Stage();
				Scene scene2=new Scene(pane2,450,300);
				scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage2.setScene(scene2);
				stage2.show();
				try{
					String sql="select user_information.Name,order_dinner.Roll,sum(Price) from order_dinner,user_information where order_dinner.Roll=user_information.Roll and order_dinner.Date between '"+dpp.getValue()+"' and '"+dpp2.getValue()+"' and user_information.Name='"+tu.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						l4.setText(rset.getString(1));
						l5.setText(rset.getString(2));
						l6.setText(rset.getString(3));
						l7.setText("From :  "+dpp.getValue()+"  to :  "+dpp2.getValue());
					
					}
				}catch(Exception ex){
					
				}
			});
		}
	}
}
