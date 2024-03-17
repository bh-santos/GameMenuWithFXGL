package com.brendondias.game.launcher;

import com.almasb.fxgl.app.*;
import com.almasb.fxgl.app.scene.*;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.texture.Texture;
import com.brendondias.game.launcher.gameModes.*;
import com.brendondias.game.logic.Player;
import com.brendondias.game.util.AssetNames;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Map;
import static com.almasb.fxgl.dsl.FXGL.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class NarutoNinjaWarApp extends GameApplication {

    PlayerFactory playerFactory = new PlayerFactory();
    SimpleFactory simpleFactory = new SimpleFactory();
    TerrainFactory terrainFactory = new TerrainFactory();
    GameFactory gameFactory = new GameFactory();


    public static Camera3D camera;
    private static Player player1 = new Player();
    private static Player player2 = new Player();

    public static Player getPlayer1(){
        return player1;
    }

    public static Player getPlayer2(){
        return player2;
    }

    private Pane ui;

    Entity nagato;

    Entity itachi;

    Entity ground;


    @Override
    protected void initSettings(GameSettings gameSettings) {//gerencia as configurações do programa
        gameSettings.set3D(true);
        gameSettings.setMainMenuEnabled(true);
        gameSettings.setIntroEnabled(false);
        gameSettings.setWidth(1280);
        gameSettings.setHeight(720);

        gameSettings.setTitle("Naruto Ninja War");
        gameSettings.setVersion("1.0");
        gameSettings.setDefaultCursor(new CursorInfo("iconKunai.png",7,6));
        gameSettings.setAppIcon("iconKunai.png");
        gameSettings.setManualResizeEnabled(true);
        gameSettings.setFullScreenAllowed(false);
        gameSettings.setFullScreenFromStart(false);
        SceneFactory sceneFactory = new SceneFactory();

        gameSettings.setSceneFactory(sceneFactory);
        gameSettings.setSceneFactory(new SceneFactory() {//passa as configurações do menu para jogo
            @Override
            public FXGLMenu newMainMenu(){

                return new MainMenu(player1);
            }
        });


        gameSettings.setApplicationMode(ApplicationMode.DEVELOPER);

    }
    @Override
    protected void onUpdate(double tpf) {
        super.onUpdate(tpf);

    }
    @Override
    protected void initInput() {

        FXGL.getInput().getMousePositionWorld().add(200,200);
        onKey(KeyCode.W,()->{
            camera.getTransform().moveForward(2);
        });
        onKey(KeyCode.S,()->{
            camera.getTransform().moveBack(2);
        });

        onKey(KeyCode.A,()->{
            camera.getTransform().moveLeft(2);
        });
        onKey(KeyCode.D,()->{
            camera.getTransform().moveRight(2);
        });


        getInput().addAction(new UserAction("Left") {
            @Override
            protected void onAction() {
                itachi.getComponent(ItachiComponent.class).left();
            }

            @Override
            protected void onActionEnd() {
                itachi.getComponent(ItachiComponent.class).stop();
            }
        }, KeyCode.LEFT);

        getInput().addAction(new UserAction("Right") {
            @Override
            protected void onAction() {
                itachi.getComponent(ItachiComponent.class).right();
            }

            @Override
            protected void onActionEnd() {
                itachi.getComponent(ItachiComponent.class).stop();
            }
        }, KeyCode.RIGHT);







    }
    @Override
    protected void initUI() {
        Pane rootFlowPane = new Pane();
        rootFlowPane.setPrefSize(getAppWidth(), getAppHeight());
        Pane gameScene = new Pane();
        Pane rightPanel = new Pane();
        Pane bottomPanel = new Pane();
        ImageView game = new ImageView(texture(AssetNames.Textures.GAME_BACKGROUND).getImage());
        ImageView rightPanelImage = new ImageView(texture(AssetNames.Textures.GAME_RIGHT_PANEL_BACKGROUND).getImage());
        ImageView bottomPanelImage = new ImageView(texture(AssetNames.Textures.GAME_BOTTOM_PANEL_BACKGROUND).getImage());
        ImageView gameSceneImage = new ImageView(texture(AssetNames.Textures.MAIN_MENU_BACKGROUND).getImage());


        gameScene.setPrefSize(1024,576);
        gameScene.setBackground(new Background(new BackgroundImage(gameSceneImage.getImage(),null,null,null,null)));
        game.setFitWidth(game.getImage().getWidth());
        game.setFitHeight(game.getImage().getHeight());

        game.setTranslateX((gameScene.getPrefWidth()-game.getFitWidth())/2);
        System.out.println((gameScene.getPrefWidth()-game.getFitWidth())/2);




        rightPanel.setPrefSize(230,720);

        System.out.println(rightPanel.getPrefWidth() +" "+  rightPanel.getPrefHeight());
        rightPanel.setTranslateX(gameScene.getPrefWidth());
        rightPanel.setTranslateY(0);
        rightPanel.setBackground(new Background(new BackgroundImage(rightPanelImage.getImage(),null,null,null,null)));

        bottomPanel.setPrefSize(1050,212);

        bottomPanel.setTranslateX(1);
        bottomPanel.setTranslateY(gameScene.getPrefHeight());
        bottomPanel.setBackground(new Background(new BackgroundImage(bottomPanelImage.getImage(),null,null,null,null)));
        System.out.println(gameScene.getPrefHeight());

        System.out.println(bottomPanel.getPrefWidth()+" "+bottomPanel.getPrefHeight()+" "+bottomPanel.getTranslateY());
        ImageView background = new ImageView(texture(AssetNames.Textures.GAME_BACKGROUND).getImage());

        rootFlowPane.setBackground(new Background(new BackgroundImage(texture(AssetNames.Textures.GAME_BACKGROUND).getImage(),null,null,null,null)));

        rootFlowPane.getChildren().addAll();



        // Configure o FlowPane conforme necessário
        // Adicione elementos, como botões, labels, etc., aos FlowPanes filhos

        // Adicione o FlowPane raiz à cena da interface do usuário
        getGameScene().addUINode(rootFlowPane);

    }
    @Override
    protected void initGameVars(Map<String, Object> vars) {

    }


    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(simpleFactory);
        getGameWorld().addEntityFactory(playerFactory);
        getGameWorld().addEntityFactory(terrainFactory);
        getGameWorld().addEntityFactory(gameFactory);






        camera=getGameScene().getCamera3D();
        camera.getTransform().translateY(0);
        camera.getTransform().translateX(0);
        camera.getTransform().translateZ(0);
        getGameScene().setFPSCamera(true);
        camera.getTransform().setZ(-400);
        camera.getTransform().setY(-200);
        camera.getTransform().setX(45);
        camera.getTransform().lookDownBy(25);

        getGameScene().getViewport().setX(6);
        getGameScene().getViewport().setY(3);
        var backgroundGame = new Texture(texture(AssetNames.Textures.MAIN_MENU_BACKGROUND).getImage());
        getGameScene().setBackgroundRepeat(backgroundGame.getImage());

        itachi = null;

        itachi = spawn("itachi");

        ground =spawn("battleField");
        /*spawn("background");*/


        set("itachi", itachi);


        camera.getTransform().unbindToLookAt3D();
    }




    @Override
    protected void initPhysics() {
        onCollisionBegin(EntityType.ITACHI,EntityType.GROUND,(itachi,ground) ->{
            System.out.println("Colidiu");
            itachi.getComponent(ItachiComponent.class).stopY();

        });
    }





    public static void main(String[] args) {
        launch(args);
    }
}
