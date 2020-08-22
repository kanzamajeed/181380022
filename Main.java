package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.plaf.InsetsUIResource;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main extends Application {
    private Label firstNameLb,lastNameLb,yearLb,monthLb,dayLb,titleLb , outputLb;
    private TextField firstNameTf,lastNameTf,yearTf,monthTf,dayTf;
    private Button calculateHeartRateBtn;
    private VBox root,yearVbox,monthVbox,dayVbox;
    private HBox dateHbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        titleLb=new Label("Heart Rate Calculation");
        titleLb.setStyle("-fx-font:26px Arial");
        firstNameLb = new Label("First Name");
        lastNameLb = new Label("last Name");
        yearLb = new Label("year");
        monthLb = new Label("month");
        dayLb = new Label("day");
        outputLb = new Label();
        outputLb.setStyle("-fx-font:23px Ariel;-fx-text-fill:blue");
        firstNameTf = new TextField();
        lastNameTf = new TextField();
        yearTf = new TextField();
        monthTf = new TextField();
        dayTf = new TextField();
        calculateHeartRateBtn = new Button("Calculate Heart Rate");
        yearVbox = new VBox();
        yearVbox.getChildren().addAll(yearLb, yearTf);
        monthVbox = new VBox();
        monthVbox.getChildren().addAll(monthLb, monthTf);
        dayVbox = new VBox();
        dayVbox.getChildren().addAll(dayLb, dayTf);
        dateHbox = new HBox();
        dateHbox.getChildren().addAll(yearVbox, monthVbox, dayVbox);
        root = new VBox();
        root.getChildren().addAll(titleLb, firstNameLb, firstNameTf, lastNameLb, lastNameTf, dateHbox, calculateHeartRateBtn,outputLb);
        calculateHeartRateBtn.setOnAction(e-> {
            int year = Integer.parseInt(yearTf.getText());
            String monthText = monthTf.getText();
            int day = Integer.parseInt(dayTf.getText());
            String fullName = firstNameTf.getText() + "" + lastNameTf.getText();
            Month month = getMonth(monthText);
            int ageInYears = getAgeInYears(year, month, day);
            double maximumHeartRate = getHeartRate(ageInYears);
            String targetHeartRate =  getTargetHeartRate(maximumHeartRate);
            String result = "Name:" + fullName + "\n"
                    +"Age:"  + ageInYears +"\n"
                    +"Maximum Heart Rate:" + maximumHeartRate + "\n"
                    + targetHeartRate;
            outputLb.setText(result);
        });
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Heart Rate Calculator");
        primaryStage.show();
    }


    private int getAgeInYears(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }

    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("april")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("may")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("june")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("NOVEMBER")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("DECEMBER")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;
    }
    private double getHeartRate(int year){
        return  220 - year;
    }
    private String getTargetHeartRate(double heartRate){
        return (int)(heartRate * 0.5) + " - " + (int)(heartRate * 0.85);
    }


    public static void main(String[] args) {
        launch(args);
    }
}



