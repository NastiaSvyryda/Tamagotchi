package world.ucode.animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.pet.PetAction;
import world.ucode.pet.PetType;


public class MinionAnimation {
    PetType type;
    private final ImageView AnimationView;
    private final Timeline timeline;


    public MinionAnimation(PetType type, ImageView AnimationView, ImageView MinionView) {
        this.AnimationView = AnimationView;
        this.type = type;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(4), actionEvent -> AnimationView.setVisible(false)));
        AnimationView.setVisible(false);
        MinionView.setImage(new Image("/Images/" + type.toString() + "/" + type.toString() + ".gif"));
    }

    public void HandleAnimation(PetAction action) {
        AnimationView.setImage(GetImage(action));
        AnimationView.setVisible(true);
        timeline.play();
    }

    private Image GetImage(PetAction action) {
        return new Image("/Images/" + type.toString() + "/" + action.toString() + ".gif", 800, 600, false, false);
    }
}
