package seedu.address.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;



public class MainPageInfoBox extends UiPart<Region> {

    private static final String FXML = "MainPageInfoBox.fxml";

    @javafx.fxml.FXML
    private StackPane datePane;

    @javafx.fxml.FXML
    private StackPane timePane;

    @javafx.fxml.FXML
    private StackPane greetingPane;

    @javafx.fxml.FXML
    private Text dateText;

    @javafx.fxml.FXML
    private Text timeText;

    @javafx.fxml.FXML
    private Text greetingText;

    private int minute;
    private int hour;
    private int second;
    private int date;
    private int month;
    private int year;
    private String greeting;

    /**
     * Creates a new MainPageInfoBox.
     *
     */
    public MainPageInfoBox() {
        super(FXML);
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar cal = Calendar.getInstance();
                    hour = cal.get(Calendar.HOUR_OF_DAY);
                    timeText.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
                    dateText.setText(new SimpleDateFormat("EEE, dd MMM").format(cal.getTime()));
                    if (hour < 12) {
                        greeting = "Good Morning!";
                    } else if (hour < 17) {
                        greeting = "Good Afternoon!";
                    } else {
                        greeting = "Good Evening!";
                    }
                    greetingText.setText(greeting);
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        //...
                    }
                }
            }
        };
        clock.start();

    }

}
