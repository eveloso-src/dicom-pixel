package laucher;

import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
public class ProgressBarr  extends Application {
 
    @Override
    public void start(Stage stage) throws InterruptedException {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Progress Controls");
 
        final Slider slider = new Slider(0,50,0);
//        slider.setMin(0);
//        slider.setMax(50);
        slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		
        final ProgressBar pb = new ProgressBar(0);
        final ProgressIndicator pi = new ProgressIndicator(0);
 
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            	System.out.println(new_val);
                pb.setProgress(new_val.doubleValue()/50);
                pi.setProgress(new_val.doubleValue()/50);
            }
        });
        System.out.println("start emi");
        ThreadEmi t = new ThreadEmi(slider);
        t.start();
        final HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(slider, pb, pi);
        scene.setRoot(hb);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    public class ThreadEmi extends Thread {
    	Slider slider;
    	public ThreadEmi(Slider slider) {
			// TODO Auto-generated constructor stub
    		this.slider = slider;
		}

		@Override
    	public void run() {
    		// TODO Auto-generated method stub
//    		super.run();
    		try {
    			System.out.println("start");
				Thread.sleep(1000);
				slider.setValue(8);
				Thread.sleep(1000);
				slider.setValue(slider.getValue()+1);
				Thread.sleep(1000);
				slider.setValue(slider.getValue()+1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }
}
