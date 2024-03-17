package com.brendondias.game.launcher.gameModes;


import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;

import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.image;

public class ItachiComponent extends Component {

    private PhysicsComponent physics;
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk;


    public ItachiComponent(){
        Image image =image("itachiComplete_strip10.png");

        animIdle = new AnimationChannel(image,10,71,87, Duration.seconds(1),0,3);

        animWalk = new AnimationChannel(image,10,71,87,Duration.seconds(1),4,9);

        texture = new AnimatedTexture(animIdle);

        texture.loop();
    }

    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(new Point2D(15,15));
        entity.getViewComponent().addChild(texture);
    }

    @Override
    public void onUpdate(double tpf) {
        if(physics.isMovingX()){
            if(texture.getAnimationChannel() != animWalk){
                texture.loopAnimationChannel(animWalk);
            }
        }else{
            if(texture.getAnimationChannel() != animIdle){
                texture.loopAnimationChannel(animIdle);
            }
        }
    }

    public void left(){
        getEntity().setScaleX(-1);
        physics.setVelocityX(-170);

    }

    public void right(){
        getEntity().setScaleX(+1);
        physics.setVelocityX(170);
    }

    public void stop(){
        physics.setVelocityX(0);
    }

    public void stopY(){

    }


}
