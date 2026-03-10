import processing.core.*;

public class App extends PApplet{ 
    public static void main(String[] args) {
        PApplet.main("App");
    }

    int height = 70;
    int circlex = 450;
    int circley = 675;
    int rectx = 0;
    int speed = 5;
    int rect2x = -300;
    int speed2 = 5;
    int rect3x = -550;
    int speed3 = 5;
    boolean sceneOne = true;
    boolean sceneTwo = true;
    int recttrain = 0;
    int height2 = 140;
    int hieght3 = 60;
    int hieght4 = 140; 

    public void setup() {

    }

    public void settings() {
        size(900, 700);

    }

    public void draw(){
        if (sceneOne == true) {
            background(120, 180, 100);

            fill(200);
            stroke(200);
            rect(-10, 580, 910, height);// car street

            stroke(10);
            for (int x = 10; x < 950; x = x + 80) {
                line(x, 615, x + 40, 615);

                fill(100);
                stroke(10);
                rect(-10, 390, 910, height2);// train street

                fill(10);
                stroke(10);
                line(-10, 467, 900, 467);

                fill(120, 180, 100);
                stroke(10);
                rect(-10, 345, 910, hieght3);// greenary 3

                fill(200);
            stroke(200);
            rect(-10, 285, 910, height);// car street 2 and 3

            stroke(10);
            for (int a = 10; a < 950; a = a + 80) {
                line(a, 615, a + 40, 615);

            }
            fill(20, 0, 140);
            stroke(20, 0, 140);
            ellipse(circlex, circley, 30, 30);

            fill(255, 255, 180);
            rect(rectx, 590, 80, 50);
            rectx = rectx + speed;
            if (rectx > width - 10 || rectx < 0) {
                rectx = -5;
            }

            rect(rect2x, 590, 80, 50);
            rect2x = rect2x + speed2;
            if (rect2x > width) {
                rect2x = -5;
            }
            rect(rect3x, 590, 80, 50);
            rect3x = rect3x + speed3;
        }
            if (rect3x > width) {
                rect3x = -5;
            }
        

            if (collision(rectx) || collision(rect2x) || collision(rect3x)) {
                sceneOne = false;
                sceneTwo = true;

            }
        }
        else if (sceneTwo == true) {
            background(100);
            text("Game Over", 300, 375);
            textSize(10);
            text("Press The Space Bar to restart", 375, 400);
            textSize(65);
        }
    }
        

        
    public void keyPressed() {

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
        if (key == ' ') {
            sceneOne = true;
            sceneTwo = false;
            circlex = 450;
            circley = 675;

        }

    }

    boolean collision(int rectx) {
        return circlex > rectx && circlex < rectx + 80 &&
                circley > 590 && circley < 640;
    }

}
    