package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.gympro.Clases.User;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class MachineInfoController {
    User user;

    int numero;
    @FXML
    private ImageView imaegen;
    @FXML
    private Label MachineName;
    @FXML
    private Label Description;
    @FXML
    private Button backButton;
    @FXML
    private Button crossButton;
    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void irAtras(ActionEvent event) {
        if (getNumero()==1|getNumero()==2|getNumero()==3){
            irPeck();
        } else if (getNumero()==4|getNumero()==5|getNumero()==6) {
            irLeg();
        }else if (getNumero()==7|getNumero()==8|getNumero()==9) {
            irArms();
        }else if (getNumero()==10|getNumero()==11|getNumero()==12) {
            irBack();
        }else if (getNumero()==13|getNumero()==14|getNumero()==15) {
            irShoulder();
        }else if (getNumero()==16|getNumero()==17|getNumero()==18) {
            irAbs();
        }
    }

    private void irPeck(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PeckMachines.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            PeckMachinesController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void irLeg(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LegMachines.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            LegMachinesController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void irArms(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ArmsMachines.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            ArmsMachinesController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void irBack(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/BackMachines.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            BackMachinesController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void irShoulder(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ShoulderMachines.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            ShoulderMachinesController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void irAbs(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/AbsMachines.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            AbsMachinesController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void construirPag(int numero){
        if (numero==1){

            MachineName.setText("PECK-DECK");
            Description.setText("1. Adjust the machine and sit with good posture.\n" +
                    "2. Grab the handles and push them forward.\n" +
                    "3. Exhale as you bring the handles together in front of your chest.\n" +
                    "4. Inhale as you slowly return to the starting position.\n" +
                    "5. Do 3-4 sets of 8-12 reps.\n" +
                    "6. Rest for 1-2 minutes between sets.\n" +
                    "7. Experiment with different grips.\n" +
                    "8. Stop if you feel pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/PeckDeck.gif");
        } else if (numero==2) {
            MachineName.setText("Chest Thrusts");
            Description.setText("1. Adjust the bench to a flat position.\n" +
                    "2. Lie down with your back on the bench.\n" +
                    "3. Hold dumbbells above your chest with your arms straight.\n" +
                    "4. Lower the dumbbells towards your chest.\n" +
                    "5. Exhale as you push the dumbbells back up.\n" +
                    "6. Do 3-4 sets of 8-12 reps.\n" +
                    "7. Rest for 1-2 minutes between sets.\n" +
                    "8. Try different grip widths.\n" +
                    "9. Stop if you feel pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/empujePecho.gif");
        } else if (numero==3) {
            MachineName.setText("Bench Press");
            Description.setText("1. Adjust the bench to a flat position.\n" +
                    "2. Lie down on the bench with your back flat.\n" +
                    "3. Grip the barbell with your hands slightly wider than shoulder-width apart.\n" +
                    "4. Lower the barbell to your chest, keeping your elbows at a 45-degree angle.\n" +
                    "5. Push the barbell back up to the starting position.\n" +
                    "6. Exhale as you push the barbell up.\n" +
                    "7. Aim for 3-4 sets of 8-12 reps.\n" +
                    "8. Rest for 1-2 minutes between sets.\n" +
                    "9. Experiment with grip width for variation.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/pressbanca.gif");
        }else if (numero==4) {
            MachineName.setText("Leg Press");
            Description.setText("1. Adjust the seat and backrest to a comfortable position.\n" +
                    "2. Sit down and place your feet shoulder-width apart on the footplate.\n" +
                    "3. Release the safety handles and extend your legs to push the footplate away.\n" +
                    "4. Lower the footplate by bending your knees to a 90-degree angle.\n" +
                    "5. Push the footplate back up by extending your legs.\n" +
                    "6. Exhale as you push the footplate.\n" +
                    "7. Aim for 3-4 sets of 8-12 reps.\n" +
                    "8. Rest for 1-2 minutes between sets.\n" +
                    "9. Adjust foot placement to target different leg muscles.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/prensa.gif");
        }else if (numero==5) {
            MachineName.setText("Leg Extension");
            Description.setText("1. Adjust the machine so the pad rests comfortably on your shins just above your ankles.\n" +
                    "2. Sit down and place your feet under the pad, with your knees bent at a 90-degree angle.\n" +
                    "3. Grip the handles on the sides of the seat for stability.\n" +
                    "4. Extend your legs straight out in front of you.\n" +
                    "5. Exhale as you lift the pad.\n" +
                    "6. Slowly lower the pad back to the starting position.\n" +
                    "7. Aim for 3-4 sets of 8-12 reps.\n" +
                    "8. Rest for 1-2 minutes between sets.\n" +
                    "9. Adjust the weight to match your strength level.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/extensionCuadriceps.gif");
        }else if (numero==6) {
            MachineName.setText("Split Squats");
            Description.setText("1. Stand with your feet hip-width apart.\n" +
                    "2. Step one foot forward and the other foot back, positioning yourself in a staggered stance.\n" +
                    "3. Keep your torso upright and hands on your hips or at your sides.\n" +
                    "4. Lower your body until your back knee nearly touches the ground and your front thigh is parallel to the floor.\n" +
                    "5. Push through your front heel to return to the starting position.\n" +
                    "6. Exhale as you push up.\n" +
                    "7. Aim for 3-4 sets of 8-12 reps per leg.\n" +
                    "8. Rest for 1-2 minutes between sets.\n" +
                    "9. Switch legs and repeat.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/bulgaras.gif");
        }else if (numero==7) {
            MachineName.setText("Bicep Curl");
            Description.setText("1. Stand with your feet shoulder-width apart.\n" +
                    "2. Hold a dumbbell in each hand with your palms facing forward.\n" +
                    "3. Keep your elbows close to your sides.\n" +
                    "4. Curl the weights up towards your shoulders while exhaling.\n" +
                    "5. Lower the weights back to the starting position while inhaling.\n" +
                    "6. Aim for 3-4 sets of 8-12 reps.\n" +
                    "7. Rest for 1-2 minutes between sets.\n" +
                    "8. Keep your back straight and avoid swinging the weights.\n" +
                    "9. Adjust the weight to match your strength level.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/curlBicepsf.gif");
        }
        else if (numero==8) {
                MachineName.setText("Single-arm Curl");
            Description.setText("1. Stand with your feet shoulder-width apart.\n" +
                    "2. Hold a dumbbell in one hand with your palm facing forward.\n" +
                    "3. Keep your elbow close to your side.\n" +
                    "4. Curl the weight up towards your shoulder while exhaling.\n" +
                    "5. Lower the weight back to the starting position while inhaling.\n" +
                    "6. Aim for 3-4 sets of 8-12 reps per arm.\n" +
                    "7. Rest for 1-2 minutes between sets.\n" +
                    "8. Switch arms and repeat.\n" +
                    "9. Keep your back straight and avoid swinging the weight.\n" +
                    "10. Adjust the weight to match your strength level.\n" +
                    "11. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/bicepsUnilateral.gif");
        }
        else if (numero==9) {
            MachineName.setText("Preacher Curl");
            Description.setText("1. Adjust the preacher bench so your upper arms rest comfortably on the pad.\n" +
                    "2. Sit down and grip an EZ curl bar or dumbbell with your palms facing up.\n" +
                    "3. Position your upper arms on the pad and extend your arms fully.\n" +
                    "4. Curl the weight up towards your shoulders while exhaling.\n" +
                    "5. Lower the weight back to the starting position while inhaling.\n" +
                    "6. Aim for 3-4 sets of 8-12 reps.\n" +
                    "7. Rest for 1-2 minutes between sets.\n" +
                    "8. Keep your upper arms on the pad throughout the movement.\n" +
                    "9. Adjust the weight to match your strength level.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/predicadorUnilateral.gif");
        }else if (numero==10) {
            MachineName.setText("Lat Pulldown");
            Description.setText("1. Adjust the thigh pad to secure your legs.\n" +
                    "2. Sit down and grip the bar with your hands wider than shoulder-width apart, palms facing forward.\n" +
                    "3. Slightly lean back while keeping your back straight.\n" +
                    "4. Pull the bar down towards your chest while exhaling, bringing your shoulder blades together.\n" +
                    "5. Slowly return the bar to the starting position while inhaling.\n" +
                    "6. Aim for 3-4 sets of 8-12 reps.\n" +
                    "7. Rest for 1-2 minutes between sets.\n" +
                    "8. Avoid using momentum; focus on controlled movements.\n" +
                    "9. Adjust the weight to match your strength level.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/jalonPecho.gif");
        }else if (numero==11) {
            MachineName.setText("Bent-Over Row");
            Description.setText("1. Stand with your feet shoulder-width apart, knees slightly bent.\n" +
                    "2. Hold a barbell or dumbbells with your palms facing down.\n" +
                    "3. Bend at your hips, keeping your back straight and almost parallel to the floor.\n" +
                    "4. Let the weights hang directly in front of you, arms fully extended.\n" +
                    "5. Pull the weights towards your lower ribcage while exhaling, squeezing your shoulder blades together.\n" +
                    "6. Slowly lower the weights back to the starting position while inhaling.\n" +
                    "7. Aim for 3-4 sets of 8-12 reps.\n" +
                    "8. Rest for 1-2 minutes between sets.\n" +
                    "9. Avoid rounding your back; maintain a neutral spine.\n" +
                    "10. Adjust the weight to match your strength level.\n" +
                    "11. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/remo.gif");
        }
        else if (numero==12) {
            MachineName.setText("Dumbbell Row");
            Description.setText("1. Stand with your feet shoulder-width apart, holding a dumbbell in each hand.\n" +
                    "2. Bend your knees slightly and hinge forward at your hips, keeping your back straight.\n" +
                    "3. Let the dumbbells hang straight down toward the floor, arms fully extended.\n" +
                    "4. Pull one dumbbell up towards your lower ribcage, keeping your elbow close to your body.\n" +
                    "5. Squeeze your shoulder blade as you lift the dumbbell.\n" +
                    "6. Lower the dumbbell back down with control.\n" +
                    "7. Repeat the movement on the other side.\n" +
                    "8. Aim for 3-4 sets of 8-12 reps per arm.\n" +
                    "9. Rest for 1-2 minutes between sets.\n" +
                    "10. Keep your core engaged and your spine neutral throughout the exercise.\n" +
                    "11. Adjust the weight as needed to maintain proper form.\n" +
                    "12. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/remoUni.gif");
        }
        else if (numero==13) {
            MachineName.setText("Military Press");
            Description.setText("1. Sit or stand with your feet shoulder-width apart, holding a barbell at shoulder height with an overhand grip.\n" +
                    "2. Engage your core and keep your back straight.\n" +
                    "3. Press the barbell overhead until your arms are fully extended, exhaling as you push.\n" +
                    "4. Lower the barbell back down to shoulder height, inhaling as you lower.\n" +
                    "5. Keep your elbows slightly in front of your body throughout the movement.\n" +
                    "6. Aim for 3-4 sets of 8-12 reps.\n" +
                    "7. Rest for 1-2 minutes between sets.\n" +
                    "8. Maintain a neutral spine and avoid arching your back excessively.\n" +
                    "9. Adjust the weight to match your strength level.\n" +
                    "10. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/pressMilitar.gif");
        }
        else if (numero==14) {
            MachineName.setText("Lateral Raises");
            Description.setText("1. Stand with your feet shoulder-width apart, holding a dumbbell in each hand by your sides.\n" +
                    "2. Engage your core and keep a slight bend in your elbows.\n" +
                    "3. Lift both dumbbells out to the sides until they reach shoulder height, keeping your palms facing downward.\n" +
                    "4. Exhale as you raise the dumbbells.\n" +
                    "5. Lower the dumbbells back down to the starting position with control.\n" +
                    "6. Inhale as you lower the dumbbells.\n" +
                    "7. Aim for 3-4 sets of 8-12 reps.\n" +
                    "8. Rest for 1-2 minutes between sets.\n" +
                    "9. Keep your torso stable and avoid swinging your body to lift the weights.\n" +
                    "10. Adjust the weight to match your strength level.\n" +
                    "11. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/laterales.gif");
        }
        else if (numero==15) {
            MachineName.setText("Dumbbell Flyes");
            Description.setText("1. Lie on a flat bench with a dumbbell in each hand, palms facing inward.\n" +
                    "2. Extend your arms directly above your chest with a slight bend in your elbows.\n" +
                    "3. Lower the dumbbells out to the sides in a wide arc until your arms are parallel to the floor, keeping a slight bend in your elbows.\n" +
                    "4. Keep your core engaged and your back pressed into the bench.\n" +
                    "5. Exhale as you lower the dumbbells.\n" +
                    "6. Slowly bring the dumbbells back together over your chest, squeezing your chest muscles.\n" +
                    "7. Inhale as you raise the dumbbells.\n" +
                    "8. Aim for 3-4 sets of 8-12 reps.\n" +
                    "9. Rest for 1-2 minutes between sets.\n" +
                    "10. Use a weight that allows you to maintain control throughout the movement.\n" +
                    "11. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/posterior.gif");
        }
        else if (numero==16) {
            MachineName.setText("Cable Crunches");
            Description.setText("1. Set up a cable machine with a rope attachment at the highest setting.\n" +
                    "2. Kneel down facing away from the machine, holding the rope above your head with both hands.\n" +
                    "3. Keep your hips stationary and contract your abs to curl your torso downward towards the floor.\n" +
                    "4. Exhale as you crunch down, bringing your elbows towards your thighs.\n" +
                    "5. Pause for a moment at the bottom of the movement, feeling the contraction in your abs.\n" +
                    "6. Inhale as you slowly return to the starting position, keeping tension on your abs.\n" +
                    "7. Aim for 3-4 sets of 10-15 reps.\n" +
                    "8. Rest for 1-2 minutes between sets.\n" +
                    "9. Keep your movements controlled and avoid using momentum.\n" +
                    "10. Adjust the weight as needed to maintain proper form.\n" +
                    "11. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/abspolea.gif");
        }
        else if (numero==17) {
            MachineName.setText("Leg Raises");
            Description.setText("1. Lie down on your back on a mat or bench with your legs straight and your arms by your sides.\n" +
                    "2. Keep your lower back pressed into the ground to engage your core muscles.\n" +
                    "3. Lift your legs off the ground, keeping them straight, until they are perpendicular to the floor.\n" +
                    "4. Exhale as you raise your legs.\n" +
                    "5. Hold the raised position for a moment, squeezing your lower abs.\n" +
                    "6. Lower your legs back down slowly, keeping them straight and controlled.\n" +
                    "7. Inhale as you lower your legs.\n" +
                    "8. Aim for 3-4 sets of 10-15 reps.\n" +
                    "9. Rest for 1-2 minutes between sets.\n" +
                    "10. Keep your movements controlled and avoid swinging your legs.\n" +
                    "11. Modify the difficulty by bending your knees or using a bench for support if needed.\n" +
                    "12. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/abspierna.gif");
        }
        else if (numero==18) {
            MachineName.setText("Bench Crunches");
            Description.setText("1. Lie down on a bench with your back flat against the surface and your feet planted firmly on the ground.\n" +
                    "2. Place your hands lightly behind your head, elbows pointed out to the sides.\n" +
                    "3. Engage your core muscles by pulling your belly button towards your spine.\n" +
                    "4. Lift your upper body off the bench by contracting your abdominal muscles, aiming to bring your ribcage towards your hips.\n" +
                    "5. Exhale as you crunch up.\n" +
                    "6. Hold the contraction at the top for a moment, squeezing your abs.\n" +
                    "7. Slowly lower your upper body back down to the starting position, keeping tension on your abs.\n" +
                    "8. Inhale as you lower down.\n" +
                    "9. Rest for 1-2 minutes between sets.\n" +
                    "10. Keep your movements controlled and avoid pulling on your neck with your hands.\n" +
                    "11. Stop if you feel any discomfort or pain.");
            contruirImagen("src/main/resources/Elements/ejsGifts/absbanco.gif");
        }
    }

    public void contruirImagen(String pathsrc){
        String rutaArchivo = pathsrc;
        File archivo = new File(rutaArchivo);

        try {
            URL url = archivo.toURI().toURL();
            imaegen.setImage(new Image("file://"+url.getPath()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        construirPag(numero);
    }
}
