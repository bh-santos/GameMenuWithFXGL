package com.brendondias.game.launcher;

import com.almasb.fxgl.audio.Music;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.view.KeyView;
import com.brendondias.game.logic.*;
import com.brendondias.game.ui.SistemaChuvaMenu;
import com.brendondias.game.util.AssetNames;
import com.brendondias.game.util.Effects;
import com.brendondias.game.util.Settings;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;
import static com.brendondias.game.util.AssetNames.Textures.UNDEFINED;
import static javafx.scene.paint.Color.*;
import static javafx.scene.paint.Color.BLACK;


public class MainMenu extends FXGLMenu {//cria uma classe que estende o FXGL MENU
    @Getter
    private static SubMenu InternalMenu;
    @Getter
    private final ObjectProperty<NarutoButton> selectedButton;
    @Getter
    private final Music currentMusic;
    @Getter
    private static final VillageSet villages = new VillageSet();
    @Getter
    private static final NinjaSet ninjas = new NinjaSet();
    @Getter
    @Setter
    private static ImageView currentVillageIcon = texture(UNDEFINED);
    @Getter
    @Setter
    private static Text currentVillageName = FXGL.getUIFactoryService().newText("Desconhecido.",Color.rgb(255,255,255),22.0);
    @Getter
    @Setter
    private static Text currentVillageFirstInfo = FXGL.getUIFactoryService().newText("Informaçao 1:",Color.rgb(255,255,255),20.0);
    @Getter
    @Setter
    private static Text currentVillageSecondInfo = FXGL.getUIFactoryService().newText("Informação 2:",Color.rgb(255,255,255),20.0);
    @Getter
    @Setter
    private static Text currentVillageThirdInfo = FXGL.getUIFactoryService().newText("Informação 3:",Color.rgb(255,255,255),20.0);
    @Getter
    @Setter
    private static Text currentVillageFirstInfoValue = FXGL.getUIFactoryService().newText("10",Color.rgb(255,255,255),20.0);
    @Getter
    @Setter
    private static Text currentVillageSecondInfoValue = FXGL.getUIFactoryService().newText("20",Color.rgb(255,255,255),20.0);
    @Getter
    @Setter
    private static Text currentVillageThirdInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),20.0);

    @Getter
    @Setter
    private static ImageView currentNinjaIcon = texture(UNDEFINED);
    @Getter
    @Setter
    private static Text currentNinjaName = FXGL.getUIFactoryService().newText("Desconhecido.",Color.rgb(255,255,255),22.0);
    @Getter
    @Setter
    private static Text currentNinjaFirstInfo = FXGL.getUIFactoryService().newText("Informaçao 1:",Color.rgb(255,255,255),15);
    @Getter
    @Setter
    private static Text currentNinjaSecondInfo = FXGL.getUIFactoryService().newText("Informação 2:",Color.rgb(255,255,255),15);
    @Getter
    @Setter
    private static Text currentNinjaThirdInfo = FXGL.getUIFactoryService().newText("Informação 3:",Color.rgb(255,255,255),15);
    @Getter
    @Setter
    private static Text currentNinjaFourthInfo = FXGL.getUIFactoryService().newText("Informação 4:",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaFifthInfo = FXGL.getUIFactoryService().newText("Informação 3:",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaSixthInfo = FXGL.getUIFactoryService().newText("Informação 3:",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaSeventhInfo = FXGL.getUIFactoryService().newText("Informação 3:",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaEighthInfo = FXGL.getUIFactoryService().newText("Informação 3:",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaNinthInfo = FXGL.getUIFactoryService().newText("Informação 3:",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaFirstInfoValue = FXGL.getUIFactoryService().newText("10",Color.rgb(255,255,255),15);
    @Getter
    @Setter
    private static Text currentNinjaSecondInfoValue = FXGL.getUIFactoryService().newText("20",Color.rgb(255,255,255),15);
    @Getter
    @Setter
    private static Text currentNinjaThirdInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaFourthInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaFifthInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaSixthInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaSeventhInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaEighthInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),15);

    @Getter
    @Setter
    private static Text currentNinjaNinthInfoValue = FXGL.getUIFactoryService().newText("30",Color.rgb(255,255,255),15);
    @Getter
    @Setter
    private static LinkedList<ImageView> charSelectImageBar = new LinkedList<>();
    @Getter
    @Setter
    private static LinkedList<Ninja> charSelectNinjaBar = new LinkedList<>();
    @Getter
    @Setter
    private static LinkedList<ImageView> currentSkillIcons =new LinkedList<>();
    @Getter
    @Setter
    private static LinkedList<Skill> currentSkillList = new LinkedList<>();

    public MainMenu(Player player1) {//cria o construtor do menu
        super(MenuType.MAIN_MENU);
        //adiciona o sistema de chuva no construtor do menu

        var backgroundImage = texture(AssetNames.Textures.MAIN_MENU_BACKGROUND);//passa a imagem de fundo para o programa
        var backgroundNode = new ImageView(backgroundImage.getImage());//passa para um dos 'Nós'(NODE) do FXGL a imagem
        getContentRoot().getChildren().addAll(backgroundNode);//adiciona o plano de fundo na tela e a chuva

        currentMusic = FXGL.getAssetLoader().loadMusic(AssetNames.Music.MUSIC_MAIN_MENU1);
        currentMusic.getAudio().play();
        currentMusic.getAudio().setLooping(true);

        var btnNovoJogo = new NarutoButton("Nova Partida","Inicia as configurações da partida.",() -> {

            InternalMenu = new SubMenu(player1,"selecionar_aldeia");

            if(getContentRoot().getChildren().contains(InternalMenu)){
                getContentRoot().getChildren().remove(InternalMenu);
            }else {
                getContentRoot().getChildren().add(InternalMenu);
                InternalMenu.requestFocus();
            }
        });//instanciação dos botões
        var btnOpcoes = new NarutoButton("Opções","Configurações do jogo.",()->{});//instanciação dos botões
        var btnExit = new NarutoButton("Sair","Sair do jogo.", this::fireExit);//instanciação dos botões

        selectedButton = new SimpleObjectProperty<>(btnNovoJogo);

        var textDescription = FXGL.getUIFactoryService().newText("",Color.LIGHTGRAY,14);//configura o trecho de descrição do menu
        textDescription.textProperty().bind(
                Bindings.createStringBinding(()-> selectedButton.get().description, selectedButton)
        );

        var box = new VBox(15,//tamanho do VBOX
                btnNovoJogo,//passa o botão para o box
                btnOpcoes,//passa o botão para box
                new NarutoButton("PlaceHolder1","TESTE",()->{}),//passa o botão para o box
                new NarutoButton("PlaceHolder2","TESTE",()->{}),//passa o botão para o box
                btnExit,//passa o botão para o box
                new LineSeparator(),
                textDescription
        );

        box.setAlignment(Pos.CENTER_LEFT);//alinha o conteudo do box
        box.setTranslateX(100);//posiciona o box
        box.setTranslateY(400);// posiciona o box

        var view = new KeyView(KeyCode.ESCAPE, Color.WHITE,15.0);
        var hBox = new HBox(25,FXGL.getUIFactoryService().newText("VOLTAR",16.0),view);//configura a visualização de informação no canto inferior direito da tela.
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setTranslateX(getAppWidth()-220);
        hBox.setTranslateY(600);
        getContentRoot().getChildren().addAll(box,hBox);
    }


    public static void changeVillageIcon(Image image){
        currentVillageIcon.setImage(image);
    }

    public static void changeNameVillage(String text){
        currentVillageName.setText(text);
    }

    public static void changeInfoVillage(String info1, String info2, String info3){
        currentVillageSecondInfo.setText(info2);
        currentVillageThirdInfo.setText(info3);
        currentVillageFirstInfo.setText(info1);
    }

    public static void changeInfoVillageValue(int value1, int value2, int value3){
        String value1Converted = String.valueOf(value1);
        String value2Converted = String.valueOf(value2);
        String value3Converted = String.valueOf(value3);
        currentVillageSecondInfoValue.setText(value2Converted);
        currentVillageThirdInfoValue.setText(value3Converted);
        currentVillageFirstInfoValue.setText(value1Converted);
    }




    public static void changeNinjaIcon(Image image){
        currentNinjaIcon.setImage(image);
    }

    public static void changeNinjaName(String text){
        currentNinjaName.setText(text);
    }

    public static void changeNinjaInfo(String info1, String info2, String info3, String info4, String info5, String info6, String info7, String info8, String info9){
        currentNinjaFirstInfo.setText(info1);
        currentNinjaSecondInfo.setText(info2);
        currentNinjaThirdInfo.setText(info3);
        currentNinjaFourthInfo.setText(info4);
        currentNinjaFifthInfo.setText(info5);
        currentNinjaSixthInfo.setText(info6);
        currentNinjaSeventhInfo.setText(info7);
        currentNinjaEighthInfo.setText(info8);
        currentNinjaNinthInfo.setText(info9);


    }

    public static void changeValueNinjaInfo(int health, int chakra, int strength,int defense, String rankNinja, Skill skillOne, Skill skillTwo, Skill skillThree, Skill skillFour, String element1,String element2, int range){
        String value1Converted = String.valueOf(health);
        String value2Converted = String.valueOf(chakra);
        String value3Converted = String.valueOf(strength);
        String value4Converted = String.valueOf(defense);
        String value5Converted = String.valueOf(rankNinja);
        String value7Converted = String.valueOf(element1);
        String value8Converted = String.valueOf(element2);
        String value9Converted = String.valueOf(range);

        currentNinjaFirstInfoValue.setText(value1Converted);
        currentNinjaSecondInfoValue.setText(value2Converted);
        currentNinjaThirdInfoValue.setText(value3Converted);
        currentNinjaFourthInfoValue.setText(value4Converted);
        currentNinjaFifthInfoValue.setText(value5Converted);


        if (skillOne != null) {
            currentSkillIcons.get(0).setImage(skillOne.getSKILL_ICON().getImage());
            currentSkillList.set(0,skillOne);
        }else{
            currentSkillIcons.get(0).setImage(texture(UNDEFINED).getImage());
            currentSkillList.set(0,null);
        }

        if (skillTwo != null) {
            currentSkillIcons.get(1).setImage(skillTwo.getSKILL_ICON().getImage());
            currentSkillList.set(1,skillTwo);
        }else{
            currentSkillIcons.get(1).setImage(texture(UNDEFINED).getImage());
            currentSkillList.set(1,null);
        }

        if (skillThree != null) {
            currentSkillIcons.get(2).setImage(skillThree.getSKILL_ICON().getImage());
            currentSkillList.set(2,skillThree);
        }else{
            currentSkillIcons.get(2).setImage(texture(UNDEFINED).getImage());
            currentSkillList.set(2,null);
        }

        if (skillFour != null) {
            currentSkillIcons.get(3).setImage(skillFour.getSKILL_ICON().getImage());
            currentSkillList.set(3,skillFour);
        }else{
            currentSkillIcons.get(3).setImage(texture(UNDEFINED).getImage());
            currentSkillList.set(3,null);
        }


        currentNinjaSeventhInfoValue.setText(value7Converted);
        currentNinjaEighthInfoValue.setText(value8Converted);
        currentNinjaNinthInfoValue.setText(value9Converted);

    }

    public static int findEmptyIndexCharSelectImageBar(){
        for (int i = 0; i < charSelectImageBar.size(); i++) {
            if (charSelectImageBar.get(i).getImage().equals(texture(UNDEFINED).getImage())) {
                return i;
            }
        }
        return -1; // Retorna -1 se não houver posições vazias
    }


    public void clearAllPlayers(){
        NarutoNinjaWarApp.getPlayer1().setVillage(null);
        NarutoNinjaWarApp.getPlayer2().setVillage(null);

        if(NarutoNinjaWarApp.getPlayer1().getPlayerSelectedNinjas() != null){
            NarutoNinjaWarApp.getPlayer1().getPlayerSelectedNinjas().clear();
        }
    }

    private static final Color SELECTED_COLOR = Color.WHITE;//Cor mostrada quando a opção do menu estiver sido selecionada
    private static final Color NOT_SELECTED_COLOR = Color.GRAY;//cor mostrada quando a opção do menu não estiver sido selecionada


    @EqualsAndHashCode(callSuper = true)
    @Data
    public class NarutoButton extends StackPane{//cria uma classe que estende um stackpane do JAVAFX para gerenciar os botões do menu
        private final String name;//nome mostrado no botão
        private final String description;
        private final Runnable action;//ação do botão
        private final Text text;//gerenciamento do texto do botão
        private final Rectangle selector;//icone de botão selecionado
        public NarutoButton(String name,String description, Runnable action) {//construtor do botão

            this.name = name;
            this.description = description;
            this.action=action;
            setAlignment(Pos.CENTER_LEFT);//alinhamento dos botões
            text = FXGL.getUIFactoryService().newText(name,Color.rgb(255,255,255),18.0);//cor e tamanho da fonte do texto dos botões.
            text.fillProperty().bind(Bindings.when(focusedProperty()).then(SELECTED_COLOR).otherwise(NOT_SELECTED_COLOR));//preenchimento dos botões quando ele é focado.
            text.strokeProperty().bind(Bindings.when(focusedProperty()).then(SELECTED_COLOR).otherwise(NOT_SELECTED_COLOR));//necessito ver.
            text.setStrokeWidth(0.5);//proporção de negrito
            setFocused(false);
            setFocusTraversable(false);//tornar o botão focável.(mover com as setas)

            selector = new Rectangle(7,17,Color.rgb(255,255,255));//icone de selecao (tamanho e cor)
            selector.setTranslateX(-25);//posição do botão referente ao stack pane.
            selector.setTranslateY(-2);//posição do botão referente ao stackpane
            selector.visibleProperty().bind(focusedProperty());//adição da possibilidade de foco no botão/icone


            focusedProperty().addListener((observable, oldvalue, isSelected) -> {
                if(isSelected){
                    selectedButton.setValue(this);
                }
            });

            setOnKeyPressed(e ->{//permite que o botão execute uma ação quando selecionado.
                setFocused(true);
                if(e.getCode()== KeyCode.ENTER){
                    action.run();//faz com que o botão execute a ação cadastrada nele.
                }
            });

            setOnMouseEntered(e ->{
                // Carregue a imagem do cursor personalizado

                var cursorImage = texture(AssetNames.Textures.GAME_ICON);
                SistemaChuvaMenu.criarRelampago();

                // Crie um cursor personalizado com a imagem

                var customCursor = new ImageCursor(cursorImage.getImage());
                setCursor(customCursor);

                setFocused(true);
            });

            setOnMouseExited(e->{
                setFocused(false);
            });

            setOnMouseClicked(e ->{
                action.run();

            });
            getChildren().addAll(selector,text);//adiciona os elementos na tela
        }
    }

    private static class LineSeparator extends Parent{//cria uma classe que será uma linha do menu com efeito de esmaecimento
        @Getter
        private final Rectangle line = new Rectangle(450,2);//será baseada em um rectangle
        public LineSeparator(){
            var gradient = new LinearGradient(0,0.5,1,0.5,true,//cria o efeito "gradient"(degradê)
                    CycleMethod.NO_CYCLE,
                    new Stop(0, Color.WHITE),
                    new Stop(0.5,Color.GRAY),
                    new Stop(1.0,Color.TRANSPARENT));
            line.setFill(gradient);//preenchimento da linha em degradê
            getChildren().add(line);//adiciona a linha na tela
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public class SubMenu extends VBox {
        private final MenuBar barraMenuSec;
        private String menuType;
        public SubMenu(Player player, String menuType){
            this.menuType = menuType;
            barraMenuSec = new MenuBar(player, getMenuType());
            setPrefHeight(600);
            setPrefWidth(900);
            setAlignment(Pos.CENTER);
            setTranslateX(190);
            setTranslateY(50);
            setFocusTraversable(true);
            setOnKeyPressed(e ->{
                if(e.getCode() == KeyCode.ESCAPE){
                    if(FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().contains(MainMenu.getInternalMenu())){
                        FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(MainMenu.getInternalMenu());
                    }else{
                        System.out.println("Não contem");
                    }
                }
            });



            if(getMenuType().equals("selecionar_aldeia")) {
                ContentMenuVillage contentMenuVillage = new ContentMenuVillage(player);
                System.out.println("Selecionou aldeia");
                getChildren().addAll(barraMenuSec, contentMenuVillage);

            }else if(getMenuType().equals("selecionar_personagem")){
                System.out.println("Selecionou personagem");
                ContentMenuCharacter contentMenuCharacter = new ContentMenuCharacter(player);
                getChildren().addAll(barraMenuSec, contentMenuCharacter);
            }
        }
        private  class MenuBar extends AnchorPane {
            @Getter
            private MenuTitle menuTitleInitGame;
            public MenuBar(Player player, String menuType){
                setPrefSize(Settings.MENU_BAR_WIDTH,Settings.MENU_BAR_HEIGHT);

                var x = new MenuBarButton("X", () -> {
                    villages.removeSelected();
                    ninjas.clearAllLists();
                    clearAllPlayers();
                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(MainMenu.getInternalMenu());
                });

                setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
                setStyle("-fx-background-radius: 5 5 0 0; -fx-background-color: white;");

                var exitButton = new VBox(0, x);
                exitButton.setPrefWidth(30);
                exitButton.setPrefHeight(30);
                exitButton.setTranslateX(0.2);
                exitButton.setTranslateY(0.19);
                getChildren().add(exitButton);

                menuTitleInitGame = null;
                VBox title = null;
                if (player.getPlayerId() == 1) {
                    if(menuType.equals("selecionar_aldeia")) {
                        menuTitleInitGame = new MenuTitle("SELECIONAR ALDEIA JOGADOR 1");
                        title = new VBox(0, menuTitleInitGame);
                        title.setPrefWidth(30);
                        title.setPrefHeight(30);
                        title.setTranslateX(340);
                        title.setTranslateY(0.19);
                    }else if(menuType.equals("selecionar_personagem")){
                        menuTitleInitGame = new MenuTitle("SELECIONAR PERSONAGEM JOGADOR 1");
                        title = new VBox(0, menuTitleInitGame);
                        title.setPrefWidth(30);
                        title.setPrefHeight(30);
                        title.setTranslateX(340);
                        title.setTranslateY(0.19);
                    }
                }else if(player.getPlayerId() == 2){
                    if(menuType.equals("selecionar_aldeia")) {
                        menuTitleInitGame = new MenuTitle("SELECIONAR ALDEIA JOGADOR 2");
                        title = new VBox(0, menuTitleInitGame);
                        title.setPrefWidth(30);
                        title.setPrefHeight(30);
                        title.setTranslateX(340);
                        title.setTranslateY(0.19);

                    } else if (menuType.equals("selecionar_personagem")) {
                        menuTitleInitGame = new MenuTitle("SELECIONAR PERSONAGEM JOGADOR 2");
                        title = new VBox(0, menuTitleInitGame);
                        title.setPrefWidth(30);
                        title.setPrefHeight(30);
                        title.setTranslateX(340);
                        title.setTranslateY(0.19);
                    }

                }
                getChildren().add(title);
                setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            }
        }

        @EqualsAndHashCode(callSuper = true)
        @Data
        private  class MenuBarButton extends StackPane {
            private final String name;//nome mostrado no botão
            private final Runnable action;//ação do botão
            private final Text text;//gerenciamento do texto do botão

            public MenuBarButton(String name, Runnable action){
                this.name = name;
                this.action=action;
                setPrefSize(29,29);
                text = FXGL.getUIFactoryService().newText(name,Color.BLACK,13.0);
                setStyle("-fx-background-radius: 5 0 0 0;-fx-background-color: white;");
                setFocusTraversable(true);

                setOnMouseEntered(e ->{
                    // Carregue a imagem do cursor personalizado
                    var cursorImage = texture(AssetNames.Textures.GAME_ICON_SELECTED);
                    SistemaChuvaMenu.criarRelampago();
                    // Crie um cursor personalizado com a imagem
                    var customCursor = new ImageCursor(cursorImage.getImage());
                    setCursor(customCursor);
                    setStyle("-fx-background-radius: 5 0 0 0;-fx-background-color: red;");
                    text.setFill(Color.WHITE);
                    setFocused(true);
                });

                setOnMouseExited(e->{
                    setStyle("-fx-background-radius: 5 0 0 0;-fx-background-color: white;");
                    text.setFill(Color.BLACK);
                    setFocused(false);
                });

                setOnMouseClicked(e ->{
                    action.run();
                });

                getChildren().addAll(text);
            }
        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        private class MenuTitle extends StackPane{
            private final String name;//nome mostrado no botão
            private final Text text;//gerenciamento do texto do botão
            public MenuTitle(String name){
                this.name = name;

                setPrefSize(30,30);
                text = FXGL.getUIFactoryService().newText(name,Color.BLACK,13.0);

                getChildren().add(text);
            }
        }
    }

    //village
    public class ContentMenuVillage extends Pane {
        public ContentMenuVillage(Player player){
            setPrefSize(Settings.CONTENT_SUBMENU_WIDTH, Settings.CONTENT_SUBMENU_HEIGHT);
            var backgroundImage = texture(AssetNames.Textures.INIT_GAME_BACKGROUND);
            var back = new ImageView(backgroundImage.getImage());
            System.out.println("Instanciado;");
            getChildren().add(back);
            setEffect(Effects.ShadowEffects.BLACK_SHADOW);

            //adiciona o leftPanel do menu
            var leftPanel = new SelectVillagePanel(player);
            leftPanel.setTranslateX(66);
            leftPanel.setTranslateY(36);
            getChildren().add(leftPanel);

            //adiciona o rightPanel do menu aldeia
            var rightPanel = new infoVillagePanel();
            rightPanel.setTranslateX(478);
            rightPanel.setTranslateY(50);
            getChildren().add(rightPanel);

            //adiciona os botões do menuAldeia

            var goBack = new BackNextButtons("VOLTAR", () -> {
                if(player.getPlayerId()==1){
                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);

                    player.setVillage(null);
                    villages.removeSelected();

                }else if(player.getPlayerId() == 2){
                    villages.removeSelected();
                    player.setVillage(null);

                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                    InternalMenu = new SubMenu(NarutoNinjaWarApp.getPlayer1(),"selecionar_aldeia");
                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().add(InternalMenu);
                }
            });
            var goForward = new BackNextButtons("AVANÇAR", () -> {
                if(player.getPlayerId() == 1){
                    if(villages.getVillageSelected() == null) {
                        System.out.println("Selecione uma aldeia");

                    }else{
                        villages.getVillageSelected().setSelectedPermanently(true);
                        player.setVillage(villages.getVillageSelected());
                        villages.setVillageSelected(null);

                        if(InternalMenu.getMenuType().equals("selecionar_aldeia")) {
                            FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                            InternalMenu = new SubMenu(NarutoNinjaWarApp.getPlayer2(), "selecionar_aldeia");
                            FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().add(InternalMenu);
                        }else if(InternalMenu.getMenuType().equals("selecionar_personagem")){
                            FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                            InternalMenu = new SubMenu(NarutoNinjaWarApp.getPlayer2(), "selecionar_personagem");
                            FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().add(InternalMenu);
                        }
                    }


                }else if(player.getPlayerId()==2){
                    if(villages.getVillageSelected() == null) {
                        System.out.println("Selecione uma aldeia");

                    }else {
                        villages.getVillageSelected().setSelectedPermanently(true);
                        player.setVillage(villages.getVillageSelected());


                        if (InternalMenu.getMenuType().equals("selecionar_aldeia")) {
                            FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                            InternalMenu = new SubMenu(NarutoNinjaWarApp.getPlayer1(), "selecionar_personagem");
                            FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().add(InternalMenu);
                        } else if (InternalMenu.getMenuType().equals("selecionar_personagem")) {
                            FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                            fireNewGame();
                            currentMusic.getAudio().stop();
                        }
                    }
                }
            });

            goBack.setTranslateX(321);
            goBack.setTranslateY(460);

            goForward.setTranslateX(463);
            goForward.setTranslateY(460);

            getChildren().addAll(goBack,goForward);
        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class SelectVillagePanel extends AnchorPane{
            private final LayoutPanelLeft panel;

            public SelectVillagePanel(Player player){
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT);
                panel = new LayoutPanelLeft(player);
                getChildren().add(panel);
            }
        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class infoVillagePanel extends AnchorPane{
            private final LayoutPanelRight panel;

            public infoVillagePanel(){
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT);
                panel = new LayoutPanelRight();
                getChildren().add(panel);
            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class LayoutPanelLeft extends VBox{

            private final ContentVillageMenuButtons nextButton;
            private final ContentVillageMenuButtons backButton;
            public LayoutPanelLeft(Player player){

                final VillageGroup layoutTop = new VillageGroup(player);
                final Pane layoutBottom = new Pane();
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT);
                //configuração layoutbaixo do painel1
                nextButton = new ContentVillageMenuButtons("Página Anterior", layoutTop::previousPage);
                backButton = new ContentVillageMenuButtons("Próxima Página", layoutTop::nextPage);

                nextButton.setTranslateX(59);
                nextButton.setTranslateY(5);

                backButton.setTranslateX(184);
                backButton.setTranslateY(5);

                layoutBottom.getChildren().addAll(nextButton, backButton);

                getChildren().addAll(layoutTop, layoutBottom);

            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class VillageGroup extends Pane{

            private  int pageSelected = 1;
            private final GridPane iconOrganizer = new GridPane();
            private ImageView[] image = new ImageView[18];


            public VillageGroup(Player player){
                setPrefSize(310,292);
                setTranslateX(20);
                setTranslateY(10);


                iconOrganizer.setPrefSize(310,292);
                iconOrganizer.setTranslateX(0);
                iconOrganizer.setTranslateY(0);

                iconOrganizer.setAlignment(Pos.CENTER);
                iconOrganizer.setPadding(new Insets(20));


                var index = 0;

                for(int i = 0; i<18; i++){
                    image[i]= villages.getVillageSet().get(i).getVILLAGE_ICON();
                }
                for(int l = 0; l<3;l++){
                    for(int c = 0; c<3; c++) {
                        iconOrganizer.add(image[index], c, l);
                        index++;

                    }
                }

                iconOrganizer.setHgap(10);
                iconOrganizer.setVgap(10);

                getChildren().add(iconOrganizer);


            }
            public void nextPage(){
                if(pageSelected == 1){
                    getIconOrganizer().getChildren().clear();
                    var index = 8;
                    for(int l = 0; l<3;l++){
                        for(int c = 0; c<3; c++) {
                            iconOrganizer.add(image[index], c, l);
                            index++;

                        }
                    }
                    setPageSelected(getPageSelected()+1);
                }else{
                    return;
                }
            }

            public void previousPage(){
                if(pageSelected==2){

                    pageSelected = pageSelected-1;
                    getIconOrganizer().getChildren().clear();
                    var index = 0;

                    for(int i = 0; i<18; i++){
                        image[i]= villages.getVillageSet().get(i).getVILLAGE_ICON();
                    }
                    for(int l = 0; l<3;l++){
                        for(int c = 0; c<3; c++) {
                            iconOrganizer.add(image[index], c, l);
                            index++;

                        }
                    }
                }else{
                    return;
                }
            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class LayoutPanelRight extends VBox{
            private final Pane layoutTop = new Pane();
            private final Pane layoutMid = new Pane();
            private final Pane layoutBottom = new Pane();
            private final StackPane internalMid = new StackPane();

            private final HBox internalBottomOrganizer;
            private final VBox internalBottomLeftOrganizerText;
            private final VBox internalBottomRightOrganizerText;


            public LayoutPanelRight(){
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT);
                setEffect(Effects.ShadowEffects.BROWN_BLACK_SHADOW);
                layoutTop.setPrefSize(350,152);
                layoutMid.setPrefSize(350,51);
                layoutBottom.setPrefSize(350,170);

                //configuração LayoutCima Painel2

                currentVillageIcon.setEffect(Effects.ShadowEffects.BLACK_SHADOW);
                currentVillageIcon.setFitWidth(125);
                currentVillageIcon.setFitHeight(125);
                currentVillageIcon.setTranslateX(112.5);
                currentVillageIcon.setTranslateY(13.5);
                layoutTop.getChildren().add(currentVillageIcon);

                //configuração LayoutMeio Painel2

                internalMid.setPrefSize(350,51);
                internalMid.setEffect(Effects.ShadowEffects.BLACK_SHADOW);

                currentVillageName.setFill(WHITE);
                currentVillageName.setStroke(BLACK);
                currentVillageName.setStrokeWidth(0.6);
                internalMid.getChildren().add(currentVillageName);
                layoutMid.getChildren().add(internalMid);

                //configuração LayoutBaixo Painel2

                internalBottomOrganizer = new HBox();
                internalBottomLeftOrganizerText = new VBox();
                internalBottomRightOrganizerText = new VBox();

                internalBottomOrganizer.setPrefSize(350,168);
                internalBottomLeftOrganizerText.setPrefSize(175,168);
                internalBottomRightOrganizerText.setPrefSize(175,168);


                currentVillageFirstInfo.setStroke(BLACK);
                currentVillageFirstInfo.setStrokeWidth(0.4);

                currentVillageSecondInfo.setStroke(BLACK);
                currentVillageSecondInfo.setStrokeWidth(0.4);

                currentVillageThirdInfo.setStroke(BLACK);
                currentVillageThirdInfo.setStrokeWidth(0.4);

                currentVillageFirstInfoValue.setStroke(BLACK);
                currentVillageFirstInfoValue.setStrokeWidth(0.4);

                currentVillageSecondInfoValue.setStroke(BLACK);
                currentVillageSecondInfoValue.setStrokeWidth(0.4);

                currentVillageThirdInfoValue.setStroke(BLACK);
                currentVillageThirdInfoValue.setStrokeWidth(0.4);
                

                StackPane leftTextField1 = new StackPane();
                StackPane leftTextField2 = new StackPane();
                StackPane leftTextField3 = new StackPane();
                StackPane leftTextField4 = new StackPane();
                StackPane leftTextField5 = new StackPane();


                leftTextField2.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField3.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField4.setEffect(Effects.ShadowEffects.RED_SHADOW);

                leftTextField2.getChildren().add(currentVillageFirstInfo);
                leftTextField3.getChildren().add(currentVillageSecondInfo);
                leftTextField4.getChildren().add(currentVillageThirdInfo);

                leftTextField1.setPrefSize(87,33.6);
                leftTextField2.setPrefSize(87,33.6);
                leftTextField3.setPrefSize(87,33.6);
                leftTextField4.setPrefSize(87,33.6);
                leftTextField5.setPrefSize(87,33.6);
                

                StackPane rightTextField1 = new StackPane();
                StackPane rightTextField2 = new StackPane();
                StackPane rightTextField3 = new StackPane();
                StackPane rightTextField4 = new StackPane();
                StackPane rightTextField5 = new StackPane();

                rightTextField2.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField3.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField4.setEffect(Effects.ShadowEffects.GREEN_SHADOW);

                rightTextField2.getChildren().add(currentVillageFirstInfoValue);
                rightTextField3.getChildren().add(currentVillageSecondInfoValue);
                rightTextField4.getChildren().add(currentVillageThirdInfoValue);

                rightTextField1.setPrefSize(87,33.6);
                rightTextField2.setPrefSize(87,33.6);
                rightTextField3.setPrefSize(87,33.6);
                rightTextField4.setPrefSize(87,33.6);
                rightTextField5.setPrefSize(87,33.6);

                internalBottomLeftOrganizerText.getChildren().add(leftTextField1);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField2);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField3);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField4);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField5);

                internalBottomRightOrganizerText.getChildren().add(rightTextField1);
                internalBottomRightOrganizerText.getChildren().add(rightTextField2);
                internalBottomRightOrganizerText.getChildren().add(rightTextField3);
                internalBottomRightOrganizerText.getChildren().add(rightTextField4);
                internalBottomRightOrganizerText.getChildren().add(rightTextField5);

                internalBottomOrganizer.getChildren().addAll(internalBottomLeftOrganizerText, internalBottomRightOrganizerText);
                layoutBottom.getChildren().add(internalBottomOrganizer);

                getChildren().addAll(layoutTop, layoutMid, layoutBottom);

            }
        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class ContentVillageMenuButtons extends StackPane{
            private final String name;
            private final Text text;
            private final Runnable action;

            public ContentVillageMenuButtons(String name, Runnable action){
                this.name=name;
                this.action = action;

                setPrefSize(110,18);
                text = FXGL.getUIFactoryService().newText(name, rgb(255,255,255),12.0);
                setEffect(Effects.ShadowEffects.BLACK_SHADOW);

                setFocusTraversable(true);

                setOnMouseEntered(e ->{
                    text.setFill(ORANGE);
                    setEffect(Effects.ShadowEffects.WHITE_SHADOW);
                    setFocused(true);
                });

                setOnMouseExited(e ->{
                    text.setFill(WHITE);
                    setEffect(Effects.ShadowEffects.BLACK_SHADOW);
                    setFocused(false);
                });

                setOnMouseClicked(e ->{
                    action.run();
                });

                getChildren().add(text);
            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public class BackNextButtons extends StackPane{
            private String name;
            private final Text text;
            private Runnable action;

            public BackNextButtons(String name, Runnable action){
                setPrefSize(121,40);

                text = FXGL.getUIFactoryService().newText(name, rgb(255,255,255),23.0);
                text.setStroke(BLACK);
                text.setStrokeWidth(0.4);
                
                setEffect(Effects.ShadowEffects.BLACK_SHADOW);

                setFocusTraversable(true);

                setOnMouseEntered(e ->{
                    text.setFill(ORANGE);
                    setEffect(Effects.ShadowEffects.WHITE_SHADOW);
                    setFocused(true);
                });

                setOnMouseExited(e ->{
                    text.setFill(WHITE);
                    setEffect(Effects.ShadowEffects.BLACK_SHADOW);
                    setFocused(false);
                });

                setOnMouseClicked(e ->{
                    SistemaChuvaMenu.criarRelampago();
                    action.run();
                });

                getChildren().add(text);

            }

        }
    }


    //char

    public class ContentMenuCharacter extends Pane {
        public ContentMenuCharacter(Player player){
            setPrefSize(Settings.CONTENT_SUBMENU_WIDTH, Settings.CONTENT_SUBMENU_HEIGHT);
            var backgroundImage = texture(AssetNames.Textures.INIT_GAME_BACKGROUND);
            var back = new ImageView(backgroundImage.getImage());
            getChildren().add(back);
            setEffect(Effects.ShadowEffects.BLACK_SHADOW);
            System.out.println("instanciado");

            //adiciona o leftPanel do menu
            var leftPanel = new SelectCharPanel(player);
            leftPanel.setTranslateX(66);
            leftPanel.setTranslateY(15);
            getChildren().add(leftPanel);

            //adiciona o rightPanel do menu aldeia
            var rightPanel = new InfoCharPanel();
            rightPanel.setTranslateX(478);
            rightPanel.setTranslateY(20);
            getChildren().add(rightPanel);

            //adiciona os botões do menuAldeia

            var goBack = new BackNextCharMenuButton("VOLTAR", () -> {
                if(player.getPlayerId()==1){
                    ninjas.clearAllLists();
                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                    InternalMenu = new SubMenu(NarutoNinjaWarApp.getPlayer2(),"selecionar_aldeia");
                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().add(InternalMenu);

                }else if(player.getPlayerId() == 2){
                    ninjas.clearAllLists();
                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                    InternalMenu = new SubMenu(NarutoNinjaWarApp.getPlayer1(),"selecionar_personagem");
                    FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().add(InternalMenu);
                }
            });
            var goForward = new BackNextCharMenuButton("AVANÇAR", () -> {
                if(player.getPlayerId() == 1){
                    if(!ninjas.verifySelectedNinjas()){
                        System.out.println("Selecione todos os ninjas.");
                    }else {
                        player.getPlayerSelectedNinjas().addAll(ninjas.getNinjasSelectedList());
                        ninjas.clearAllLists();

                        for(int i =0;i<ninjas.getNinjasSelectedList().size();i++){
                            System.out.println(player.getPlayerSelectedNinjas().get(i).getNinjaName());
                        }

                        FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                        InternalMenu = new SubMenu(NarutoNinjaWarApp.getPlayer2(), "selecionar_personagem");
                        FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().add(InternalMenu);
                    }

                }else if(player.getPlayerId()==2){
                    if(!ninjas.verifySelectedNinjas()){
                        System.out.println("Selecione todos os ninjas.");
                    }else {
                        player.getPlayerSelectedNinjas().addAll(ninjas.getNinjasSelectedList());
                        ninjas.clearAllLists();
                        for(int i =0;i<ninjas.getNinjasSelectedList().size();i++){
                            System.out.println(player.getPlayerSelectedNinjas().get(i).getNinjaName());
                        }

                        FXGL.getSceneService().getCurrentScene().getContentRoot().getChildren().remove(InternalMenu);
                        FXGL.getGameController().startNewGame();
                        currentMusic.getAudio().stop();
                    }
                }
            });

            goBack.setTranslateX(321);
            goBack.setTranslateY(480);

            goForward.setTranslateX(463);
            goForward.setTranslateY(480);

            getChildren().addAll(goBack,goForward);

            //adiciona a barra de personagem selecionados

            var selectCharBar = new CharSelectedBar();
            var selectText = FXGL.getUIFactoryService().newText("SELECIONADOS",WHITE,20);
            selectText.setTranslateX(165);
            selectText.setTranslateY(375);
            selectText.setStroke(BLACK);
            selectText.setStrokeWidth(0.6);
            getChildren().addAll(selectCharBar,selectText);


        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class SelectCharPanel extends AnchorPane {
            private final LayoutPanelLeft panel;

            public SelectCharPanel(Player player){
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT);
                panel = new LayoutPanelLeft(player);
                getChildren().add(panel);
            }
        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class InfoCharPanel extends AnchorPane{
            private final LayoutPanelRight panel;

            public InfoCharPanel(){
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT_EXTENDED);
                panel = new LayoutPanelRight();
                getChildren().add(panel);
            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class LayoutPanelLeft extends VBox{

            private final ContentNinjaSetMenuButton nextButton;
            private final ContentNinjaSetMenuButton backButton;
            public LayoutPanelLeft(Player player){

                final NinjaSet layoutTop = new NinjaSet(player);
                final Pane layoutBottom = new Pane();
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT);
                //configuração layoutbaixo do painel1
                nextButton = new ContentNinjaSetMenuButton("Página Anterior", layoutTop::previousPage);
                backButton = new ContentNinjaSetMenuButton("Próxima Página", layoutTop::nextPage);

                nextButton.setTranslateX(59);
                nextButton.setTranslateY(5);

                backButton.setTranslateX(184);
                backButton.setTranslateY(5);

                layoutBottom.getChildren().addAll(nextButton, backButton);

                getChildren().addAll(layoutTop, layoutBottom);

            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class NinjaSet extends Pane{

            private  int pageSelected = 1;
            private final GridPane iconOrganizer = new GridPane();
            private ImageView[] page1 = new ImageView[9];
            private ImageView[] page2 = new ImageView[9];
            private ImageView[] page3 = new ImageView[2];


            public NinjaSet(Player player){
                setPrefSize(310,292);
                setTranslateX(20);
                setTranslateY(10);


                iconOrganizer.setPrefSize(310,292);
                iconOrganizer.setTranslateX(0);
                iconOrganizer.setTranslateY(0);

                iconOrganizer.setAlignment(Pos.CENTER);
                iconOrganizer.setPadding(new Insets(20));
                setEffect(Effects.ShadowEffects.BROWN_BLACK_SHADOW);

                for(int i = 0; i<9; i++){
                    page1[i]= ninjas.getNinjaSet().get(i).getNINJA_ICON();

                }
                for(int i = 0; i<9;i++){
                    page2[i] = ninjas.getNinjaSet().get(i+9).getNINJA_ICON();
                }
                for(int i = 0; i<2; i++){
                    page3[i] = ninjas.getNinjaSet().get(i+18).getNINJA_ICON();
                }
                selectPage(1);

                iconOrganizer.setHgap(10);
                iconOrganizer.setVgap(10);

                getChildren().add(iconOrganizer);


            }
            public void nextPage(){
                if(pageSelected <3){
                    setPageSelected(getPageSelected()+1);
                    selectPage(pageSelected);
                }
            }

            public void previousPage(){
                if(pageSelected >1){
                    setPageSelected(getPageSelected()-1);
                    selectPage(pageSelected);
                }
            }


            public void selectPage(int pageId){
                int index = 0;
                switch(pageId){
                    case 1:
                        pageSelected = pageId;
                        iconOrganizer.getChildren().clear();
                        for(int l = 0; l<3;l++){
                            for(int c = 0; c<3; c++) {
                                iconOrganizer.add(page1[index], c, l);
                                index++;
                            }
                        }

                        break;
                    case 2:
                        iconOrganizer.getChildren().clear();
                        pageSelected = pageId;
                        for(int l = 0; l<3;l++){
                            for(int c = 0; c<3; c++) {
                                iconOrganizer.add(page2[index], c, l);
                                System.out.println(index);
                                index++;
                            }
                        }
                        break;
                    case 3:
                        iconOrganizer.getChildren().clear();
                        pageSelected = pageId;
                        for(int l = 0; l<3;l++){
                            for(int c = 0; c<3; c++) {
                                if(index < 2) {
                                    iconOrganizer.add(page3[index], c, l);
                                    index++;
                                }else{
                                   ImageView undefined = texture(UNDEFINED);
                                   undefined.setFitHeight(80);
                                   undefined.setFitWidth(80);
                                    iconOrganizer.add(undefined,c,l);
                                }
                            }
                        }
                        break;
                }
            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class LayoutPanelRight extends VBox {

            private final Pane layoutTop = new Pane();
            private final Pane layoutMid = new Pane();
            private final Pane layoutBottom = new Pane();
            private final StackPane internalMid = new StackPane();

            private final HBox internalBottomOrganizer;
            private final VBox internalBottomLeftOrganizerText;
            private final VBox internalBottomRightOrganizerText;


            public LayoutPanelRight(){
                setPrefSize(Settings.MENU_PANELS_WIDTH,Settings.MENU_PANELS_HEIGHT_EXTENDED);
                layoutTop.setPrefSize(350,152);
                layoutMid.setPrefSize(350,51);
                layoutBottom.setPrefSize(350,233);
                System.out.println("LayoutPanelRight");
                layoutTop.setEffect(Effects.ShadowEffects.BLACK_SHADOW);
                layoutMid.setEffect(Effects.ShadowEffects.RED_SHADOW);
                layoutBottom.setEffect(Effects.ShadowEffects.BLACK_SHADOW);


                //configuração LayoutCima Painel2

                currentNinjaIcon.setFitWidth(125);
                currentNinjaIcon.setFitHeight(125);
                currentNinjaIcon.setTranslateX(112.5);
                currentNinjaIcon.setTranslateY(13.5);
                layoutTop.getChildren().add(currentNinjaIcon);

                //configuração LayoutMeio Painel2

                internalMid.setPrefSize(350,51);

                currentNinjaName.setFill(WHITE);
                currentNinjaName.setStroke(BLACK);
                currentNinjaName.setStrokeWidth(0.6);
                internalMid.getChildren().add(currentNinjaName);
                layoutMid.getChildren().add(internalMid);

                //configuração LayoutBaixo Painel2

                internalBottomOrganizer = new HBox();
                internalBottomLeftOrganizerText = new VBox();
                internalBottomRightOrganizerText = new VBox();
                internalBottomOrganizer.setAlignment(Pos.CENTER_LEFT);

                internalBottomOrganizer.setPrefSize(350,233);
                internalBottomLeftOrganizerText.setPrefSize(175,233);
                internalBottomRightOrganizerText.setPrefSize(175,233);


                currentNinjaFirstInfo.setStroke(BLACK);
                currentNinjaFirstInfo.setStrokeWidth(0.2);
                currentNinjaFirstInfo.setFill(GREEN);

                currentNinjaSecondInfo.setStroke(BLACK);
                currentNinjaSecondInfo.setStrokeWidth(0.2);
                currentNinjaSecondInfo.setFill(SKYBLUE);

                currentNinjaThirdInfo.setStroke(BLACK);
                currentNinjaThirdInfo.setStrokeWidth(0.4);
                currentNinjaThirdInfo.setFill(RED);

                currentNinjaFourthInfo.setStroke(BLACK);
                currentNinjaFourthInfo.setStrokeWidth(0.4);
                currentNinjaFourthInfo.setFill(YELLOW);

                currentNinjaFifthInfo.setStroke(BLACK);
                currentNinjaFifthInfo.setStrokeWidth(0.4);
                currentNinjaFifthInfo.setFill(ORANGE);

                currentNinjaSixthInfo.setStroke(BLACK);
                currentNinjaSixthInfo.setStrokeWidth(0.4);
                currentNinjaSixthInfo.setFill(YELLOW);

                currentNinjaSeventhInfo.setStroke(BLACK);
                currentNinjaSeventhInfo.setStrokeWidth(0.4);
                currentNinjaSeventhInfo.setFill(YELLOW);

                currentNinjaEighthInfo.setStroke(BLACK);
                currentNinjaEighthInfo.setStrokeWidth(0.4);
                currentNinjaEighthInfo.setFill(YELLOW);

                currentNinjaNinthInfo.setStroke(BLACK);
                currentNinjaNinthInfo.setStrokeWidth(0.4);
                currentNinjaNinthInfo.setFill(YELLOW);


                currentNinjaFirstInfoValue.setStroke(BLACK);
                currentNinjaFirstInfoValue.setStrokeWidth(0.4);

                currentNinjaSecondInfoValue.setStroke(BLACK);
                currentNinjaSecondInfoValue.setStrokeWidth(0.4);

                currentNinjaThirdInfoValue.setStroke(BLACK);
                currentNinjaThirdInfoValue.setStrokeWidth(0.4);

                currentNinjaFourthInfoValue.setStroke(BLACK);
                currentNinjaFourthInfoValue.setStrokeWidth(0.4);

                currentNinjaFifthInfoValue.setStroke(BLACK);
                currentNinjaFifthInfoValue.setStrokeWidth(0.4);

                currentNinjaSixthInfoValue.setStroke(BLACK);
                currentNinjaSixthInfoValue.setStrokeWidth(0.4);

                currentNinjaSeventhInfoValue.setStroke(BLACK);
                currentNinjaSeventhInfoValue.setStrokeWidth(0.4);

                currentNinjaEighthInfoValue.setStroke(BLACK);
                currentNinjaEighthInfoValue.setStrokeWidth(0.4);

                currentNinjaNinthInfoValue.setStroke(BLACK);
                currentNinjaNinthInfoValue.setStrokeWidth(0.4);


                StackPane leftTextField1 = new StackPane();
                StackPane leftTextField2 = new StackPane();
                StackPane leftTextField3 = new StackPane();
                StackPane leftTextField4 = new StackPane();
                StackPane leftTextField5 = new StackPane();
                StackPane leftTextField6 = new StackPane();
                StackPane leftTextField7 = new StackPane();
                StackPane leftTextField8 = new StackPane();
                StackPane leftTextField9 = new StackPane();

                /*leftTextField1.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField2.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField3.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField4.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField5.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField6.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField7.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField8.setEffect(Effects.ShadowEffects.RED_SHADOW);
                leftTextField9.setEffect(Effects.ShadowEffects.RED_SHADOW);*/

                leftTextField1.getChildren().add(currentNinjaFirstInfo);
                leftTextField2.getChildren().add(currentNinjaSecondInfo);
                leftTextField3.getChildren().add(currentNinjaThirdInfo);
                leftTextField4.getChildren().add(currentNinjaFourthInfo);
                leftTextField5.getChildren().add(currentNinjaFifthInfo);
                leftTextField6.getChildren().add(currentNinjaSixthInfo);
                leftTextField7.getChildren().add(currentNinjaSeventhInfo);
                leftTextField8.getChildren().add(currentNinjaEighthInfo);
                leftTextField9.getChildren().add(currentNinjaNinthInfo);

                leftTextField1.setPrefSize(87,25.8);
                leftTextField2.setPrefSize(87,25.8);
                leftTextField3.setPrefSize(87,25.8);
                leftTextField4.setPrefSize(87,25.8);
                leftTextField5.setPrefSize(87,25.8);
                leftTextField6.setPrefSize(87,25.8);
                leftTextField7.setPrefSize(87,25.8);
                leftTextField8.setPrefSize(87,25.8);
                leftTextField9.setPrefSize(87,25.8);


                StackPane rightTextField1 = new StackPane();
                StackPane rightTextField2 = new StackPane();
                StackPane rightTextField3 = new StackPane();
                StackPane rightTextField4 = new StackPane();
                StackPane rightTextField5 = new StackPane();
                StackPane rightTextField6 = new StackPane();
                StackPane rightTextField7 = new StackPane();
                StackPane rightTextField8 = new StackPane();
                StackPane rightTextField9 = new StackPane();

                /*rightTextField1.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField2.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField3.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField4.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField5.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField6.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField7.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField8.setEffect(Effects.ShadowEffects.GREEN_SHADOW);
                rightTextField9.setEffect(Effects.ShadowEffects.GREEN_SHADOW);*/

                var skillBar = new HBox();

                StackPane[] stackPanes = new StackPane[4];


                skillBar.setPrefSize(87,25.8);

                //inicializando a currentSkillList
                for(int i = 0; i< 4; i++) {
                    currentSkillList.add(null);
                }

                for(int i = 0; i<4; i++){
                    currentSkillIcons.add(texture(UNDEFINED));
                    currentSkillIcons.get(i).setFitHeight(25.8);
                    currentSkillIcons.get(i).setFitWidth(25.8);
                    stackPanes[i] = new StackPane();
                    stackPanes[i].setPrefSize(43.75,25.8);
                    stackPanes[i].getChildren().add(currentSkillIcons.get(i));
                    skillBar.getChildren().add(stackPanes[i]);
                }
                ninjas.onMouseActionsInSkillIcons(currentSkillIcons);

                rightTextField1.getChildren().add(currentNinjaFirstInfoValue);
                rightTextField2.getChildren().add(currentNinjaSecondInfoValue);
                rightTextField3.getChildren().add(currentNinjaThirdInfoValue);
                rightTextField4.getChildren().add(currentNinjaFourthInfoValue);
                rightTextField5.getChildren().add(currentNinjaFifthInfoValue);
                rightTextField6.getChildren().add(skillBar);
                rightTextField7.getChildren().add(currentNinjaSeventhInfoValue);
                rightTextField8.getChildren().add(currentNinjaEighthInfoValue);
                rightTextField9.getChildren().add(currentNinjaNinthInfoValue);

                rightTextField1.setPrefSize(87,25.8);
                rightTextField2.setPrefSize(87,25.8);
                rightTextField3.setPrefSize(87,25.8);
                rightTextField4.setPrefSize(87,25.8);
                rightTextField5.setPrefSize(87,25.8);
                rightTextField6.setPrefSize(87,25.8);
                rightTextField7.setPrefSize(87,25.2);
                rightTextField8.setPrefSize(87,25.8);
                rightTextField9.setPrefSize(87,25.8);

                internalBottomLeftOrganizerText.getChildren().add(leftTextField1);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField2);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField3);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField4);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField5);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField6);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField7);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField8);
                internalBottomLeftOrganizerText.getChildren().add(leftTextField9);

                internalBottomRightOrganizerText.getChildren().add(rightTextField1);
                internalBottomRightOrganizerText.getChildren().add(rightTextField2);
                internalBottomRightOrganizerText.getChildren().add(rightTextField3);
                internalBottomRightOrganizerText.getChildren().add(rightTextField4);
                internalBottomRightOrganizerText.getChildren().add(rightTextField5);
                internalBottomRightOrganizerText.getChildren().add(rightTextField6);
                internalBottomRightOrganizerText.getChildren().add(rightTextField7);
                internalBottomRightOrganizerText.getChildren().add(rightTextField8);
                internalBottomRightOrganizerText.getChildren().add(rightTextField9);

                internalBottomOrganizer.getChildren().addAll(internalBottomLeftOrganizerText, internalBottomRightOrganizerText);
                layoutBottom.getChildren().add(internalBottomOrganizer);

                getChildren().addAll(layoutTop, layoutMid, layoutBottom);

            }
        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public  class ContentNinjaSetMenuButton extends StackPane{
            private final String name;
            private final Text text;
            private final Runnable action;

            public ContentNinjaSetMenuButton(String name, Runnable action){
                this.name=name;
                this.action = action;

                setPrefSize(110,18);
                text = FXGL.getUIFactoryService().newText(name, rgb(255,255,255),12.0);
                setEffect(Effects.ShadowEffects.BLACK_SHADOW);
                System.out.println("testeContentMenuButton");

                setFocusTraversable(true);

                setOnMouseEntered(e ->{
                    text.setFill(ORANGE);
                    setEffect(Effects.ShadowEffects.WHITE_SHADOW);
                    setFocused(true);
                });

                setOnMouseExited(e ->{
                    text.setFill(WHITE);
                    setEffect(Effects.ShadowEffects.BLACK_SHADOW);
                    setFocused(false);
                });

                setOnMouseClicked(e ->{
                    action.run();
                });

                getChildren().add(text);
            }

        }
        @EqualsAndHashCode(callSuper = true)
        @Data
        public class BackNextCharMenuButton extends StackPane{
            private String name;
            private final Text text;
            private Runnable action;

            public BackNextCharMenuButton(String name, Runnable action){
                setPrefSize(121,40);

                text = FXGL.getUIFactoryService().newText(name, rgb(255,255,255),23.0);
                text.setStroke(BLACK);
                text.setStrokeWidth(0.4);
                System.out.println("teste BackNext");

                setEffect(Effects.ShadowEffects.BLACK_SHADOW);

                setFocusTraversable(true);

                setOnMouseEntered(e ->{
                    text.setFill(ORANGE);
                    setEffect(Effects.ShadowEffects.WHITE_SHADOW);
                    setFocused(true);
                });

                setOnMouseExited(e ->{
                    text.setFill(WHITE);
                    setEffect(Effects.ShadowEffects.BLACK_SHADOW);
                    setFocused(false);
                });

                setOnMouseClicked(e ->{
                    SistemaChuvaMenu.criarRelampago();
                    action.run();
                });

                getChildren().add(text);

            }

        }



        @EqualsAndHashCode(callSuper = true)
        @Data
        public class CharSelectedBar extends HBox {
            public CharSelectedBar() {
                setPrefSize(350, 60);
                setTranslateX(57);
                setTranslateY(380);
                setPadding(new Insets(10));
                for (int i = 0; i < 5; i++) {
                    charSelectImageBar.add(new ImageView(texture(UNDEFINED).getImage()));
                    charSelectNinjaBar.add(null);
                    charSelectImageBar.get(i).setFitHeight(60);
                    charSelectImageBar.get(i).setFitWidth(60);
                    var node = charSelectImageBar.get(i);
                    setMargin(node, new Insets(0, 10, 0, 0));
                    getChildren().add(node);
                }

            }
        }
    }
}

