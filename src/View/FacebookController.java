/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.Membre;
import service.CompteMembre;





public class FacebookController extends Application {
    
    public static Membre user= new Membre();
    String token;
    String appSecret = "772c38bdd02eff33d34fc23eaf916e6e";
    String appId = "1545494242446524";
    Membre client = new Membre();
    CompteMembre userDAO;
    Stage stage;
    Parent root;
    @FXML
    private WebView web;
         
    //LoginnController loginWindowController;

    public void getName(String accessToken) throws IOException, Exception {
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, appSecret, Version.VERSION_2_5);
        User me = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "email"), Parameter.with("fields", "birthday"));
        client.setId(Integer.parseInt(me.getId().substring(10)));

        if (me.getEmail() == null) {
            me = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "email"));
            client.setEmail(me.getEmail());
            client.setPseudo(me.getEmail());
        }
        if (me.getFirstName() == null) {
            me = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "first_name"));
            client.setPrenom(me.getFirstName());
        }

        if (me.getLastName() == null) {
            me = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "last_name"));
            client.setNom(me.getLastName());
        }
        

         client.setPseudo(client.getNom()+client.getPrenom());
         client.setMdp("facebook");
           client.setProfession("");
            client.setPays("");
           client.setPic("");
           
          
         
         
             user=client;
            primaryStage.close();
      
            root = FXMLLoader.load(getClass().getResource("/View/FXMLProfile.fxml"));
           
             Scene scene = new Scene(root);
              primaryStage.setScene(scene);
             primaryStage.show();
        //List u = facebookClient.executeFqlQuery("SELECT uid, name, email FROM user WHERE uid = me()", User.class);
        //User m = facebookClient.fetchObject(me.getId(), User.class, Parameter.with("fields", "email"));
        //System.out.println(m);
    }
    

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        String url = "https://www.facebook.com/dialog/oauth?client_id=" + appId + "&redirect_uri=https://www.facebook.com/connect/login_success.html&response_type=token&scope=email,public_profile,user_birthday";
        engine.load(url);
        engine.getLoadWorker().stateProperty().addListener((ob, oldState, newState) -> {
            if (engine.getLocation().contains("access_token")) {
                token = engine.getLocation().substring(engine.getLocation().indexOf("access_token") + "access_token=".length(), engine.getLocation().length());
                token = token.substring(0, token.indexOf("&"));
                if (!token.isEmpty()) {
                    try {
                        getName(token);
                    } catch (IOException ex) {
                        Logger.getLogger(FacebookController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(FacebookController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        VBox root = new VBox();
        root.getChildren().addAll(webView);

        Scene scene = new Scene(root, 500, 600);
        this.primaryStage.setTitle("Login to facebook");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }

  

    public FacebookController() {
    }

    @FXML
    private void verifURL(MouseEvent event) throws IOException {
      /*  if(userDAO.seekUserByEmail(client.getEmail()))
      {
            
            stage = (Stage) web.getScene().getWindow();
             root = FXMLLoader.load(getClass().getResource("/View/FXMLProfile.fxml"));
        
             Scene scene = new Scene(root);

              stage.setScene(scene);
        
        stage.show();
                   }
        else
        {
              
           userDAO = new CompteMembre();
            userDAO.ajouterMembre(client);
            stage = (Stage) web.getScene().getWindow();
             root = FXMLLoader.load(getClass().getResource("/View/FXMLProfile.fxml"));
        
             Scene scene = new Scene(root);

              stage.setScene(scene);
        
        stage.show();
        }
    }*/

}}
