/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.FXMLListUserController;
import controller.application.Administrateur.ViewAdminController;
import controller.application.Membre.ViewMembreController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import media.userNameMedia;

/**
 * FXML Controller class
 *
 * @author haythem
 */
public class ApplicationnController implements Initializable {
    
    
    @FXML
    private AnchorPane acMain;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private StackPane spMainContent;
    @FXML
    private BorderPane appContent;
    @FXML
    private AnchorPane acHead;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Button btnLogOut;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Label lblUsrName;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private Label lblUserId;
    @FXML
    private StackPane acContent;
    @FXML
    private Button btnVideo;
    @FXML
    private Button btnMembres;
    @FXML
    private Button btnJeux;
    @FXML
    private Button btnForum;
    @FXML
    private Button btnApropos;
    @FXML
    private Button btnServeurs;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnReglage;
    
    private userNameMedia usrNameMedia;
    
    String usrName;
    String id;
    @FXML
    private ImageView imgVideoBtn;
    @FXML
    private ImageView imgMembresBtn;
    @FXML
    private ImageView imgJeuxBtn;
    @FXML
    private ImageView imgForumBtn;
    @FXML
    private ImageView imgServeursBtn;
    @FXML
    private ImageView imgEventBtn;
    @FXML
    private ImageView imgReglageBtn;
    @FXML
    private ImageView imgAproposBtn;
    
    public userNameMedia getUsrNameMedia() {
        return usrNameMedia;
    }
    
    public void setUsrNameMedia(userNameMedia usrNameMedia) {
        lblUserId.setText(usrNameMedia.getId());
        lblUsrName.setText(usrNameMedia.getUsrName());
        id = usrNameMedia.getId();
        usrName = usrNameMedia.getUsrName();

        this.usrNameMedia = usrNameMedia;
    }
    
    Image menuImage = new Image("/icon/menu.png");
    Image menuImageRed = new Image("/icon/menuRed.png");
    Image image;

    String defultStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:none";

    String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:#FF4E3C";

