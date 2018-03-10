package application;


import java.io.File;
import java.sql.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.*;

public class HallManagementMain extends Application{
	Button b=new Button("Admin");
	Button b2=new Button("User");
	Label l=new Label("Balance Your Diet.");
	Button b3=new Button();
	Button b4=new Button();
	File file=new File("admin.png");
	Image i=new Image(file.toURI().toString());
	ImageView ii=new ImageView(i);
	File file2=new File("person.png");
	Image i2=new Image(file2.toURI().toString());
	ImageView ii2=new ImageView(i2);
	File file3=new File("002.gif");
	Image i3=new Image(file3.toURI().toString());
	ImageView ii3=new ImageView(i3);
	DatePicker dp=new DatePicker();
	Statement statement;
	Connection connection;
	int j=5;
	Timeline timeline=new Timeline();
	public void start(Stage stage){
		
		
		initializeDB();
		Pane pane=new Pane();
		pane.setPrefSize(800, 450);
		pane.setStyle("-fx-background-color:rgb(6,90,157)");
		pane.getChildren().addAll(b,b2,l,b3,b4);
		b.setPrefSize(100, 40);
		b2.setPrefSize(100, 40);
		b.getStyleClass().add("btn");
		b2.getStyleClass().add("btn");
		l.setStyle("-fx-font-size:30px;-fx-text-fill:white;");
		l.relocate(285, 70);
		b3.setPrefSize(100, 144);
		b3.relocate(190, 150);
		b3.setGraphic(ii);
		b3.getStyleClass().add("btnt");
		b4.setPrefSize(100, 144);
		b4.relocate(490, 150);
		b4.setGraphic(ii2);
		b4.getStyleClass().add("btnt");
		b.relocate(200, 350);
		b2.relocate(500, 350);
		Scene scene=new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		b.setOnAction(e ->{
			Button bl=new Button("Submit");
			TextField t=new TextField();
			PasswordField p=new PasswordField();
			Label l=new Label("Enter Name:");
			Label l2=new Label("Password:");
			Pane pane2=new Pane();
			pane2.getChildren().addAll(l,t,l2,p,bl);
			pane2.setStyle("-fx-background-color:rgb(6,90,157)");
			l.relocate(49, 80);
			l.getStyleClass().add("lbl");
			t.relocate(180, 80);
			t.getStyleClass().add("txt");
			l2.relocate(70, 130);
			l2.getStyleClass().add("lbl");
			p.relocate(180, 130);
			p.getStyleClass().add("txt");
			bl.relocate(168, 200);
			bl.getStyleClass().add("btn");
			Stage stage2=new Stage();
			Scene scene2=new Scene(pane2,400,300);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage2.setScene(scene2);
			stage2.show();
			bl.setOnAction(ex ->{
				File file=new File("lo.jpg");
				Image i=new Image(file.toURI().toString());
				ImageView ii=new ImageView(i);
				Pane pane3=new Pane();
				
				Button bw=new Button();
				Label lw=new Label("Please Wait...");
				pane3.setStyle("-fx-background-color:rgb(3,56,87)");
				
				pane3.getChildren().addAll(ii,bw,lw);
				bw.setGraphic(ii3);
				bw.getStyleClass().add("btnt");
				bw.relocate(12, 15);
				lw.getStyleClass().add("lbl");
				lw.relocate(60, 18);
				Stage stage3=new Stage();
				Scene scene3=new Scene(pane3,190,70);
				scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage3.setScene(scene3);
				stage3.show();
				try{
					String sql="select * from admin where Name='"+t.getText()+"' and ID='"+p.getText()+"'";
					ResultSet rset=statement.executeQuery(sql);
					while(rset.next()){
						timeline.setCycleCount(Timeline.INDEFINITE);
						
						if (timeline != null) {      
							timeline.stop();    
							}        
						timeline = new Timeline();  
						timeline.setCycleCount(Timeline.INDEFINITE);  

						timeline.getKeyFrames().add(  
								new KeyFrame(Duration.seconds(1),  
										 new EventHandler<ActionEvent>() {   
									// KeyFrame event handler   
									public void handle(ActionEvent event) {  
										j--;   
										if (j <= 0) {
											timeline.stop();
											stage3.hide();
											//destination
											list ls=new list();
											ls.list();
										}   
									}    
								}));   
								timeline.playFromStart();
					}
				}catch(Exception ey){
					
				}
				
				
			});
			
		});
		b2.setOnAction(e ->{
			HallManagement hm=new HallManagement();
			hm.HallManagement();
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

	public static void main(String[] args) {
		launch(args);

	}
	public class list extends Button{
		Button b=new Button("Show the Meal List for Launch.");
		TextField t=new TextField();
		Label l=new Label("Enter Date");
		Button b2=new Button("Show the Meal List for Dinner..");
		public void list(){
			Pane pane=new Pane();
			
			pane.setPrefSize(400, 400);
			pane.setStyle("-fx-background-color:rgb(6,90,157)");
			pane.getChildren().addAll(b,l,dp,b2);
			b.getStyleClass().add("btn");
			b.relocate(90, 200);
			l.relocate(153,80);
			l.getStyleClass().add("lbl");
			dp.relocate(115, 130);
			t.getStyleClass().add("txt");
			b2.getStyleClass().add("btn");
			b2.relocate(90, 260);
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			b.setOnAction(e ->{
				launch l=new launch();
				l.launch();
			});
			b2.setOnAction(e ->{
				dinner d=new dinner();
				d.dinner();
			});
		}
	}
	public class launch extends Button{
		Statement statement;
		Connection connection;
		ObservableList<ObservableList> data;
	    TableView tableview=new TableView();
		public void launch(){
			initializeDB();
			 data = FXCollections.observableArrayList();
			try{

				String query="select user_information.Name,order_launch.Roll,order_launch.RoomNo,order_launch.Meal,order_launch.Meal2,order_launch.Meal3,order_launch.Price,order_launch.Date from order_launch,user_information where order_launch.Roll=user_information.Roll and order_launch.Date='"+dp.getValue()+"'";
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
	}
	public class dinner extends Button{
		Statement statement;
		Connection connection;
		ObservableList<ObservableList> data;
	    TableView tableview=new TableView();
		public void dinner(){
			initializeDB();
			 data = FXCollections.observableArrayList();
			try{

				String query="select user_information.Name,order_dinner.Roll,order_dinner.RoomNo,order_dinner.Meal,order_dinner.Meal2,order_dinner.Meal3,order_dinner.Price,order_dinner.Date from order_dinner,user_information where order_dinner.Roll=user_information.Roll and order_dinner.Date='"+dp.getValue()+"'";
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
		               //col.setStyle("-fx-font-size:15");
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
	}

}
