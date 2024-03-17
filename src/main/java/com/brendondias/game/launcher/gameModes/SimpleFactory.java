package com.brendondias.game.launcher.gameModes;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.brendondias.game.util.AssetNames;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class SimpleFactory implements EntityFactory {

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data){
        return FXGL.entityBuilder(data)
                //.view(new Rectangle(40,40, Color.RED))
                .view("sandVillageIcon.png")
                .with(new ProjectileComponent(new Point2D(1,0), 150))
                .buildAndAttach();

    }

    @Spawns("ally")
    public Entity newAlly(SpawnData data){
        var texture = FXGL.texture("sandVillageIcon.png").multiplyColor(Color.GREEN);
        return FXGL.entityBuilder(data)
                //.view(new Rectangle(40,40, Color.RED))

                .view(texture)
                .with(new ProjectileComponent(new Point2D(-1,0), 150))
                .buildAndAttach();
    }
    @Spawns("playerx")
    public Entity newPlayer(SpawnData data){
        System.out.println("Teste");
        return FXGL.entityBuilder(data)
                .view(new Rectangle(40,40,Color.RED))
                .with(new ProjectileComponent(new Point2D(-1,0), 150))
                .buildAndAttach();
    }


}
