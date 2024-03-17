package com.brendondias.game.ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static com.almasb.fxgl.core.math.FXGLMath.random;

public class SistemaChuvaMenu extends Pane {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final Image  RAIN_DROP_IMAGE = new Image("assets/textures/rain.png");
    private static final int NUM_RAIN_DROPS = 200;

    private final Canvas canvas;
    private final GraphicsContext gc;

    private final RainDrop[] rainDrops;

    private static final List<Relampago> relampagos = new ArrayList<>();

    public SistemaChuvaMenu() {
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();


        Image backgroundImage = FXGL.getAssetLoader().loadImage("backgroundGif.gif");

        // Cria um nó de imagem com a imagem de fundo
        Node backgroundNode = new ImageView(backgroundImage);

        // Defina a posição da imagem de fundo para cobrir
        backgroundNode.setTranslateX(0);
        backgroundNode.setTranslateY(0);

        // Adicione a imagem de fundo à lista de filhos do Pane
        getChildren().add(backgroundNode);
        getChildren().add(canvas);


        rainDrops = new RainDrop[NUM_RAIN_DROPS];
        for (int i = 0; i < NUM_RAIN_DROPS; i++) {
            rainDrops[i] = new RainDrop(Math.random() * WIDTH, Math.random() * HEIGHT);
        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                draw();
                drawRelampagos();
            }
        };
        timer.start();
    }

    private void draw() {
        gc.clearRect(0, 0, WIDTH, HEIGHT); // Limpa o canvas



        for (RainDrop rainDrop : rainDrops) {
            rainDrop.update();
            gc.drawImage(RAIN_DROP_IMAGE, rainDrop.getX(), rainDrop.getY());
        }
    }

    private void drawRelampagos(){


        for (Relampago relampago : relampagos) {
            relampago.draw(gc);
        }
    }

   public static void criarRelampago() {
        double x1 = Math.random() * WIDTH;
        double y1 = 0;
        double x2 = x1 + Math.random() * 20 - 50; // Variação horizontal
        double y2 = Math.random() * 700 + 10; // Altura do relâmpago
        Color color = Color.WHITE; // Cor do relâmpago

        Relampago relampago = new Relampago(x1, y1, x2, y2, color,1300000000);
        relampagos.add(relampago);
    }

    public static void removeRelampago(Relampago relampago) {
        relampagos.remove(relampago);
    }
    private static class RainDrop {
        private double x;
        private double y;
        private double speed;
        private double angle;

        public RainDrop(double x, double y) {
            this.x = x;
            this.y = y;
            this.speed = Math.random() * 1 + 1;
            this.angle = Math.toRadians(73);
        }


        public void update() {

            x -= speed * Math.cos(angle);
            y += speed * Math.sin(angle);

            if (x < 0 || x > WIDTH || y < 0 || y > HEIGHT) {
                x = Math.random() * WIDTH;
                y = Math.random() * HEIGHT;
            }
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}
