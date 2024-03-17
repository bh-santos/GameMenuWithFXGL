package com.brendondias.game.launcher.gameModes;

import com.almasb.fxgl.core.math.Vec3;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.scene3d.Cone;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAssetLoader;

public class Game3dFactory implements EntityFactory {

    @Spawns("crystal")
    public Entity newCrystal(SpawnData data){

        var view2 = getAssetLoader().loadModel3D("third.obj");
        view2.setScaleX(10);
        view2.setScaleY(10);
        view2.setScaleZ(10);
        view2.setRotate(178);
        view2.setTranslateX(1);
        view2.setTranslateY(3);
        view2.setTranslateZ(1);
        return entityBuilder(data)
                .type(EntityType.CRYSTAL)
                .bbox(BoundingShape.box3D(1,1,1))

                .view(view2)
                .collidable()
                .with(new ProjectileComponent(new Point2D(0,1),10).allowRotation(false))
                .build();
    }

    @Spawns("ground")
    public Entity newGroud(SpawnData Data){
        var view = getAssetLoader().loadModel3D("ground.obj");
        view.setTranslateX(0);
        view.setTranslateY(3);
        view.setTranslateZ(0);
        view.setScaleX(10);
        view.setScaleY(10);
        view.setScaleZ(10);

        view.getTransforms().add(new Rotate(180, Rotate.X_AXIS));

        return entityBuilder()
                .type(EntityType.GROUND)
                .bbox(BoundingShape.box3D(30,0.4,10))
                .view(view)
                .collidable()
                .build();
    }
}
