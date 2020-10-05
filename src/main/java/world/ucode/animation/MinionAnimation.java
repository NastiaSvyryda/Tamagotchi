package world.ucode.animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.pet.Minion;
import world.ucode.pet.PetAction;
import world.ucode.pet.PetType;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MinionAnimation {
    private Image Happy;
    private Image Sad;
    private Image Eat;
    private Image Drink;
    private Image Play;
    private Image GetMedicine;
    private Image Clean;
    private final ImageView AnimationView;
    private final Timeline timeline;

    private final Map<PetAction, Image> Images;

    public MinionAnimation(PetType type, ImageView AnimationView) {
        this.AnimationView = AnimationView;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(4), actionEvent -> AnimationView.setImage(Happy)));
        if (type == PetType.BOB)
            CreateBobAnimation();
        else if (type == PetType.KEVIN)
            CreateKevinAnimation();
        else
            CreateStuartAnimation();
        Images = new HashMap<PetAction, Image>() {{
            put(PetAction.PLAY, Play);
            put(PetAction.FEED, Eat);
            put(PetAction.GIVE_WATER, Drink);
            put(PetAction.GIVE_MEDICINE, GetMedicine);
            put(PetAction.CLEAN_UP, Clean);
        }};
        AnimationView.setImage(Happy);
    }

    public void HandleAnimation(PetAction action) {
        AnimationView.setImage(Images.get(action));
        timeline.play();
    }
    private void CreateBobAnimation() {//сделать один конструктор
        Happy = new Image("/Bob.gif");
        Sad = new Image("/shockedBob.gif");//
        Eat = new Image("/BobEat.gif");
        Drink = new Image("/BobEat2.gif");
        Play = new Image("/BobPlay.gif");
        GetMedicine = new Image("/GameOver.gif");//
        Clean = new Image("/GameOver.gif");//
    }
    private void CreateKevinAnimation() {
        Happy = new Image("/Kevin.gif");
        Sad = new Image("/GameOver.gif");//
        Eat = new Image("/KevinEat.gif");
        Drink = new Image("/GameOver.gif");//
        Play = new Image("/KevinPlay2.gif");
        GetMedicine = new Image("/GameOver.gif");//
        Clean = new Image("/KevinShower.gif");
    }
    private void CreateStuartAnimation() {
        Happy = new Image("/Stuart.gif");
        Sad = new Image("/sadStuart.gif");
        Eat = new Image("/StuartEat.gif");
        Drink = new Image("/StuartDrink.gif");
        Play = new Image("/StuartPlay.gif");
        GetMedicine = new Image("/StuartMedicine.gif");//
        Clean = new Image("/StuartShower.gif", 800, 400, false, false);
    }
}