    Image home = new Image("/icon/home.png");
    Image homeRed = new Image("/icon/homeRed.png");
    Image video = new Image("/icon/video.png");
    Image videoRed = new Image("/icon/videoRed.png");
    Image jeu = new Image("/icon/jeu.png");
    Image jeutRed = new Image("/icon/jeuRed.png");
    Image membre = new Image("/icon/membre.png");
    Image membreRed = new Image("/icon/membreRed.png");
    Image store = new Image("/icon/store.png");
    Image storeRed = new Image("/icon/storeRed.png");
    Image topic = new Image("/icon/topic.png");
    Image topicRed = new Image("/icon/topicRed.png");
    Image serveur = new Image("/icon/serveur.png");
    Image serveurRed = new Image("/icon/serveurRed.png");
    Image event = new Image("/icon/event.png");
    Image eventRed = new Image("/icon/eventRed.png");
    Image reglage = new Image("/icon/reglage.png");
    Image reglageRed = new Image("/icon/reglageRed.png");
    Image about = new Image("/icon/about.png");
    Image aboutRed = new Image("/icon/aboutRed.png");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgMenuBtn.setImage(menuImage);
        Image usrImg = new Image("/image/pho.png");
        imgUsrTop.setFill(new ImagePattern(usrImg));
        circleImgUsr.setFill(new ImagePattern(usrImg));
    }    

    @FXML
    private void btnHomeOnClick(ActionEvent event) {
    }

    @FXML
    private void btnStoreOnClick(ActionEvent event) {
    }


    @FXML
    private void hlUpdateAccount(ActionEvent event) {
    }

    @FXML
    private void btnLogOut(ActionEvent event) throws IOException {
        acContent.getChildren().clear();
        acContent.getChildren().add(FXMLLoader.load(getClass().getResource("/View/Login.fxml")));
        acDashBord.getChildren().clear();
        acHead.getChildren().clear();
        acHead.setMaxHeight(0.0); 
    }

    @FXML
    private void mbtnOnClick(ActionEvent event) {
    }

    @FXML
    private void sideMenuToogleBtnOnCLick(ActionEvent event) {
        if (sideMenuToogleBtn.isSelected()) {
            imgMenuBtn.setImage(menuImageRed);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(-130);
            sideMenu.play();
            acDashBord.getChildren().clear();
        } else {
            imgMenuBtn.setImage(menuImage);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(130);
            sideMenu.play();
            acDashBord.getChildren().add(leftSideBarScroolPan);
        }
    }

    @FXML
    private void acMain(KeyEvent event) {
        if (event.getCode() == KeyCode.F11) {
            Stage stage = (Stage) acMain.getScene().getWindow();
            stage.setFullScreen(true);
        }
    }

    @FXML
    private void acMainOnMouseMove(MouseEvent event) {
    }

    @FXML
    private void btnVideoOnClick(ActionEvent event) {
    }

    @FXML
    private void btnMembresOnClick(ActionEvent event) {
         try {
            MembreActive();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/FXMLListUser.fxml").openStream());
            FXMLListUserController MController = fXMLLoader.getController();
           MController.usr.getStylesheets().add("/style/MainStyle.css");
            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationnController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btnJeuxOnClick(ActionEvent event) {
    }

    @FXML
    private void btnForumOnClick(ActionEvent event) {
    }

    @FXML
    private void btnServeursOnClick(ActionEvent event) throws IOException {
    }

    @FXML
    private void btnAproposOnClick(ActionEvent event) {
        try {
            AdminActive();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/ViewAdministrateur.fxml").openStream());
            ViewAdminController aController = fXMLLoader.getController();
           aController.acAdminMainContent.getStylesheets().add("/style/MainStyle.css");
            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationnController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void btnEventOnClick(ActionEvent event) {
    }

    @FXML
    private void btnReglageOnClick(ActionEvent event) {
    }
    
    private void serveurActive() {
        imgHomeBtn.setImage(home);
        imgVideoBtn.setImage(video);
        imgJeuxBtn.setImage(jeu);
        imgMembresBtn.setImage(membre);
        imgStoreBtn.setImage(store);
        imgForumBtn.setImage(topic);
        imgServeursBtn.setImage(serveurRed);
        imgEventBtn.setImage(event);
        imgReglageBtn.setImage(reglage);
        imgAproposBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnVideo.setStyle(defultStyle);
        btnJeux.setStyle(defultStyle);
        btnMembres.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnForum.setStyle(defultStyle);
        btnServeurs.setStyle(activeStyle);
        btnEvent.setStyle(defultStyle);
        btnReglage.setStyle(defultStyle);
        btnApropos.setStyle(defultStyle);
       
    }
    private void MembreActive() {
        imgHomeBtn.setImage(home);
        imgVideoBtn.setImage(video);
        imgJeuxBtn.setImage(jeu);
        imgMembresBtn.setImage(membreRed);
        imgStoreBtn.setImage(store);
        imgForumBtn.setImage(topic);
        imgServeursBtn.setImage(serveur);
        imgEventBtn.setImage(event);
        imgReglageBtn.setImage(reglage);
        imgAproposBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnVideo.setStyle(defultStyle);
        btnJeux.setStyle(defultStyle);
        btnMembres.setStyle(activeStyle);
        btnStore.setStyle(defultStyle);
        btnForum.setStyle(defultStyle);
        btnServeurs.setStyle(defultStyle);
        btnEvent.setStyle(defultStyle);
        btnReglage.setStyle(defultStyle);
        btnApropos.setStyle(defultStyle);
       
    }
    private void AdminActive() {
        imgHomeBtn.setImage(home);
        imgVideoBtn.setImage(video);
        imgJeuxBtn.setImage(jeu);
        imgMembresBtn.setImage(membre);
        imgStoreBtn.setImage(store);
        imgForumBtn.setImage(topic);
        imgServeursBtn.setImage(serveur);
        imgEventBtn.setImage(event);
        imgReglageBtn.setImage(reglage);
        imgAproposBtn.setImage(aboutRed);
        btnHome.setStyle(defultStyle);
        btnVideo.setStyle(defultStyle);
        btnJeux.setStyle(defultStyle);
        btnMembres.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnForum.setStyle(defultStyle);
        btnServeurs.setStyle(defultStyle);
        btnEvent.setStyle(defultStyle);
        btnReglage.setStyle(defultStyle);
        btnApropos.setStyle(activeStyle);
       
    }
    
}
