import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 
import ddf.minim.signals.*; 
import ddf.minim.spi.*; 
import ddf.minim.ugens.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PokeClickerDone extends PApplet {








Minim minim;
AudioPlayer pokeSong;
AudioSample pikaSound;
AudioSample bulbasaurSound;
AudioSample charmanderSound;
AudioSample squirtleSound;

PImage Charmander, Pikachu, Bulbasaur, Squirtle, Raichu, Ivysauer, Venusauer, Blastoise, Charizard, Wartortle, Charmeleon, retardPikachu;
PImage PokeClicker, Back, Finger, Baggrund, PokeBall, Potion, Candy, Sky;

int side = 5; //startskærm
long lastTime = 0;
int antalPokeBall = 0;
int antalPotions = 0;
int antalCandy = 0;
int sideEvolve = 0;
boolean isPlaying = false;

ArrayList <Pokemons> pokemons = new ArrayList<Pokemons>();

public void setup() {
  
  minim = new Minim(this);
  pokeSong = minim.loadFile("PokeSong.mp3");
  pokeSong.setGain(-35);
  pokeSong.play();
  pokeSong.loop();

  minim = new Minim(this);
  pikaSound = minim.loadSample("pikaSound.mp3", 512);
  bulbasaurSound = minim.loadSample("BulbasaurSound.mp3", 512);
  charmanderSound = minim.loadSample("CharmanderSound.mp3", 512);
  squirtleSound = minim.loadSample("SquirtleSound.mp3", 512);

  PokeClicker = loadImage("PokeClicker.png");
  Back = loadImage("back1.png");
  Baggrund = loadImage("baggrundstor.png");
  PokeBall = loadImage("PokeBall.png");
  Potion = loadImage("Potion.png");
  Candy = loadImage("Candy.png");

  PokeClicker.resize(600, 200);
  Back.resize(70, 70);
  Baggrund.resize(1200, 800);
  PokeBall.resize(70, 70);
  Potion.resize(70, 70);
  Candy.resize(70, 70);



  Pokemons pikachu = new Pokemons();
  pikachu.initPikachu();
  Pokemons bulbasaur = new Pokemons();
  bulbasaur.initBulbasaur();
  Pokemons charmander = new Pokemons();
  charmander.initCharmander();
  Pokemons squirtle = new Pokemons();
  squirtle.initSquirtle();

  pokemons.add(pikachu);
  pokemons.add(bulbasaur);
  pokemons.add(charmander);
  pokemons.add(squirtle);
}

public void draw() {
  tilbage();

  if (side == 5) {
    startside();
  } else if (side == 6) {
    isPlaying = false;
    valg();
  } else if (side == 1) {
    if (!isPlaying && pokemons.get(0).evolve==0) {
      pikaSound.setGain(-25);
      pikaSound.trigger();
      isPlaying = true;
    }
    pokemons.get(0).display();
    
  } else if (side == 2) {
    if (!isPlaying && pokemons.get(1).evolve==0) {
      bulbasaurSound.setGain(-32);
      bulbasaurSound.trigger();
      isPlaying = true;
    }
    pokemons.get(1).display();
    
  } else if (side == 3) {
    if (!isPlaying  && pokemons.get(2).evolve==0) {
      charmanderSound.setGain(-22);
      charmanderSound.trigger();
      isPlaying = true;
    }
    pokemons.get(2).display();
    
  } else if (side == 4) {
    if (!isPlaying  && pokemons.get(3).evolve==0) {
      squirtleSound.setGain(-33);
      squirtleSound.trigger();
      isPlaying = true;
    }
    pokemons.get(3).display();
  }
 
}

public void mousePressed() {
  if (side == 6) {
    if (millis() - lastTime > 500 ) {
      if (mouseX >0 && mouseX <0+600 && mouseY>0 && mouseY <0+400) {
        side =1;
      }

      if (mouseX >600 && mouseX <600+600 && mouseY>0 && mouseY <0+400) {
        side =2;
      }

      if (mouseX >0 && mouseX <0+600 && mouseY>400 && mouseY <400+400) {
        side =3;
      }

      if (mouseX >600 && mouseX <600+600 && mouseY>400 && mouseY <400+400) {
        side =4;
      }
    }
  }
}

public void mouseReleased() {
  if (side < 5) {
    if (mouseX > 400 && mouseX < 400+400 && mouseY > 200 && mouseY <200+400) {
      pokemons.get(side-1).score += pokemons.get(side-1).klikAmount;
    }
  }

  if (mouseX > 200 && mouseX <200+70 && mouseY>650 && mouseY<650+70) {
    if (pokemons.get(side-1).score >19) {
      pokemons.get(side-1).score -= 20;
      pokemons.get(side-1).klikAmount += 1;
      pokemons.get(side-1).pokeBalls++;
    }
  }

  if (mouseX > 400 && mouseX <400+70 && mouseY>650 && mouseY<650+70) {
    if (pokemons.get(side-1).score >499) {
      pokemons.get(side-1).score -= 500;
      pokemons.get(side-1).klikAmount += 5;
      pokemons.get(side-1).potions++;
    }
  }


  if (mouseX > 600 && mouseX <600+70 && mouseY>650 && mouseY<650+70) {
    if (pokemons.get(side-1).score >4999) {
      pokemons.get(side-1).score -= 5000;
      pokemons.get(side-1).klikAmount += 30;
      pokemons.get(side-1).candy++;
    }
  }
}

/*
500/20 = 25

5000/20 = 250


*/
class Pokemons {
  int evolve = 0;
  int score = 0;

  int pokeBalls;
  int potions;
  int candy;

  int klikAmount;

  PImage basic, evolve1, evolve2;

  Pokemons() {
    evolve = 0;
    score = 0;
    pokeBalls = 0;
    potions = 0;
    candy = 0;
    klikAmount = 1;
  }

  public void initPikachu () {
    basic = loadImage("Pikachu1.png");
    evolve1 = loadImage("Raichu1.png");
    evolve2 = loadImage("RetardPikachu.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  public void initBulbasaur() {
    basic = loadImage("Bulbasaur1.png");
    evolve1 = loadImage("Ivysauer1.png");
    evolve2 = loadImage("Venusauer.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  public void initCharmander() {
    basic = loadImage("charmander1.png");
    evolve1 = loadImage("Charmeleon.png");
    evolve2 = loadImage("Charizard.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  public void initSquirtle () {
    basic = loadImage("Squirtle1.png");
    evolve1 = loadImage("Wartortle.png");
    evolve2 = loadImage("Blastoise.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  public void display() {
    image(Baggrund, 0, 0);
    if (evolve == 0) { 
      image(basic, 400, 200);
    } else if  (evolve == 1) {
      image(evolve1, 400, 200);
    } else if (evolve == 2) {
      image(evolve2, 400, 200);
    }

    pokeballosv();
    if (score >= 20000) {
      if (evolve == 0) { 
        evolve = 1;
      }
    }
    if (score >= 40000) {
      if (evolve == 1) {
        evolve = 2;
      }
    }
  }


  public void drawPokemon () {
    if (evolve == 0) { 
      image(basic, 0, 0);
    } else if  (evolve == 1) {
      image(evolve1, 0, 0);
    } else if (evolve == 2) {
      image(evolve2, 0, 0);
    }
  }
}


public void valg() {
  if (side == 6) {
    stroke(255);
    noFill();
    stroke(225);
    image(Baggrund, 0, 0);
    line(0, height/2, width, height/2);
    line(width/2, 0, width/2, height);
    pushMatrix();
    translate( 100, 0);
    pokemons.get(0).drawPokemon();
    popMatrix();

    pushMatrix();
    translate( 700, 0);
    pokemons.get(1).drawPokemon();
    popMatrix();

    pushMatrix();
    translate( 100, 400);
    pokemons.get(2).drawPokemon();
    popMatrix();

    pushMatrix();
    translate( 700, 400);
    pokemons.get(3).drawPokemon();
    popMatrix();

    image(Back, 1130, 0);
  }
}

public void tilbage () {
  if (mousePressed) {
    if (mouseX >1130 && mouseX <1130+70 && mouseY>0 && mouseY <0+70) {
      side =5;
    }
  }
}

public void startside () {
  if (side==5) {
    image(Baggrund, 0, 0);
    stroke(0);
    fill(0);
    rect(400, 255, 400, 200);
    textSize(72);
    fill(255);
    textAlign(CENTER);
    text("START", width/2, height/2-20);
    image(PokeClicker, 300, 30);

    textSize(22);
    fill(255);
    textAlign(LEFT);

    text("- Vælg den Pokemon, som du godt kunne tænke dig!", 50, 675);
    text("- Klik på Pokemonen for at optjene points til opgraderinger!", 50, 700);
    text("- Evolves ved hver 20000 points!", 50, 725);
    fill(0);

    //startknappen-------
    if (mousePressed) {
      if (mouseX>400 && mouseX <400+400 && mouseY > 255 && mouseY < 255+200) {
        side=6;
        lastTime = millis();
      }
    }
  }
}

public void pokeballosv() {
  image(Back, 1130, 0);
  image(PokeBall, 200, 650);
  image(Potion, 400, 650);
  image(Candy, 600, 650);
  textAlign(LEFT);


  textSize(32);
  fill(243, 250, 48);
  text("20", 215, 750);
  text("500", 400, 750);
  text("5000", 590, 750);
  textAlign(CENTER);
  noFill();
  image(PokeBall, 10, 0);
  image(Potion, 10, 80);
  image(Candy, 10, 160);

  fill(0);
  text(pokemons.get(side-1).pokeBalls, 130, 45);
  text(pokemons.get(side-1).potions, 130, 125);
  text(pokemons.get(side-1).candy, 130, 205);

  if (side < 5) {
    textSize(30);
    fill(0);
    textAlign(CENTER, TOP);
    if (pokemons.get(side-1).score < 999999999) {
      text(pokemons.get(side-1).score, 600, 100);
    }
  }
}

  public void settings() {  size(1200, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "PokeClickerDone" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
