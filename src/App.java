import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    int highscore = 0;
    int number0fwinsInArow = 0;
    int backgroundR = 120;
    int backgroundG = 180;
    int backgroundB = 100;
    int playerR = 20;
    int playerG = 0;
    int playerB = 140;

    int height = 70;
    int circlex = 450;
    int circley = 675;

    PImage car1;
    PImage car2;
    PImage car3;
    PImage car4;
    PImage topcar1;
    PImage topcar2;
    PImage topcar3;
    PImage topcar4;
    int bottomRowY = 560;
    PVector rect1 = new PVector(0, bottomRowY);
    double speed = 5;
    // int rect2x = -300;
    PVector rect2 = new PVector(-300, bottomRowY);
    double speed2 = 5;
    // int rect3x = -550;
    PVector rect3 = new PVector(-550, bottomRowY);
    double speed3 = 5;
    PVector rect4 = new PVector(-800, bottomRowY);
    double speed4 = 5;

    boolean h0mescene = true;
    boolean sceneOne = false;
    boolean sceneTwo = false;
    boolean instructions = false;

    PVector train = new PVector(-200, 402);
    boolean trainMoving = false;
    float trainSpeed = 25;
    int trainTimer = 0;
    int BottomtrainTimer = 0;
    PVector bottomtrain = new PVector(900, 469);
    int topRowY = 140;
    PVector topRowrect1 = new PVector(900, topRowY);
    double speed5 = 5;
    PVector topRowrect2 = new PVector(1200, topRowY);
    double speed6 = 5;
    PVector topRowrect3 = new PVector(1500, topRowY);
    double speed7 = 5;
    PVector topRowrect4 = new PVector(1800, topRowY);
    double speed8 = 5;

    int height2 = 140;
    int hieght3 = 70;

    int lilyPadY = 315;
    PVector pad1 = new PVector(510, lilyPadY);
    PVector pad2 = new PVector(810, lilyPadY);
    PVector pad3 = new PVector(90, lilyPadY);
    PVector pad4 = new PVector(630, lilyPadY);
    PVector pad5 = new PVector(210, lilyPadY);
    PVector pad6 = new PVector(390, lilyPadY);
    PVector pad7 = new PVector(330, lilyPadY);
    boolean showCircle = true;
    int counter1 = 0;
    boolean showCircle2 = false;
    int counter2 = 0;
    boolean onPad = false;
    boolean load = true;

    public void setup() {

    }

    public void load() {
        car1 = loadImage("m9kraj9fuu1p8ckbhlsmktnk48.png");
        car1.resize(120, 100);
        car2 = loadImage("m9kraj9fuu1p8ckbhlsmktnk48.png");
        car2.resize(120, 100);
        car3 = loadImage("m9kraj9fuu1p8ckbhlsmktnk48.png");
        car3.resize(120, 100);
        car4 = loadImage("m9kraj9fuu1p8ckbhlsmktnk48.png");
        car4.resize(120, 100);
        topcar1 = loadImage("Cartoon-car-hand-drawn-on-transparent-background-PNG.png");
        topcar1.resize(120, 100);
        topcar2 = loadImage("Cartoon-car-hand-drawn-on-transparent-background-PNG.png");
        topcar2.resize(120, 100);
        topcar3 = loadImage("Cartoon-car-hand-drawn-on-transparent-background-PNG.png");
        topcar3.resize(120, 100);
        topcar4 = loadImage("Cartoon-car-hand-drawn-on-transparent-background-PNG.png");
        topcar4.resize(120, 100);
    }

    public void settings() {
        size(900, 700);

    }

    public void draw() {
        if (h0mescene == true) {
            background(215);
            textSize(100);
            fill(0, 150, 150);
            textAlign(CENTER);
            text("CROSSY ROAD", 450, 250);

            fill(0, 110, 150);
            textSize(25);
            text("Press keys 0-9 to choose your player's color", 450, 300);
            fill(playerR, playerG, playerB);
            ellipse(450, 375, 100, 100);
            fill(0, 110, 150);
            text("Press return to begin", 450, 475);

        }

        if (instructions == true) {
            background(0);
            fill(225);
            textSize(20);
            text("Use the arrow keys to move the player across the screen. Do not hit anything moving.", 450, 350);
            fill(200, 0, 0);
            textSize(20);
            text("Press p to play", 450, 370);

            if(load == true){
                load();
                load = false;
            }
        }

        if (sceneOne == true) {
            background(backgroundR, backgroundG, backgroundB);

            fill(200);
            stroke(200);
            rect(-10, 580, 910, height);// car street

            stroke(10);// bottom car street dotted line
            for (int x = 10; x < 950; x = x + 80) {
                line(x, 615, x + 40, 615);

            }
            fill(100);
            stroke(10);
            rect(-10, 395, 910, height2);// train street

            fill(10);
            stroke(10);
            line(-10, 467, 900, 467); // train top line
            line(-10, 396, 900, 396); // train middle line

            fill(backgroundR, backgroundG, backgroundB);
            stroke(backgroundR, backgroundG, backgroundB);
            rect(-10, 325, 910, hieght3);// greenary 3

            fill(135, 206, 250);
            stroke(0, 0, 200);
            rect(-10, 280, 910, height);// water
            stroke(200, 230, 255);

            fill(10, 200, 10);
            stroke(10, 200, 10);
            onPad = false;
            counter1++;

            if (counter1 >= 120) { // timer for the lilypad(2 seconds)
                showCircle = !showCircle;
                counter1 = 0;

            }
            counter2++;
            if (counter2 >= 180) { // timer for the other lilypads(3 seconds)
                showCircle2 = !showCircle2;
                counter2 = 0;
            }

            if (showCircle) {
                ellipse(pad1.x, pad1.y, 45, 45);// lilypadsal
                ellipse(pad2.x, pad2.y, 45, 45);
                ellipse(pad3.x, pad3.y, 45, 45);
                ellipse(pad7.x, pad7.y, 45, 45);
            }

            if (showCircle2) {
                ellipse(pad4.x, pad4.y, 45, 45);
                ellipse(pad5.x, pad5.y, 45, 45);
                ellipse(pad6.x, pad6.y, 45, 45);

            }
            if (showCircle) {
                if (onLilypad(pad1.x, pad1.y))
                    onPad = true;
                if (onLilypad(pad2.x, pad2.y))
                    onPad = true;
                if (onLilypad(pad3.x, pad3.y))
                    onPad = true;
                if (onLilypad(pad7.x, pad7.y))
                    onPad = true;
            }

            if (showCircle2) {
                if (onLilypad(pad4.x, pad4.y))
                    onPad = true;
                if (onLilypad(pad5.x, pad5.y))
                    onPad = true;
                if (onLilypad(pad6.x, pad6.y))
                    onPad = true;// chatgpt helped me to do these because it was super difficult to figure out
                                 // how to have the lilypads be safe but the water not and after much trial and
                                 // error it helped me do this which actually works

            }
            fill(200);
            stroke(200);
            rect(-10, 157, 910, height);// car street top

            stroke(10);
            for (int a = 10; a < 950; a = a + 80) {
                line(a, 192, a + 40, 192);// top car road middle lines

            }
            circlex = constrain(circlex, 30, 870);
            circley = constrain(circley, -40, 675);
            fill(playerR, playerG, playerB);
            stroke(20, 0, 140);
            ellipse(circlex, circley, 30, 30);

            //bottom row cars 
            fill(255, 255, 180);
         
            image(car1, rect1.x, bottomRowY);
            move(rect1);

            
            image(car2, rect2.x, bottomRowY);
            move(rect2);

         
            image(car3, rect3.x, bottomRowY);
            move(rect3);

            
            image(car4, rect4.x, bottomRowY);
            move(rect4);

            trainTimer++;
            BottomtrainTimer++;

            if (trainTimer >= 150 && BottomtrainTimer >= 400 && trainMoving == false) {
                trainMoving = true;
                train.x = -500;
                bottomtrain.x = width + 500;
            }

            if (trainMoving == true) {
                train.x = train.x + trainSpeed;
                bottomtrain.x = bottomtrain.x - trainSpeed;

            }

            if (train.x > width + 500 && bottomtrain.x < -500) {
                trainMoving = false;

            }
            //top row cars 
            fill(60);
            rect(train.x, train.y, 200, 60);
            rect(bottomtrain.x, bottomtrain.y, 200, 60);

            fill(255, 255, 180);
            
            image(topcar1, topRowrect1.x, topRowY);
            move2(topRowrect1);

            
            image(topcar2, topRowrect2.x, topRowY);
            move2(topRowrect2);

            
            image(topcar3, topRowrect3.x, topRowY);
            move2(topRowrect3);

            
            image(topcar4, topRowrect4.x, topRowY);
            move2(topRowrect4);

            

            // checks for when the circle y cordinate gets greater or equal to 0 
            if (circley <= 0) {
                levelUp();

            }

        }

        if (collision(rect1, 120, 100) || collision(rect2, 120, 100) || collision(rect3, 120, 100)
                || collision(rect4, 120, 100)) {

            reset();
        }

        if (collision(train, 200, 60)) {

            reset();

        }
        if (collision(bottomtrain, 200, 60)) {

            reset();
        }
        if (collision(topRowrect1, 120, 100) || collision(topRowrect2, 120, 100) || collision(topRowrect3, 120, 100)
                || collision(topRowrect4, 120, 100)) {

            reset();
        }
        
        // once the player is hit this scene happens    
        if (sceneTwo == true) {
            background(100);
            fill(20, 0, 140);
            textSize(100);
            text("Game Over", 450, 375);
            fill(173, 216, 230);
            textSize(20);
            text("press the space bar to restart", 300, 400);
            fill(255);
            textSize(20);
            text("OR", 450, 400);
            fill(173, 216, 230);
            textSize(20);
            text("press h to go to the homepage", 600, 400);
            textSize(40);
            text("Score:" + number0fwinsInArow, 450, 300);
            fill(20, 0, 140);
            textSize(20);
            text("High score: " + highscore, 60, 50);
        }
    }

    public void reset() {
        sceneOne = false;
        sceneTwo = true;
        h0mescene = false;
    }

    public void keyPressed() {
        // this allows the player to move the circle around and also the p lets the player start the game after the instructions 
        if (instructions) {
            if (key == 'p') {
                instructions = false;
                sceneOne = true;
                sceneTwo = false;
            }
        }
        if (sceneOne) {
            if (keyCode == UP) {
                circley = circley - 60;
            }

            if (keyCode == DOWN) {
                circley = circley + 60;
            }

            if (keyCode == LEFT) {
                circlex = circlex - 60;
            }

            if (keyCode == RIGHT) {
                circlex = circlex + 60;

            }

        }

        // when these keys are pressed on the origional home screen it allows the player
        // to choose its circles color when playing the game
        if (h0mescene) {
            if (key == '1') {
                playerR = 255;
                playerG = 60;
                playerB = 60;
            }

            if (key == '2') {
                playerR = 255;
                playerG = 170;
                playerB = 120;
            }

            if (key == '3') {
                playerR = 255;
                playerG = 230;
                playerB = 70;
            }

            if (key == '4') {
                playerR = 120;
                playerG = 255;
                playerB = 80;
            }

            if (key == '5') {
                playerR = 140;
                playerG = 220;
                playerB = 170;
            }

            if (key == '6') {
                playerR = 0;
                playerG = 200;
                playerB = 255;
            }

            if (key == '7') {
                playerR = 70;
                playerG = 120;
                playerB = 255;
            }

            if (key == '8') {
                playerR = 180;
                playerG = 60;
                playerB = 255;
            }

            if (key == '9') {
                playerR = 255;
                playerG = 160;
                playerB = 200;
            }

            if (key == '0') {
                playerR = 255;
                playerG = 0;
                playerB = 180;

            }
            // this allows the player to change from the home screen to the actual game once
            // their color is chosen
            if (key == ENTER || keyCode == RETURN) {
                instructions = true;
                h0mescene = false;

            }
        }
        if (sceneTwo) {
            // this allows the player to go from sceen after you die back to the homepage to
            // change their color
            if (key == 'h') {
                h0mescene = true;
                sceneTwo = false;
                sceneOne = false;
                circlex = 450;
                circley = 675;
                number0fwinsInArow = 0;

            }
            // when the player dies this allows them to press the start button to restart
            // the cirlce to its starting position and start over
            if (key == ' ') {
                sceneOne = true;
                sceneTwo = false;
                circlex = 450;
                circley = 675;
                speed = 5;
                backgroundR = 120;
                backgroundG = 180;
                backgroundB = 100;
                number0fwinsInArow = 0;

            }
        } 
    }

    public void move(PVector currentRect) {
        // allows the cars moving left to right to move
        currentRect.x += speed;
        if (currentRect.x > width) {
            currentRect.x = -200;

        }

    }

    // allows the cars moving right to left to move
    public void move2(PVector Currentrect) {
        Currentrect.x -= speed;
        if (Currentrect.x < -150) {
            Currentrect.x = 1100;
        }

    }

    boolean collision(PVector rect, int w, int h) {
        // collision
        boolean hitCar = circlex > rect.x && circlex < rect.x + w &&
                circley > rect.y && circley < rect.y + h;

        // train collision
        boolean hitTrain = circlex > train.x && circlex < train.x + 200 &&
                circley > train.y && circley < train.y + 60;

        // water collision
        boolean hitWater = circlex > 0 && circlex < 900 && circley > 280 && circley < 350 && !onPad;

        // bottom train collision
        boolean hitbottomtrain = circlex > bottomtrain.x && circlex < bottomtrain.x + 200 &&
                circley > bottomtrain.y && circley < bottomtrain.y + 60;

        return hitCar || hitTrain || hitWater || hitbottomtrain;
    }

    boolean onLilypad(float padX, float padY) { // chatgpt helped me do this and teach me to use the booleans becuase I needed to know how to have the
                                                // circles be safe but the water kill the player, it was very
                                                // challenging
        return dist(circlex, circley, padX, padY) < 22;
    }


    public void levelUp() {
        circlex = 450;
        circley = 675;

        speed = speed * 1.18;
        speed2 = speed2 * 1.18;
        speed3 = speed3 * 1.18;
        speed4 = speed4 * 1.18;
        speed5 = speed5 * 1.18;
        speed6 = speed6 * 1.18;
        speed7 = speed7 * 1.18;
        speed8 = speed8 * 1.18;

        backgroundR = (int) random(175);
        backgroundG = (int) random(175);
        backgroundB = (int) random(175);
        number0fwinsInArow++;
        if (number0fwinsInArow > highscore) {
            highscore = number0fwinsInArow;
        }
    }
}
