package com.brendondias.game.launcher.gameModes;

import com.almasb.fxgl.animation.AnimatedValue;
import com.almasb.fxgl.animation.AnimationBuilder;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ActivatorComponent;
import com.almasb.fxgl.dsl.components.EffectComponent;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.action.ActionComponent;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputCapture;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.pathfinding.CellMoveComponent;
import com.almasb.fxgl.physics.*;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import com.almasb.fxgl.texture.Texture;
import com.brendondias.game.launcher.NarutoNinjaWarApp;
import com.brendondias.game.util.AssetNames;
import com.brendondias.game.util.Effects;
import javafx.animation.Interpolator;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.geometry.Rectangle2D;
import javafx.scene.chart.Axis;
import javafx.scene.control.Control;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


import static com.almasb.fxgl.dsl.FXGLForKtKt.*;
import static com.brendondias.game.launcher.NarutoNinjaWarApp.camera;
import static com.brendondias.game.util.Effects.ShadowEffects.ORANGE_SHADOW;
import static com.brendondias.game.util.Effects.ShadowEffects.YELLOW_SHADOW;

public class GameFactory implements EntityFactory {

    @Spawns("battleField")
    public Entity newBattleField(SpawnData data){
        var view = new Box();
        view.setWidth(400);
        view.setHeight(400);
        view.setDepth(5);
        view.setScaleX(1);
        view.setScaleY(1);
        view.setScaleZ(1);
        PhongMaterial mat = new PhongMaterial(Color.ANTIQUEWHITE,texture(AssetNames.Textures.MAP).getImage(),
                texture(AssetNames.Textures.CHIDORI).getImage(),
                null,
                texture("chess.png").getImage());
        view.setMaterial(mat);
        view.getTransforms().add(new Rotate(90, Rotate.X_AXIS));
        view.getTransforms().add(new Rotate(180, Rotate.Z_AXIS));

       /* view.setTranslateX((1024-(view.getWidth()))/2);
        view.setTranslateY((576-(view.getHeight()))/2);*/



        return FXGL.entityBuilder(data)
                .type(EntityType.GROUND)
                //.view(new Rectangle(40,40, Color.RED))
                .bbox(BoundingShape.box3D(400,400,5))

                .collidable()
                .view(view)
                .at(0,0)
                .buildOrigin3DAndAttach();
    }

    @Spawns("background")
    public Entity newBackground(SpawnData data){
        var view = new Box();
        view.setWidth(10);
        view.setHeight(6);
        view.setDepth(1);
        view.setScaleX(1);
        view.setScaleY(1);
        view.setScaleZ(1);
        PhongMaterial mat = new PhongMaterial(Color.ANTIQUEWHITE,texture(AssetNames.Textures.BACKGROUND1).getImage(),
                texture(AssetNames.Textures.BACKGROUND1).getImage(),
                texture(AssetNames.Textures.BACKGROUND1).getImage(),
                texture(AssetNames.Textures.BACKGROUND1).getImage());
        view.setMaterial(mat);
        view.getTransforms().add(new Rotate(0, Rotate.X_AXIS));


        return FXGL.entityBuilder(data)
                .type(EntityType.CRYSTAL)
                //.view(new Rectangle(40,40, Color.RED))
                .bbox(BoundingShape.box3D(10,10,10))
                .view(view)
                .at(0,0)
                .buildOrigin3DAndAttach();
    }


    @Spawns("itachi")
    public Entity newItachi(SpawnData data){
        PhysicsComponent physicsComponent = new PhysicsComponent();
        return FXGL.entityBuilder(data)
                .type(EntityType.ITACHI)
                .bbox(new HitBox(BoundingShape.box(71,89)))
                .with(physicsComponent)
                .collidable()
                .with(new CollidableComponent(true))
                .with(new IrremovableComponent())
                .with(new ItachiComponent())
                .at(0,-97,0)
                .buildOrigin3DAndAttach();
    }


    @Spawns("nagato")
    public Entity newNagato(SpawnData data){
        Entity nagatoEntity;
        var view = texture("nagato_strip4.png");

        /*Texture frame1 = view.subTexture(new Rectangle2D(88*27,0,88,63));
        Texture frame2 = view.subTexture(new Rectangle2D(88*28,0,88,63));
        Texture frame3 = view.subTexture(new Rectangle2D(88*29,0,88,63));
        Texture frame4 = view.subTexture(new Rectangle2D(88*30,0,88,63));

        frame1.setScaleX(0.5);
        frame1.setScaleY(0.5);
        frame1.setScaleZ(0.5);
        frame2.setScaleX(0.5);
        frame2.setScaleY(0.5);
        frame2.setScaleZ(0.5);*/


        AnimationChannel nagato = new AnimationChannel(view.getImage(),4,(int)view.getWidth()/4,(int)view.getHeight(),Duration.seconds(0.5),0,3);
        AnimatedTexture nagatoAnimated = new AnimatedTexture(nagato);

        nagatoAnimated.setScaleX(-1);
        nagatoAnimated.setScaleY(1);
        nagatoAnimated.setScaleZ(1);
        nagatoAnimated.loopAnimationChannel(nagato);


        nagatoEntity =FXGL.entityBuilder(data)
                .type(EntityType.NAGATO)
                .viewWithBBox(nagatoAnimated)
                .buildOrigin3DAndAttach();




        return nagatoEntity;
    }
}
