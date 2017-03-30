package com.company.TSI.lab1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;


public class LineChartSample extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("BitStuffing");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("BitStuffing1");
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setCreateSymbols(false);

        lineChart.setTitle("BitStuffing");
        XYChart.Series series = new XYChart.Series();
        series.setName("'1' = '-|_' or '0' = '_|-'");
        ArrayList<String> elementsString = BitStuffing.doBitStuffing("A5 EC FE 1F A0");
        int counter = 0;
        System.out.println(Arrays.asList(elementsString));
        for(String element: elementsString){
            if (element.equals("1")) {
                series.getData().add(new XYChart.Data(counter, 1));
                series.getData().add(new XYChart.Data(counter+1, 1));
                series.getData().add(new XYChart.Data(counter+1, 0));
                series.getData().add(new XYChart.Data(counter+2, 0));
            } else {
                series.getData().add(new XYChart.Data(counter, 0));
                series.getData().add(new XYChart.Data(counter+1, 0));
                series.getData().add(new XYChart.Data(counter+1, 1));
                series.getData().add(new XYChart.Data(counter+2, 1));
            }
            counter += 2;
        }


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}