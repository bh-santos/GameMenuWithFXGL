package com.brendondias.game.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Relampago {
    private double startX, startY;
    private double endX, endY;
    private Color color;
    private Random random;
    private long tempoVida;
    private long tempoInicial;
    private double opacidade;

    public Relampago(double startX, double startY, double endX, double endY, Color color, long tempoVida) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
        this.random = new Random();
        this.tempoVida = tempoVida;
        this.tempoInicial = System.nanoTime(); // Registra o tempo de criação
        this.opacidade = 1.0; // Opacidade inicial
    }

    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(2.0);

        long tempoAtual = System.nanoTime() - tempoInicial;

        // Calcula a opacidade com base no tempo decorrido
        if (tempoAtual < tempoVida) {
            opacidade = 1.0 - (double) tempoAtual / (double) tempoVida;

            gc.setGlobalAlpha(opacidade); // Define a opacidade
            drawRelampago(gc, startX, startY, endX, endY, 4);
            gc.setGlobalAlpha(1.0); // Restaura a opacidade
        }
    }

    private void drawRelampago(GraphicsContext gc, double x1, double y1, double x2, double y2, int depth) {
        if (depth == 0) {
            gc.strokeLine(x1, y1, x2, y2);
        } else {
            double mx = (x1 + x2) / 2;
            double my = (y1 + y2) / 2;
            mx += (random.nextDouble() - 0.5) * depth * 25;
            my += (random.nextDouble() - 0.5) * depth * 25;
            drawRelampago(gc, x1, y1, mx, my, depth - 1);
            drawRelampago(gc, mx, my, x2, y2, depth - 1);
        }
    }
}
