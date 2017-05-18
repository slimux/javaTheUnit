/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.FacebookController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import model.Membre;
import service.CompteMembre;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class HomeController implements Initializable {

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
    private Button btnVideo;
    @FXML
    private ImageView imgVideoBtn;
    @FXML
    private Button btnMembres;
    @FXML
    private ImageView imgMembresBtn;
    @FXML
    private Button btnJeux;
    @FXML
    private ImageView imgJeuxBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private Button btnForum;
    @FXML
    private ImageView imgForumBtn;
    @FXML
    private Button btnServeurs;
    @FXML
    private ImageView imgServeursBtn;
    @FXML
    private Button btnEvent;
    @FXML
    private ImageView imgEventBtn;
    @FXML
    private Button btnReglage;
    @FXML
    private ImageView imgReglageBtn;
    @FXML
    private Button btnApropos;
    @FXML
    private ImageView imgAproposBtn;
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     CompteMembre c=new CompteMembre();
    Membre m;
    Membre m2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgMenuBtn.setImage(menuImage);
        Image usrImg = new Image(m.getPic());
        imgUsrTop.setFill(new ImagePattern(usrImg));
        circleImgUsr.setFill(new ImagePattern(usrImg));
        // TODO
    }    
        private userNameMedia usrNameMedia;
Image menuImage = new Image("/icon/menu.png");
    Image menuImageRed = new Image("/icon/menuRed.png");
    Image image;
     public userNameMedia getUsrNameMedia() {
        return usrNameMedia;
    }
public void setUsrNameMedia(userNameMedia usrNameMedia) {
        m=   View.LoginnController.user;
         m2=FacebookController.user; 
       
        lblUsrName.setText(m.getPseudo());
        String usrName=usrNameMedia.getUsrName();
        this.usrNameMedia = usrNameMedia;
    }
    @FXML
    private void btnHomeOnClick(ActionEvent event) {
    }

    @FXML
    private void btnVideoOnClick(ActionEvent event) {
    }

    @FXML
    private void btnMembresOnClick(ActionEvent event) {
    }

    @FXML
    private void btnJeuxOnClick(ActionEvent event) {
    }

    @FXML
    private void btnStoreOnClick(ActionEvent event) {
    }

    @FXML
    private void btnForumOnClick(ActionEvent event) {
    }

    @FXML
    private void btnServeursOnClick(ActionEvent event) {
    }

    @FXML
    private void btnEventOnClick(ActionEvent event) {
    }

    @FXML
    private void btnReglageOnClick(ActionEvent event) {
    }

    @FXML
    private void btnAproposOnClick(ActionEvent event) {
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
 Stage stage;
  Parent root;

    @FXML
    private void mbtnOnClick(ActionEvent event) throws IOException {
        
        stage = (Stage) mbtnUsrInfoBox.getScene().getWindow();
        
        
         root = FXMLLoader.load(getClass().getResource("/View/FXMLProfile.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        stage.show();
        
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
    }

    @FXML
    private void acMainOnMouseMove(MouseEvent event) {
    }
    
}
