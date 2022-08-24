package Events;

import com.google.common.eventbus.Subscribe;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Listener {
    @Subscribe
    public void onLoginEvent(LoginEvent loginEvent){
        Alert alert = new Alert(Alert.AlertType.NONE, "Logged successfully", ButtonType.OK);
        alert.show();
    }
}
