package com.brendondias.game.launcher.gameModes;

import com.almasb.fxgl.app.scene.Camera3D;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class TerrainFactory implements EntityFactory {

    @Spawns("block")
    public Entity newBlock(SpawnData data){
        Entity block;

        var caixa = new Box();
        caixa.setWidth(200);
        caixa.setHeight(200);

        caixa.setDrawMode(DrawMode.FILL);
        caixa.setDepth(100);

        block = entityBuilder()
                .view(caixa)
                .at(200,200)
                .buildOrigin3DAndAttach();

        return block;
    }


    @Spawns("camera")
    public Entity newCamera(SpawnData data){

    Entity camera;

    var z = new Camera3D();
    z.setMoveSpeed(10);


    camera = entityBuilder().view(z.getPerspectiveCamera()).buildAndAttach();

    return camera;
    }
}
