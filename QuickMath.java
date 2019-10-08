/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathcoach;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author anthonyreyes
 */
public class QuickMath extends Application {
    
    Random rand = new Random();
    
    Label title = new Label("QuiclMatch");
    Button startBtn = new Button("Start Practicing");
    Button backBtn = new Button("Back");
    Text txt1 = new Text();
    Text txt2 = new Text();
    Text score = new Text("Score: " + 0);
    
    Button easyLvl = new Button("Easy");
    Button mediumLvl = new Button("Medium");
    Button hardLvl = new Button("Hard");
    
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    
    @Override
    public void start(Stage PrimaryStage) {
        
        title.setFont(Font.font("Avenir", 50));
        
        startBtn.setFont(Font.font("Avenir", 20));
        startBtn.setStyle("-fx-background-color: #69bed1; -fx-border-color: #69bed1; -fx-border-width: 2px;");
        
        backBtn.setFont(Font.font("Avenir", 15));
        backBtn.setStyle("-fx-background-color: #69bed1; -fx-border-color: #69bed1; -fx-border-width: 2px;");
        
        btn1.setPrefSize(150,150);
        btn2.setPrefSize(150,150);
        btn3.setPrefSize(150,150);
        btn4.setPrefSize(150,150);
        
        btn1.setFont(Font.font("Arial", 50));
        btn2.setFont(Font.font("Arial", 50));
        btn3.setFont(Font.font("Arial", 50));
        btn4.setFont(Font.font("Arial", 50));
        
        btn1.setStyle("-fx-background-color:#69bed1; -fx-border-color: #69bed1; -fx-border-width: 2px;");
        btn2.setStyle("-fx-background-color:#69bed1; -fx-border-color: #69bed1; -fx-border-width: 2px;");
        btn3.setStyle("-fx-background-color:#69bed1; -fx-border-color: #69bed1; -fx-border-width: 2px;");
        btn4.setStyle("-fx-background-color:#69bed1; -fx-border-color: #69bed1; -fx-border-width: 2px;");
        
        easyLvl.setFont(Font.font("Arial", 35));
        mediumLvl.setFont(Font.font("Arial", 35));
        hardLvl.setFont(Font.font("Arial", 35));
        
        easyLvl.setStyle("-fx-background-color:#69bed1; -fx-border-color: #69bed1; -fx-border-width: 2px;");
        mediumLvl.setStyle("-fx-background-color:#5499a8; -fx-border-color: #5499a8; -fx-border-width: 2px;");
        hardLvl.setStyle("-fx-background-color:#5499a8; -fx-border-color: #5499a8; -fx-border-width: 2px;");
        
        //Game Screen
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.add(btn1,0,0);
        gp.add(btn2,1,0);
        gp.add(btn3,0,1);
        gp.add(btn4,1,1);
        
        //Game Screen Composition
        VBox vb = new VBox();
        vb.setSpacing(15);
        vb.getChildren().addAll(txt1, txt2, gp, score);
        vb.setAlignment(Pos.CENTER);
        
        //Levels Screen
        VBox lp = new VBox();
        lp.setSpacing(15);
        lp.getChildren().addAll(easyLvl, mediumLvl, hardLvl);
        lp.setAlignment(Pos.CENTER);
                        
        //Home Screen
        BorderPane bpane = new BorderPane();
        BorderPane.setMargin(title, new Insets(30, 0, 0, 0));
        bpane.setStyle("-fx-background-color: #79d8ed;");
        bpane.setTop(title);
        bpane.setAlignment(title, Pos.TOP_CENTER);
        bpane.setCenter(startBtn);
        
        startBtn.setOnAction( e ->{
            bpane.setCenter(lp);
        });
        
        easyLvl.setOnAction( e -> {
            
            BorderPane.setMargin(backBtn, new Insets(20, 0, 0, 20));
            bpane.setTop(backBtn);
            bpane.setAlignment(backBtn, Pos.TOP_LEFT);
            bpane.setCenter(vb);
            
            gp.setAlignment(Pos.CENTER);
            
            startGame();
            
        });
        
        backBtn.setOnAction( e -> {
            bpane.setTop(title);
            bpane.setAlignment(title, Pos.TOP_CENTER);
            bpane.setCenter(startBtn);
        });
        
        btn1.setOnAction( e -> {
            checkAnswer(Integer.parseInt(btn1.getText()));
        });
        
        btn2.setOnAction( e -> {
            checkAnswer(Integer.parseInt(btn2.getText()));
        });
        
        btn3.setOnAction( e -> {
            checkAnswer(Integer.parseInt(btn3.getText()));
        });
        
        btn4.setOnAction( e -> {
            checkAnswer(Integer.parseInt(btn4.getText()));
        });
        
        Scene scene = new Scene(bpane, 375,600);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Quick Math");
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
        int num1;
        int num2;
        int answer;
        
        int points = 0;
        
        public void numberRange(){
            
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
            answer = num1 + num2;
            
            int addNumber = 3;
            
            ArrayList<Integer> randomNumber = new ArrayList<Integer>();
            
            randomNumber.add(answer);
            
            for(int x=0; x<addNumber; x++){
                int num = rand.nextInt(21);
                while(randomNumber.contains(num)){
                    num=rand.nextInt(21);
                }
                randomNumber.add(num);
            }
            
            System.out.println(randomNumber);
            
            int arraySize = randomNumber.size();
            
            for(int i=0; i<1; i++){
                
                int randNum1 = rand.nextInt(randomNumber.size());
                btn1.setText(Integer.toString(randomNumber.get(randNum1)));
                randomNumber.remove(randNum1);
                
                int randNum2 = rand.nextInt(randomNumber.size());
                btn2.setText(Integer.toString(randomNumber.get(randNum2)));
                randomNumber.remove(randNum2);
                
                int randNum3 = rand.nextInt(randomNumber.size());
                btn3.setText(Integer.toString(randomNumber.get(randNum3)));
                randomNumber.remove(randNum3);
                
                int randNum4 = rand.nextInt(randomNumber.size());
                btn4.setText(Integer.toString(randomNumber.get(randNum4)));
                randomNumber.remove(randNum4);
            }
            
            
            
        }
        
        public void startGame(){
            
            numberRange();
            
            txt1.setText(num1 + " + " + num2);
            txt1.setFont(Font.font("Arial", 75));
            txt2.setText("");
            
        }
        
        public void checkAnswer(int btn){
                        
            if (btn != answer){
                txt2.setText("Wrong! Try Again");
                txt2.setFont(Font.font("Arial", 20));
                txt2.setFill(Color.RED);
            } else {
                startGame();
                txt2.setText("");
            }
            
        }
    
}